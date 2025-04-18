/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.ArrayList;
/**
 *
 * @author Conecta
 */
public class Carrera {
    private String nombreCarrera;
    private PlanDeEstudio planDeEstudio;
    private ArrayList<Alumno> listaDeAlumnos;
    private int materiasOptativasRequeridas;
    private int duracion;

    public Carrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.listaDeAlumnos = new ArrayList<>();
        this.materiasOptativasRequeridas = 0;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setMateriaOptativasRequeridas (int materiaOptativasRequeridas){
        this.materiasOptativasRequeridas = materiaOptativasRequeridas;
    }

    public int getMateriaOptativasRequeridas(){
        return materiasOptativasRequeridas;
    }

    public void setDuracionCarrera (int duracion){
        this.duracion = duracion;
    }

    public int getDuracionCarrera(){
        return duracion;
    }
    
    public void agregarAlumno(Alumno alumno) {
        listaDeAlumnos.add(alumno);
    }

    public ArrayList<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }

    public PlanDeEstudio getPlanDeEstudio() {
        return planDeEstudio;
    }

    public ArrayList<Materia> getListaDeMaterias() {
        if (planDeEstudio != null) {
            return planDeEstudio.getListaDeMaterias();
        }
        return new ArrayList<>(); // Retorna lista vacía si no hay plan de estudio
    }

    public boolean verificarFinalizacionCarrera(Alumno alumno) {
        if (planDeEstudio == null) {
            return false;
        }

        HistoriaAcademica historia = alumno.getHistoriaAcademica();
        ArrayList<Materia> materias = planDeEstudio.getListaDeMaterias();
        
        boolean obligatoriasCompletas = materias.stream()
            .filter(Materia::getObligatoria) // Solo verifica las obligatorias
            .allMatch(m -> {
                EstadoMateria estado = historia.buscarMateria(m.getCodigoMateria());
                return estado == EstadoMateria.FINALIZADA || 
                    estado == EstadoMateria.PROMOCIONADA;
            });

        long optativasAprobadas = materias.stream()
            .filter(m -> !m.getObligatoria()) // Materias optativas: las que no son obligatorias
            .filter(m -> {
                EstadoMateria estado = historia.buscarMateria(m.getCodigoMateria());
                return estado == EstadoMateria.FINALIZADA || 
                    estado == EstadoMateria.PROMOCIONADA;
            })
            .count();

        
        return obligatoriasCompletas && 
               optativasAprobadas >= materiasOptativasRequeridas;
    }
    
}
