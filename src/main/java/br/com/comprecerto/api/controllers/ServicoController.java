package br.com.comprecerto.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.entities.PacoteServico;
import br.com.comprecerto.api.entities.Servico;
import br.com.comprecerto.api.services.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;

	@GetMapping
	public ResponseEntity<List<Servico>> buscarServicos() {
		return ResponseEntity.ok(servicoService.buscarServicos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Servico> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(servicoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Servico> salvarServico(@RequestBody @Valid Servico servico) {
		return ResponseEntity.ok(servicoService.salvarServico(servico));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarServico(@PathVariable Integer id, @RequestBody @Valid Servico servico) {
		try {
			return ResponseEntity.ok(servicoService.atualizarServico(id, servico));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarServico(@PathVariable Integer id) {
		try {
			servicoService.deletarServico(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/pacotes")
	public ResponseEntity<List<PacoteServico>> buscarPacoteServicos() {
		return ResponseEntity.ok(servicoService.buscarPacoteServicos());
	}
}
