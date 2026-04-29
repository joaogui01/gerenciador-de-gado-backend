package com.projeto.Gerenciador.de.Gado.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public record DadosCadastroLote(
		
		@NotBlank
		String nome_lote,
		
		@PastOrPresent
		LocalDate data_criacao,
		
		String obs_lote) {

}
