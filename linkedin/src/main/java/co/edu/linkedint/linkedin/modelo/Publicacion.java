package co.edu.linkedint.linkedin.modelo;

import java.util.List;
import org.bson.types.ObjectId;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize; 
import org.springframework.data.annotation.Id;

public class Publicacion {

    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private String contenido;
    private String multimedia; 
    private int numLike;
    private List<String> comentarios;

    @JsonCreator
    public Publicacion(
        @JsonProperty("id") ObjectId id,
        @JsonProperty("contenido") String contenido,
        @JsonProperty("multimedia") String multimedia,
        @JsonProperty("comentarios") List<String> comentarios) {
        
        this.id = id;
        this.contenido = contenido;
        this.multimedia = multimedia != null ? multimedia : null; 
        this.comentarios = comentarios != null ? comentarios : List.of();  
        this.numLike = 0;  
    }

    // Getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }
}

