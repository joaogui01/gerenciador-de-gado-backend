package com.projeto.Gerenciador.de.Gado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListarIntervaloAnimal(	
		LocalDate data_nascimento,
		BigDecimal peso_entrada,
		LocalDate data_entrada,
		BigDecimal valor_compra,
		Integer idstatus,
		BigDecimal peso_atual,
		BigDecimal valor_atual) {

}

