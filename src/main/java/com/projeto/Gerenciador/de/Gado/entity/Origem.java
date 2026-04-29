package com.projeto.Gerenciador.de.Gado.entity;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarOrigem;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroOrigem;

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
public class Origem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_origem;
	
	private String nome_origem;
	
	public Origem() {
		
	}
	
	public Origem(DadosCadastroOrigem dados) {
		this.nome_origem = dados.nome_origem();
	}
	
	public Integer getId_origem() {
		return id_origem;
	}
	public void setId_origem(Integer id_origem) {
		this.id_origem = id_origem;
	}
	public String getNome_origem() {
		return nome_origem;
	}
	public void setNome_origem(String nome_origem) {
		this.nome_origem = nome_origem;
	}
	
	public void atualizarInfomacoes(@Valid DadosAtualizarOrigem dados) {
		if(dados.nome_origem() != null) {
			this.nome_origem = dados.nome_origem();
		}
	}
}
