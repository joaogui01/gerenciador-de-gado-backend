package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroStatus(
		
		@NotBlank
		String descricao) {

}
