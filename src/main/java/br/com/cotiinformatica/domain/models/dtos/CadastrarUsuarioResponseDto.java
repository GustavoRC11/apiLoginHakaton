package br.com.cotiinformatica.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class CadastrarUsuarioResponseDto {
	
	private UUID id;
	private String nome;
	private Integer matricula;
	private String email;
	private String mensagem;

}
