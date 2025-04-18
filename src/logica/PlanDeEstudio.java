package logica;
import java.util.ArrayList;
import java.util.Collections;
public abstract class PlanDeEstudio {
    private ArrayList<Materia> listaDeMaterias;

    public PlanDeEstudio (){ 
        listaDeMaterias = new ArrayList<>();
    }

    public void agregarMateria (Materia materia){
        listaDeMaterias.add(materia);
        Collections.sort(listaDeMaterias);
    }

    public ArrayList<Materia> getListaDeMaterias(){
        return listaDeMaterias;
    }

    public abstract boolean puedeInscribirse(Alumno alumno, Materia materia);
}