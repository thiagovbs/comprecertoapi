package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Usuario;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByLogin(String username);
	
	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByIdUsuario(Integer id);

	Optional<Usuario> findByEmailAndNome(String email, String nomeFantasia);

	@Transactional
	@Modifying
	@Query("update Usuario set fAtivo = false where email = ?1 and nome = ?2")
	void desativaUsuarioPorEmailAndNome(String email, String nome);

	
	@Transactional
	@Modifying
	@Query("update Usuario set fAtivo = true where email = ?1 and nome = ?2")
	void ativaUsuarioPorEmailAndNome(String email, String nome);
	
	
	@Transactional
	@Modifying
	@Query(nativeQuery =  true, value = "delete from sheap.usuario_permissao where id_usuario = ?1")
	void deleteRelacionamento(Integer idUsuario);

	Optional<Usuario> findByLoginAndFAtivo(String login, boolean ativo);
	
	List<Usuario> findByFirebaseToken(String firebaseToken);
}
