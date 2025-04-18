/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces.views;
import logica.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Conecta
 */
public class PanelAlumnos extends javax.swing.JPanel {
    private Gestion gestion;
    private Alumno alumnoSeleccionado;
    private JPanel panelDatosAlumno;
    private JPanel panelMateriasCursando;
    private JPanel panelMateriasRegularizadas;
    private JPanel panelMateriasFinalizadas;
    private JTable tablaMateriasCursando;
    private JTable tablaMateriasRegularizadas;
    private JTable tablaMateriasFinalizadas;
    private DefaultTableModel modeloMateriasCursando;
    private DefaultTableModel modeloMateriasRegularizadas;
    private DefaultTableModel modeloMateriasFinalizadas;
    /**
     * Creates new form PanelAlumnos
     */
    public PanelAlumnos(Gestion gestion) {
        this.gestion = gestion;
        initComponents();
        inicializarComponentesPersonalizados();
        cargarAlumnos();
    }
    private void inicializarComponentesPersonalizados() {
        // Inicializar los paneles que irán en el tabbedPane
        panelDatosAlumno = new JPanel();
        panelDatosAlumno.setLayout(new BorderLayout());
        
        panelMateriasCursando = new JPanel();
        panelMateriasCursando.setLayout(new BorderLayout());
        
        panelMateriasRegularizadas = new JPanel();
        panelMateriasRegularizadas.setLayout(new BorderLayout());
        
        panelMateriasFinalizadas = new JPanel();
        panelMateriasFinalizadas.setLayout(new BorderLayout());
        
        // Crear los modelos de tablas para materias
        String[] columnasMaterias = {"Código", "Nombre", "Año", "Cuatrimestre"};
        modeloMateriasCursando = new DefaultTableModel(columnasMaterias, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modeloMateriasRegularizadas = new DefaultTableModel(columnasMaterias, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modeloMateriasFinalizadas = new DefaultTableModel(columnasMaterias, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Crear las tablas
        tablaMateriasCursando = new JTable(modeloMateriasCursando);
        tablaMateriasRegularizadas = new JTable(modeloMateriasRegularizadas);
        tablaMateriasFinalizadas = new JTable(modeloMateriasFinalizadas);
        
        // Configurar panel de materias cursando
        JLabel lblMateriasCursando = new JLabel("Materias que está cursando actualmente:");
        lblMateriasCursando.setFont(new Font("Century Gothic", Font.BOLD, 14));
        panelMateriasCursando.add(lblMateriasCursando, BorderLayout.NORTH);
        panelMateriasCursando.add(new JScrollPane(tablaMateriasCursando), BorderLayout.CENTER);
        
        // Configurar panel de materias regularizadas
        JLabel lblMateriasRegularizadas = new JLabel("Materias regularizadas:");
        lblMateriasRegularizadas.setFont(new Font("Century Gothic", Font.BOLD, 14));
        panelMateriasRegularizadas.add(lblMateriasRegularizadas, BorderLayout.NORTH);
        panelMateriasRegularizadas.add(new JScrollPane(tablaMateriasRegularizadas), BorderLayout.CENTER);
        
        // Configurar panel de materias finalizadas
        JLabel lblMateriasFinalizadas = new JLabel("Materias finalizadas o promocionadas:");
        lblMateriasFinalizadas.setFont(new Font("Century Gothic", Font.BOLD, 14));
        panelMateriasFinalizadas.add(lblMateriasFinalizadas, BorderLayout.NORTH);
        panelMateriasFinalizadas.add(new JScrollPane(tablaMateriasFinalizadas), BorderLayout.CENTER);
        
        // Agregar los paneles al tabbedPane
        tabbedPanelDatosAlumno.addTab("Datos del Alumno", panelDatosAlumno);
        tabbedPanelDatosAlumno.addTab("Materias Cursando", panelMateriasCursando);
        tabbedPanelDatosAlumno.addTab("Materias Regularizadas", panelMateriasRegularizadas);
        tabbedPanelDatosAlumno.addTab("Materias Finalizadas", panelMateriasFinalizadas);
        
        // Configurar el botón de información
        btnInfoPanelAlumnos.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnInfoPanelAlumnosActionPerformed(evt);
        });
    }
    
    private void cargarAlumnos() {
        ArrayList<Alumno> alumnos = gestion.getListaDeAlumnos();
        if (alumnos != null && !alumnos.isEmpty()) {
            String[] nombresAlumnos = new String[alumnos.size()];
            for (int i = 0; i < alumnos.size(); i++) {
                Alumno alumno = alumnos.get(i);
                nombresAlumnos[i] = alumno.getLegajo() + " - " + alumno.getApellido() + ", " + alumno.getNombre();
            }
            seleccionarAlumnoBoxPanelAlumnos.setModel(new DefaultComboBoxModel<>(nombresAlumnos));
        } else {
            seleccionarAlumnoBoxPanelAlumnos.setModel(new DefaultComboBoxModel<>(new String[]{"No hay alumnos registrados"}));
        }
    }
    
    private void mostrarDatosAlumno(Alumno alumno) {
        if (alumno == null) return;
        
        alumnoSeleccionado = alumno;
        
        // Limpiar el panel de datos
        panelDatosAlumno.removeAll();
        
        // Crear un panel para mostrar los datos del alumno
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(null); // Layout absoluto para posicionar manualmente
        
        // Agregar etiquetas con la información del alumno
        JLabel lblNombre = new JLabel("Nombre: " + alumno.getNombre());
        lblNombre.setBounds(20, 20, 300, 25);
        lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
        JLabel lblApellido = new JLabel("Apellido: " + alumno.getApellido());
        lblApellido.setBounds(20, 50, 300, 25);
        lblApellido.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
        JLabel lblDNI = new JLabel("DNI: " + alumno.getDNI());
        lblDNI.setBounds(20, 80, 300, 25);
        lblDNI.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
        JLabel lblLegajo = new JLabel("Legajo: " + alumno.getLegajo());
        lblLegajo.setBounds(20, 110, 300, 25);
        lblLegajo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
        JLabel lblFechaNac = new JLabel("Fecha de Nacimiento: " + alumno.getFechaNacimiento());
        lblFechaNac.setBounds(20, 140, 300, 25);
        lblFechaNac.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
        JLabel lblCarrera = new JLabel("Carrera: " + (alumno.getPropuesta() != null ? alumno.getPropuesta() : "No inscripto"));
        lblCarrera.setBounds(20, 170, 500, 25);
        lblCarrera.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
        // Agregar las etiquetas al panel
        panelInfo.add(lblNombre);
        panelInfo.add(lblApellido);
        panelInfo.add(lblDNI);
        panelInfo.add(lblLegajo);
        panelInfo.add(lblFechaNac);
        panelInfo.add(lblCarrera);
        
        // Agregar el panel de información al panel de datos
        panelDatosAlumno.add(panelInfo, BorderLayout.CENTER);
        
        // Actualizar las tablas de materias
        actualizarTablasMaterias(alumno);
        
        // Repintar el panel
        panelDatosAlumno.revalidate();
        panelDatosAlumno.repaint();
    }
    
    private void actualizarTablasMaterias(Alumno alumno) {
        // Limpiar las tablas
        modeloMateriasCursando.setRowCount(0);
        modeloMateriasRegularizadas.setRowCount(0);
        modeloMateriasFinalizadas.setRowCount(0);
        
        if (alumno == null || alumno.getPropuesta() == null || alumno.getPropuesta().isEmpty()) {
            return;
        }
        
        // Obtener la historia académica del alumno
        HistoriaAcademica historia = alumno.getHistoriaAcademica();
        if (historia == null) {
            return;
        }
        
        HashMap<String, EstadoMateria> historialMaterias = historia.getHistoriaAcademica();
        
        // Buscar la carrera del alumno
        Carrera carreraAlumno = null;
        for (Carrera carrera : gestion.getListaDeCarreras()) {
            if (carrera.getNombreCarrera().equals(alumno.getPropuesta())) {
                carreraAlumno = carrera;
                break;
            }
        }
        
        if (carreraAlumno == null) {
            return;
        }
        
        // Obtener todas las materias de la carrera
        ArrayList<Materia> materias = carreraAlumno.getPlanDeEstudio().getListaDeMaterias();
        
        // Filtrar y mostrar las materias según su estado
        for (Map.Entry<String, EstadoMateria> entry : historialMaterias.entrySet()) {
            String codigoMateria = entry.getKey();
            EstadoMateria estado = entry.getValue();
            
            // Buscar la materia por su código
            Materia materia = null;
            for (Materia m : materias) {
                if (m.getCodigoMateria().equals(codigoMateria)) {
                    materia = m;
                    break;
                }
            }
            
            if (materia != null) {
                // Datos para agregar a la tabla
                Object[] filaDatos = {
                    materia.getCodigoMateria(),
                    materia.getNombreMateria(),
                    materia.getAnio(),
                    materia.getCuatrimetre()
                };
                
                // Agregar la materia a la tabla correspondiente según su estado
                switch (estado) {
                    case CURSANDO -> modeloMateriasCursando.addRow(filaDatos);
                    case REGULARIZADA -> modeloMateriasRegularizadas.addRow(filaDatos);
                    case FINALIZADA, PROMOCIONADA -> modeloMateriasFinalizadas.addRow(filaDatos);
                }
            }
        }
    }
    
    private void btnInfoPanelAlumnosActionPerformed(java.awt.event.ActionEvent evt) {
        String seleccion = (String) seleccionarAlumnoBoxPanelAlumnos.getSelectedItem();
        if (seleccion == null || seleccion.equals("No hay alumnos registrados")) {
            return;
        }
        
        // Extraer el legajo del alumno seleccionado
        int legajo;
        try {
            legajo = Integer.parseInt(seleccion.split(" - ")[0]);
        } catch (NumberFormatException e) {
            return;
        }
        
        // Buscar el alumno por legajo
        Alumno alumnoEncontrado = null;
        for (Alumno alumno : gestion.getListaDeAlumnos()) {
            if (alumno.getLegajo() == legajo) {
                alumnoEncontrado = alumno;
                break;
            }
        }
        
        if (alumnoEncontrado != null) {
            mostrarDatosAlumno(alumnoEncontrado);
            tabbedPanelDatosAlumno.setSelectedIndex(0); // Mostrar la pestaña de datos primero
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelContenidoAlumnos = new javax.swing.JPanel();
        tituloSeleccionaAlumnoPanelAlumnos = new javax.swing.JLabel();
        seleccionarAlumnoBoxPanelAlumnos = new javax.swing.JComboBox<>();
        btnInfoPanelAlumnos = new javax.swing.JButton();
        tabbedPanelDatosAlumno = new javax.swing.JTabbedPane();

        jLabel1.setText("jLabel1");

        setMinimumSize(new java.awt.Dimension(644, 600));
        setPreferredSize(new java.awt.Dimension(644, 600));

        panelContenidoAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        panelContenidoAlumnos.setForeground(new java.awt.Color(255, 255, 255));

        tituloSeleccionaAlumnoPanelAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        tituloSeleccionaAlumnoPanelAlumnos.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        tituloSeleccionaAlumnoPanelAlumnos.setForeground(new java.awt.Color(255, 77, 109));
        tituloSeleccionaAlumnoPanelAlumnos.setText("Seleccionar Alumno: ");

        seleccionarAlumnoBoxPanelAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        seleccionarAlumnoBoxPanelAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        seleccionarAlumnoBoxPanelAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seleccionarAlumnoBoxPanelAlumnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 10, 84), 2));
        seleccionarAlumnoBoxPanelAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarAlumnoBoxPanelAlumnosActionPerformed(evt);
            }
        });

        btnInfoPanelAlumnos.setBackground(new java.awt.Color(255, 10, 84));
        btnInfoPanelAlumnos.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        btnInfoPanelAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnInfoPanelAlumnos.setText("INFORMACION");

        javax.swing.GroupLayout panelContenidoAlumnosLayout = new javax.swing.GroupLayout(panelContenidoAlumnos);
        panelContenidoAlumnos.setLayout(panelContenidoAlumnosLayout);
        panelContenidoAlumnosLayout.setHorizontalGroup(
            panelContenidoAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoAlumnosLayout.createSequentialGroup()
                .addGroup(panelContenidoAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenidoAlumnosLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(panelContenidoAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloSeleccionaAlumnoPanelAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarAlumnoBoxPanelAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelContenidoAlumnosLayout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(btnInfoPanelAlumnos))
                    .addGroup(panelContenidoAlumnosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(tabbedPanelDatosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelContenidoAlumnosLayout.setVerticalGroup(
            panelContenidoAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoAlumnosLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(tituloSeleccionaAlumnoPanelAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionarAlumnoBoxPanelAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInfoPanelAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabbedPanelDatosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenidoAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenidoAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarAlumnoBoxPanelAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarAlumnoBoxPanelAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarAlumnoBoxPanelAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfoPanelAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelContenidoAlumnos;
    private javax.swing.JComboBox<String> seleccionarAlumnoBoxPanelAlumnos;
    private javax.swing.JTabbedPane tabbedPanelDatosAlumno;
    private javax.swing.JLabel tituloSeleccionaAlumnoPanelAlumnos;
    // End of variables declaration//GEN-END:variables
}
