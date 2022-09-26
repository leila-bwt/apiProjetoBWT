package com.registro.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.exception.ErroAutenticacao;
import com.registro.exception.RegraNegocioException;
import com.registro.modelDOMEN.Viajante;
import com.registro.repositories.ViajanteRepository;
import com.registro.services.ViajanteLogin;

@Service
public class ViajanteLoginImpl implements ViajanteLogin{

	@Autowired /* Fazer construtores */
	private ViajanteRepository repository;
	
	
	public Viajante autenticar(String email, String senha) {
		Optional<Viajante> viajante = repository.findByEmail(email); 
		
		if (!viajante.isPresent()) {
			throw new ErroAutenticacao("Viajante não encontrado.");
	}
	
		if (!viajante.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Ops... senha incorreta. Tente Novamente.");
			
		}
		return viajante.get();
	}

	
	@Transactional /* qndo ha manipulaçao do db*/
	public Viajante salvarViajante(Viajante viajante) {
		validarEmail(viajante.getEmail());
		return repository.save(viajante);
	}

	
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe um viajante cadastrado com esse e-mail.");
		}
		
	}

	
	public Optional<Viajante> buscarporId(Long id) {
		return repository.findById(id);
	}

	}
