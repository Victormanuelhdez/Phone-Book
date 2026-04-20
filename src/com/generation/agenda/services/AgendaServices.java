package com.generation.agenda.services;
import java.util.ArrayList;
import java.util.Comparator;

public class AgendaServices {
    // Listar contactos
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("📭 La agenda está vacía.");
            return;
        }

        contactos.sort(Comparator.comparing(Contacto::getNombre)
                .thenComparing(Contacto::getApellido));

        System.out.println("📑 Lista de contactos:");
        for (Contacto c : contactos) {
            System.out.println("👤 " + c.getNombre() + " " + c.getApellido() + " - 📞 " + c.getTelefono());
        }
    }


}
