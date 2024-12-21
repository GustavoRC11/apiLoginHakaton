package br.com.cotiinformatica.infrastructere.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.domain.models.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
	

	@Query("FROM Usuario u WHERE u.email = :email")
	Usuario findByEmail(@Param("email") String email);
	
	@Query("FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
	Usuario findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);

}
