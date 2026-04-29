package com.projeto.Gerenciador.de.Gado.dto;

import java.time.LocalDate;

public record DadosListarFiltradorLote(
		Integer id_lote,
		String nome_lote,
		LocalDate data_criacao,
		String obs_lote,
		Integer idStatus) {

}
