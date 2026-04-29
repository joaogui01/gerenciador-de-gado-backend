package com.projeto.Gerenciador.de.Gado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListarIntervaloReceita(
		LocalDate data_receita,
		BigDecimal valor) {

}
