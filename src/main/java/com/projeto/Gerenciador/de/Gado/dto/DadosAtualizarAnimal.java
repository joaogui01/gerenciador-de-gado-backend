package com.projeto.Gerenciador.de.Gado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAnimal(
		
		@NotNull
		Integer id_animal,
		
		String brinco,
		LocalDate data_nascimento,
		Integer id_sexo,
		Integer id_raca,
		BigDecimal peso_entrada,
		LocalDate data_entrada,
		Integer id_origem,
		BigDecimal valor_compra,
		BigDecimal peso_atual,
		BigDecimal valor_atual,
		Integer id_lote) {

}
