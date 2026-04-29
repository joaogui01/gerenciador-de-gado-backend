package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroSexo(
		
		@NotBlank
		String descricao) {

}
