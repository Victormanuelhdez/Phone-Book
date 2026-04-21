package com.generation.agenda.main;

import java.util.Scanner;
import com.generation.agenda.models.Contacto;
import com.generation.agenda.services.AgendaServices;

    public class AgendaMain {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            // Se crea la agenda con capacidad máxima de 10 contactos
            AgendaServices agenda = new AgendaServices(10);

            int opcion;

            do {
                System.out.println("\n--- AGENDA TELEFÓNICA ---");
                System.out.println("--- Selecciona una de las siguientes opciones ---");
                System.out.println("1. Añadir Contacto");
                System.out.println("2. Existe Contacto");
                System.out.println("3. Listar Contactos");
                System.out.println("4. Buscar Contacto");
                System.out.println("5. Eliminar Contacto");
                System.out.println("6. Modificar Teléfono");
                System.out.println("7. Modificar Correo");
                System.out.println("8. ¿Cuantos espacios libres hay?");
                System.out.println("0. Salir");
                System.out.print("Opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer

                switch (opcion) {

                    case 1:
                        // solicita datos al usuario y crea un nuevo contacto
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine();

                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();

                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();

                        // Llama al método para añadir el contacto a la agenda
                        agenda.añadirContacto(new Contacto(nombre, apellido, telefono, correo));
                        break;

                    case 2:
                        // solicita nombre y apellido para verificar si el contacto existe
                        System.out.print("Nombre: ");
                        String n2 = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String a2 = scanner.nextLine();

                        // Llama al método que verifica la existencia del contacto
                        agenda.existeContacto(new Contacto(n2, a2, "", ""));
                        break;

                    case 3:
                        // Llama al método que lista todos los contactos ordenados
                        agenda.listarContactos();
                        break;

                    case 4:
                        // solicita datos para buscar un contacto específico
                        System.out.print("Nombre: ");
                        String n3 = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String a3 = scanner.nextLine();

                        // Llama al método que busca el contacto y muestra su teléfono y correo
                        agenda.buscarContacto(n3, a3);
                        break;

                    case 5:
                        // solicita datos para eliminar un contacto
                        System.out.print("Nombre: ");
                        String n4 = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String a4 = scanner.nextLine();

                        // Llama al método que elimina el contacto si existe
                        agenda.eliminarContacto(new Contacto(n4, a4, "", ""));
                        break;

                    case 6:
                        // solicita datos para modificar el teléfono de un contacto
                        System.out.print("Nombre: ");
                        String n5 = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String a5 = scanner.nextLine();

                        System.out.print("Nuevo teléfono: ");
                        String nuevoTelefono = scanner.nextLine();

                        // Llama al método que actualiza el teléfono del contacto
                        agenda.modificarCorreo(n5, a5, nuevoTelefono);
                        break;
                    case 7:
                        // solicita datos para modificar el teléfono de un contacto
                        System.out.print("Nombre: ");
                        String n7 = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String a7 = scanner.nextLine();

                        System.out.print("Nuevo correo: ");
                        String nuevoCorreo = scanner.nextLine();

                        // Llama al método que actualiza el teléfono del contacto
                        agenda.modificarCorreo(n7, a7, nuevoCorreo);
                        break;
                    case 8:
                        // Llama al método que muestra cuántos espacios libres quedan
                        agenda.espaciosLibres();
                        break;

                    case 0:
                        // Finaliza la ejecución del programa
                        System.out.println("Saliendo...");
                        break;

                    default:
                        // Maneja opciones inválidas
                        System.out.println("Opción inválida");
                }

            } while (opcion != 0);

            scanner.close();
        }
    }

