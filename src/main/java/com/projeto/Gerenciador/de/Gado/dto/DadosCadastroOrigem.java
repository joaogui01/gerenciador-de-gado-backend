package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroOrigem(
		
		@NotBlank
		String nome_origem) {

}
