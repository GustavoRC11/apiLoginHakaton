package br.com.cotiinformatica.aplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.contracture.service.UsuarioService;
import br.com.cotiinformatica.domain.models.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.AutenticarUsuarioResponseDto;
import br.com.cotiinformatica.domain.models.dtos.CadastrarUsuarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.CadastrarUsuarioResponseDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class UsuarioController {
	
	@Autowired 
	UsuarioService usuarioService;

	@PostMapping("cadastrar") 
	public CadastrarUsuarioResponseDto cadastrarUsuario(@RequestBody @Valid CadastrarUsuarioRequestDto dto) {
		return usuarioService.cadastrarUsuario(dto);
	}

	@PostMapping("autenticar")
	public AutenticarUsuarioResponseDto autenticarUsuario(@RequestBody @Valid AutenticarUsuarioRequestDto dto) {
		return usuarioService.autenticarUsuario(dto);
	}
}


