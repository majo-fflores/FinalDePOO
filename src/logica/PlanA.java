package logica;
import java.util.ArrayList;

public class PlanA extends PlanDeEstudio{
    public PlanA(){}

    @Override
    public boolean puedeInscribirse (Alumno alumno, Materia materia) {
        // Obtener la historia académica del alumno
        HistoriaAcademica historiaAcademica = alumno.getHistoriaAcademica();

        // Obtener la lista de correlativas de la materia actual
        ArrayList<Materia> correlativas = materia.getCorrelativas();

        if (correlativas!=null){
            // Verificar si todas las correlativas están aprobadas en la historia académica del alumno
            for (Materia correlativa : correlativas) {
                EstadoMateria estadoCorrelativa = historiaAcademica.buscarMateria(correlativa.getCodigoMateria());
               
                // Si alguna correlativa no está aprobada, el alumno no cumple con los requisitos del plan A
                if ((estadoCorrelativa != EstadoMateria.FINALIZADA) && (estadoCorrelativa != EstadoMateria.REGULARIZADA)){
                    return false;
                }
            }
        } 
        // Si todas las correlativas están aprobadas para todas las materias o no tiene correlativas el alumno cumple con los requisitos del plan A
        return true;
    }
 
}