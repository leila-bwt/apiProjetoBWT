package com.registro.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.registro.modelDOMEN.Viajante;

@Repository
public interface ViajanteRepository  extends JpaRepository<Viajante, Long>{
	
	
	/*query methods*/
	boolean existsByEmail(String email); 
	Optional<Viajante> findByEmail(String email);

	

	
	
}
