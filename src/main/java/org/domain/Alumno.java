package org.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Alumno {
    private String nombre;
    private String apellido;
    private Set<Materia> materiasAprobadas;
    private Set<Inscripcion> inscripciones;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = new HashSet<>();
        this.inscripciones = new HashSet<>();
    }

    public Alumno(String nombre, String apellido, Set<Materia> materiasAprobadas, Set<Inscripcion> inscripciones) {
        if (materiasAprobadas == null) {
            throw new IllegalArgumentException("Las materias no pueden ser nulas");
        }

        if (inscripciones == null) {
            throw new IllegalArgumentException("Las inscripciones no pueden ser nulas");
        }

        this.nombre = nombre;
        this.apellido = apellido;
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
