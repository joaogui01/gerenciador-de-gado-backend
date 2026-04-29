package com.projeto.Gerenciador.de.Gado.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLote(
		
		@NotNull
		Integer id_lote,
		
		String nome_lote,
		LocalDate data_criacao,
		String obs_lote) {

}
