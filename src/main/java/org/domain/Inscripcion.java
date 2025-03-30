package org.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materias;

    public Inscripcion(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }

        this.alumno = alumno;
        this.materias = new HashSet<>();
    }

    public Inscripcion(Alumno alumno, Set<Materia> materias) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }

        if (materias == null) {
            throw new IllegalArgumentException("Las materias no pueden ser nulas"); // No sé sí se testea esto
        }

        this.alumno = alumno;
        this.materias = materias;
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public boolean aprobada() {
        return materias.stream().allMatch(materia -> materia.cumpleCorrelativas(alumno));
    }
}
