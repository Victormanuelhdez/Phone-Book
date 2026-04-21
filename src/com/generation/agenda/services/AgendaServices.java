package com.generation.agenda.services;

import com.generation.agenda.models.Contacto;

import java.util.Arrays;
import java.util.Comparator;

public class AgendaServices {

    private static final int TAMANO_POR_DEFECTO = 10;

    private final Contacto[] agenda;
    private int totalContactos;

    public AgendaServices() {
        this(TAMANO_POR_DEFECTO);
    }

    public AgendaServices(int tamanoMaximo) {
        if (tamanoMaximo <= 0) {
            tamanoMaximo = TAMANO_POR_DEFECTO;
        }
        this.agenda = new Contacto[tamanoMaximo];
        this.totalContactos = 0;
    }

    public boolean agendaLlena() {
        boolean llena = totalContactos == agenda.length;
        if (llena) {
            System.out.println("La agenda está llena. No hay espacio disponible para nuevos contactos.");
        }
        return llena;
    }

    public int espaciosLibres() {
        int libres = agenda.length - totalContactos;
        System.out.println("Espacios libres: " + libres);
        return libres;
    }

    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < totalContactos; i++) {
            if (agenda[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    public void añadirContacto(Contacto c) {
        if (c.getNombre().isEmpty() || c.getApellido().isEmpty()) {
            System.out.println("Error: nombre y apellido son obligatorios.");
            return;
        }
        if (totalContactos == agenda.length) {
            System.out.println("Error: la agenda está llena.");
            return;
        }
        if (existeContacto(c)) {
            System.out.println("Error: el contacto ya existe.");
            return;
        }
        agenda[totalContactos] = c;
        totalContactos++;
        System.out.println("Contacto añadido correctamente.");
    }

    public void listarContactos() {
        if (totalContactos == 0) {
            System.out.println("La agenda está vacía.");
            return;
        }

        Arrays.sort(agenda, 0, totalContactos,
                Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Lista de contactos:");
        for (int i = 0; i < totalContactos; i++) {
            System.out.println(agenda[i]);
        }
    }

    public void buscarContacto(String nombre, String apellido) {
        int idx = indiceDe(nombre, apellido);
        if (idx == -1) {
            System.out.println("Contacto no encontrado.");
            return;
        }
        System.out.println("Teléfono: " + agenda[idx].getTelefono() + "Correo: " + agenda[idx].getCorreo());
    }

    public void eliminarContacto(Contacto c) {
        int idx = indiceDe(c.getNombre(), c.getApellido());
        if (idx == -1) {
            System.out.println("No se pudo eliminar: el contacto no existe.");
            return;
        }
        // Desplaza los siguientes una posición a la izquierda
        for (int i = idx; i < totalContactos - 1; i++) {
            agenda[i] = agenda[i + 1];
        }
        agenda[totalContactos - 1] = null;
        totalContactos--;
        System.out.println("Contacto eliminado correctamente.");
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        int idx = indiceDe(nombre, apellido);
        if (idx == -1) {
            System.out.println("No se pudo modificar: el contacto no existe.");
            return;
        }
        agenda[idx].setTelefono(nuevoTelefono);
        System.out.println("Teléfono actualizado correctamente.");
    }

    // Búsqueda interna reutilizada por buscar, eliminar y modificar para evitar duplicar bucles.
    private int indiceDe(String nombre, String apellido) {
        if (nombre == null || apellido == null) return -1;
        for (int i = 0; i < totalContactos; i++) {
            if (agenda[i].getNombre().equalsIgnoreCase(nombre.trim())
                    && agenda[i].getApellido().equalsIgnoreCase(apellido.trim())) {
                return i;
            }
        }
        return -1;
    }
}
