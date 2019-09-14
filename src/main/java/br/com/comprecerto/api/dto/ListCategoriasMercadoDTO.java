package br.com.comprecerto.api.dto;

import java.util.ArrayList;
import java.util.List;

public class ListCategoriasMercadoDTO  extends ArrayList<CategoriasMercadoDTO> {
	
	
	private static final long serialVersionUID = 1L;

		public boolean findCategoria(Integer idCategoria) {
			
			 for (CategoriasMercadoDTO obj : this)
				 if(obj.getIdCategoria() == idCategoria) {
						return true;
					}		    
			
			return false;

		}
		
		
	
}
