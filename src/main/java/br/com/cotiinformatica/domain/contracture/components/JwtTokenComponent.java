package br.com.cotiinformatica.domain.contracture.components;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtTokenComponent {
	 
		public String generateToken(UUID usuarioId) {

			var dataAtual = new Date(); 

			return Jwts.builder().setSubject(usuarioId.toString()) 
				.setNotBefore(dataAtual) 
				.setExpiration(new Date(dataAtual.getTime() + 600000)) 
				.signWith(SignatureAlgorithm.HS256, "73cbce54-24dd-46af-a820-4e8fa5f8ecc2") 
				.compact();
		}
	}
