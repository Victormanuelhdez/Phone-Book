package com.generation.agenda.services;

public class AgendaServices {

    public boolean agendaLlena() {
        return totalContactos == agenda.length;
    }

    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < totalContactos; i++) {
            if (agenda[i].getNombre().equalsIgnoreCase(c.getNombre()) &&
                    agenda[i].getApellido().equalsIgnoreCase(c.getApellido())) {
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
        if (agendaLlena()) {
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



}


}
