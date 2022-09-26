package com.registro.services;

import java.util.Optional;

import com.registro.modelDOMEN.Viajante;

public interface ViajanteLogin {

	Viajante autenticar(String email, String senha);
	
	Viajante salvarViajante(Viajante viajante);
	
	void validarEmail(String email);
	
	Optional<Viajante>buscarporId(Long id);
}
