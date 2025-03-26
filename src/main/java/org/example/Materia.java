package org.example;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private final String nombre;
    private final Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public Materia(String nombre, Set<Materia> correlativas) {
        this.nombre = nombre;

        if (correlativas == null) {
            throw new IllegalArgumentException("Correlativas no puede ser nulo");
        }

        this.correlativas = correlativas;
    }

    public boolean cumpleCorrelativas(Alumno alumno) {
        return correlativas.stream().allMatch(alumno::aproboMateria);
    }
}
