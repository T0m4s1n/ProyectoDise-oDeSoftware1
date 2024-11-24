package co.edu.linkedint.linkedin;

import co.edu.linkedint.linkedin.modelo.Publicacion;
import co.edu.linkedint.linkedin.service.PublicacionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/publicaciones")
@CrossOrigin(origins = "*")  
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;


    @PostMapping
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        try {
            Publicacion nuevaPublicacion = publicacionService.crearPublicacion(publicacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPublicacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Publicacion>> obtenerPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.obtenerTodasLasPublicaciones();
        return ResponseEntity.ok(publicaciones);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable String id) {
        try {
            return publicacionService.obtenerPublicacionPorId(new ObjectId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/{id}/like")
    public ResponseEntity<Publicacion> darLike(@PathVariable String id) {
        try {
            Publicacion publicacion = publicacionService.darLike(new ObjectId(id));
            return ResponseEntity.ok(publicacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/{id}/comentar")
    public ResponseEntity<Publicacion> agregarComentario(
            @PathVariable String id,
            @RequestBody Map<String, String> comentario) {
        try {
            Publicacion publicacion = publicacionService.agregarComentario(
                new ObjectId(id),
                comentario.get("comentario")
            );
            return ResponseEntity.ok(publicacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable String id) {
        try {
            publicacionService.eliminarPublicacion(new ObjectId(id));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
