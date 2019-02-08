package br.com.comprecerto.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.dto.MercadoProdutoDTO;
import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.repositories.MercadoProdutoRepository;

@Service
public class MercadoProdutoService {
	
	@Autowired
	private MercadoProdutoRepository mercadoProdutoRepository;

	public List<MercadoProdutoDTO> filtrar(MercadoProdutoFilter filter) {
		return mercadoProdutoRepository.filtrar(filter);
	}

}
