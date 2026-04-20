package com.generation.agenda.services;
import com.generation.agenda.models.Contacto;

import java.util.Scanner;

public class AgendaServices {

    //  Método de modificar teléfono
    public void modificarTelefono(String nombre, String nuevoTelefono) {
        for (Contacto c : agenda ) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado para " + nombre);
                return;
            }
        }
        System.out.println("No se encontró el contacto para modificar.");
    }

    //  Método para eliminar teléfono
    public void eliminarContacto(Contacto c) {
        if (agenda.remove(c)) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("El contacto no existe.");
        }
    }
}
