package org.example;

import java.util.Set;

public class Inscripcion {
    private final Alumno alumno;
    private final Set<Materia> materias;

    public Inscripcion(Alumno alumno, Set<Materia> materias) {
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
