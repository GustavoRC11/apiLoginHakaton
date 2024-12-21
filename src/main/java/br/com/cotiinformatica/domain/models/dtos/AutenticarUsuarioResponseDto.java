package br.com.cotiinformatica.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class AutenticarUsuarioResponseDto {
	
	private UUID id;
	private String nome;
	private String email;
	private String token;
	private Date dataHoraAcesso;
	private Date dataHoraExpiracao;
	private String mensagem;

}
