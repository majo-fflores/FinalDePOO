package logica;
import java.util.ArrayList;

public class PlanC extends PlanDeEstudio {
    public PlanC() {}

    @Override
    public boolean puedeInscribirse(Alumno alumno, Materia materia) {
        // Obtener la historia académica del alumno
        HistoriaAcademica historiaAcademica = alumno.getHistoriaAcademica();

        // Obtener la lista de correlativas de la materia actual
        ArrayList<Materia> correlativas = materia.getCorrelativas();

        // Verificar si todas las correlativas están aprobadas en la historia académica del alumno
        if (correlativas != null) {
            for (Materia correlativa : correlativas) {
                EstadoMateria estadoCorrelativa = historiaAcademica.buscarMateria(correlativa.getCodigoMateria());
                // Si alguna correlativa no está aprobada, el alumno no cumple con los requisitos del plan C
                if (estadoCorrelativa != EstadoMateria.FINALIZADA && estadoCorrelativa != EstadoMateria.REGULARIZADA) {
                    return false;
                }
            }
        }

        // Obtenemos la lista del plan de estudio
        ArrayList<Materia> planEstudio = this.getListaDeMaterias();

        int cuatrimestreActual = materia.getCuatrimetre();
        if (cuatrimestreActual > 1) {
            for (int i = cuatrimestreActual - 1; i >= Math.max(cuatrimestreActual - 5, 1); i--) {
                boolean cuatrimestreValido = false;
                for (Materia materiaPlan : planEstudio) {
                    if (materiaPlan.getCuatrimetre() == i) {
                        EstadoMateria estadoMateriaPlan = historiaAcademica.buscarMateria(materiaPlan.getCodigoMateria());
                        if (estadoMateriaPlan == EstadoMateria.FINALIZADA) {
                            cuatrimestreValido = true;
                            break; // Si encontramos al menos una materia finalizada en el cuatrimestre, continuamos con el siguiente cuatrimestre
                        }
                    }
                }
                if (!cuatrimestreValido) {
                    return false; // Si no encontramos ninguna materia finalizada en el cuatrimestre, no puede inscribirse
                }
            }
        } else {
            return false; // Si el cuatrimestre actual es 1, no se permiten materias (no hay cuatrimestres previos)
        }
        return true; // El alumno cumple con todas las condiciones para inscribirse
    }
}
