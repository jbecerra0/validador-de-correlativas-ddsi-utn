package org.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Materia {
    private String nombre;
    private Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public Materia(String nombre, Set<Materia> correlativas) {
        if (correlativas == null) {
            throw new IllegalArgumentException("Correlativas no puede ser nulo");
        }

        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public boolean cumpleCorrelativas(Alumno alumno) {
        return correlativas.stream().allMatch(alumno::aproboMateria);
    }
}
