package br.com.comprecerto.api.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.dto.LocalidadeFilter;
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

}
