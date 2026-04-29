package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTipo_Receita(
		
		@NotBlank
		String descricao) {
	
}
