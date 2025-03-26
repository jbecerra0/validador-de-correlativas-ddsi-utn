import org.example.Alumno;
import org.example.Inscripcion;
import org.example.Materia;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CorrelativasTest {

    @Test
    public void dadoUnAlumnoUnasMateriasYUnaInscripcion_CuandoElAlumnoTieneAprobadasLasCorrelativasDeLasMateriasDeLaInscripcion_EntoncesLeAceptanLaInscripcion() {
        // Arrange
        Alumno alumno = new Alumno("Juan", "Perez", new HashSet<>(), new HashSet<>());

        Materia am1 = new Materia("Analisis Matematico I", new HashSet<>());
        Materia aga = new Materia("Algebra y Geometria Analitica", new HashSet<>());

        Materia am2 = new Materia("Analisis Matematico II", Set.of(am1, aga));
        Materia f1 = new Materia("Fisica I", new HashSet<>());

        alumno.agregarMateriaAprobada(am1);
        alumno.agregarMateriaAprobada(aga);

        Inscripcion inscripcion = new Inscripcion(alumno, Set.of(am2, f1));

        alumno.agregarInscripcion(inscripcion);

        // Act
        boolean leAceptanInscripcion = inscripcion.aprobada();

        // Assert
        assertTrue(leAceptanInscripcion);
    }

    @Test
    public void dadoUnAlumnoUnasMateriasYUnaInscripcion_CuandoElAlumnoNoTieneAprobadasUnaDeLasCorrelativasDeLaMateriaDeLaInscripcion_EntoncesNoLeAceptanLaInscripcion() {
        // Arrange
        Alumno alumno = new Alumno("Juan", "Perez", new HashSet<>(), new HashSet<>());

        Materia am1 = new Materia("Analisis Matematico I", new HashSet<>());
        Materia aga = new Materia("Algebra y Geometria Analitica", new HashSet<>());

        Materia am2 = new Materia("Analisis Matematico II", Set.of(am1, aga));
        Materia f1 = new Materia("Fisica I", new HashSet<>());

        alumno.agregarMateriaAprobada(am1);

        Inscripcion inscripcion = new Inscripcion(alumno, Set.of(am2, f1));

        alumno.agregarInscripcion(inscripcion);

        // Act
        boolean noLeAceptanLaInscripcion = inscripcion.aprobada();

        // Assert
        assertFalse(noLeAceptanLaInscripcion);
    }

    @Test
    public void dadoUnaInscripcionConUnAlumnoNulo_EntoncesSeLanzaUnaExcepcion() {
        // Arrange
        Alumno alumno = null;
        Set<Materia> materias = new HashSet<>();

        // Act & Assert
        try {
            new Inscripcion(alumno, materias);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("El alumno no puede ser nulo"));
        }
    }

}
