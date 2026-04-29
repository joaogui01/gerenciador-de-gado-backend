package com.projeto.Gerenciador.de.Gado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public record DadosCadastroAnimal(
		
		 	@NotBlank
		    String brinco,

		    @Past
		    LocalDate data_nascimento,

		    @NotNull
		    Integer id_sexo,

		    @NotNull
		    Integer id_raca,

		    @Positive
		    BigDecimal peso_entrada,

		    @PastOrPresent
		    LocalDate data_entrada,

		    @NotNull
		    Integer id_origem,

		    @Positive
		    BigDecimal valor_compra,

		    @Positive
		    BigDecimal peso_atual,

		    @Positive
		    BigDecimal valor_atual,

		    @NotNull
		    Integer id_lote) {
	
}
