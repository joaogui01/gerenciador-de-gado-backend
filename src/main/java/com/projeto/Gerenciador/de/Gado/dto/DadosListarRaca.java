package com.projeto.Gerenciador.de.Gado.dto;

import com.projeto.Gerenciador.de.Gado.entity.Raca;

public record DadosListarRaca(
		Integer id_raca,
		String nome_raca,
		String sigla) {

		public DadosListarRaca(Raca raca) {
			this(
					raca.getId_raca(), 
					raca.getNome_raca(), 
					raca.getSigla());
		}
	
}
