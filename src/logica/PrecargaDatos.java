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
        gestion.AgregarAlumno("Carlos", "Rodríguez", "30456789", LocalDate.of(1998, 7, 20));        
        
//--------------------------------------------- AGREGAR CARRERA ANALISTA EN SISTEMAS -----------------------------------------------
        // Crear la carrera Analista en Sistemas
        Carrera carreraAnalista = new Carrera("Analista en Sistemas");
        carreraAnalista.setMateriaOptativasRequeridas(1);
        carreraAnalista.setDuracionCarrera(3);
        PlanDeEstudio planDeEstudio = new PlanA();

        // Crear materias utilizando buscarOCrearMateria

        //PRIMER AÑO
        Materia elementosInformatica = gestion.buscarOCrearMateria("IF001", "Elementos de Informática", true, true, null, 1, 1);
        Materia algebra = gestion.buscarOCrearMateria("MA045", "Álgebra", true, true, null, 1, 1);
        Materia epa = gestion.buscarOCrearMateria("IF002", "Expresión de Problemas y Algoritmos", true, true, null, 1, 1);

        ArrayList<Materia> correlativasAyP = new ArrayList<>();
        correlativasAyP.add(epa);
        Materia aypI = gestion.buscarOCrearMateria("IF003", "Algorítmica y Programación I", true, true, correlativasAyP, 2, 1);

        Materia analisisMatematico = gestion.buscarOCrearMateria("MA046", "Análisis Matemático", true, true, null, 2, 1);
        Materia elementosLogica = gestion.buscarOCrearMateria("MA00", "Elementos de Lógica y Matematica Discreta", true, true, null, 2, 1);

        //SEGUNDO AÑO
        ArrayList<Materia> correlativasEstadistica = new ArrayList<>();
        correlativasEstadistica.add(algebra);
        correlativasEstadistica.add(analisisMatematico);
        Materia estadistica = gestion.buscarOCrearMateria("MA008", "Estadística", true, true, correlativasEstadistica, 3, 2);

        ArrayList<Materia> correlativasAypII = new ArrayList<>();
        correlativasAypII.add(aypI);
        correlativasAypII.add(elementosLogica);
        Materia algoritmicaII = gestion.buscarOCrearMateria("IF006", "Algorítmica y Programación II", true, true, correlativasAypII, 3, 2);

        Materia sistemasYOrg = gestion.buscarOCrearMateria("IF004", "Sistemas y Organizaciones", true, true, null, 3, 2);

        ArrayList<Materia> correlativasArqui = new ArrayList<>();
        correlativasArqui.add(elementosInformatica);
        Materia arquitectura = gestion.buscarOCrearMateria("IF005", "Arquitectura de Computadoras", true, false, correlativasArqui, 3, 2);

        ArrayList<Materia> correlativasBD = new ArrayList<>();
        correlativasBD.add(algoritmicaII);
        Materia basesDeDatos = gestion.buscarOCrearMateria("IF007", "Bases de Datos I", true, true, correlativasBD, 4, 2);

        ArrayList<Materia> correlativasPOO = new ArrayList<>();
        correlativasPOO.add(algoritmicaII);
        Materia poo = gestion.buscarOCrearMateria("IF030", "Programación y Diseño Orientado a Objetos", true, false, correlativasPOO, 4, 2);

        ArrayList<Materia> correlativasIngI = new ArrayList<>();
        correlativasIngI.add(aypI);
        Materia ingenieriaI = gestion.buscarOCrearMateria("IF031", "Ingeniería de Software I", true, true, correlativasIngI, 4, 2);

        //TERCER AÑO
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
        Materia sistemasOperativos = gestion.buscarOCrearMateria("IF037", "Sistemas Operativos", true, false, correlativasSO, 6, 3);

        ArrayList<Materia> correlativasLabSoft = new ArrayList<>();
        correlativasLabSoft.add(basesDeDatos);
        correlativasLabSoft.add(poo);
        correlativasLabSoft.add(ingenieriaI);
        Materia labSoftware = gestion.buscarOCrearMateria("IF055", "Laboratorio de Software", true, true, correlativasLabSoft, 6, 3);

        Materia seminario = gestion.buscarOCrearMateria("IF000", "Seminario de Aspectos Legales", false, true, null, 6, 3);

        // Agregar todas las materias al plan de estudio
        //PRIMER AÑO
        planDeEstudio.agregarMateria(elementosInformatica);
        planDeEstudio.agregarMateria(algebra);
        planDeEstudio.agregarMateria(epa);
        planDeEstudio.agregarMateria(aypI);
        planDeEstudio.agregarMateria(analisisMatematico);
        planDeEstudio.agregarMateria(elementosLogica);
        //SEGUNDO AÑO
        planDeEstudio.agregarMateria(estadistica);
        planDeEstudio.agregarMateria(algoritmicaII);
        planDeEstudio.agregarMateria(sistemasYOrg);
        planDeEstudio.agregarMateria(arquitectura);
        planDeEstudio.agregarMateria(basesDeDatos);
        planDeEstudio.agregarMateria(poo);
        planDeEstudio.agregarMateria(ingenieriaI);
        //TERCER AÑO
        planDeEstudio.agregarMateria(labProgramacion);
        planDeEstudio.agregarMateria(ingenieriaII);
        planDeEstudio.agregarMateria(concurrencia);
        planDeEstudio.agregarMateria(sistemasOperativos);
        planDeEstudio.agregarMateria(labSoftware);
        //OPTATIVA
        planDeEstudio.agregarMateria(seminario);

        carreraAnalista.setPlanDeEstudio(planDeEstudio);
        gestion.getListaDeCarreras().add(carreraAnalista);
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
        
//--------------------------------------------- AGREGAR CARRERA LICENCIATURA EN TURISMO ---------------------------------------------------------------------
    // Crear la carrera Licenciatura en Turismo
    Carrera carreraTurismo = new Carrera("Licenciatura en Turismo");
    carreraTurismo.setMateriaOptativasRequeridas(2); // Se requieren 2 materias optativas
    carreraTurismo.setDuracionCarrera(5); // 5 años de duración
    PlanDeEstudio planDeEstudio2 = new PlanB(); 

    // PRIMER AÑO
    Materia introTurismo = gestion.buscarOCrearMateria("TU001", "Introducción al Turismo", true, true, null, 1, 1);
    Materia geografiaFisica = gestion.buscarOCrearMateria("GF001", "Geografía Física", true, true, null, 1, 1);
    Materia sociologia = gestion.buscarOCrearMateria("SO001", "Sociología", true, true, null, 1, 1);
    Materia epistemologia = gestion.buscarOCrearMateria("EP001", "Epistemología", true, true, null, 1, 1);
    Materia seminarioIntro = gestion.buscarOCrearMateria("SI001", "Seminario: Introducción a las Prácticas Profesionales", true, true, null, 1, 1);

    // SEGUNDO AÑO
    ArrayList<Materia> correlativasServTransporte = new ArrayList<>();
    correlativasServTransporte.add(introTurismo);
    Materia serviciosTuristicosTransporte = gestion.buscarOCrearMateria("TU002", "Servicios Turísticos. Transporte", true, true, correlativasServTransporte, 2, 2);

    ArrayList<Materia> correlativasServAlojamiento = new ArrayList<>();
    correlativasServAlojamiento.add(introTurismo);
    Materia serviciosTuristicosAlojamiento = gestion.buscarOCrearMateria("TU003", "Servicios Turísticos. Alojamiento", true, true, correlativasServAlojamiento, 2, 2);

    ArrayList<Materia> correlativasEcologia = new ArrayList<>();
    correlativasEcologia.add(geografiaFisica);
    Materia ecologiaConservacion = gestion.buscarOCrearMateria("EC001", "Ecología y Conservación", true, true, correlativasEcologia, 2, 2);

    ArrayList<Materia> correlativasPsicologia = new ArrayList<>();
    correlativasPsicologia.add(sociologia);
    Materia psicologiaSocial = gestion.buscarOCrearMateria("PS001", "Psicología Social", true, true, correlativasPsicologia, 2, 2);

    ArrayList<Materia> correlativasParques = new ArrayList<>();
    correlativasParques.add(geografiaFisica);
    correlativasParques.add(ecologiaConservacion);
    Materia parquesNacionales = gestion.buscarOCrearMateria("PN001", "Parques Nacionales", true, true, correlativasParques, 2, 2);

    ArrayList<Materia> correlativasGeografia = new ArrayList<>();
    correlativasGeografia.add(geografiaFisica);
    Materia geografiaHumana = gestion.buscarOCrearMateria("GH001", "Geografía Humana", true, true, correlativasGeografia, 2, 2);

    ArrayList<Materia> correlativasHistoria = new ArrayList<>();
    correlativasHistoria.add(sociologia);
    Materia historiaSocialArg = gestion.buscarOCrearMateria("HA001", "Historia Social Argentina", true, true, correlativasHistoria, 2, 2);

    ArrayList<Materia> correlativasPracticaI = new ArrayList<>();
    correlativasPracticaI.add(introTurismo);
    correlativasPracticaI.add(seminarioIntro);
    correlativasPracticaI.add(geografiaFisica);
    Materia practicaProfesionalI = gestion.buscarOCrearMateria("PP001", "Práctica Profesional I", true, true, correlativasPracticaI, 2, 2);

    // TERCER AÑO
    ArrayList<Materia> correlativasAgenciasViajes = new ArrayList<>();
    correlativasAgenciasViajes.add(introTurismo);
    correlativasAgenciasViajes.add(serviciosTuristicosTransporte);
    correlativasAgenciasViajes.add(serviciosTuristicosAlojamiento);
    Materia serviciosTuristicosAgencias = gestion.buscarOCrearMateria("TU004", "Servicios Turísticos. Agencias de Viajes", true, true, correlativasAgenciasViajes, 3, 3);

    ArrayList<Materia> correlativasPsicosociologia = new ArrayList<>();
    correlativasPsicosociologia.add(psicologiaSocial);
    Materia psicosociologiaGrupos = gestion.buscarOCrearMateria("PS002", "Psicosociología de los Grupos y de las Instituciones", true, true, correlativasPsicosociologia, 3, 3);

    ArrayList<Materia> correlativasPatrimonio = new ArrayList<>();
    correlativasPatrimonio.add(historiaSocialArg);
    Materia patrimonioCultural = gestion.buscarOCrearMateria("PC001", "Patrimonio Cultural", true, true, correlativasPatrimonio, 3, 3);

    ArrayList<Materia> correlativasMetodologia = new ArrayList<>();
    correlativasMetodologia.add(epistemologia);
    Materia metodologiaInvestigacion = gestion.buscarOCrearMateria("MI001", "Metodología de la Investigación Social", true, true, correlativasMetodologia, 3, 3);

    Materia recursosJuridicos = gestion.buscarOCrearMateria("RJ001", "Recursos Jurídicos", true, true, null, 3, 3);

    Materia teoriaAdministracion = gestion.buscarOCrearMateria("TA001", "Teoría de la Administración", true, true, null, 3, 3);

    ArrayList<Materia> correlativasPracticaII = new ArrayList<>();
    correlativasPracticaII.add(serviciosTuristicosTransporte);
    correlativasPracticaII.add(serviciosTuristicosAlojamiento);
    correlativasPracticaII.add(practicaProfesionalI);
    Materia practicaProfesionalII = gestion.buscarOCrearMateria("PP002", "Práctica Profesional II", true, true, correlativasPracticaII, 3, 3);

    Materia idiomaInglesI = gestion.buscarOCrearMateria("II001", "Primer Nivel de Idioma Inglés", true, true, null, 3, 3);

    // CUARTO AÑO
    ArrayList<Materia> correlativasAdminEmpresas = new ArrayList<>();
    correlativasAdminEmpresas.add(serviciosTuristicosAgencias);
    correlativasAdminEmpresas.add(teoriaAdministracion);
    Materia administracionEmpresas = gestion.buscarOCrearMateria("AE001", "Administración de Empresas Turísticas", true, true, correlativasAdminEmpresas, 4, 4);

    Materia economia = gestion.buscarOCrearMateria("EC002", "Economía", true, true, null, 4, 4);

    ArrayList<Materia> correlativasAntropologia = new ArrayList<>();
    correlativasAntropologia.add(sociologia);
    Materia antropologiaCultural = gestion.buscarOCrearMateria("AC001", "Antropología Cultural", true, true, correlativasAntropologia, 4, 4);

    ArrayList<Materia> correlativasPolitica = new ArrayList<>();
    correlativasPolitica.add(introTurismo);
    correlativasPolitica.add(sociologia);
    correlativasPolitica.add(psicosociologiaGrupos);
    Materia politicaTuristica = gestion.buscarOCrearMateria("PT001", "Política Turística", true, true, correlativasPolitica, 4, 4);

    ArrayList<Materia> correlativasHistoriaAmericana = new ArrayList<>();
    correlativasHistoriaAmericana.add(historiaSocialArg);
    Materia historiaAmericana = gestion.buscarOCrearMateria("HA002", "Historia Americana", true, true, correlativasHistoriaAmericana, 4, 4);

    ArrayList<Materia> correlativasPracticaIII = new ArrayList<>();
    correlativasPracticaIII.add(serviciosTuristicosAgencias);
    correlativasPracticaIII.add(practicaProfesionalII);
    Materia practicaProfesionalIII = gestion.buscarOCrearMateria("PP003", "Práctica Profesional III", true, true, correlativasPracticaIII, 4, 4);

    // QUINTO AÑO
    ArrayList<Materia> correlativasPlanificacion = new ArrayList<>();
    correlativasPlanificacion.add(introTurismo);
    correlativasPlanificacion.add(metodologiaInvestigacion);
    Materia planificacionTuristica = gestion.buscarOCrearMateria("PT002", "Planificación Turística", true, true, correlativasPlanificacion, 5, 5);

    ArrayList<Materia> correlativasInvestigacion = new ArrayList<>();
    correlativasInvestigacion.add(metodologiaInvestigacion);
    Materia investigacionTuristica = gestion.buscarOCrearMateria("IT001", "Investigación Turística", true, true, correlativasInvestigacion, 5, 5);

    ArrayList<Materia> correlativasPracticaIV = new ArrayList<>();
    correlativasPracticaIV.add(practicaProfesionalIII);
    Materia practicaProfesionalIV = gestion.buscarOCrearMateria("PP004", "Práctica Profesional IV", true, true, correlativasPracticaIV, 5, 5);

    // Materias optativas
    Materia seminarioOptativoI = gestion.buscarOCrearMateria("SOP01", "Seminario Optativo I", false, true, null, 5, 5);
    Materia seminarioOptativoII = gestion.buscarOCrearMateria("SOP02", "Seminario Optativo II", false, true, null, 5, 5);
    // Tesis de grado
    Materia tesisGrado = gestion.buscarOCrearMateria("TG001", "Tesis de Grado", true, true, null, 5, 5);
    
    Materia idiomaInglesII = gestion.buscarOCrearMateria("II002", "Segundo Nivel de Idioma Inglés", true, true, null, 5, 5);

    // Agregar todas las materias al plan de estudio
    // PRIMER AÑO
    planDeEstudio2.agregarMateria(introTurismo);
    planDeEstudio2.agregarMateria(geografiaFisica);
    planDeEstudio2.agregarMateria(sociologia);
    planDeEstudio2.agregarMateria(epistemologia);
    planDeEstudio2.agregarMateria(seminarioIntro);

    // SEGUNDO AÑO
    planDeEstudio2.agregarMateria(serviciosTuristicosTransporte);
    planDeEstudio2.agregarMateria(serviciosTuristicosAlojamiento);
    planDeEstudio2.agregarMateria(ecologiaConservacion);
    planDeEstudio2.agregarMateria(psicologiaSocial);
    planDeEstudio2.agregarMateria(parquesNacionales);
    planDeEstudio2.agregarMateria(geografiaHumana);
    planDeEstudio2.agregarMateria(historiaSocialArg);
    planDeEstudio2.agregarMateria(practicaProfesionalI);

    // TERCER AÑO
    planDeEstudio2.agregarMateria(serviciosTuristicosAgencias);
    planDeEstudio2.agregarMateria(psicosociologiaGrupos);
    planDeEstudio2.agregarMateria(patrimonioCultural);
    planDeEstudio2.agregarMateria(metodologiaInvestigacion);
    planDeEstudio2.agregarMateria(recursosJuridicos);
    planDeEstudio2.agregarMateria(teoriaAdministracion);
    planDeEstudio2.agregarMateria(practicaProfesionalII);
    planDeEstudio2.agregarMateria(idiomaInglesI);

    // CUARTO AÑO
    planDeEstudio2.agregarMateria(administracionEmpresas);
    planDeEstudio2.agregarMateria(economia);
    planDeEstudio2.agregarMateria(antropologiaCultural);
    planDeEstudio2.agregarMateria(politicaTuristica);
    planDeEstudio2.agregarMateria(historiaAmericana);
    planDeEstudio2.agregarMateria(practicaProfesionalIII);

    // QUINTO AÑO
    planDeEstudio2.agregarMateria(planificacionTuristica);
    planDeEstudio2.agregarMateria(investigacionTuristica);
    planDeEstudio2.agregarMateria(practicaProfesionalIV);
    planDeEstudio2.agregarMateria(seminarioOptativoI);
    planDeEstudio2.agregarMateria(seminarioOptativoII);
    planDeEstudio2.agregarMateria(tesisGrado);
    planDeEstudio2.agregarMateria(idiomaInglesII);

    // Asignar el plan de estudio a la carrera y agregar la carrera a la gestión
    carreraTurismo.setPlanDeEstudio(planDeEstudio2);
    gestion.getListaDeCarreras().add(carreraTurismo);


    // Inscribir alumnos en carreras
    gestion.InscripcionAlumnoCarrera("Licenciatura en Turismo", 1);
    gestion.InscripcionAlumnoCarrera("Ingeniería en Sistemas", 2);
    gestion.InscripcionAlumnoCarrera("Analista en Sistemas", 3);

    // Buscar el alumno Carlos para agregarle las materias aprobadas
    Alumno carlos = null;
    for (Alumno a : gestion.getListaDeAlumnos()) {
        if (a.getDNI().equals("30456789")) {
            carlos = a;
            break;
        }
    }

    // Si encontramos a Carlos, le agregamos todas las materias aprobadas
    if (carlos != null) {
        // Aprobar todas las materias excepto Laboratorio de Software
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF001"), EstadoMateria.FINALIZADA); // Elementos de Informática
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("MA045"), EstadoMateria.PROMOCIONADA); // Álgebra
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF002"), EstadoMateria.PROMOCIONADA); // Expresión de Problemas y Algoritmos
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF003"), EstadoMateria.FINALIZADA); // Algorítmica y Programación I
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("MA046"), EstadoMateria.PROMOCIONADA); // Análisis Matemático
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("MA00"), EstadoMateria.PROMOCIONADA);  // Elementos de Lógica
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("MA008"), EstadoMateria.PROMOCIONADA); // Estadística
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF006"), EstadoMateria.FINALIZADA); // Algorítmica y Programación II
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF004"), EstadoMateria.PROMOCIONADA); // Sistemas y Organizaciones
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF005"), EstadoMateria.FINALIZADA); // Arquitectura de Computadoras
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF007"), EstadoMateria.PROMOCIONADA); // Bases de Datos I
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF030"), EstadoMateria.FINALIZADA); // Programación y Diseño Orientado a Objetos
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF031"), EstadoMateria.PROMOCIONADA); // Ingeniería de Software I
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF009"), EstadoMateria.FINALIZADA); // Laboratorio de Programación y Lenguajes
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF033"), EstadoMateria.PROMOCIONADA); // Ingeniería de Software II
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF038"), EstadoMateria.FINALIZADA); // Introducción a la Concurrencia
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF037"), EstadoMateria.FINALIZADA); // Sistemas Operativos
        carlos.agregarMateriaAHistoriaAcademica(gestion.buscarMateria("IF000"), EstadoMateria.PROMOCIONADA); // Seminario de Aspectos Legales

        // No agregamos IF055 (Laboratorio de Software) para que sea la única que falta
    }

        // Inscribir alumnos en materias (ejemplo simple)
        gestion.InscripcionAlumnoMateria(1, "TU001");
        gestion.InscripcionAlumnoMateria(2, "MA045");

        // Verificaciones
        gestion.verificarAlumnoTerminacionCarrera(1);
        gestion.verificarAlumnoTerminacionCarrera(2);
    }
}
