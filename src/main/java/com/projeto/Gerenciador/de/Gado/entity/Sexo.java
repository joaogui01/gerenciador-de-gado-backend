package com.projeto.Gerenciador.de.Gado.entity;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarSexo;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroSexo;

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
public class Sexo {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_sexo;
	
	private String descricao;
	
	public Sexo() {
		
	}
	
	public Sexo(DadosCadastroSexo dados) {
		this.descricao = dados.descricao();
	}
	
	public Integer getId_sexo() {
		return id_sexo;
	}
	public void setId_sexo(Integer id_sexo) {
		this.id_sexo = id_sexo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void atualizarInfomacoes(@Valid DadosAtualizarSexo dados) {
		if(dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
	}
}
