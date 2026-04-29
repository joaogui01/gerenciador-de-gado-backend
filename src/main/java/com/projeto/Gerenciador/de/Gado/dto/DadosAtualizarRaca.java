package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRaca(		
		
		@NotNull
		Integer id_raca,
		String nome_raca,
		String sigla) {

}
