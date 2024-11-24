package co.edu.linkedint.linkedin.modelo;
import org.bson.types.ObjectId;


public class Persona extends Usuario{
	
	private PerfilPersona perfil;

	public Persona(ObjectId id, String email, String contrasena, PerfilPersona perfil) {
		super(id, email, contrasena);
		this.perfil = perfil;
	}

	public PerfilPersona getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilPersona perfil) {
		this.perfil = perfil;
	}
	
}
