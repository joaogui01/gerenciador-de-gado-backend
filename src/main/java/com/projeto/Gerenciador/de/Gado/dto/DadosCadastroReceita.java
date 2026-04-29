package com.projeto.Gerenciador.de.Gado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public record DadosCadastroReceita(
		
		@PastOrPresent
		LocalDate data_receita,
		
		@NotNull
		Integer id_tipo_receita,
		
		@Positive
		BigDecimal valor,
		
		@NotNull
		Integer id_animal) {

}
