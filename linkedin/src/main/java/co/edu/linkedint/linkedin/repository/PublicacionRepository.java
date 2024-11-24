package co.edu.linkedint.linkedin.repository;

import co.edu.linkedint.linkedin.modelo.Publicacion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends MongoRepository<Publicacion, ObjectId> {
    List<Publicacion> findAllByOrderByIdDesc();
}
