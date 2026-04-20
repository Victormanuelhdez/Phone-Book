# 📒 Agenda Telefónica — Hackathon Generation

Aplicación de consola desarrollada en Java para gestionar una agenda de contactos, construida durante el Hackathon de Generation México.

---

## 👥 Equipo

| Integrante       |
|------------------|
| Victor Hernandez |
| Diego Hernandez  |
| Vianey López     |
| Edwin Sánchez    |
| Carlos Gastelum  |
| Giovanni Tlahuiz |
| Tonatiuh Sánchez |

---

## 🗂️ Arquitectura del Proyecto

El proyecto aplica el principio de **Separación de Responsabilidades**, dividiendo la lógica en capas bien definidas:

```
src/
└── com/
    └── generation/
        └── agenda/
            ├── main/
            │   └── AgendaMain.java        // Punto de entrada (public static void main)
            ├── models/                    // Definición de los objetos
            │   └── Contacto.java
            ├── services/                  // Lógica y operaciones de la agenda
            │   └── AgendaServices.java
            └── test/                      // Pruebas funcionales
                └── AgendaTest.java
```

| Clase | Responsabilidad |
|---|---|
| `Contacto.java` | Define qué es un contacto y sus atributos |
| `AgendaServices.java` | Contiene toda la lógica de negocio |
| `AgendaMain.java` | Maneja la interacción con el usuario vía consola |
| `AgendaTest.java` | Pruebas funcionales de todos los métodos |

---

## ⚙️ Funcionalidades

| Método | Descripción |
|---|---|
| `añadirContacto(Contacto c)` | Añade un contacto validando duplicados, campos vacíos y espacio disponible |
| `existeContacto(Contacto c)` | Verifica si un contacto ya existe (insensible a mayúsculas) |
| `listarContactos()` | Lista todos los contactos ordenados alfabéticamente |
| `buscarContacto(nombre, apellido)` | Busca y muestra el teléfono de un contacto |
| `eliminarContacto(Contacto c)` | Elimina un contacto e informa el resultado |
| `modificarTelefono(nombre, apellido, nuevoTelefono)` | Modifica el teléfono de un contacto existente |
| `agendaLlena()` | Indica si no hay espacio disponible |
| `espaciosLibres()` | Muestra cuántos contactos más se pueden agregar |

---



## 🧪 Casos de prueba cubiertos

- ✅ Agregar contacto válido
- ✅ Rechazar nombre o apellido vacío
- ✅ Rechazar contacto duplicado (insensible a mayúsculas)
- ✅ Listar contactos ordenados alfabéticamente
- ✅ Buscar contacto existente y no existente
- ✅ Modificar teléfono
- ✅ Detectar agenda llena
- ✅ Rechazar contacto cuando la agenda está llena
- ✅ Eliminar contacto existente y no existente

---

## 🌟 Decisiones técnicas destacadas

- **Array de tamaño fijo** con capacidad por defecto de 10 contactos, permitiendo tamaño personalizado vía constructor.
- **Método privado `indiceDe()`** reutilizado internamente por `buscar`, `eliminar` y `modificar` para evitar duplicar bucles.
- **Comparación case-insensitive** en toda búsqueda de contactos usando `equalsIgnoreCase`.
- **Ordenamiento alfabético** en `listarContactos()` usando `Arrays.sort` con `Comparator`.

---

*Desarrollado con ❤️ durante el Hackathon de Generation México — 2026*
