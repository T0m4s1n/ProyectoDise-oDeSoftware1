package co.edu.linkedint.linkedin.modelo;

import java.util.ArrayList;

public abstract class Perfil {
    protected String nombre;
    protected String experiencia;
    protected String contacto;
    protected String localidad;
    protected ArrayList<String> certificados;
    protected String descripcion;

    public Perfil(String nombre, String experiencia, String contacto, String localidad, ArrayList<String> certificados, String descripcion) {
        super();
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.contacto = contacto;
        this.localidad = localidad;
        this.certificados = certificados;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public ArrayList<String> getCertificados() {
        return certificados;
    }

    public void setCertificados(ArrayList<String> certificados) {
        this.certificados = certificados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}