package com.projeto.Gerenciador.de.Gado.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosCadastroAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarFiltradorAnimal;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarIntervaloAnimal;

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
public class Animal {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_animal;
	
	private String brinco;
	private LocalDate data_nascimento;
	private Integer id_sexo;
	private Integer id_raca;
	private BigDecimal peso_entrada;
	private LocalDate data_entrada;
	private Integer id_origem;
	private BigDecimal valor_compra;

	@Column(name = "id_status")
	private Integer idStatus;
	
	private BigDecimal peso_atual;
	private BigDecimal valor_atual;
	private Integer id_lote;
	
	public Animal() {
		
	}
	
	public Animal(DadosCadastroAnimal dados) {
		this.brinco = dados.brinco();
		this.data_nascimento = dados.data_nascimento();
		this.id_sexo = dados.id_sexo();
		this.id_raca = dados.id_raca();
		this.peso_entrada = dados.peso_entrada();
		this.data_entrada = dados.data_entrada();
		this.id_origem = dados.id_origem();
		this.valor_compra = dados.valor_compra();
		this.idStatus = 1;
		this.peso_atual = dados.peso_atual();
		this.valor_atual = dados.valor_atual();
		this.id_lote = dados.id_lote();
	}

	public Animal(DadosListarFiltradorAnimal dados) {
		this.id_animal = dados.id_animal();
		this.data_nascimento = dados.data_nascimento();
		this.id_sexo = dados.id_sexo();
		this.id_raca = dados.id_raca();
		this.peso_entrada = dados.peso_entrada();
		this.data_entrada = dados.data_entrada();
		this.id_origem = dados.id_origem();
		this.valor_compra = dados.valor_compra();
		this.idStatus = dados.idstatus();
		this.peso_atual = dados.peso_atual();
		this.valor_atual = dados.valor_atual();
		this.id_lote = dados.id_lote();
	}

	public Animal(@Valid DadosListarIntervaloAnimal dados) {
		this.data_nascimento = dados.data_nascimento();
		this.peso_entrada = dados.peso_entrada();
		this.data_entrada = dados.data_entrada();
		this.valor_compra = dados.valor_compra();
		this.idStatus = dados.idstatus();
		this.peso_atual = dados.peso_atual();
		this.valor_atual = dados.valor_atual();
	}

	public Integer getId_animal() {
		return id_animal;
	}
	public void setId_animal(Integer id_animal) {
		this.id_animal = id_animal;
	}
	public String getBrinco() {
		return brinco;
	}
	public void setBrinco(String brinco) {
		this.brinco = brinco;
	}
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public Integer getId_sexo() {
		return id_sexo;
	}
	public void setId_sexo(Integer id_sexo) {
		this.id_sexo = id_sexo;
	}
	public Integer getId_raca() {
		return id_raca;
	}
	public void setId_raca(Integer id_raca) {
		this.id_raca = id_raca;
	}
	public BigDecimal getPeso_entrada() {
		return peso_entrada;
	}
	public void setPeso_entrada(BigDecimal peso_entrada) {
		this.peso_entrada = peso_entrada;
	}
	public LocalDate getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(LocalDate data_entrada) {
		this.data_entrada = data_entrada;
	}
	public Integer getId_origem() {
		return id_origem;
	}
	public void setId_origem(Integer id_origem) {
		this.id_origem = id_origem;
	}
	public BigDecimal getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(BigDecimal valor_compra) {
		this.valor_compra = valor_compra;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public BigDecimal getPeso_atual() {
		return peso_atual;
	}
	public void setPeso_atual(BigDecimal peso_atual) {
		this.peso_atual = peso_atual;
	}
	public BigDecimal getValor_atual() {
		return valor_atual;
	}
	public void setValor_atual(BigDecimal valor_atual) {
		this.valor_atual = valor_atual;
	}
	public Integer getId_lote() {
		return id_lote;
	}
	public void setId_lote(Integer id_lote) {
		this.id_lote = id_lote;
	}
	public Integer getIdStatus() {
		return idStatus;
	}

	public void atualizarInformacoes(@Valid DadosAtualizarAnimal dados) {
		if(dados.brinco() != null) {
			this.brinco = dados.brinco();
		}
		if(dados.data_nascimento() != null) {
			this.data_nascimento = dados.data_nascimento();
		}
		if(dados.id_sexo() != null) {
			this.id_sexo = dados.id_sexo();
		}
		if(dados.id_raca() != null) {
			this.id_raca = dados.id_raca();
		}
		if(dados.peso_entrada() != null) {
			this.peso_entrada = dados.peso_entrada();
		}
		if(dados.data_entrada() != null) {
			this.data_entrada = dados.data_entrada();
		}
		if(dados.id_origem() != null) {
			this.id_origem = dados.id_origem();
		}
		if(dados.valor_compra() != null) {
			this.valor_compra = dados.valor_compra();
		}
		if(dados.peso_atual() != null) {
			this.peso_atual = dados.peso_atual();
		}
		if(dados.valor_atual() != null) {
			this.valor_atual = dados.valor_atual();
		}
		if(dados.id_lote() != null) {
			this.id_lote = dados.id_lote();
		}
	}

	public void inativar() {
		this.idStatus = 2;
	}

	public void reativar() {
		this.idStatus = 1;
	}
}
