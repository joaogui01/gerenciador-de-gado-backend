package com.projeto.Gerenciador.de.Gado.dto;

import com.projeto.Gerenciador.de.Gado.entity.Origem;

public record DadosListarOrigem(
		Integer id_origem,
		String nome_origem) {
	
		public DadosListarOrigem(Origem origem) {
			this(
					origem.getId_origem(), 
					origem.getNome_origem());
		}
}
