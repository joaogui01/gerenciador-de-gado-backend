package com.projeto.Gerenciador.de.Gado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarTipo_Receita;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarTipo_Receita;
import com.projeto.Gerenciador.de.Gado.entity.Receita;
import com.projeto.Gerenciador.de.Gado.entity.Tipo_Receita;
import com.projeto.Gerenciador.de.Gado.exception.RegraNegocioException;
import com.projeto.Gerenciador.de.Gado.repository.ReceitaRepository;
import com.projeto.Gerenciador.de.Gado.repository.Tipo_ReceitaRepository;

@Service
public class Tipo_ReceitaService {
	
	@Autowired
	private Tipo_ReceitaRepository tipo_ReceitaRepository;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public void cadastrarTipo_Receita(Tipo_Receita tipo_Receita) {
		List<Tipo_Receita> tipo_Receitas = tipo_ReceitaRepository.findAll();
		
		for (Tipo_Receita tp : tipo_Receitas) {
			if (tp.getDescricao().equals(tipo_Receita.getDescricao())) {
				throw new RegraNegocioException("descricao", "'tipo_receita' já existente.");
			}
		}
		
		tipo_ReceitaRepository.save(tipo_Receita);
	}
	
	public void atualizarTipo_Receita(DadosAtualizarTipo_Receita dados) {
		Tipo_Receita tipo_Receita = tipo_ReceitaRepository.getReferenceById(dados.id_tipo_receita());
		List<Tipo_Receita> tipo_Receitas = tipo_ReceitaRepository.findAll();
		
		for (Tipo_Receita tp : tipo_Receitas) {
			if (tp.getDescricao().equals(tipo_Receita.getDescricao())) {
				throw new RegraNegocioException("descricao", "'tipo_receita' já existente.");
			}
		}
		
		tipo_Receita.AtualizarInformacoes(dados);
	}
	
	public void deletarTipo_Receita(Integer id) {
		List<Receita> receitas = receitaRepository.findAll();
		
		for (Receita r : receitas) {
			if (r.getId_tipo_receita().equals(id)) {
				throw new RegraNegocioException("id_tipo_receita", "Existe 'id_receita' com esse 'id_tipo_receita'.");
			}
		}
		
		tipo_ReceitaRepository.deleteById(id);
	}
	
	public ResponseEntity<List<DadosListarTipo_Receita>> listarTipo_Receita() {
	    List<Tipo_Receita> tipo_Receita = tipo_ReceitaRepository.findAll();
	    List<DadosListarTipo_Receita> lista = new ArrayList<>();

	    for (Tipo_Receita t : tipo_Receita) {
	        DadosListarTipo_Receita dados = new DadosListarTipo_Receita(t);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
}
