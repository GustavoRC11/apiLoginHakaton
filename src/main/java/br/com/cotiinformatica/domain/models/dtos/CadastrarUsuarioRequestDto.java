package br.com.cotiinformatica.domain.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CadastrarUsuarioRequestDto {
	
	@Size(min = 8, max = 100, message = "Por favor, informe o nome de 8 a 100 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	
	@NotNull(message = "Por favor, informe o cargo do usuário.")
	private String cargo;
	
	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotEmpty(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", 
			message = "Por favor, informe a senha com letras maiúsculas, minúsculas, números, símbolos e pelo menos 8 caracteres.")
	@NotEmpty(message = "Por favor, informe a senha do usuário.")
	private String senha;

}
