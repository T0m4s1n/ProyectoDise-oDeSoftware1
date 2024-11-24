package co.edu.linkedint.linkedin.service;

import co.edu.linkedint.linkedin.modelo.Publicacion;
import co.edu.linkedint.linkedin.repository.PublicacionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;


    public Publicacion crearPublicacion(Publicacion publicacion) {

        return publicacionRepository.save(publicacion);
    }


    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionRepository.findAllByOrderByIdDesc();
    }


    public Optional<Publicacion> obtenerPublicacionPorId(ObjectId id) {
        return publicacionRepository.findById(id);
    }

 
    public Publicacion darLike(ObjectId id) {
        Optional<Publicacion> publicacionOpt = publicacionRepository.findById(id);
        if (publicacionOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            publicacion.setNumLike(publicacion.getNumLike() + 1);
            return publicacionRepository.save(publicacion);
        }
        throw new RuntimeException("Publicación no encontrada");
    }


    public Publicacion agregarComentario(ObjectId id, String comentario) {
        Optional<Publicacion> publicacionOpt = publicacionRepository.findById(id);
        if (publicacionOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            List<String> comentarios = publicacion.getComentarios();
            comentarios.add(comentario);
            publicacion.setComentarios(comentarios);
            return publicacionRepository.save(publicacion);
        }
        throw new RuntimeException("Publicación no encontrada");
    }

    public void eliminarPublicacion(ObjectId id) {
        publicacionRepository.deleteById(id);
    }
}
