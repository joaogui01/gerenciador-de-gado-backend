package com.projeto.Gerenciador.de.Gado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.projeto.Gerenciador.de.Gado.entity.Animal;

public record DadosListarAnimal(
		Integer id_animal,
		String brinco,
		LocalDate data_nascimento,
		Integer id_sexo,
		Integer id_raca,
		BigDecimal peso_entrada,
		LocalDate data_entrada,
		Integer id_origem,
		BigDecimal valor_compra,
		Integer idstatus,
		BigDecimal peso_atual,
		BigDecimal valor_atual,
		Integer id_lote) {
	
	public DadosListarAnimal(Animal animal) {
		this(
				animal.getId_animal(), 
				animal.getBrinco(), 
				animal.getData_nascimento(), 
				animal.getId_sexo(), 
				animal.getId_raca(), 
				animal.getPeso_entrada(),
				animal.getData_entrada(), 
				animal.getId_origem(), 
				animal.getValor_compra(), 
				animal.getIdStatus(), 
				animal.getPeso_atual(), 
				animal.getValor_atual(), 
				animal.getId_lote());
	}

}
