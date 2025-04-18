package logica;
import java.util.ArrayList;

public class PlanD extends PlanDeEstudio {
    public PlanD() {}

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
                // Si alguna correlativa no está aprobada, el alumno no cumple con los requisitos del plan D
                if (estadoCorrelativa != EstadoMateria.FINALIZADA && estadoCorrelativa != EstadoMateria.REGULARIZADA) {
                    return false;
                }
            }
        }

        // Obtener la lista de materias del plan de estudio
        ArrayList<Materia> planEstudio = this.getListaDeMaterias();
        int cuatrimestreActual = materia.getCuatrimetre();

        // Verificar materias aprobadas en los 3 cuatrimestres previos
        if (cuatrimestreActual > 1) {
            for (int i = cuatrimestreActual - 1; i >= Math.max(cuatrimestreActual - 3, 1); i--) {
                boolean todasMateriasAprobadas = true;
                for (Materia materiaPlan : planEstudio) {
                    if (materiaPlan.getCuatrimetre() == i) {
                        EstadoMateria estadoMateriaPlan = historiaAcademica.buscarMateria(materiaPlan.getCodigoMateria());
                        if (estadoMateriaPlan != EstadoMateria.FINALIZADA) {
                            todasMateriasAprobadas = false;
                            break; // No es necesario seguir verificando otras materias de este cuatrimestre
                        }
                    }
                }
                if (!todasMateriasAprobadas) {
                    return false; // No se encontraron materias aprobadas en uno de los cuatrimestres previos
                }
            }
        } else {
            // Si el cuatrimestre actual es 1, no se permiten inscripciones (no hay cuatrimestres previos)
            return false;
        }

        // El alumno cumple con todas las condiciones para inscribirse
        return true;
    }
}
