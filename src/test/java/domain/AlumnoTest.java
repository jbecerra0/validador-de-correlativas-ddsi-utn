package domain;

import org.domain.Alumno;
import org.domain.Inscripcion;
import org.domain.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class AlumnoTest {

    @Test
    @DisplayName("Se inicializa el alumno con el parametro de materias aprobadas en null")
    public void alumnoConMateriasAprobadasNulas() {
        try {
            new Alumno("Juan", "Perez", null, new HashSet<>());
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Las materias no pueden ser nulas", e.getMessage());
        }
    }

    @Test
    @DisplayName("Se inicializa el alumno con el parametro de inscripciones en null")
    public void alumnoConInscripcionesNulas() {
        try {
            new Alumno("Juan", "Perez", new HashSet<>(), null);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Las inscripciones no pueden ser nulas", e.getMessage());
        }
    }

    @Test
    @DisplayName("Se agrega al alumno una nueva materia aprobada e inscripcion")
    public void agregarMateriaAprobadaEInscripcion() {
        Alumno alumno = new Alumno("Juan", "Perez");
        Materia am1 = new Materia("Analisis Matematico I");
        Inscripcion inscripcion = new Inscripcion(alumno, Set.of(am1));

        alumno.agregarMateriaAprobada(am1);
        alumno.agregarInscripcion(inscripcion);

        Assertions.assertTrue(alumno.aproboMateria(am1));
        Assertions.assertTrue(alumno.getInscripciones().contains(inscripcion));
    }

    @Test
    @DisplayName("Se agrega al alumno una nueva materia aprobada")
    public void aproboMateria() {
        Alumno alumno = new Alumno("Juan", "Perez");
        Materia am1 = new Materia("Analisis Matematico I");

        alumno.agregarMateriaAprobada(am1);

        Assertions.assertTrue(alumno.aproboMateria(am1));
    }

}
