package br.com.comprecerto.api.controllers;

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

import br.com.comprecerto.api.entities.Pedido;
import br.com.comprecerto.api.services.PedidoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> buscarPedidos() {
		return ResponseEntity.ok(pedidoService.buscarPedidos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(pedidoService.buscarPorId(id));
	}
	
	@GetMapping(value = "/usuario/{idUsuario}")
	public ResponseEntity<List<Pedido>> buscarPorUsuario(@PathVariable Integer idUsuario) {
		return ResponseEntity.ok(pedidoService.buscarPorUsuario(idUsuario));
	}
	
	@GetMapping(value = "/mercadoLocalidade/{idMercadoLocalidade}")
	public ResponseEntity<List<Pedido>> buscarPorMercadoLocalidade(@PathVariable Integer idMercadoLocalidade) {
		return ResponseEntity.ok(pedidoService.buscarPorMercadoLocalidade(idMercadoLocalidade));
	}
	
	@GetMapping(value = "/mercado/{idMercado}")
	public ResponseEntity<List<Pedido>> buscarPorMercado(@PathVariable Integer idMercado) {		
		return ResponseEntity.ok(pedidoService.buscarPorMercado(idMercado));
	}

	@PostMapping
	public ResponseEntity<Pedido> salvarPedido(@RequestBody @Valid Pedido pedido) {
		return ResponseEntity.ok(pedidoService.salvarPedido(pedido));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarPedido(@PathVariable Integer id, @RequestBody @Valid Pedido pedido) {
		try {
			return ResponseEntity.ok(pedidoService.atualizarPedido(id, pedido));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarPedido(@PathVariable Integer id) {
		try {
			pedidoService.deletarPedido(id);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
