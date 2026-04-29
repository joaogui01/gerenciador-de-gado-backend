package com.projeto.Gerenciador.de.Gado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.projeto.Gerenciador.de.Gado.entity.Receita;

public record DadosDetalharReceita(
		Integer id_receita,
		LocalDate data_receita,
		Integer id_tipo_receita,
		BigDecimal valor,
		Integer id_animal) {

	public DadosDetalharReceita(Receita receita) {
		this(
				receita.getId_receita(), 
				receita.getData_receita(), 
				receita.getId_tipo_receita(), 
				receita.getValor(), 
				receita.getId_animal());
	}

}
