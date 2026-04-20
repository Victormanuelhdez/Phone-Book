package com.generation.agenda.services;

public class AgendaServices {
    //método para buscar contactos
    public static String buscaContacto(List <Contacto> lista, String nombre){
        for (Contacto c: lista){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return c.getTelefono;
            }
        }
        return null;
    }

    //método para espacios libres
    public static int espaciosDisponibles(List<Contacto> lista) {
        int capacidad = 10;
        int disponibles = capacidad - lista.size();
        return Math.max(disponibles, 0);
    }

    public static boolean agendaLlena(List<Contacto> lista){
        return lista.size() >= 10;
        }
    }

}
