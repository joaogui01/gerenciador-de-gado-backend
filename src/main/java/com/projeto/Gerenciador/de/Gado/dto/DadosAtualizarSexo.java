package com.projeto.Gerenciador.de.Gado.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarSexo(
		
		@NotNull
		Integer id_sexo,
		String descricao) {

}
