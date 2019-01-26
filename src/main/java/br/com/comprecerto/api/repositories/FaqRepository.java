package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer> {

	Optional<Faq> findByIdFaq(Integer id);

}
