package br.com.comprecerto.api.controllers;

import java.net.URI;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.services.MercadoService;

/**
 * Servicos para consumo do objeto 'Mercado'
 * 
 * @author braz
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/rest/mercados")
public class MercadoController {

	@Autowired
	private MercadoService mercadoService;

	/**
	 * Listagem de mercados
	 * 
	 * @return Lista de mercados
	 */
	@GetMapping
	public ResponseEntity<List<Mercado>> buscarMercados() {
		return ResponseEntity.ok(mercadoService.buscarMercados());
	}

	/**
	 * Consulta de mercado por Id
	 * 
	 * @param id Identificador do mercado necessario
	 * @return Mercado solicitado
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Mercado> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(mercadoService.buscarPorId(id));
	}

	/**
	 * Salvar um mercado
	 * 
	 * @param mercado Mercado a ser salvo
	 * @return Mercado salvo
	 */
	@PostMapping
	public ResponseEntity<Mercado> salvarMercado(@RequestBody @Valid Mercado mercado) {
		return ResponseEntity.ok(mercadoService.salvarMercado(mercado));
	}

	/**
	 * <br>
	 * Atualização um mercado
	 * 
	 * @param id      Identificador do mercado a ser atualizado
	 * @param mercado Mercado a ser atualizado
	 * @return Mercado atualizado
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarMercado(@PathVariable Integer id, @RequestBody @Valid Mercado mercado) {
		try {
			return ResponseEntity.ok(mercadoService.atualizarMercado(id, mercado));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	/**
	 * Inativação do mercado
	 * 
	 * @param id Identificador do mercado a ser inativado
	 */
	@DeleteMapping(value = "/{id}")
	public void desativarMercado(@PathVariable Integer id) {
		try {
			mercadoService.desativarMercado(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Consulta de mercado por funcionario
	 * 
	 * @return Mercado do funcionario
	 */
	@GetMapping(value = "/funcionario")
	public ResponseEntity<?> buscarPorFuncionario(Principal principal) {
		try {
			return ResponseEntity.ok(mercadoService.buscarPorFuncionario(principal));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
