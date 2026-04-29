package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarStatus(		
		
		@NotNull
		Integer id_status,
		String descricao) {

}
