package com.projeto.Gerenciador.de.Gado.entity;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarTipo_Receita;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroTipo_Receita;

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
public class Tipo_Receita {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_receita;
	
	private String descricao;
	
	public Tipo_Receita() {
		
	}
	
	public Tipo_Receita(DadosCadastroTipo_Receita dados) {
		this.descricao = dados.descricao();
	}
	
	public Integer getId_tipo_receita() {
		return id_tipo_receita;
	}
	public void setId_tipo_receita(Integer id_tipo_receita) {
		this.id_tipo_receita = id_tipo_receita;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void AtualizarInformacoes(@Valid DadosAtualizarTipo_Receita dados) {
		if(dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
	}
}
