/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces.views;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.Gestion;
/**
 *
 * @author Conecta
 */
public class PanelAltaAlumno extends javax.swing.JPanel {
private Gestion gestion;
    /**
     * Creates new form PanelAltaAlumno
     */
    public PanelAltaAlumno(Gestion gestion) {
        this.gestion = gestion;
        initComponents();
        configurarCampoTexto(nombreAltaAlumno, " Ingresar Nombre");
        configurarCampoTexto(apellidoAltaAlumno, " Ingresar Apellido");
        configurarCampoTexto(nacimientoAltaAlumno, " Ingresar Fecha de Nacimiento (AAAA-MM-DD)");
        configurarCampoTexto(dniAltaAlumno, " Ingresar DNI");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenidoAltaAlumno = new javax.swing.JPanel();
        tituloAltaAlumno = new javax.swing.JLabel();
        nombreAltaAlumno = new javax.swing.JTextField();
        apellidoAltaAlumno = new javax.swing.JTextField();
        dniAltaAlumno = new javax.swing.JTextField();
        nacimientoAltaAlumno = new javax.swing.JTextField();
        subirAlumnoAltaBtn = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(644, 600));
        setPreferredSize(new java.awt.Dimension(644, 600));

        panelContenidoAltaAlumno.setBackground(new java.awt.Color(255, 255, 255));

        tituloAltaAlumno.setFont(new java.awt.Font("Century Gothic", 3, 36)); // NOI18N
        tituloAltaAlumno.setForeground(new java.awt.Color(164, 19, 60));
        tituloAltaAlumno.setText("Registrar nuevo alumno");

        nombreAltaAlumno.setBackground(new java.awt.Color(255, 255, 255));
        nombreAltaAlumno.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        nombreAltaAlumno.setForeground(new java.awt.Color(102, 102, 102));
        nombreAltaAlumno.setText("   Ingresar Nombre");
        nombreAltaAlumno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true));
        nombreAltaAlumno.setMaximumSize(new java.awt.Dimension(700, 50));
        nombreAltaAlumno.setPreferredSize(new java.awt.Dimension(700, 50));
        nombreAltaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAltaAlumnoActionPerformed(evt);
            }
        });

        apellidoAltaAlumno.setBackground(new java.awt.Color(255, 255, 255));
        apellidoAltaAlumno.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        apellidoAltaAlumno.setForeground(new java.awt.Color(102, 102, 102));
        apellidoAltaAlumno.setText("   Ingresar Apellido");
        apellidoAltaAlumno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true));
        apellidoAltaAlumno.setMaximumSize(new java.awt.Dimension(700, 50));
        apellidoAltaAlumno.setPreferredSize(new java.awt.Dimension(700, 50));
        apellidoAltaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoAltaAlumnoActionPerformed(evt);
            }
        });

        dniAltaAlumno.setBackground(new java.awt.Color(255, 255, 255));
        dniAltaAlumno.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        dniAltaAlumno.setForeground(new java.awt.Color(102, 102, 102));
        dniAltaAlumno.setText("   Ingresar DNI");
        dniAltaAlumno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true));
        dniAltaAlumno.setMaximumSize(new java.awt.Dimension(700, 50));
        dniAltaAlumno.setPreferredSize(new java.awt.Dimension(700, 50));
        dniAltaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniAltaAlumnoActionPerformed(evt);
            }
        });

        nacimientoAltaAlumno.setBackground(new java.awt.Color(255, 255, 255));
        nacimientoAltaAlumno.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        nacimientoAltaAlumno.setForeground(new java.awt.Color(102, 102, 102));
        nacimientoAltaAlumno.setText("   Ingresar Fecha de Nacimiento (AAAA-MM-DD)");
        nacimientoAltaAlumno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true));
        nacimientoAltaAlumno.setMaximumSize(new java.awt.Dimension(700, 50));
        nacimientoAltaAlumno.setPreferredSize(new java.awt.Dimension(700, 50));
        nacimientoAltaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacimientoAltaAlumnoActionPerformed(evt);
            }
        });

        subirAlumnoAltaBtn.setBackground(new java.awt.Color(255, 10, 84));
        subirAlumnoAltaBtn.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        subirAlumnoAltaBtn.setForeground(new java.awt.Color(255, 255, 255));
        subirAlumnoAltaBtn.setText("SUBIR ALUMNO");
        subirAlumnoAltaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirAlumnoAltaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenidoAltaAlumnoLayout = new javax.swing.GroupLayout(panelContenidoAltaAlumno);
        panelContenidoAltaAlumno.setLayout(panelContenidoAltaAlumnoLayout);
        panelContenidoAltaAlumnoLayout.setHorizontalGroup(
            panelContenidoAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoAltaAlumnoLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(panelContenidoAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subirAlumnoAltaBtn)
                    .addComponent(nombreAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloAltaAlumno)
                    .addComponent(apellidoAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dniAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nacimientoAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContenidoAltaAlumnoLayout.setVerticalGroup(
            panelContenidoAltaAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoAltaAlumnoLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(tituloAltaAlumno)
                .addGap(36, 36, 36)
                .addComponent(nombreAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(apellidoAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dniAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nacimientoAltaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subirAlumnoAltaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenidoAltaAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenidoAltaAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

 private void configurarCampoTexto(JTextField campo, String placeholder) {
    // Configurar el campo con el placeholder y color gris
    campo.setText(placeholder);
    campo.setForeground(Color.GRAY);
    
    // Aplicar un margen interno al campo de texto
    campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true),
        javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
    
    campo.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (campo.getText().equals(placeholder)) {
                campo.setText("");
                campo.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (campo.getText().isEmpty()) {
                campo.setText(placeholder);
                campo.setForeground(Color.GRAY);
            }
        }
    });
}
    private void nombreAltaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreAltaAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreAltaAlumnoActionPerformed

    private void apellidoAltaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoAltaAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoAltaAlumnoActionPerformed

    private void dniAltaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniAltaAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniAltaAlumnoActionPerformed

    private void nacimientoAltaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacimientoAltaAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nacimientoAltaAlumnoActionPerformed

    private void subirAlumnoAltaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirAlumnoAltaBtnActionPerformed
        try {
            // Obtener los valores y eliminar espacios en blanco
            String nombre = nombreAltaAlumno.getText().trim();
            String apellido = apellidoAltaAlumno.getText().trim();
            String fechaNacimientoStr = nacimientoAltaAlumno.getText().trim();
            String dni = dniAltaAlumno.getText().trim();

            // Validar que los campos no estén vacíos o con el texto placeholder
            if (nombre.isEmpty() || nombre.equals(" Ingresar Nombre") ||
                apellido.isEmpty() || apellido.equals(" Ingresar Apellido") ||
                dni.isEmpty() || dni.equals(" Ingresar DNI") ||
                fechaNacimientoStr.isEmpty() || fechaNacimientoStr.equals(" Ingresar Fecha de Nacimiento (AAAA-MM-DD)")) {

                mostrarDialogoCentrado(
                    "Por favor complete todos los campos obligatorios.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar longitud del DNI (mínimo 7 y máximo 10 caracteres)
            if (dni.length() < 7 || dni.length() > 10) {
                mostrarDialogoCentrado(
                    "El DNI debe tener entre 7 y 10 caracteres.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que el DNI contenga solo números
            if (!dni.matches("\\d+")) {
                mostrarDialogoCentrado(
                    "El DNI debe contener solo números.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar y parsear la fecha
            LocalDate fechaNacimiento;
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoStr);

                // Validar que la fecha no sea futura
                if (fechaNacimiento.isAfter(LocalDate.now())) {
                    mostrarDialogoCentrado(
                        "La fecha de nacimiento no puede ser una fecha futura.",
                        "Error de Validación",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que la persona sea mayor de 18 años
                LocalDate fechaMinima = LocalDate.now().minusYears(18);
                if (fechaNacimiento.isAfter(fechaMinima)) {
                    mostrarDialogoCentrado(
                        "El alumno debe ser mayor de 18 años para registrarse.",
                        "Error de Validación",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (DateTimeParseException ex) {
                mostrarDialogoCentrado(
                    "Por favor ingrese una fecha válida en el formato AAAA-MM-DD.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Agregar el alumno
                gestion.AgregarAlumno(nombre, apellido, dni, fechaNacimiento);

                // Si llegamos aquí, el alumno se agregó exitosamente
                mostrarDialogoCentrado(
                    "¡Alumno registrado exitosamente!",
                    "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

                // Limpiar los campos después del registro exitoso
                limpiarCampos();

            } catch (IllegalArgumentException ex) {
                // Verificar si es un error de alumno existente o de datos inválidos
                String mensaje = ex.getMessage();
                if (mensaje != null && mensaje.startsWith("ERROR_ALUMNO_EXISTENTE:")) {
                    // Es un error de alumno duplicado
                    mostrarDialogoCentrado(
                        mensaje.substring("ERROR_ALUMNO_EXISTENTE:".length()),
                        "Alumno ya registrado",
                        JOptionPane.WARNING_MESSAGE);
                } else {
                    // Es otro tipo de error de datos
                    mostrarDialogoCentrado(
                        "Error en los datos: " + mensaje,
                        "Datos inválidos",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                // Capturar cualquier otro error inesperado
                mostrarDialogoCentrado(
                    "Error inesperado al procesar el registro: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException ex) {
            // Capturar errores relacionados con la interfaz de usuario
            mostrarDialogoCentrado(
                "Error en la interfaz: " + ex.getMessage(),
                "Error de sistema",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_subirAlumnoAltaBtnActionPerformed

    // Método para mostrar diálogos centrados en la pantalla y ajustados a la izquierda
    private void mostrarDialogoCentrado(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane panel = new JOptionPane(mensaje, tipoMensaje);
        panel.setOptions(new Object[] {"OK"});
        JDialog dialogo = panel.createDialog(this, titulo);
        
        // Centrar el diálogo en la pantalla
        dialogo.setLocationRelativeTo(null);
        
        // Ajustar la posición hacia la izquierda
        java.awt.Point ubicacion = dialogo.getLocation();
        dialogo.setLocation(ubicacion.x - 80, ubicacion.y); // Ajustar 80 píxeles a la izquierda
        
        dialogo.setVisible(true);
    }
    
        // Método auxiliar para limpiar los campos después de un registro exitoso
    private void limpiarCampos() {
        nombreAltaAlumno.setText(" Ingresar Nombre");
        nombreAltaAlumno.setForeground(Color.GRAY);

        apellidoAltaAlumno.setText(" Ingresar Apellido");
        apellidoAltaAlumno.setForeground(Color.GRAY);

        nacimientoAltaAlumno.setText(" Ingresar Fecha de Nacimiento (AAAA-MM-DD)");
        nacimientoAltaAlumno.setForeground(Color.GRAY);

        dniAltaAlumno.setText(" Ingresar DNI");
        dniAltaAlumno.setForeground(Color.GRAY);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoAltaAlumno;
    private javax.swing.JTextField dniAltaAlumno;
    private javax.swing.JTextField nacimientoAltaAlumno;
    private javax.swing.JTextField nombreAltaAlumno;
    private javax.swing.JPanel panelContenidoAltaAlumno;
    private javax.swing.JButton subirAlumnoAltaBtn;
    private javax.swing.JLabel tituloAltaAlumno;
    // End of variables declaration//GEN-END:variables
}
