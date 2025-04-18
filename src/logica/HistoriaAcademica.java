package logica;
import java.util.HashMap;

public class HistoriaAcademica {
    private final HashMap<String, EstadoMateria> listaDeMaterias; // Variable de instancia

    public HistoriaAcademica() {
        listaDeMaterias = new HashMap<>();
    }

    public void agregarMateria(Materia materia, EstadoMateria estado) {
        listaDeMaterias.put(materia.getCodigoMateria(), estado);
    }

    public EstadoMateria buscarMateria(String codMateria) {
        return listaDeMaterias.getOrDefault(codMateria, null);
    }

    public HashMap<String, EstadoMateria> getHistoriaAcademica() {
        return listaDeMaterias;
    }

    public boolean estaAprobada(String codMateria) {
        EstadoMateria estado = buscarMateria(codMateria);
        return estado == EstadoMateria.FINALIZADA || estado == EstadoMateria.PROMOCIONADA;
    }
}
