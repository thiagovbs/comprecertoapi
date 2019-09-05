package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Pedido;
import br.com.comprecerto.api.push.PushSender;
import br.com.comprecerto.api.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PushSender pushSender;
		

	public List<Pedido> buscarPedidos() {		
		return pedidoRepository.findAll();
	}
	
	public List<Pedido> buscarPorUsuario(Integer idUsuario) {
		return pedidoRepository.findByIdUsuario(idUsuario);
	}
	
	public List<Pedido> buscarPorMercadoLocalidade(Integer idMercadoLocalidade) {
		return pedidoRepository.findByIdMercadoLocalidade(idMercadoLocalidade);
	}
	
	public List<Pedido> buscarPorMercado(Integer idMercado) {
		return pedidoRepository.findByIdMercado(idMercado);
	}

	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> pedidoOp = pedidoRepository.findByIdPedido(id);

		if (pedidoOp.isPresent())
			return pedidoOp.get();

		return null;
	}
	
	
	public Pedido salvarPedido(@Valid Pedido pedido) {		
		
		return pedidoRepository.saveAndFlush(pedido);
	}
	

	public Pedido atualizarPedido(Integer id, @Valid Pedido pedido) throws Exception {
		Optional<Pedido> pedidoOp = pedidoRepository.findByIdPedido(id);

		if (!pedidoOp.isPresent())
			throw new Exception("O pedido informado não existe!");

		pushSender.sendAtualizacaoPedido(pedido);	
		
		return salvarPedido(pedido);
	}

	public void deletarPedido(Integer id) throws Exception {
		Optional<Pedido> pedidoOp = pedidoRepository.findByIdPedido(id);

		if (!pedidoOp.isPresent())
			throw new Exception("O pedido informado não existe!");

		pedidoRepository.delete(pedidoOp.get());
	}

}
