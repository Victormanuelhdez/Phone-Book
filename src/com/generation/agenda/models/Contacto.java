package com.generation.agenda.models;

import java.util.Objects;

public class Contacto {

    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String apellido, String telefono) {
        this(nombre, apellido, telefono, "");
    }

    public Contacto(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre == null ? "" : nombre.trim();
        this.apellido = apellido == null ? "" : apellido.trim();
        this.telefono = telefono == null ? "" : telefono.trim();
        this.correo = correo == null ? "" : correo.trim();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre == null ? "" : nombre.trim(); }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido == null ? "" : apellido.trim(); }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono == null ? "" : telefono.trim(); }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo == null ? "" : correo.trim(); }

    // Dos contactos son iguales si comparten nombre y apellido (sin importar mayúsculas/minúsculas).
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto other = (Contacto) o;
        return nombre.equalsIgnoreCase(other.nombre)
                && apellido.equalsIgnoreCase(other.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}
