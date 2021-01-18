package com.zup.loteria.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.loteria.dto.ApostaRegisterDto;
import com.zup.loteria.modelo.Aposta;
import com.zup.loteria.repository.ApostaRepository;

@RestController
@RequestMapping("/apostas")
public class ApostaController {
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	@GetMapping
	public List<Aposta> list(String email){
		if(email != null) {
			return apostaRepository.findByEmailOrderByCreatedAtDesc(email);
		}
		return apostaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Aposta> create (@Valid @RequestBody ApostaRegisterDto body, UriComponentsBuilder uriBuilder) {			
		Aposta aposta = body.converter();
		apostaRepository.save(aposta);
		
		URI uri = uriBuilder.path("/apostas/{id}").buildAndExpand(aposta.getId()).toUri();
		return ResponseEntity.created(uri).body(aposta);		
	}
}
