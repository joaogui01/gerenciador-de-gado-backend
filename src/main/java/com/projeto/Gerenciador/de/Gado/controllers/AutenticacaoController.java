package com.projeto.Gerenciador.de.Gado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.Gerenciador.de.Gado.config.TokenService;
import com.projeto.Gerenciador.de.Gado.dto.DadosAutenticacao;
import com.projeto.Gerenciador.de.Gado.dto.DadosTokenJWT;
import com.projeto.Gerenciador.de.Gado.entity.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> efetuarLogin (@RequestBody @Valid DadosAutenticacao dados){
	    var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = manager.authenticate(token);
		
		var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
		
	    return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
}
