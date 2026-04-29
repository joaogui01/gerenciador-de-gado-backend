package com.projeto.Gerenciador.de.Gado.dto;

import com.projeto.Gerenciador.de.Gado.entity.Tipo_Receita;

public record DadosListarTipo_Receita(
		Integer id_tipo_receita,
		String descricao) {
		
		public DadosListarTipo_Receita(Tipo_Receita tipo_Receita) {
			this(tipo_Receita.getId_tipo_receita(), tipo_Receita.getDescricao());
		}
	
}
