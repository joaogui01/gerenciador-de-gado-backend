package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarOrigem(
		
		@NotNull
		Integer id_origem,
		String nome_origem) {
	
}
