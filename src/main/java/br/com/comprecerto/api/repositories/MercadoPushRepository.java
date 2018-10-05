package br.com.comprecerto.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.MercadoPush;

@Repository
public interface MercadoPushRepository extends JpaRepository<MercadoPush, Integer> {

}
