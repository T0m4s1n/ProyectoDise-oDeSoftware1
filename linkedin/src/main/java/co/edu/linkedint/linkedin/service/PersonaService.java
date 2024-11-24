package co.edu.linkedint.linkedin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import co.edu.linkedint.linkedin.repository.PersonaRepository;
import co.edu.linkedint.linkedin.modelo.Persona;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    // Cifrador de contraseñas
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Crear un nuevo usuario
    public Persona crearUsuario(Persona persona) {
        // Cifrar la contraseña antes de guardarla
        String hashedPassword = passwordEncoder.encode(persona.getContrasena());
        persona.setContrasena(hashedPassword);
        return personaRepository.save(persona);
    }

    // Iniciar sesión (validación de credenciales)
    public boolean iniciarSesion(String email, String contrasena) {
        Optional<Persona> personaOptional = personaRepository.findByEmail(email);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            // Comparar contraseñas cifradas
            return passwordEncoder.matches(contrasena, persona.getContrasena());
        }
        return false;
    }
}
