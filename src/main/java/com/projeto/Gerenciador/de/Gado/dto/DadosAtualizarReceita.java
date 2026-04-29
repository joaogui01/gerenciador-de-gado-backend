package com.projeto.Gerenciador.de.Gado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarReceita(
		
		@NotNull
		Integer id_receita,
		
		LocalDate data_receita,
		Integer id_tipo_receita,
		BigDecimal valor,
		Integer id_animal) {

}
