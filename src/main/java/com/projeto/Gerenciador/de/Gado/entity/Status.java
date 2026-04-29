package com.projeto.Gerenciador.de.Gado.entity;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarStatus;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroStatus;

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
public class Status {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_status;
	
	private String descricao;
	
	public Status() {
		
	}
	
	public Status(DadosCadastroStatus dados) {
		this.descricao = dados.descricao();
	}
	
	public Integer getId_status() {
		return id_status;
	}
	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void AtualizarInformacoes(@Valid DadosAtualizarStatus dados) {
		if(dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
	}
}
