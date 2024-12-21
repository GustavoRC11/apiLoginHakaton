package br.com.cotiinformatica.domain.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.contracture.components.JwtTokenComponent;
import br.com.cotiinformatica.domain.contracture.components.SHA256Component;
import br.com.cotiinformatica.domain.contracture.service.UsuarioService;
import br.com.cotiinformatica.domain.models.Cargo;
import br.com.cotiinformatica.domain.models.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.AutenticarUsuarioResponseDto;
import br.com.cotiinformatica.domain.models.dtos.CadastrarUsuarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.CadastrarUsuarioResponseDto;
import br.com.cotiinformatica.domain.models.entidades.Usuario;
import br.com.cotiinformatica.infrastructere.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired 
	SHA256Component sha256Component;
	
	@Autowired 
	JwtTokenComponent jwtTokenComponent;
	
	

	@Override
	public CadastrarUsuarioResponseDto cadastrarUsuario(CadastrarUsuarioRequestDto dto) {
		
		if (usuarioRepository.findByEmail(dto.getEmail()) != null)
			throw new IllegalArgumentException("O email informado já está cadastrado, tente outro.");

		
		var usuario = new Usuario();
		usuario.setId(UUID.randomUUID());
		usuario.setNome(dto.getNome());
		usuario.setCargo(Cargo.valueOf(dto.getCargo()));
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(sha256Component.hash(dto.getSenha()));

		
		usuarioRepository.save(usuario);

		
		var response = new CadastrarUsuarioResponseDto();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setCargo(usuario.getCargo().toString());
		response.setEmail(usuario.getEmail());
		response.setMensagem("Usuário cadastrado com sucesso.");

		return response;
	}

	@Override
	public AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto dto) {

		var usuario = usuarioRepository.findByEmailAndSenha(dto.getEmail(), sha256Component.hash(dto.getSenha()));
	
		if(usuario == null)
			throw new IllegalArgumentException("Usuário inválido.");
		
		
		var token = jwtTokenComponent.generateToken(usuario.getId());
		
	

		var response = new AutenticarUsuarioResponseDto();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setToken(token);
		response.setDataHoraAcesso(new Date());
		response.setDataHoraExpiracao(new Date(new Date().getTime() + 600000));
		response.setMensagem("Usuário autenticado com sucesso.");
		
		return response;
	
	}

}