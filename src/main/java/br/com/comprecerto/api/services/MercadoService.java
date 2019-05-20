package br.com.comprecerto.api.services;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import br.com.comprecerto.api.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.repositories.BairroRepository;
import br.com.comprecerto.api.repositories.CidadeRepository;
import br.com.comprecerto.api.repositories.EstadoRepository;
import br.com.comprecerto.api.repositories.MercadoRepository;
import br.com.comprecerto.api.repositories.PaisRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MercadoService {

    @Autowired
    private MercadoRepository mercadoRepository;

    @Autowired
    private BairroRepository bairroRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imgService;

    public List<Mercado> buscarMercados() {
        return mercadoRepository.findAll();
    }

    public Mercado buscarPorId(Integer id) {
        Optional<Mercado> mercado = mercadoRepository.findByIdMercado(id);

        if (!mercado.isPresent())
            return null;

        for (MercadoLocalidade localidade : mercado.get().getMercadoLocalidades()) {

            for (Servico servico : servicoService.buscarServicos()) {
                List<MercadoServico> ms = localidade.getMercadoServicos().stream().filter(mercadoServico -> mercadoServico.getPacoteServico().getServico().equals(servico))
                        .collect(Collectors.toList());

                if (!ms.isEmpty()) {
                    servico.setPacoteSelecionado(ms.get(0).getPacoteServico());
                } else {
                    servico.setPacoteSelecionado(new PacoteServico());
                }

                localidade.addServicoTemp(servico);
            }
        }

        return mercado.get();
    }

    @Transactional
    public Mercado salvarMercado(@Valid Mercado mercado) {
        try {
            mercado.getMercadoLocalidades().forEach(localidade -> {
                localidade.setMercado(mercado);
                localidade.getMercadoServicos().stream().forEach((servico) -> servico.setMercadoLocalidade(localidade));

                Bairro bairro = bairroRepository.findByNomeAndCidadeAndEstadoAndPais(localidade.getBairro().getNome(), localidade.getBairro().getCidade().getNome(),
                        localidade.getBairro().getCidade().getEstado().getNome(), localidade.getBairro().getCidade().getEstado().getPais().getNome());
                if (bairro != null) {
                    localidade.setBairro(bairro);
                } else {
                    Cidade cidade = cidadeRepository.findByNomeAndEstadoAndPais(localidade.getBairro().getCidade().getNome(), localidade.getBairro().getCidade().getEstado().getNome(),
                            localidade.getBairro().getCidade().getEstado().getPais().getNome());
                    if (cidade != null) {
                        localidade.getBairro().setCidade(cidade);
                    } else {
                        Estado estado = estadoRepository.findByNomeAndPais(localidade.getBairro().getCidade().getEstado().getNome(),
                                localidade.getBairro().getCidade().getEstado().getPais().getNome());
                        if (estado != null) {
                            localidade.getBairro().getCidade().setEstado(estado);
                        } else {
                            Pais pais = paisRepository.findByNome(localidade.getBairro().getCidade().getEstado().getPais().getNome());
                            if (pais != null) {
                                localidade.getBairro().getCidade().getEstado().setPais(pais);
                            }
                        }
                    }
                }

                salvaDependenciasMercado(localidade);
            });

            calculaSaldoMercadoServico(mercado);
            Mercado mercadoSalvo = mercadoRepository.saveAndFlush(mercado);
            if (mercado.getImageBase64() != null && !mercado.getImageBase64().isEmpty()) {
                mercadoSalvo.setImageBase64(mercado.getImageBase64());
                mercadoSalvo = uploadMercadoPicture(mercadoSalvo);
            }
            verificarUsuarioMercado(mercado);

            return mercadoSalvo;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void verificarUsuarioMercado(Mercado mercado) {
        Usuario usuario = usuarioService.buscarPorEmail(mercado.getEmail());
        if (usuario == null && usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
            usuario = new Usuario();
            usuario.setLogin(mercado.getEmail());
            usuario.setEmail(mercado.getEmail());
            usuario.setSenha(mercado.getSenha());
            usuario.setNome(mercado.getNomeFantasia());
            usuario.setPermissoes(new HashSet<>(Arrays.asList(usuarioService.buscarPermissao("MERCADO_OPERADOR"))));
        }

        if (!usuario.getEmail().equals(mercado.getEmail())) {
            usuario.setEmail(mercado.getEmail());
        }
        if (!usuario.getSenha().equals(mercado.getSenha())) {
            usuario.setSenha(mercado.getSenha());
        }

        usuarioService.salvarUsuario(usuario);
    }

    private void calculaSaldoMercadoServico(Mercado mercado) {
        mercado.getMercadoLocalidades().forEach(localidade -> {
            localidade.getMercadoServicos().forEach(servico -> {
                BigDecimal saldo = servico.getPacoteServico().getValor();

                if (servico.getPacoteServico().getAcrescimo() != null)
                    saldo.add(servico.getPacoteServico().getAcrescimo());
                if (servico.getPacoteServico().getDesconto() != null)
                    saldo.subtract(servico.getPacoteServico().getDesconto());

                servico.setSaldo(saldo);
            });
        });
    }

    private void salvaDependenciasMercado(MercadoLocalidade localidade) {
        if (localidade.getBairro().getCidade().getEstado().getPais().getIdPais() == null) {
            localidade.getBairro().getCidade().getEstado().setPais(paisRepository.save(localidade.getBairro().getCidade().getEstado().getPais()));
            if (localidade.getBairro().getCidade().getEstado().getIdEstado() == null) {
                localidade.getBairro().getCidade().setEstado(estadoRepository.save(localidade.getBairro().getCidade().getEstado()));
                if (localidade.getBairro().getCidade().getIdCidade() == null) {
                    localidade.getBairro().setCidade(cidadeRepository.save(localidade.getBairro().getCidade()));
                    if (localidade.getBairro() == null) {
                        localidade.setBairro(bairroRepository.save(localidade.getBairro()));
                    }
                }
            }
        } else if (localidade.getBairro().getCidade().getEstado().getIdEstado() == null) {
            localidade.getBairro().getCidade().setEstado(estadoRepository.save(localidade.getBairro().getCidade().getEstado()));
            if (localidade.getBairro().getCidade().getIdCidade() == null) {
                localidade.getBairro().setCidade(cidadeRepository.save(localidade.getBairro().getCidade()));
                if (localidade.getBairro() == null) {
                    localidade.setBairro(bairroRepository.save(localidade.getBairro()));
                }
            }
        } else if (localidade.getBairro().getCidade().getIdCidade() == null) {
            localidade.getBairro().setCidade(cidadeRepository.save(localidade.getBairro().getCidade()));
            if (localidade.getBairro() == null) {
                localidade.setBairro(bairroRepository.save(localidade.getBairro()));
            }
        } else if (localidade.getBairro().getIdBairro() == null) {
            localidade.setBairro(bairroRepository.save(localidade.getBairro()));
        }
    }

    public Mercado atualizarMercado(Integer id, @Valid Mercado mercado) throws Exception {
        Optional<Mercado> mercadoOp = mercadoRepository.findByIdMercado(id);

        if (!mercadoOp.isPresent())
            throw new Exception("O mercado informado não existe!");

        return salvarMercado(mercado);
    }

    public void desativarMercado(Integer id) throws Exception {
        Optional<Mercado> mercadoOp = mercadoRepository.findByIdMercado(id);

        if (!mercadoOp.isPresent())
            throw new Exception("O mercado informado não existe!");

        mercadoRepository.desativar(mercadoOp.get().getIdMercado());
    }

    public Mercado buscarPorFuncionario(Principal principal) throws Exception {
        Usuario usuario = usuarioService.buscarPorLogin(principal.getName());

        if (usuario.getMercado() == null)
            throw new Exception("Usuário não possui relacionamento com nenhum mercado!");

        return buscarPorId(usuario.getMercado().getIdMercado());
    }

    public Mercado uploadMercadoPicture(Mercado mercado) throws Exception {
        mercado.setImagemUrl(imgService.salvaImagemFromBase64(mercado.getImageBase64(), "mercado-" + mercado.getIdMercado()));
        return mercadoRepository.saveAndFlush(mercado);
    }

}
