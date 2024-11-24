package co.edu.linkedint.linkedin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.linkedint.linkedin.service.PersonaService;
import co.edu.linkedint.linkedin.modelo.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    // Endpoint para crear un nuevo usuario hacer peticion en raw
    @PostMapping("/crear")
    public ResponseEntity<Persona> crearUsuario(@RequestBody Persona persona) {
        Persona createdPersona = personaService.crearUsuario(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPersona);
    }

    // Endpoint para iniciar sesión, hacer peticion por medio de urlencoded en postman
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String contrasena) {
        boolean isValid = personaService.iniciarSesion(email, contrasena);
        if (isValid) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}

