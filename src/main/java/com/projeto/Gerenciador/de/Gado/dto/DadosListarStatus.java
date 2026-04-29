package com.projeto.Gerenciador.de.Gado.dto;

import com.projeto.Gerenciador.de.Gado.entity.Status;

public record DadosListarStatus(
		Integer id_status,
		String descricao) {

		public DadosListarStatus(Status status) {
			this(
					status.getId_status(), 
					status.getDescricao());
		}
	
}
