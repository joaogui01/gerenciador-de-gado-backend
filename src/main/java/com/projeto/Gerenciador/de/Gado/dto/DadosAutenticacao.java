package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao (
		
		@NotBlank
		String login,

		@NotBlank
		String senha) {
	
}
