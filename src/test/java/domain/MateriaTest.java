package domain;

import org.domain.Alumno;
import org.domain.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class MateriaTest {

    @Test
    @DisplayName("Alumno cumple correlativas de una materia")
    public void cumpleCorrelativasDeMateria() {
        Materia am1 = new Materia("Analisis Matematico I");
        Materia aga = new Materia("Algebra y Geometria Analitica");
        Materia am2 = new Materia("Analisis Matematico II", Set.of(am1, aga));

        Alumno alumno = new Alumno("Juan", "Perez");
        alumno.agregarMateriaAprobada(am1);
        alumno.agregarMateriaAprobada(aga);

        Assertions.assertTrue(am2.cumpleCorrelativas(alumno));
    }

    @Test
    @DisplayName("Alumno no cumple correlativas de una materia")
    public void noCumpleCorrelativasDeMateria() {
        Materia am1 = new Materia("Analisis Matematico I");
        Materia aga = new Materia("Algebra y Geometria Analitica");
        Materia am2 = new Materia("Analisis Matematico II", Set.of(am1, aga));

        Alumno alumno = new Alumno("Juan", "Perez");
        alumno.agregarMateriaAprobada(am1);

        Assertions.assertFalse(am2.cumpleCorrelativas(alumno));
    }

}
