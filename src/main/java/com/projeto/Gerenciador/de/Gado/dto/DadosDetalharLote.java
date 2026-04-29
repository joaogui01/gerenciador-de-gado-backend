package com.projeto.Gerenciador.de.Gado.dto;

import java.time.LocalDate;

import com.projeto.Gerenciador.de.Gado.entity.Lote;

public record DadosDetalharLote(
		Integer id_lote,
		String nome_lote,
		LocalDate data_criacao,
		String obs_lote,
		Integer idStatus) {

		public DadosDetalharLote(Lote lote) {
			this(
					lote.getId_lote(), 
					lote.getNome_lote(), 
					lote.getData_criacao(), 
					lote.getObs_lote(), 
					lote.getIdStatus());
		}

}
