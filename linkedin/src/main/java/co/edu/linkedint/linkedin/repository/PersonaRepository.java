package co.edu.linkedint.linkedin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.linkedint.linkedin.modelo.Persona;
import java.util.Optional;

public interface PersonaRepository extends MongoRepository<Persona, String> {
	
	Optional<Persona> findByEmailAndContrasena(String email, String contrasena);
	
	
    // Buscar personas por email
	Optional<Persona> findByEmail(String email);

}
