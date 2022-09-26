package com.registro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.modelDOMEN.Viajante;
import com.registro.services.ViajanteService;

@Service
@RestController /* sinaliza o controlador*/
@RequestMapping (value = "/viajante")  /* rota principal */
@CrossOrigin("*") /* consegue acessar qq lugar-rota*/
public class ViajanteController {
	
	@Autowired
	private ViajanteService ViajanteService;

	/* FIND BY ID */
	@GetMapping(value = "{id}")
	public ResponseEntity<Viajante> findById(@PathVariable Long id){
		Viajante viajante = ViajanteService.findById(id);
		return ResponseEntity.ok().body(viajante);
	}
	
	/* FIND ALL */
	@GetMapping /* readding*/
	public ResponseEntity<List<Viajante>> findAll() {
		List<Viajante> viajante = ViajanteService.findAll();
		return ResponseEntity.ok().body(viajante);
	}
	
	/* SAVE */
	@PostMapping /* referente ao Create*/
	public ResponseEntity<Viajante> save(@RequestBody Viajante viajante) { /* para indicar entrada de usuario*/
		Viajante obj = ViajanteService.save(viajante);
		return ResponseEntity.ok().body(obj);
	
	}
	
	/* UPDATE */
	@PutMapping /* inserção de dados*/
	public ResponseEntity<Viajante> update(@RequestBody Viajante viajante) {
		Viajante obj = ViajanteService.update(viajante);
		return ResponseEntity.ok().body(obj);
	}
	
	/* DELETE */
	@DeleteMapping(value = "/(id)")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		ViajanteService.deleteViajante(id);
		return ResponseEntity.noContent().build();
		
	}
 	
}