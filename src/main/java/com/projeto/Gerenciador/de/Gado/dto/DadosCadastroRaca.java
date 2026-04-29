package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRaca(
		
		@NotBlank
		String nome_raca,
		
		@NotBlank
		String sigla) {
	
}
