package com.generation.agenda.test;

import com.generation.agenda.models.Contacto;
import com.generation.agenda.services.AgendaServices;

public class AgendaTest {

    public static void main(String[] args) {
        AgendaServices agenda = new AgendaServices(3);

        System.out.println("--- Alta de contactos ---");
        agenda.añadirContacto(new Contacto("Ana", "López", "555-1111"));
        agenda.añadirContacto(new Contacto("Luis", "Pérez", "555-2222"));
        agenda.añadirContacto(new Contacto("", "Sin nombre", "000"));        // debe rechazar
        agenda.añadirContacto(new Contacto("ana", "lópez", "555-9999"));     // duplicado (case-insensitive)

        System.out.println("\n--- Listar ---");
        agenda.listarContactos();

        System.out.println("\n--- Buscar ---");
        agenda.buscarContacto("Luis", "Pérez");
        agenda.buscarContacto("Pepe", "Ficticio");

        System.out.println("\n--- Modificar ---");
        agenda.modificarTelefono("Ana", "López", "555-0000");
        agenda.buscarContacto("Ana", "López");

        System.out.println("\n--- Espacios libres ---");
        agenda.espaciosLibres();

        System.out.println("\n--- Llenar y probar llena ---");
        agenda.añadirContacto(new Contacto("Carlos", "Ruiz", "555-3333"));
        agenda.agendaLlena();
        agenda.añadirContacto(new Contacto("Extra", "Persona", "555-4444")); // debe rechazar

        System.out.println("\n--- Eliminar ---");
        agenda.eliminarContacto(new Contacto("Luis", "Pérez", ""));
        agenda.eliminarContacto(new Contacto("No", "Existe", ""));
        agenda.listarContactos();
        agenda.espaciosLibres();
    }
}
