package br.com.comprecerto.api.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.config.CompreCertoExceptionHandler.Erro;
import br.com.comprecerto.api.dto.MercadoLocalidadeAppDTO;
import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.entities.Bairro;
import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.entities.MercadoLocalidade;
import br.com.comprecerto.api.repositories.MercadoLocalidadeRepository;
import br.com.comprecerto.api.services.MercadoLocalidadeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/mercado-localidades")
public class MercadoLocalidadeController {

	@Autowired
	private MercadoLocalidadeService service;

	@Autowired
	private MercadoLocalidadeRepository repository;

	@GetMapping
	private ResponseEntity<?> buscarMercadoLocalides(Principal principal) {
		try {
			return ResponseEntity.ok(service.buscarMercadoLocalidades(principal));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/filtro")
	public ResponseEntity<?> filtrar(MercadoProdutoFilter filtro) {
		MercadoLocalidade mercadoLocalidade = new MercadoLocalidade();
		mercadoLocalidade.setMercado(new Mercado(filtro.getIdMercado()));
		mercadoLocalidade.setBairro(new Bairro(filtro.getIdBairro()));

		Example<MercadoLocalidade> mercadoExample = Example.of(mercadoLocalidade);
		return ResponseEntity.ok(repository.findAll(mercadoExample));
	}

	@GetMapping(value = "/bairro/{idBairro}")
	public ResponseEntity<?> filtrarPorBairro(@PathVariable Integer idBairro) {
		try {
			return ResponseEntity.ok(service.buscarMercadoLocalidadePorBairro(idBairro));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	/**
	 * Inativação do mercadoLocalidade
	 * 
	 * @param id
	 *            Identificador do mercadoLocalidade a ser inativado
	 */
	@DeleteMapping(value = "/{id}")
	public void desativarrMercadoLocalidade(@PathVariable Integer id) {
		try {
			service.desativarMercadoLocalidade(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "/dto/bairro/{idBairro}")
	public ResponseEntity<?> filtrarPorBairroDTO(@PathVariable Integer idBairro) {
		try {
			List<MercadoLocalidade> list = service.buscarMercadoLocalidadePorBairro(idBairro);
			List<MercadoLocalidadeAppDTO> listDTO = list.stream().map(obj -> new MercadoLocalidadeAppDTO(obj))
					.collect(Collectors.toList());
			return ResponseEntity.ok(listDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarMercadoLocalidade(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(service.buscarMercadoLocalidade(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> salvarMercadoLocalidade(@RequestBody @Valid MercadoLocalidade mercadoLocalidade) {
		try {
			return ResponseEntity.ok(service.salvarMercadoLocalidade(mercadoLocalidade));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Arrays.asList(new Erro(e.getMessage(), e.getCause())));
		}
	}

}
