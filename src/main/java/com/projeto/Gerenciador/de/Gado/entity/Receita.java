package com.projeto.Gerenciador.de.Gado.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarFiltradorReceita;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarIntervaloReceita;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_receita;
	
	private LocalDate data_receita;
	private Integer id_tipo_receita;
	private BigDecimal valor;
	private Integer id_animal;
	
	public Receita() {
		
	}
	
	public Receita(DadosCadastroReceita dados) {
		this.data_receita = dados.data_receita();
		this.id_tipo_receita = dados.id_tipo_receita();
		this.valor = dados.valor();
		this.id_animal = dados.id_animal();
	}
	
	public Receita(@Valid DadosListarFiltradorReceita dados) {
		this.id_receita = dados.id_receita();
		this.data_receita = dados.data_receita();
		this.id_tipo_receita = dados.id_tipo_receita();
		this.valor = dados.valor();
		this.id_animal = dados.id_animal();
	}

	public Receita(DadosListarIntervaloReceita dados) {
		this.data_receita = dados.data_receita();
		this.valor = dados.valor();
	}

	public Integer getId_receita() {
		return id_receita;
	}
	public void setId_receita(Integer id_receita) {
		this.id_receita = id_receita;
	}
	public LocalDate getData_receita() {
		return data_receita;
	}
	public void setData_receita(LocalDate data_receita) {
		this.data_receita = data_receita;
	}
	public Integer getId_tipo_receita() {
		return id_tipo_receita;
	}
	public void setId_tipo_receita(Integer id_tipo_receita) {
		this.id_tipo_receita = id_tipo_receita;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Integer getId_animal() {
		return id_animal;
	}
	public void setId_animal(Integer id_animal) {
		this.id_animal = id_animal;
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizarReceita dados) {
		if(dados.data_receita() != null) {
			this.data_receita = dados.data_receita();
		}
		if(dados.id_tipo_receita() != null) {
			this.id_tipo_receita = dados.id_tipo_receita();
		}
		if(dados.valor() != null) {
			this.valor = dados.valor();
		}
		if(dados.id_animal() != null) {
			this.id_animal = dados.id_animal();
		}
	}
}
