package com.projeto.Gerenciador.de.Gado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.Gerenciador.de.Gado.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	List<Animal> findAllByIdStatus(Integer idstatus);

}
