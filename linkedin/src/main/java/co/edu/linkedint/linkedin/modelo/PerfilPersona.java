package co.edu.linkedint.linkedin.modelo;

import java.util.ArrayList;

public class PerfilPersona extends Perfil {

private int edad;
private String habilidades;
private String estudios;

public PerfilPersona(String nombre, String experiencia, String contacto, String localidad,  ArrayList<String> certificados, String descripcion, int edad, String habilidades, String estudios) {
super(nombre, experiencia, contacto, localidad, certificados, descripcion);
this.edad = edad;
this.habilidades = habilidades;
this.estudios = estudios;
}

public int getEdad() {
return edad;
}

public void setEdad(int edad) {
this.edad = edad;
}

public String getHabilidades() {
return habilidades;
}

public void setHabilidades(String habilidades) {
this.habilidades = habilidades;
}

public String getEstudios() {
return estudios;
}

public void setEstudios(String estudios) {
this.estudios = estudios;
}
}