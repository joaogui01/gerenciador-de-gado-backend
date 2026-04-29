package com.projeto.Gerenciador.de.Gado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.Gerenciador.de.Gado.dto.DadosAtualizarSexo;
import com.projeto.Gerenciador.de.Gado.dto.DadosListarSexo;
import com.projeto.Gerenciador.de.Gado.entity.Animal;
import com.projeto.Gerenciador.de.Gado.entity.Sexo;
import com.projeto.Gerenciador.de.Gado.exception.RegraNegocioException;
import com.projeto.Gerenciador.de.Gado.repository.AnimalRepository;
import com.projeto.Gerenciador.de.Gado.repository.SexoRepository;

@Service
public class SexoService {
	
	@Autowired
	private SexoRepository sexoRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public void cadastrarSexo(Sexo sexo) {
		List<Sexo> sexos = sexoRepository.findAll();
		
		for (Sexo s : sexos) {
			if (s.getDescricao().equals(sexo.getDescricao())) {
				throw new RegraNegocioException("descricao", "'sexo' já existente.");
			}
		}
		
		sexoRepository.save(sexo);
	}
	
	public void atualizarSexo(DadosAtualizarSexo dados) {
		Sexo sexo = sexoRepository.getReferenceById(dados.id_sexo());
		List<Sexo> sexos = sexoRepository.findAll();
		
		for (Sexo s : sexos) {
			if (s.getDescricao().equals(sexo.getDescricao())) {
				throw new RegraNegocioException("descricao", "'sexo' já existente.");
			}
		}
		
		sexo.atualizarInfomacoes(dados);
	}
	
	public void deletarSexo(Integer id) {
		List<Animal> animais = animalRepository.findAll();
		
		for (Animal a : animais) {
			if (a.getId_sexo().equals(id)) {
				throw new RegraNegocioException("id_sexo", "Existe 'id_animal' com esse 'id_sexo'.");
			}
		}
		
		sexoRepository.deleteById(id);
	}
	
	public ResponseEntity<List<DadosListarSexo>> listarSexo() {
	    List<Sexo> sexo = sexoRepository.findAll();
	    List<DadosListarSexo> lista = new ArrayList<>();

	    for (Sexo s : sexo) {
	        DadosListarSexo dados = new DadosListarSexo(s);
	        lista.add(dados);
	    }

	    return ResponseEntity.ok(lista);
	}
}
