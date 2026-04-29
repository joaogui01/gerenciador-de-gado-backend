package com.projeto.Gerenciador.de.Gado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.Gerenciador.de.Gado.entity.Lote;

public interface LoteRepository extends JpaRepository<Lote, Integer>{
	List<Lote> findAllByIdStatus(Integer idStaus);
	
}
