package com.generation.agenda.services;

public class AgendaServices {
    //método para buscar contactos
    public static Contacto buscarUsuario(List <Contacto> lista, String nombre){
        for (Contacto c: lista){
            if(c.nombre == nombre){
                return c;
            }
            return null;
        }
    }
}
