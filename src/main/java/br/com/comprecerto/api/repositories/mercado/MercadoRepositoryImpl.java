package br.com.comprecerto.api.repositories.mercado;

import br.com.comprecerto.api.dto.LocalidadeFilter;
import br.com.comprecerto.api.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MercadoRepositoryImpl implements MercadoRepositoryQuery {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Mercado> buscarMercados(LocalidadeFilter localidadeFilter, Boolean fativo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Mercado> cq = cb.createQuery(Mercado.class);

        Root<Mercado> mercado = cq.from(Mercado.class);
        List<Predicate> predicates = new ArrayList<>();

        verificaFiltros(cb, mercado, predicates, localidadeFilter, fativo);

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

    private void verificaFiltros(CriteriaBuilder cb, Root<Mercado> mercado, List<Predicate> predicates, LocalidadeFilter localidadeFilter, Boolean fativo) {
    	if(fativo) {
    		predicates.add(cb.equal(mercado.get("fAtivo"), fativo));
    	}	
    	
        if (localidadeFilter.getIdEstado() != null && localidadeFilter.getIdEstado() != 0) {
            Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercado.join("mercadoLocalidades");
            Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");
            Join<Bairro, Cidade> cidade = bairro.join("cidade");
            Join<Cidade, Estado> estado = cidade.join("estado");

            predicates.add(cb.equal(estado.get("idEstado"), localidadeFilter.getIdEstado()));
        }

        if (localidadeFilter.getIdCidade() != null && localidadeFilter.getIdCidade() != 0) {
            Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercado.join("mercadoLocalidades");
            Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");
            Join<Bairro, Cidade> cidade = bairro.join("cidade");

            predicates.add(cb.equal(cidade.get("idCidade"), localidadeFilter.getIdCidade()));
        }

        if (localidadeFilter.getIdBairro() != null && localidadeFilter.getIdBairro() != 0) {
            Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercado.join("mercadoLocalidades");
            Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");

            predicates.add(cb.equal(bairro.get("idBairro"), localidadeFilter.getIdBairro()));
        }
    }
}
