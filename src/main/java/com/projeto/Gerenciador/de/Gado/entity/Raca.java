package com.projeto.Gerenciador.de.Gado.entity;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarRaca;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroRaca;

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
public class Raca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_raca;
	
	private String nome_raca;
	private String sigla;
	
	public Raca() {
		
	}
	
	public Raca(DadosCadastroRaca dados) {
		this.nome_raca = dados.nome_raca();
		this.sigla = dados.sigla();
	}
	
	public Integer getId_raca() {
		return id_raca;
	}
	public void setId_raca(Integer id_raca) {
		this.id_raca = id_raca;
	}
	public String getNome_raca() {
		return nome_raca;
	}
	public void setNome_raca(String nome_raca) {
		this.nome_raca = nome_raca;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizarRaca dados) {
		if(dados.nome_raca() != null) {
			this.nome_raca = dados.nome_raca();
		}
		if(dados.sigla() != null) {
			this.sigla = dados.sigla();
		}
	}
}
