package logica;
import java.util.ArrayList;


public class PlanB extends PlanDeEstudio {
    public PlanB() {}

    @Override
    public boolean puedeInscribirse(Alumno alumno, Materia materia) {
        // Obtener la historia académica del alumno
        HistoriaAcademica historiaAcademica = alumno.getHistoriaAcademica();

        // Obtener la lista de correlativas de la materia actual
        ArrayList<Materia> correlativas = materia.getCorrelativas();

        if (correlativas != null) {
            // Verificar si todas las correlativas están aprobadas en la historia académica del alumno
            for (Materia correlativa : correlativas) {
                EstadoMateria estadoCorrelativa = historiaAcademica.buscarMateria(correlativa.getCodigoMateria());
                // Si alguna correlativa no está finalizada, el alumno no cumple con los requisitos del plan B
                if (estadoCorrelativa != EstadoMateria.FINALIZADA) {
                    return false;
                }
            }
        }
        // Si todas las correlativas están aprobadas, o no tiene correlativas el alumno cumple con los requisitos del plan B
        return true;
    }
}
