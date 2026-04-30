package com.projeto.Gerenciador.de.Gado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.Gerenciador.de.Gado.dto.DadosAutenticacao;
import com.projeto.Gerenciador.de.Gado.entity.Usuario;
import com.projeto.Gerenciador.de.Gado.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/login")
	public ResponseEntity<?> efetuarLogin (@RequestBody @Valid DadosAutenticacao dados){
	    var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = manager.authenticate(token);
	
	    return ResponseEntity.ok().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registrar (@RequestBody @Valid DadosAutenticacao dados){
		if(this.usuarioRepository.findByLogin(dados.login()) != null) {
			return ResponseEntity.badRequest().build();
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
		Usuario usuario = new Usuario(dados.login(), encryptedPassword);
		
		this.usuarioRepository.save(usuario);
		
	    return ResponseEntity.ok().build();
	}
}
