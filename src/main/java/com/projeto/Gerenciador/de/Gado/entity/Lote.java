package com.projeto.Gerenciador.de.Gado.entity;

import java.time.LocalDate;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarLote;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroLote;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarFiltradorLote;

import jakarta.persistence.Column;
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
public class Lote {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_lote;
	
	private String nome_lote;
	private LocalDate data_criacao;
	private String obs_lote;
	
	@Column(name = "id_status")
	private Integer idStatus;
	
	public Lote() {
		
	}
	
	public Lote(DadosCadastroLote dados) {
		this.nome_lote = dados.nome_lote();
		this.data_criacao = dados.data_criacao();
		this.obs_lote = dados.obs_lote();
		this.idStatus = 1;
	}
	
	public Lote(DadosListarFiltradorLote dados) {
		this.id_lote = dados.id_lote();
		this.nome_lote = dados.nome_lote();
		this.data_criacao = dados.data_criacao();
		this.obs_lote = dados.obs_lote();
		this.idStatus = dados.idStatus();
	}

	public Integer getId_lote() {
		return id_lote;
	}
	public void setId_lote(Integer id_lote) {
		this.id_lote = id_lote;
	}
	public String getNome_lote() {
		return nome_lote;
	}
	public void setNome_lote(String nome_lote) {
		this.nome_lote = nome_lote;
	}
	public LocalDate getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(LocalDate data_criacao) {
		this.data_criacao = data_criacao;
	}
	public String getObs_lote() {
		return obs_lote;
	}
	public void setObs_lote(String obs_lote) {
		this.obs_lote = obs_lote;
	}
	public Integer isIdtatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public Integer getIdStatus() {
		return idStatus;
	}

	public void atualizarInformacoes(@Valid DadosAtualizarLote dados) {
		if(dados.nome_lote() != null) {
			this.nome_lote = dados.nome_lote();
		}
		if(dados.data_criacao() != null) {
			this.data_criacao = dados.data_criacao();
		}
		if(dados.obs_lote() != null) {
			this.obs_lote = dados.obs_lote();
		}
	}

	public void inativar() {
		this.idStatus = 2;
	}

	public void reativar() {
		this.idStatus = 1;
	}
}
