package com.projeto.Gerenciador.de.Gado.dto;

import com.projeto.Gerenciador.de.Gado.entity.Sexo;

public record DadosListarSexo(
		Integer id_sexo,
		String descricao) {

	public DadosListarSexo(Sexo sexo) {
		this(sexo.getId_sexo(), sexo.getDescricao());
	}
	
}
