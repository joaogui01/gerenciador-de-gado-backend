package com.projeto.Gerenciador.de.Gado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.projeto.Gerenciador.de.Gado.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	UserDetails findByLogin(String login);

}
