package br.com.comprecerto.api.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Estado;
import br.com.comprecerto.api.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private UsuarioService usuarioService;

	public List<Estado> buscarEstados() {
		return estadoRepository.findAll();
	}

	public Estado buscarPorId(Integer id) {
		Optional<Estado> estado = estadoRepository.findByIdEstado(id);

		if (estado.isPresent())
			return estado.get();

		return null;
	}

	public Estado salvarEstado(@Valid Estado estado) {
		return estadoRepository.saveAndFlush(estado);
	}

	public Estado atualizarEstado(Integer id, @Valid Estado estado) throws Exception {
		Optional<Estado> estadoOp = estadoRepository.findByIdEstado(id);

		if (!estadoOp.isPresent())
			throw new Exception("O estado informado não existe!");

		return salvarEstado(estado);
	}

	public void deletarEstado(Integer id) throws Exception {
		Optional<Estado> estadoOp = estadoRepository.findByIdEstado(id);

		if (!estadoOp.isPresent())
			throw new Exception("O estado informado não existe!");

		estadoRepository.delete(estadoOp.get());
	}

    public List<Estado> buscarEstados(Principal principal) throws Exception {
		if (usuarioService.isAdmin(principal)) {
			return buscarEstados();
		}

		return estadoRepository.findByMercado(usuarioService.buscarPorLogin(principal.getName()).getMercado().getIdMercado());
    }
}
