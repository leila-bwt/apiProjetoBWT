package com.registro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.modelDOMEN.Viajante;
import com.registro.repositories.ViajanteRepository;
import com.registro.service.exception.ObjectNotFoundException;

@Service
public class ViajanteService {
	
	@Autowired
	private ViajanteRepository ViajanteRepository;
	
	/* FIND BY ID */
	public Viajante findById(Long id) {
		Optional<Viajante> viajante = ViajanteRepository.findById(id);
		return viajante.orElseThrow(() -> new ObjectNotFoundException ("Objeto com id: "
+ id + " não foi encontrado. Tipo: " + Viajante.class.getName()));
	}
	
	/* FIND ALL */
	public List<Viajante> findAll() {
		return ViajanteRepository.findAll();
	}
	
	/* SAVE  = create*/
	public Viajante save(Viajante viajante) {
		return ViajanteRepository.save(viajante);
	}
	
	/* UPDATE */
	public Viajante update(Viajante viajante) {
		findById(viajante.getId());
		return ViajanteRepository.save(viajante);
	}
	
	/* DELETE */
	public void deleteViajante(Long id) {
		ViajanteRepository.deleteById(id);
	}
	
	
}
