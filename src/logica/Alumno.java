/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.time.LocalDate;
/**
 *
 * @author Conecta
 */
public class Alumno {
    private String nombre;
    private String apellido;
    private String DNI;
    private int legajo;
    private LocalDate fechaNacimiento;
    private String propuesta;
    private HistoriaAcademica historiaAcademica;
    private static int proximoLegajo = 0; //es para que vaya aumentando de a uno y no se modifique el numero de lagajo de cada alumno

    public Alumno(String nombre, String apellido, String DNI, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento; 
        this.legajo = generarLegajo();
        this.historiaAcademica = new HistoriaAcademica(); // Inicializar historiaAcademica
    }

    private static int generarLegajo() {
        return ++proximoLegajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setPropuesta(String propuesta) {
        this.propuesta = propuesta;
    }

    public String getPropuesta() {
        return propuesta;
    }

    public void agregarMateriaAHistoriaAcademica(Materia materia, EstadoMateria estado) {
        this.historiaAcademica.agregarMateria(materia, estado); // Actualizar historiaAcademica del objeto actual
    }

    public HistoriaAcademica getHistoriaAcademica() {
        return historiaAcademica;
    }
    
    public void inscribirEnCarrera(Carrera carrera) {
        this.propuesta = carrera.getNombreCarrera();
    }
}
