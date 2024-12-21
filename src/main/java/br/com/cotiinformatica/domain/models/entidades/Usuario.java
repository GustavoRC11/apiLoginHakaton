package br.com.cotiinformatica.domain.models.entidades;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "tb_usuario")
@Data
public class Usuario {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "matricula", length = 50, nullable = false, unique = true)
	private Integer matricula;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "senha", length = 100, nullable = false)
	private String senha;
	
	

}