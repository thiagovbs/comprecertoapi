package br.com.comprecerto.api.repositories.mercadolocalidade;

import br.com.comprecerto.api.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MercadoLocalidadeRepositoryImpl implements MercadoLocalidadeRepositoryQuery {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MercadoLocalidade> buscarMercadosLocalidadePorBairro(Integer idBairro) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MercadoLocalidade> cq = cb.createQuery(MercadoLocalidade.class);

        Root<MercadoLocalidade> mercadoLocalidade = cq.from(MercadoLocalidade.class);
        List<Predicate> predicates = new ArrayList<>();

        verificaFiltros(cb, mercadoLocalidade, predicates, idBairro);

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

    private void verificaFiltros(CriteriaBuilder cb, Root<MercadoLocalidade> mercadoLocalidade, List<Predicate> predicates, Integer idBairro) {
        
        if (idBairro != null && idBairro != 0) {
            Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");

            predicates.add(cb.equal(bairro.get("idBairro"), idBairro));
        }
    }

	
}
