/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Conecta
 */

import interfaces.PanelPrincipal;
import java.time.LocalDate;
import logica.Alumno;
import logica.Gestion;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una instancia de la clase Gestion
        Gestion gestion = new Gestion();

        java.awt.EventQueue.invokeLater(() -> {
            new PanelPrincipal(gestion).setVisible(true);
        });
                
        // Agregar carreras
        gestion.AgregarCarrera("Ingeniería en Sistemas", 1,5);
        gestion.AgregarCarrera("Licenciatura en Informática", 2,5);
        gestion.AgregarCarreraAnalista();

        // Agregar alumnos
        gestion.AgregarAlumno("Juan", "Pérez", "a2345678", LocalDate.of(2000, 5, 15));
        gestion.AgregarAlumno("Ana", "Gómez", "87b54321", LocalDate.of(1999, 3, 10));

        // Inscribir alumno en una carrera
        gestion.InscripcionAlumnoCarrera("Analista en Sistemas", 1); // Legajo del primer alumno
        gestion.InscripcionAlumnoCarrera("Ingeniería en Sistemas", 2); // Legajo del segundo alumno

        // Inscribir alumno en una materia
        gestion.InscripcionAlumnoMateria(1, "IF001"); // Elementos de Informática
        gestion.InscripcionAlumnoMateria(2, "MA045"); // Álgebra

        // Verificar si un alumno terminó su carrera
        gestion.verificarAlumnoTerminacionCarrera(1); // Verificar para el primer alumno
        gestion.verificarAlumnoTerminacionCarrera(2); // Verificar para el segundo alumno

        // Mostrar lista de alumnos de una carrera
        System.out.println("Lista de alumnos en Analista en Sistemas:");
        for (Alumno alumno : gestion.getListaDeAlumnosDeCarrera("Analista en Sistemas")) {
            System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        }
    }
}
