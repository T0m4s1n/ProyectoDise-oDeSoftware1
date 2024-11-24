package co.edu.linkedint.linkedin.modelo;
import org.bson.types.ObjectId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize; 
import org.springframework.data.annotation.Id;

public class Usuario {
	
    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    protected ObjectId id;
    
	protected String email;
	protected String contrasena;
	
	public Usuario(ObjectId id, String email, String contrasena) {
		super();
		this.id = id;
		this.email = email;
		this.contrasena = contrasena;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
