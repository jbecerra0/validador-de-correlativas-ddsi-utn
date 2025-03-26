package org.example;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private final String nombre;
    private final String apellido;
    private final Set<Materia> materiasAprobadas;
    private final Set<Inscripcion> inscripciones;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = new HashSet<>();
        this.inscripciones = new HashSet<>();
    }

    public Alumno(String nombre, String apellido, Set<Materia> materiasAprobadas, Set<Inscripcion> inscripciones) {
        this.nombre = nombre;
        this.apellido = apellido;

        if (materiasAprobadas == null) {
            throw new IllegalArgumentException("Las materias no pueden ser nulas");
        }

        if (inscripciones == null) {
            throw new IllegalArgumentException("Las inscripciones no pueden ser nulas");
        }

        this.materiasAprobadas = materiasAprobadas;
        this.inscripciones = inscripciones;
    }

    public void agregarMateriaAprobada(Materia materia) {
        materiasAprobadas.add(materia);
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public boolean aproboMateria(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}
