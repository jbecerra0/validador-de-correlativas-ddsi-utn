import org.domain.Alumno;
import org.domain.Inscripcion;
import org.domain.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class InscripcionTest {

    @Test
    @DisplayName("Una inscripción no puede ser creada sin un alumno")
    public void inscripcionConAlumnoNulo() {
        Alumno alumno = null;

        try {
            new Inscripcion(alumno);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("El alumno no puede ser nulo", e.getMessage());
        }
    }

    @Test
    @DisplayName("Dado un alumno, unas materias y una inscripción, cuando el alumno tiene aprobadas las correlativas de las materias de la inscripción, entonces le aceptan la inscripción")
    public void inscripcionAceptada() {
        Alumno alumno = new Alumno("Juan", "Perez");

        Materia am1 = new Materia("Analisis Matematico I");
        Materia aga = new Materia("Algebra y Geometria Analitica");

        Materia am2 = new Materia("Analisis Matematico II", Set.of(am1, aga));
        Materia f1 = new Materia("Fisica I");

        alumno.agregarMateriaAprobada(am1);
        alumno.agregarMateriaAprobada(aga);

        Inscripcion inscripcion = new Inscripcion(alumno, Set.of(am2, f1));

        alumno.agregarInscripcion(inscripcion);

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Dado un alumno, unas materias y una inscripción, cuando el alumno no tiene aprobadas una de las correlativas de la materia de la inscripción, entonces le rechazan la inscripción")
    public void rechazanInscripcion() {
        Alumno alumno = new Alumno("Juan", "Perez");

        Materia am1 = new Materia("Analisis Matematico I");
        Materia aga = new Materia("Algebra y Geometria Analitica");

        Materia am2 = new Materia("Analisis Matematico II", Set.of(am1, aga));
        Materia f1 = new Materia("Fisica I");

        alumno.agregarMateriaAprobada(am1);

        Inscripcion inscripcion = new Inscripcion(alumno, Set.of(am2, f1));

        alumno.agregarInscripcion(inscripcion);

        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Se agrega una materia a la inscripción")
    public void agregarMateria() {
        Alumno alumno = new Alumno("Juan", "Perez");
        Inscripcion inscripcion = new Inscripcion(alumno);
        Materia aga = new Materia("Algebra y Geometria Analitica");

        inscripcion.agregarMateria(aga);

        Assertions.assertTrue(inscripcion.getMaterias().contains(aga));
    }

}
