/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces.views;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import logica.*;

/**
 *
 * @author Conecta
 */
public class PanelAltaNotas extends javax.swing.JPanel {

    private Gestion gestion;
    private ArrayList<Carrera> listaCarreras;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Materia> listaMaterias;

    /**
     * Creates new form PanelAltaNotas
     */
    public PanelAltaNotas(Gestion gestion) {
        this.gestion = gestion;
        initComponents();
        inicializarComponentes();
        
    }

    // Nuevo método para inicializar los componentes de manera controlada
    private void inicializarComponentes() {
        // Desactivar botones hasta que se seleccionen opciones válidas
        btnRegularizoMateriaAltaNotas.setEnabled(false);
        btnFinalizoMateriaAltaNotas.setEnabled(false);
        
        // Cargar las carreras sin mostrar errores
        cargarCarrerasSinError();
    }
    
    // Método modificado para cargar carreras sin mostrar errores
    private void cargarCarrerasSinError() {
        listaCarreras = gestion.getListaDeCarreras();
        
        if (listaCarreras == null || listaCarreras.isEmpty()) {
            // Si no hay carreras, simplemente mostramos un mensaje en el combo
            seleccionarCarreraBoxAltaNotas.setModel(new DefaultComboBoxModel<>(new String[]{"No hay carreras disponibles"}));
            seleccionarAlumnoBoxAltaNotas.setModel(new DefaultComboBoxModel<>(new String[]{""}));
            seleccionarMateriaBoxAltaNotas1.setModel(new DefaultComboBoxModel<>(new String[]{""}));
            return;
        }

        String[] nombresCarreras = new String[listaCarreras.size()];
        for (int i = 0; i < listaCarreras.size(); i++) {
            nombresCarreras[i] = listaCarreras.get(i).getNombreCarrera();
        }

        seleccionarCarreraBoxAltaNotas.setModel(new DefaultComboBoxModel<>(nombresCarreras));
        
        // Después de cargar las carreras, cargamos los alumnos y materias
        cargarAlumnosDeCarrera();
        cargarMateriasDeCarrera();
    }

    // Método modificado para cargar alumnos sin mostrar errores
    private void cargarAlumnosDeCarrera() {
        if (listaCarreras == null || listaCarreras.isEmpty()) {
            return;
        }
        
        String carreraSeleccionada = (String) seleccionarCarreraBoxAltaNotas.getSelectedItem();
        if (carreraSeleccionada == null || carreraSeleccionada.equals("No hay carreras disponibles")) {
            return;
        }

        listaAlumnos = gestion.getListaDeAlumnosDeCarrera(carreraSeleccionada);
        if (listaAlumnos == null || listaAlumnos.isEmpty()) {
            seleccionarAlumnoBoxAltaNotas.setModel(new DefaultComboBoxModel<>(new String[]{"No hay alumnos"}));
            return;
        }

        String[] nombresAlumnos = new String[listaAlumnos.size()];
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumno alumno = listaAlumnos.get(i);
            nombresAlumnos[i] = alumno.getLegajo() + " - " + alumno.getApellido() + ", " + alumno.getNombre();
        }

        seleccionarAlumnoBoxAltaNotas.setModel(new DefaultComboBoxModel<>(nombresAlumnos));
    }

    // Método modificado para cargar materias sin mostrar errores
    private void cargarMateriasDeCarrera() {
        if (listaCarreras == null || listaCarreras.isEmpty()) {
            return;
        }
        
        String carreraSeleccionada = (String) seleccionarCarreraBoxAltaNotas.getSelectedItem();
        if (carreraSeleccionada == null || carreraSeleccionada.equals("No hay carreras disponibles")) {
            return;
        }

        // Buscamos la carrera seleccionada
        Carrera carrera = null;
        for (Carrera c : listaCarreras) {
            if (c.getNombreCarrera().equals(carreraSeleccionada)) {
                carrera = c;
                break;
            }
        }

        if (carrera == null) {
            seleccionarMateriaBoxAltaNotas1.setModel(new DefaultComboBoxModel<>(new String[]{"Error al obtener carrera"}));
            return;
        }

        // Obtenemos las materias de la carrera
        listaMaterias = carrera.getListaDeMaterias();
        if (listaMaterias == null || listaMaterias.isEmpty()) {
            seleccionarMateriaBoxAltaNotas1.setModel(new DefaultComboBoxModel<>(new String[]{"No hay materias"}));
            return;
        }

        String[] nombresMaterias = new String[listaMaterias.size()];
        for (int i = 0; i < listaMaterias.size(); i++) {
            Materia materia = listaMaterias.get(i);
            nombresMaterias[i] = materia.getCodigoMateria() + " - " + materia.getNombreMateria();
        }

        seleccionarMateriaBoxAltaNotas1.setModel(new DefaultComboBoxModel<>(nombresMaterias));
    }
    
    // Nuevo método que valida si se puede habilitar los botones
    private void validarSelecciones() {
        boolean seleccionesValidas = false;
        
        // Verificar que hay una carrera seleccionada
        String carreraSeleccionada = (String) seleccionarCarreraBoxAltaNotas.getSelectedItem();
        if (carreraSeleccionada == null || carreraSeleccionada.equals("No hay carreras disponibles")) {
            seleccionesValidas = false;
        } 
        // Verificar que hay un alumno seleccionado
        else {
            String alumnoSeleccionado = (String) seleccionarAlumnoBoxAltaNotas.getSelectedItem();
            if (alumnoSeleccionado == null || alumnoSeleccionado.equals("No hay alumnos")) {
                seleccionesValidas = false;
            } 
            // Verificar que hay una materia seleccionada
            else {
                String materiaSeleccionada = (String) seleccionarMateriaBoxAltaNotas1.getSelectedItem();
                seleccionesValidas = !(materiaSeleccionada == null || materiaSeleccionada.equals("No hay materias"));
            }
        }
        
        // Habilitar/deshabilitar botones según validación
        btnRegularizoMateriaAltaNotas.setEnabled(seleccionesValidas);
        btnFinalizoMateriaAltaNotas.setEnabled(seleccionesValidas);
    }

    // Método para actualizar el estado de la materia
    private void actualizarEstadoMateria(EstadoMateria nuevoEstado) {
        // Verificar que hay selecciones válidas
        int indexAlumno = seleccionarAlumnoBoxAltaNotas.getSelectedIndex();
        int indexMateria = seleccionarMateriaBoxAltaNotas1.getSelectedIndex();

        if (listaAlumnos == null || listaAlumnos.isEmpty() || indexAlumno < 0 || 
            seleccionarAlumnoBoxAltaNotas.getSelectedItem().equals("No hay alumnos")) {
            mostrarDialogoCentrado(this, "Debe seleccionar un alumno válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (listaMaterias == null || listaMaterias.isEmpty() || indexMateria < 0 || 
            seleccionarMateriaBoxAltaNotas1.getSelectedItem().equals("No hay materias")) {
            mostrarDialogoCentrado(this, "Debe seleccionar una materia válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el alumno y la materia seleccionados
        Alumno alumnoSeleccionado = listaAlumnos.get(indexAlumno);
        Materia materiaSeleccionada = listaMaterias.get(indexMateria);

        // Verificar si el alumno ya tiene registro de esta materia
        EstadoMateria estadoActual = alumnoSeleccionado.getHistoriaAcademica().buscarMateria(materiaSeleccionada.getCodigoMateria());

        // Verificar las reglas de actualización de estado
        if (estadoActual == EstadoMateria.FINALIZADA && nuevoEstado == EstadoMateria.REGULARIZADA) {
            mostrarDialogoCentrado(this, 
                "No se puede cambiar el estado de una materia finalizada a regularizada.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // NUEVA VERIFICACIÓN: Si estamos finalizando una materia, verificar correlativas
        if (nuevoEstado == EstadoMateria.FINALIZADA) {
            // Verificar que todas las correlativas estén finalizadas
            ArrayList<Materia> correlativas = materiaSeleccionada.getCorrelativas();
            if (correlativas != null && !correlativas.isEmpty()) {
                StringBuilder materiasNoFinalizadas = new StringBuilder();

                for (Materia correlativa : correlativas) {
                    EstadoMateria estadoCorrelativa = alumnoSeleccionado.getHistoriaAcademica()
                                                     .buscarMateria(correlativa.getCodigoMateria());

                    if (estadoCorrelativa != EstadoMateria.FINALIZADA) {
                        if (materiasNoFinalizadas.length() > 0) {
                            materiasNoFinalizadas.append(", ");
                        }
                        materiasNoFinalizadas.append(correlativa.getNombreMateria());
                    }
                }

                if (materiasNoFinalizadas.length() > 0) {
                    mostrarDialogoCentrado(this, 
                        "No se puede finalizar la materia porque no están finalizadas las siguientes correlativas: " 
                        + materiasNoFinalizadas.toString(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        // Actualizar el estado de la materia en la historia académica del alumno
        alumnoSeleccionado.agregarMateriaAHistoriaAcademica(materiaSeleccionada, nuevoEstado);

        // Mostrar mensaje de éxito
        String mensaje = "La materia " + materiaSeleccionada.getNombreMateria() + 
                        " ha sido actualizada a estado " + nuevoEstado + 
                        " para el alumno " + alumnoSeleccionado.getNombre() + " " + alumnoSeleccionado.getApellido();
        mostrarDialogoCentrado(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Si estamos finalizando una materia, verificamos si el alumno completó la carrera
        if (nuevoEstado == EstadoMateria.FINALIZADA) {
            boolean completoCarrera = gestion.verificarAlumnoTerminacionCarrera(alumnoSeleccionado.getLegajo());
            if (completoCarrera) {
                mostrarDialogoCentrado(this, 
                    "¡Felicitaciones! El alumno " + alumnoSeleccionado.getNombre() + " " + alumnoSeleccionado.getApellido() + 
                    " ha completado todos los requisitos para la carrera " + alumnoSeleccionado.getPropuesta(), 
                    "Carrera Completada", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
   
    // Método para mostrar diálogos centrados en la pantalla y ajustados a la izquierda
    private void mostrarDialogoCentrado(java.awt.Component parent, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane panel = new JOptionPane(mensaje, tipoMensaje);
        panel.setOptions(new Object[] {"OK"});
        JDialog dialogo = panel.createDialog(parent, titulo);

        // Centrar el diálogo en la pantalla
        dialogo.setLocationRelativeTo(null);

        // Ajustar la posición hacia la izquierda
        java.awt.Point ubicacion = dialogo.getLocation();
        dialogo.setLocation(ubicacion.x - 80, ubicacion.y); // Ajustar 80 píxeles a la izquierda

        dialogo.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        panelContenidoAltaNotas = new javax.swing.JPanel();
        tituloPrincipalAltaNotas = new javax.swing.JLabel();
        tituloSeleccionaCarreraAltaNotas = new javax.swing.JLabel();
        seleccionarCarreraBoxAltaNotas = new javax.swing.JComboBox<>();
        tituloSeleccionaAlumnoAltaNotas = new javax.swing.JLabel();
        seleccionarAlumnoBoxAltaNotas = new javax.swing.JComboBox<>();
        btnRegularizoMateriaAltaNotas = new javax.swing.JButton();
        btnFinalizoMateriaAltaNotas = new javax.swing.JButton();
        tituloSeleccionaMateriaAltaNotas1 = new javax.swing.JLabel();
        seleccionarMateriaBoxAltaNotas1 = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(jEditorPane1);

        setMinimumSize(new java.awt.Dimension(644, 600));
        setPreferredSize(new java.awt.Dimension(644, 600));

        panelContenidoAltaNotas.setBackground(new java.awt.Color(255, 255, 255));
        panelContenidoAltaNotas.setMinimumSize(new java.awt.Dimension(644, 600));

        tituloPrincipalAltaNotas.setFont(new java.awt.Font("Century Gothic", 3, 30)); // NOI18N
        tituloPrincipalAltaNotas.setForeground(new java.awt.Color(164, 19, 60));
        tituloPrincipalAltaNotas.setText("ALTA DE NOTAS");

        tituloSeleccionaCarreraAltaNotas.setBackground(new java.awt.Color(255, 255, 255));
        tituloSeleccionaCarreraAltaNotas.setFont(new java.awt.Font("Century Gothic", 3, 20)); // NOI18N
        tituloSeleccionaCarreraAltaNotas.setForeground(new java.awt.Color(255, 77, 109));
        tituloSeleccionaCarreraAltaNotas.setText("Seleccionar carrera: ");

        seleccionarCarreraBoxAltaNotas.setBackground(new java.awt.Color(255, 255, 255));
        seleccionarCarreraBoxAltaNotas.setForeground(new java.awt.Color(0, 0, 0));
        seleccionarCarreraBoxAltaNotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seleccionarCarreraBoxAltaNotas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 10, 84), 2));
        seleccionarCarreraBoxAltaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarCarreraBoxAltaNotasActionPerformed(evt);
            }
        });

        tituloSeleccionaAlumnoAltaNotas.setBackground(new java.awt.Color(255, 255, 255));
        tituloSeleccionaAlumnoAltaNotas.setFont(new java.awt.Font("Century Gothic", 3, 20)); // NOI18N
        tituloSeleccionaAlumnoAltaNotas.setForeground(new java.awt.Color(255, 77, 109));
        tituloSeleccionaAlumnoAltaNotas.setText("Seleccionar Alumno: ");

        seleccionarAlumnoBoxAltaNotas.setBackground(new java.awt.Color(255, 255, 255));
        seleccionarAlumnoBoxAltaNotas.setForeground(new java.awt.Color(0, 0, 0));
        seleccionarAlumnoBoxAltaNotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seleccionarAlumnoBoxAltaNotas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 10, 84), 2));
        seleccionarAlumnoBoxAltaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarAlumnoBoxAltaNotasActionPerformed(evt);
            }
        });

        btnRegularizoMateriaAltaNotas.setBackground(new java.awt.Color(255, 10, 84));
        btnRegularizoMateriaAltaNotas.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        btnRegularizoMateriaAltaNotas.setForeground(new java.awt.Color(255, 255, 255));
        btnRegularizoMateriaAltaNotas.setText("Regularizo materia");

        btnFinalizoMateriaAltaNotas.setBackground(new java.awt.Color(255, 10, 84));
        btnFinalizoMateriaAltaNotas.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        btnFinalizoMateriaAltaNotas.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizoMateriaAltaNotas.setText("Finalizo materia");

        tituloSeleccionaMateriaAltaNotas1.setBackground(new java.awt.Color(255, 255, 255));
        tituloSeleccionaMateriaAltaNotas1.setFont(new java.awt.Font("Century Gothic", 3, 20)); // NOI18N
        tituloSeleccionaMateriaAltaNotas1.setForeground(new java.awt.Color(255, 77, 109));
        tituloSeleccionaMateriaAltaNotas1.setText("Seleccionar Materia: ");

        seleccionarMateriaBoxAltaNotas1.setBackground(new java.awt.Color(255, 255, 255));
        seleccionarMateriaBoxAltaNotas1.setForeground(new java.awt.Color(0, 0, 0));
        seleccionarMateriaBoxAltaNotas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seleccionarMateriaBoxAltaNotas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 10, 84), 2));
        seleccionarMateriaBoxAltaNotas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarMateriaBoxAltaNotas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenidoAltaNotasLayout = new javax.swing.GroupLayout(panelContenidoAltaNotas);
        panelContenidoAltaNotas.setLayout(panelContenidoAltaNotasLayout);
        panelContenidoAltaNotasLayout.setHorizontalGroup(
            panelContenidoAltaNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoAltaNotasLayout.createSequentialGroup()
                .addGroup(panelContenidoAltaNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenidoAltaNotasLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(panelContenidoAltaNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloSeleccionaCarreraAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarCarreraBoxAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloSeleccionaAlumnoAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarAlumnoBoxAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarMateriaBoxAltaNotas1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloSeleccionaMateriaAltaNotas1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelContenidoAltaNotasLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(tituloPrincipalAltaNotas))
                    .addGroup(panelContenidoAltaNotasLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(btnRegularizoMateriaAltaNotas))
                    .addGroup(panelContenidoAltaNotasLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btnFinalizoMateriaAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        panelContenidoAltaNotasLayout.setVerticalGroup(
            panelContenidoAltaNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoAltaNotasLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(tituloPrincipalAltaNotas)
                .addGap(18, 18, 18)
                .addComponent(tituloSeleccionaCarreraAltaNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionarCarreraBoxAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tituloSeleccionaAlumnoAltaNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionarAlumnoBoxAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tituloSeleccionaMateriaAltaNotas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionarMateriaBoxAltaNotas1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnRegularizoMateriaAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizoMateriaAltaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenidoAltaNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenidoAltaNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnRegularizoMateriaAltaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegularizoMateriaAltaNotasActionPerformed(evt);
            }
        });

        btnFinalizoMateriaAltaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizoMateriaAltaNotasActionPerformed(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarCarreraBoxAltaNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarCarreraBoxAltaNotasActionPerformed
        // Cargar alumnos y materias correspondientes a la carrera seleccionada
        cargarAlumnosDeCarrera();
        cargarMateriasDeCarrera();
        validarSelecciones();
    }//GEN-LAST:event_seleccionarCarreraBoxAltaNotasActionPerformed

    private void seleccionarAlumnoBoxAltaNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarAlumnoBoxAltaNotasActionPerformed
        // Validar selecciones cuando cambia el alumno
        validarSelecciones();
    }//GEN-LAST:event_seleccionarAlumnoBoxAltaNotasActionPerformed

    private void seleccionarMateriaBoxAltaNotas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarMateriaBoxAltaNotas1ActionPerformed
        // Validar selecciones cuando cambia el materia
        validarSelecciones();
    }//GEN-LAST:event_seleccionarMateriaBoxAltaNotas1ActionPerformed

    private void btnRegularizoMateriaAltaNotasActionPerformed(java.awt.event.ActionEvent evt) {
        actualizarEstadoMateria(EstadoMateria.REGULARIZADA);
    }

    private void btnFinalizoMateriaAltaNotasActionPerformed(java.awt.event.ActionEvent evt) {
        actualizarEstadoMateria(EstadoMateria.FINALIZADA);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizoMateriaAltaNotas;
    private javax.swing.JButton btnRegularizoMateriaAltaNotas;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContenidoAltaNotas;
    private javax.swing.JComboBox<String> seleccionarAlumnoBoxAltaNotas;
    private javax.swing.JComboBox<String> seleccionarCarreraBoxAltaNotas;
    private javax.swing.JComboBox<String> seleccionarMateriaBoxAltaNotas1;
    private javax.swing.JLabel tituloPrincipalAltaNotas;
    private javax.swing.JLabel tituloSeleccionaAlumnoAltaNotas;
    private javax.swing.JLabel tituloSeleccionaCarreraAltaNotas;
    private javax.swing.JLabel tituloSeleccionaMateriaAltaNotas1;
    // End of variables declaration//GEN-END:variables
}
