package br.com.cotiinformatica.domain.contracture.service;

import br.com.cotiinformatica.domain.models.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.AutenticarUsuarioResponseDto;
import br.com.cotiinformatica.domain.models.dtos.CadastrarUsuarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.CadastrarUsuarioResponseDto;

public interface UsuarioService {
	
	CadastrarUsuarioResponseDto cadastrarUsuario(CadastrarUsuarioRequestDto dto);

	AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto  dto);

}


