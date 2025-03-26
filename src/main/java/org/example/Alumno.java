package org.example;

import java.util.Set;

public class Alumno {
    private String nombre;
    private String apellido;
    private final Set<Materia> materiasAprobadas;
    private final Set<Inscripcion> inscripciones;

    public Alumno(String nombre, String apellido, Set<Materia> materiasAprobadas, Set<Inscripcion> inscripciones) {
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
