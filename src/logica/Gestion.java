package logica;
import java.time.LocalDate;
import java.util.ArrayList;

public class Gestion {
    private ArrayList<Carrera> Carreras;
    private ArrayList<Alumno> Alumnos;
    private ArrayList<Materia> materiasCatalogo; // Catálogo centralizado de materias

    public Gestion(){
        Carreras = new ArrayList<>();
        Alumnos = new ArrayList<>();
        materiasCatalogo = new ArrayList<>();
    }

    public Materia buscarOCrearMateria(String codigo, String nombreMateria, boolean obligatoria, 
                                     boolean promocion, ArrayList<Materia> correlativas, 
                                     int cuatrimestre, int anio) {
        // Primero buscamos por código (identificador único)
        for (Materia materia : materiasCatalogo) {
            if (materia.getCodigoMateria().equals(codigo)) {
                return materia; // Devolvemos la materia existente
            }
        }
        
        // Si no existe, la creamos
        Materia nuevaMateria = new Materia(codigo, nombreMateria, obligatoria, promocion, 
                                         correlativas, cuatrimestre, anio);
        materiasCatalogo.add(nuevaMateria);
        return nuevaMateria;
    }
    
    public void AgregarCarrera(String nombreCarrera, int tipoPlan, int duracionCarrera) {
        // Verificar si ya existe una carrera con el mismo nombre
        if (existeCarrera(nombreCarrera)) {
            throw new IllegalArgumentException("Ya existe una carrera con el nombre '" + nombreCarrera + "'");
        }

        Carrera nuevaCarrera = new Carrera(nombreCarrera);

        // Asignar el plan de estudio adecuado según el tipo proporcionado
        PlanDeEstudio planDeEstudio;
        switch (tipoPlan) {
            case 1:
                planDeEstudio = new PlanA();
                break;
            case 2:
                planDeEstudio = new PlanB();
                break;
            case 3:
                planDeEstudio = new PlanC();
                break;
            case 4:
                planDeEstudio = new PlanD();
                break;
            case 5:
                planDeEstudio = new PlanE();
                break;
            default:
                // En caso de tipo de plan no reconocido, se puede manejar de alguna manera apropiada
                // Por ejemplo, lanzar una excepción
                throw new IllegalArgumentException("Tipo de plan de estudio no válido: " + tipoPlan);
        }

        nuevaCarrera.setPlanDeEstudio(planDeEstudio);
        nuevaCarrera.setDuracionCarrera(duracionCarrera);
        Carreras.add(nuevaCarrera);
    }

    public void AgregarAlumno(String nombre, String apellido, String DNI, LocalDate fechaNacimiento) {
        // Normalizar el DNI para comparación (eliminar espacios y convertir a minúsculas)
        String dniNormalizado = DNI.trim().toLowerCase();

        // Verificar si ya existe un alumno con ese DNI
        for (Alumno alumno : Alumnos) {
            String dniExistente = alumno.getDNI().trim().toLowerCase();
            if (dniExistente.equals(dniNormalizado)) {
                throw new IllegalArgumentException("ERROR_ALUMNO_EXISTENTE: Ya existe un alumno registrado con el DNI: " + DNI);
            }
        }

        // Si pasó todas las validaciones, crear y agregar el alumno
        Alumno nuevoAlumno = new Alumno(nombre, apellido, DNI, fechaNacimiento);
        Alumnos.add(nuevoAlumno);
    }
    
    public void InscripcionAlumnoCarrera(String NombreCarrera, int legajo) { 
        for (Alumno nuevAlumno : Alumnos) {
            if (nuevAlumno.getLegajo() == legajo) {
                for (Carrera carrera : Carreras) {
                    if (carrera.getNombreCarrera().equals(NombreCarrera)) {
                        carrera.agregarAlumno(nuevAlumno);
                        // Asignar la carrera al alumno
                        nuevAlumno.setPropuesta(NombreCarrera);
                        System.out.println("Alumno " + nuevAlumno.getNombre() + " " + nuevAlumno.getApellido() + " inscrito en la carrera " + NombreCarrera + " correctamente.");
                        return; // Salir del método una vez que se encuentra y procesa al alumno
                    }
                }
                System.out.println("No se encontró la carrera con el nombre proporcionado.");
                return;
            }
        }
        System.out.println("No se encontró ningún alumno con el legajo proporcionado.");
    }
    
    public void agregarMateriaPlanDeEstudios(String codigoMateria, String nombreMateria, int numeroCuatrimestre, int anio, boolean obligatoria, String nombreCarrera, ArrayList<Materia> correlativas) {
        // Buscar la carrera
        for (Carrera carrera : Carreras) {
            if (carrera.getNombreCarrera().equals(nombreCarrera)) {
                // Crear la nueva materia
                Materia nuevaMateria = buscarOCrearMateria(
                    codigoMateria,
                    nombreMateria,
                    obligatoria,
                    true,  // activa por defecto
                    correlativas,
                    numeroCuatrimestre,
                    anio
                );

                // Agregar la materia al plan de estudios de la carrera
                carrera.getPlanDeEstudio().agregarMateria(nuevaMateria);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró la carrera especificada: " + nombreCarrera);
    }
    
public String InscripcionAlumnoMateria(int legajoAlumno, String referenciaMateria) {
    String mensaje;
    boolean encontroMateria = false;
    
    for (Alumno alumno: Alumnos) {
        if (alumno.getLegajo() == legajoAlumno) {
            // Verificar si el alumno está inscrito en alguna carrera
            if (alumno.getPropuesta() == null || alumno.getPropuesta().isEmpty()) {
                mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " no está inscrito en ninguna carrera.";
                System.out.println(mensaje);
                return mensaje;
            }
            
            for (Carrera carrera: Carreras) {
                if (carrera.getNombreCarrera().equals(alumno.getPropuesta())) {
                    ArrayList<Materia> planDeEstudio = carrera.getPlanDeEstudio().getListaDeMaterias();
                    
                    // Imprimir información para depuración
                    System.out.println("Buscando materia: '" + referenciaMateria + "'");
                    System.out.println("Materias disponibles en el plan de estudio:");
                    for (Materia m : planDeEstudio) {
                        System.out.println("- Código: '" + m.getCodigoMateria() + "', Nombre: '" + m.getNombreMateria() + "'");
                    }
                    
                    // Eliminar por completo los caracteres especiales para una comparación más simple
                    String referenciaBuscadaSimplificada = referenciaMateria.toLowerCase()
                                                          .trim()
                                                          .replaceAll("[^a-z0-9 ]", "")
                                                          .replaceAll("\\s+", " ");
                    
                    System.out.println("Referencia de materia simplificada para búsqueda: '" + referenciaBuscadaSimplificada + "'");
                    
                    // Primero buscamos una coincidencia exacta por código
                    for (Materia materia: planDeEstudio) {
                        if (materia.getCodigoMateria().equalsIgnoreCase(referenciaMateria.trim())) {
                            encontroMateria = true;
                            System.out.println("Coincidencia exacta encontrada por código: " + materia.getCodigoMateria());
                            
                            // Verificar si el alumno ya está inscrito en la materia
                            HistoriaAcademica historia = alumno.getHistoriaAcademica();
                            EstadoMateria estadoActual = historia.buscarMateria(materia.getCodigoMateria());
                            if (estadoActual == EstadoMateria.CURSANDO || estadoActual == EstadoMateria.FINALIZADA) {
                                mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                       " ya está inscrito o ya finalizó la materia " + materia.getNombreMateria();
                                System.out.println(mensaje);
                                return mensaje;
                            }
                            
                            if (carrera.getPlanDeEstudio().puedeInscribirse(alumno, materia)) {
                                // Inscribir al alumno en la materia
                                alumno.agregarMateriaAHistoriaAcademica(materia, EstadoMateria.CURSANDO);
                                mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                         " se ha inscrito correctamente a "+ materia.getNombreMateria() + " (código: " + materia.getCodigoMateria() + ")";
                                System.out.println(mensaje);
                                return mensaje;
                            } else {
                                mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                          " no cumple los requisitos para anotarse a "+ materia.getNombreMateria();
                                System.out.println(mensaje);
                                return mensaje;
                            }
                        }
                    }
                    
                    // Si no encontramos por código, buscamos por nombre exacto
                    if (!encontroMateria) {
                        for (Materia materia: planDeEstudio) {
                            // Simplificar el nombre de la materia de la misma manera
                            String nombreMateriaSimplificado = materia.getNombreMateria().toLowerCase()
                                                                 .trim()
                                                                 .replaceAll("[^a-z0-9 ]", "")
                                                                 .replaceAll("\\s+", " ");
                            
                            System.out.println("Comparando con nombre: '" + nombreMateriaSimplificado + "'");
                            
                            // Comparar versiones simplificadas
                            if (nombreMateriaSimplificado.equals(referenciaBuscadaSimplificada)) {
                                encontroMateria = true;
                                System.out.println("¡Coincidencia exacta encontrada por nombre!");
                                
                                // Verificar si el alumno ya está inscrito en la materia
                                HistoriaAcademica historia = alumno.getHistoriaAcademica();
                                EstadoMateria estadoActual = historia.buscarMateria(materia.getCodigoMateria());
                                if (estadoActual == EstadoMateria.CURSANDO || estadoActual == EstadoMateria.FINALIZADA) {
                                    mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                           " ya está inscrito o ya finalizó la materia " + materia.getNombreMateria();
                                    System.out.println(mensaje);
                                    return mensaje;
                                }
                                
                                if (carrera.getPlanDeEstudio().puedeInscribirse(alumno, materia)) {
                                    // Inscribir al alumno en la materia
                                    alumno.agregarMateriaAHistoriaAcademica(materia, EstadoMateria.CURSANDO);
                                    mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                             " se ha inscrito correctamente a "+ materia.getNombreMateria() + " (código: " + materia.getCodigoMateria() + ")";
                                    System.out.println(mensaje);
                                    return mensaje;
                                } else {
                                    mensaje = "El alumno "+ alumno.getNombre() + " " + alumno.getApellido() + 
                                              " no cumple los requisitos para anotarse a "+ materia.getNombreMateria();
                                    System.out.println(mensaje);
                                    return mensaje;
                                }
                            }
                        }
                    }
                    
                    if (!encontroMateria) {
                        mensaje = "No se encontró la materia '" + referenciaMateria + "' en el plan de estudios.";
                        System.out.println(mensaje);
                        
                        // Búsqueda aproximada como último recurso
                        System.out.println("Intentando búsqueda aproximada...");
                        for (Materia materia: planDeEstudio) {
                            // Verificar si la referencia está contenida en el código
                            if (materia.getCodigoMateria().toLowerCase().contains(referenciaBuscadaSimplificada)) {
                                System.out.println("Posible coincidencia aproximada encontrada por código: " + materia.getCodigoMateria());
                                
                                // Verificar si el alumno ya está inscrito en la materia
                                HistoriaAcademica historia = alumno.getHistoriaAcademica();
                                EstadoMateria estadoActual = historia.buscarMateria(materia.getCodigoMateria());
                                if (estadoActual == EstadoMateria.CURSANDO || estadoActual == EstadoMateria.FINALIZADA) {
                                    mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                           " ya está inscrito o ya finalizó la materia " + materia.getNombreMateria();
                                    System.out.println(mensaje);
                                    return mensaje;
                                }
                                
                                if (carrera.getPlanDeEstudio().puedeInscribirse(alumno, materia)) {
                                    alumno.agregarMateriaAHistoriaAcademica(materia, EstadoMateria.CURSANDO);
                                    mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                             " se ha inscrito correctamente a "+ materia.getNombreMateria() + " (código: " + materia.getCodigoMateria() + ")";
                                    System.out.println(mensaje);
                                    return mensaje;
                                } else {
                                    mensaje = "El alumno "+ alumno.getNombre() + " " + alumno.getApellido() + 
                                              " no cumple los requisitos para anotarse a "+ materia.getNombreMateria();
                                    System.out.println(mensaje);
                                    return mensaje;
                                }
                            }
                            
                            // Verificar si la referencia está contenida en el nombre
                            String nombreMateriaSimplificado = materia.getNombreMateria().toLowerCase()
                                                                .trim()
                                                                .replaceAll("[^a-z0-9 ]", "");
                            
                            if (nombreMateriaSimplificado.contains(referenciaBuscadaSimplificada) || 
                                referenciaBuscadaSimplificada.contains(nombreMateriaSimplificado)) {
                                
                                System.out.println("Posible coincidencia aproximada encontrada por nombre: " + materia.getNombreMateria());
                                
                                // Verificar si el alumno ya está inscrito en la materia
                                HistoriaAcademica historia = alumno.getHistoriaAcademica();
                                EstadoMateria estadoActual = historia.buscarMateria(materia.getCodigoMateria());
                                if (estadoActual == EstadoMateria.CURSANDO || estadoActual == EstadoMateria.FINALIZADA) {
                                    mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                           " ya está inscrito o ya finalizó la materia " + materia.getNombreMateria();
                                    System.out.println(mensaje);
                                    return mensaje;
                                }
                                
                                if (carrera.getPlanDeEstudio().puedeInscribirse(alumno, materia)) {
                                    alumno.agregarMateriaAHistoriaAcademica(materia, EstadoMateria.CURSANDO);
                                    mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + 
                                             " se ha inscrito correctamente a "+ materia.getNombreMateria() + " (código: " + materia.getCodigoMateria() + ")";
                                    System.out.println(mensaje);
                                    return mensaje;
                                } else {
                                    mensaje = "El alumno "+ alumno.getNombre() + " " + alumno.getApellido() + 
                                              " no cumple los requisitos para anotarse a "+ materia.getNombreMateria();
                                    System.out.println(mensaje);
                                    return mensaje;
                                }
                            }
                        }
                        return mensaje;
                    }
                    mensaje = "No se pudo procesar la inscripción a la materia.";
                    return mensaje;
                }
            }
            mensaje = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " no está inscrito en ninguna carrera.";
            return mensaje;
        }
    }
    mensaje = "No se encontró ningún alumno con el legajo proporcionado.";
    return mensaje;
}
/**
 * Método auxiliar para buscar una materia por código o nombre
 * @param codigoONombre El código o nombre de la materia a buscar
 * @return La materia encontrada, o null si no se encuentra
 */
public Materia buscarMateria(String codigoONombre) {
    if (codigoONombre == null || codigoONombre.trim().isEmpty()) {
        return null;
    }
    
    String busquedaSimplificada = codigoONombre.toLowerCase()
                                   .trim()
                                   .replaceAll("[^a-z0-9 ]", "")
                                   .replaceAll("\\s+", " ");
    
    for (Carrera carrera : Carreras) {
        ArrayList<Materia> materias = carrera.getPlanDeEstudio().getListaDeMaterias();
        for (Materia materia : materias) {
            // Búsqueda exacta por código
            if (materia.getCodigoMateria().equalsIgnoreCase(codigoONombre.trim())) {
                return materia;
            }
            
            // Búsqueda exacta por nombre
            String nombreSimplificado = materia.getNombreMateria().toLowerCase()
                                         .trim()
                                         .replaceAll("[^a-z0-9 ]", "")
                                         .replaceAll("\\s+", " ");
            if (nombreSimplificado.equals(busquedaSimplificada)) {
                return materia;
            }
        }
    }
    
    // Búsqueda aproximada
    for (Carrera carrera : Carreras) {
        ArrayList<Materia> materias = carrera.getPlanDeEstudio().getListaDeMaterias();
        for (Materia materia : materias) {
            // Búsqueda por contenido en código
            if (materia.getCodigoMateria().toLowerCase().contains(busquedaSimplificada)) {
                return materia;
            }
            
            // Búsqueda por contenido en nombre
            String nombreSimplificado = materia.getNombreMateria().toLowerCase()
                                         .trim()
                                         .replaceAll("[^a-z0-9 ]", "");
            
            if (nombreSimplificado.contains(busquedaSimplificada) || 
                busquedaSimplificada.contains(nombreSimplificado)) {
                return materia;
            }
        }
    }
    
    return null; // No se encontró ninguna materia
}

    public boolean verificarAlumnoTerminacionCarrera(int legajoAlumno) {
        for (Alumno alumno : Alumnos) {
            if (alumno.getLegajo() == legajoAlumno) {
                // obtenemos el nombre de la carrera del alumno
                String nombreCarrera = alumno.getPropuesta();

                // 1) validar que esté inscrito en una carrera
                if (nombreCarrera == null || nombreCarrera.isEmpty()) {
                    System.out.println("El alumno no está inscrito en ninguna carrera.");
                    return false;
                }

                // 2) buscar la Carrera correspondiente y delegar
                for (Carrera carrera : Carreras) {
                    if (carrera.getNombreCarrera().equals(nombreCarrera)) {
                        boolean terminado = carrera.verificarFinalizacionCarrera(alumno);
                        if (terminado) {
                            System.out.println("El alumno " + alumno.getNombre() +
                                               " ha terminado la carrera " + nombreCarrera);
                        } else {
                            System.out.println("El alumno " + alumno.getNombre() +
                                               " no ha terminado la carrera " + nombreCarrera);
                        }
                        return terminado;
                    }
                }

                System.out.println("No se encontró la carrera del alumno.");
                return false;
            }
        }

        System.out.println("No se encontró ningún alumno con el legajo proporcionado.");
        return false;
    }

    public ArrayList<Carrera> getListaDeCarreras() {
        return Carreras;
    }

    public ArrayList<Alumno> getListaDeAlumnos() {
        return Alumnos;
    }

    public ArrayList<Alumno> getListaDeAlumnosDeCarrera(String nombreCarrera) {
        ArrayList<Alumno> alumnosDeCarrera = new ArrayList<>();
        for (Alumno alumno : Alumnos) {
            if (alumno.getPropuesta().equals(nombreCarrera)) {
                alumnosDeCarrera.add(alumno);
            }
        }
        return alumnosDeCarrera;
    }

    public ArrayList<Materia> getMateria() {
        // Crear una lista para almacenar todas las materias
        ArrayList<Materia> todasLasMaterias = new ArrayList<>();

        // Recorrer todas las carreras y obtener sus materias
        for (Carrera carrera : Carreras) {
            ArrayList<Materia> materiasCarrera = carrera.getListaDeMaterias();
            if (materiasCarrera != null) {
                // Para evitar duplicados, verificamos si la materia ya está en la lista
                for (Materia materia : materiasCarrera) {
                    boolean existe = false;
                    for (Materia m : todasLasMaterias) {
                        if (m.getCodigoMateria().equals(materia.getCodigoMateria())) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        todasLasMaterias.add(materia);
                    }
                }
            }
        }

        return todasLasMaterias;
    }
    
    public boolean existeCarrera(String nombreCarrera) {
        if (nombreCarrera == null || nombreCarrera.trim().isEmpty()) {
            return false;
        }

        // Normalizar el nombre para comparación: convertir a minúsculas y eliminar espacios extra
        String nombreNormalizado = normalizarNombre(nombreCarrera);

        for (Carrera carrera : Carreras) {
            String nombreExistente = normalizarNombre(carrera.getNombreCarrera());
            if (nombreExistente.equals(nombreNormalizado)) {
                return true;
            }
        }
        return false;
    }
    
    // Método para verificar si una materia existe en el catálogo
    public boolean existeMateria(String codigoMateria) {
        for (Materia materia : materiasCatalogo) {
            if (materia.getCodigoMateria().equals(codigoMateria)) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar para normalizar nombres para comparación
    private String normalizarNombre(String nombre) {
        return nombre.toLowerCase()
                    .trim()
                    .replaceAll("\\s+", " "); // Reemplaza múltiples espacios con uno solo
    }

}