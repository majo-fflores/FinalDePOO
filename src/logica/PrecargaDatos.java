/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Conecta
 */
public class PrecargaDatos {
public static void precargar(Gestion gestion) {
        // Agregar carreras
        gestion.AgregarCarrera("Ingeniería en Sistemas", 1, 5);
        gestion.AgregarCarrera("Licenciatura en Informática", 2, 5);

        // Agregar alumnos
        gestion.AgregarAlumno("Juan", "Pérez", "a2345678", LocalDate.of(2000, 5, 15));
        gestion.AgregarAlumno("Ana", "Gómez", "87b54321", LocalDate.of(1999, 3, 10));
        
        
//--------------------------------------------- AGREGAR CARRERA ANALISTA EN SISTEMAS -----------------------------------------------
        // Crear la carrera Analista en Sistemas
        Carrera carreraAnalista = new Carrera("Analista en Sistemas");
        carreraAnalista.setMateriaOptativasRequeridas(3);
        carreraAnalista.setDuracionCarrera(3);
        PlanDeEstudio planDeEstudio = new PlanA();

        // Crear materias utilizando buscarOCrearMateria
        Materia elementosInformatica = gestion.buscarOCrearMateria("IF001", "Elementos de Informática", true, true, null, 1, 1);
        Materia algebra = gestion.buscarOCrearMateria("MA045", "Álgebra", true, true, null, 1, 1);
        Materia epa = gestion.buscarOCrearMateria("IF002", "EPA", true, true, null, 1, 1);

        ArrayList<Materia> correlativasAyP = new ArrayList<>();
        correlativasAyP.add(epa);
        Materia aypI = gestion.buscarOCrearMateria("IF003", "Algorítmica y Programación I", true, true, correlativasAyP, 2, 1);

        Materia analisisMatematico = gestion.buscarOCrearMateria("MA046", "Análisis Matemático", true, true, null, 2, 1);
        Materia elementosLogica = gestion.buscarOCrearMateria("MA00", "Elementos de Lógica", true, true, null, 2, 1);

        ArrayList<Materia> correlativasEstadistica = new ArrayList<>();
        correlativasEstadistica.add(algebra);
        correlativasEstadistica.add(analisisMatematico);
        Materia estadistica = gestion.buscarOCrearMateria("MA008", "Estadística", true, true, correlativasEstadistica, 3, 2);

        ArrayList<Materia> correlativasAypII = new ArrayList<>();
        correlativasAypII.add(aypI);
        correlativasAypII.add(elementosLogica);
        Materia algoritmicaII = gestion.buscarOCrearMateria("IF006", "Algorítmica II", true, true, correlativasAypII, 3, 2);

        Materia sistemasYOrg = gestion.buscarOCrearMateria("IF004", "Sistemas y Organizaciones", true, true, null, 3, 2);

        ArrayList<Materia> correlativasArqui = new ArrayList<>();
        correlativasArqui.add(elementosInformatica);
        Materia arquitectura = gestion.buscarOCrearMateria("IF005", "Arquitectura de Computadoras", false, true, correlativasArqui, 3, 2);

        ArrayList<Materia> correlativasBD = new ArrayList<>();
        correlativasBD.add(algoritmicaII);
        Materia basesDeDatos = gestion.buscarOCrearMateria("IF007", "Bases de Datos I", true, true, correlativasBD, 4, 2);

        ArrayList<Materia> correlativasPOO = new ArrayList<>();
        correlativasPOO.add(algoritmicaII);
        Materia poo = gestion.buscarOCrearMateria("IF030", "POO", false, true, correlativasPOO, 4, 2);

        ArrayList<Materia> correlativasIngI = new ArrayList<>();
        correlativasIngI.add(aypI);
        Materia ingenieriaI = gestion.buscarOCrearMateria("IF031", "Ingeniería de Software I", true, true, correlativasIngI, 4, 2);

        ArrayList<Materia> correlativasLab = new ArrayList<>();
        correlativasLab.add(algoritmicaII);
        Materia labProgramacion = gestion.buscarOCrearMateria("IF009", "Laboratorio de Programación y Lenguajes", true, true, correlativasLab, 5, 3);

        ArrayList<Materia> correlativasIngII = new ArrayList<>();
        correlativasIngII.add(ingenieriaI);
        correlativasIngII.add(estadistica);
        Materia ingenieriaII = gestion.buscarOCrearMateria("IF033", "Ingeniería de Software II", true, true, correlativasIngII, 5, 3);

        ArrayList<Materia> correlativasConcurrencia = new ArrayList<>();
        correlativasConcurrencia.add(arquitectura);
        correlativasConcurrencia.add(algoritmicaII);
        Materia concurrencia = gestion.buscarOCrearMateria("IF038", "Introducción a la Concurrencia", true, true, correlativasConcurrencia, 5, 3);

        ArrayList<Materia> correlativasSO = new ArrayList<>();
        correlativasSO.add(concurrencia);
        Materia sistemasOperativos = gestion.buscarOCrearMateria("IF037", "Sistemas Operativos", false, true, correlativasSO, 6, 3);

        ArrayList<Materia> correlativasLabSoft = new ArrayList<>();
        correlativasLabSoft.add(basesDeDatos);
        correlativasLabSoft.add(poo);
        correlativasLabSoft.add(ingenieriaI);
        Materia labSoftware = gestion.buscarOCrearMateria("IF055", "Laboratorio de Software", false, true, correlativasLabSoft, 6, 3);

        Materia seminario = gestion.buscarOCrearMateria("IF000", "Seminario de Aspectos Legales", true, true, null, 6, 3);

        // Agregar todas las materias al plan de estudio
        planDeEstudio.agregarMateria(elementosInformatica);
        planDeEstudio.agregarMateria(algebra);
        planDeEstudio.agregarMateria(epa);
        planDeEstudio.agregarMateria(aypI);
        planDeEstudio.agregarMateria(analisisMatematico);
        planDeEstudio.agregarMateria(elementosLogica);
        planDeEstudio.agregarMateria(estadistica);
        planDeEstudio.agregarMateria(algoritmicaII);
        planDeEstudio.agregarMateria(sistemasYOrg);
        planDeEstudio.agregarMateria(arquitectura);
        planDeEstudio.agregarMateria(basesDeDatos);
        planDeEstudio.agregarMateria(poo);
        planDeEstudio.agregarMateria(ingenieriaI);
        planDeEstudio.agregarMateria(labProgramacion);
        planDeEstudio.agregarMateria(ingenieriaII);
        planDeEstudio.agregarMateria(concurrencia);
        planDeEstudio.agregarMateria(sistemasOperativos);
        planDeEstudio.agregarMateria(labSoftware);
        planDeEstudio.agregarMateria(seminario);

        carreraAnalista.setPlanDeEstudio(planDeEstudio);
        gestion.getListaDeCarreras().add(carreraAnalista);
//----------------------------------------------------------------------------------------------------------------------------------------------------------------


        // Inscribir alumnos en carreras
        gestion.InscripcionAlumnoCarrera("Analista en Sistemas", 1);
        gestion.InscripcionAlumnoCarrera("Ingeniería en Sistemas", 2);

        // Inscribir alumnos en materias (ejemplo simple)
        gestion.InscripcionAlumnoMateria(1, "IF001");
        gestion.InscripcionAlumnoMateria(2, "MA045");

        // Verificaciones
        gestion.verificarAlumnoTerminacionCarrera(1);
        gestion.verificarAlumnoTerminacionCarrera(2);
    }
}
