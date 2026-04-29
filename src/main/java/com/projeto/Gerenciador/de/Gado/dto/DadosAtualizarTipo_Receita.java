package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTipo_Receita(
		
		@NotNull
		Integer id_tipo_receita,
		String descricao) {

}
