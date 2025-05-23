/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces.views;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.Gestion;
/**
 *
 * @author Conecta
 */
public class PanelAltaCarrera extends javax.swing.JPanel {
private Gestion gestion;
    /**
     * Creates new form PanelAltaCarrera
     */
    public PanelAltaCarrera(Gestion gestion) {
        this.gestion = gestion;
        initComponents();
        configurarCampoTexto(nombreAltaCarrera, "  Ingrese nombre de la nueva carrera");
        configurarCampoTexto(tipoPlanAltaCarrera, "  Ingrese tipo de plan: 1 = A, 2 = B, 3 = C, 4 = D, 5 = E");
        configurarCampoTexto(totalOptativasAltaCarrera, "  Ingrese total de optativas de la carrera");
        configurarCampoTexto(duracionAltaCarrera, "  Ingrese duración de la carrera");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenidoAltaCarrera = new javax.swing.JPanel();
        tituloAltaCarrera = new javax.swing.JLabel();
        nombreAltaCarrera = new javax.swing.JTextField();
        tipoPlanAltaCarrera = new javax.swing.JTextField();
        totalOptativasAltaCarrera = new javax.swing.JTextField();
        duracionAltaCarrera = new javax.swing.JTextField();
        agregarCarreraAltaCarrera = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(644, 600));
        setPreferredSize(new java.awt.Dimension(644, 600));

        panelContenidoAltaCarrera.setBackground(new java.awt.Color(255, 255, 255));
        panelContenidoAltaCarrera.setMinimumSize(new java.awt.Dimension(644, 600));

        tituloAltaCarrera.setFont(new java.awt.Font("Century Gothic", 3, 36)); // NOI18N
        tituloAltaCarrera.setForeground(new java.awt.Color(164, 19, 60));
        tituloAltaCarrera.setText("Crear nueva carrera");

        nombreAltaCarrera.setBackground(new java.awt.Color(255, 255, 255));
        nombreAltaCarrera.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        nombreAltaCarrera.setForeground(new java.awt.Color(102, 102, 102));
        nombreAltaCarrera.setText("  Ingrese nombre de la nueva carrera");
        nombreAltaCarrera.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true));
        nombreAltaCarrera.setMaximumSize(new java.awt.Dimension(700, 50));
        nombreAltaCarrera.setPreferredSize(new java.awt.Dimension(700, 50));
        nombreAltaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAltaCarreraActionPerformed(evt);
            }
        });

        tipoPlanAltaCarrera.setBackground(new java.awt.Color(255, 255, 255));
        tipoPlanAltaCarrera.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        tipoPlanAltaCarrera.setForeground(new java.awt.Color(102, 102, 102));
        tipoPlanAltaCarrera.setText("  Ingrese tipo de plan: 1 = A, 2 = B, 3 = C, 4 = D, 5 = E");
        tipoPlanAltaCarrera.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true));
        tipoPlanAltaCarrera.setPreferredSize(new java.awt.Dimension(700, 50));
        tipoPlanAltaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPlanAltaCarreraActionPerformed(evt);
            }
        });

        totalOptativasAltaCarrera.setBackground(new java.awt.Color(255, 255, 255));
        totalOptativasAltaCarrera.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        totalOptativasAltaCarrera.setForeground(new java.awt.Color(102, 102, 102));
        totalOptativasAltaCarrera.setText("  Ingrese total de optativas de la carrera");
        totalOptativasAltaCarrera.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true));
        totalOptativasAltaCarrera.setPreferredSize(new java.awt.Dimension(700, 50));
        totalOptativasAltaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalOptativasAltaCarreraActionPerformed(evt);
            }
        });

        duracionAltaCarrera.setBackground(new java.awt.Color(255, 255, 255));
        duracionAltaCarrera.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        duracionAltaCarrera.setForeground(new java.awt.Color(102, 102, 102));
        duracionAltaCarrera.setText("  Ingrese duración de la carrera");
        duracionAltaCarrera.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 10, 84), 2, true));
        duracionAltaCarrera.setPreferredSize(new java.awt.Dimension(700, 50));
        duracionAltaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionAltaCarreraActionPerformed(evt);
            }
        });

        agregarCarreraAltaCarrera.setBackground(new java.awt.Color(255, 10, 84));
        agregarCarreraAltaCarrera.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        agregarCarreraAltaCarrera.setForeground(new java.awt.Color(255, 255, 255));
        agregarCarreraAltaCarrera.setText("AGREGAR CARRERA");
        agregarCarreraAltaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCarreraAltaCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenidoAltaCarreraLayout = new javax.swing.GroupLayout(panelContenidoAltaCarrera);
        panelContenidoAltaCarrera.setLayout(panelContenidoAltaCarreraLayout);
        panelContenidoAltaCarreraLayout.setHorizontalGroup(
            panelContenidoAltaCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoAltaCarreraLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelContenidoAltaCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarCarreraAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContenidoAltaCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tituloAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipoPlanAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(nombreAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(totalOptativasAltaCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                        .addComponent(duracionAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        panelContenidoAltaCarreraLayout.setVerticalGroup(
            panelContenidoAltaCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoAltaCarreraLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(tituloAltaCarrera)
                .addGap(35, 35, 35)
                .addComponent(nombreAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tipoPlanAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalOptativasAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(duracionAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agregarCarreraAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenidoAltaCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenidoAltaCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private void nombreAltaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreAltaCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreAltaCarreraActionPerformed

    private void tipoPlanAltaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPlanAltaCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoPlanAltaCarreraActionPerformed

    private void totalOptativasAltaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalOptativasAltaCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalOptativasAltaCarreraActionPerformed

    private void duracionAltaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionAltaCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionAltaCarreraActionPerformed

    private void agregarCarreraAltaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCarreraAltaCarreraActionPerformed
        try {
            // Obtener los valores y eliminar espacios en blanco
            String nombre = nombreAltaCarrera.getText().trim();
            String tipoPlanStr = tipoPlanAltaCarrera.getText().trim();
            String totalOptativasStr = totalOptativasAltaCarrera.getText().trim();
            String duracionStr = duracionAltaCarrera.getText().trim();

            // Validar que los campos no estén vacíos o con el texto placeholder
            if (nombre.isEmpty() || nombre.equals("  Ingrese nombre de la nueva carrera") ||
                tipoPlanStr.isEmpty() || tipoPlanStr.equals("  Ingrese tipo de plan para la condicion de cursada: 1 = A, 2 = B, 3 = C, 4 = D, 5 = E") ||
                totalOptativasStr.isEmpty() || totalOptativasStr.equals("  Ingrese total de optativas de la carrera") ||
                duracionStr.isEmpty() || duracionStr.equals("  Ingrese duracion de la carrera")) {
                
                // Usar el nuevo método para mostrar diálogos centrados
                mostrarDialogoCentrado(
                    "Por favor complete todos los campos obligatorios.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar y parsear los datos
            int tipoPlan, totalOptativas, duracion;
            try {
                tipoPlan = Integer.parseInt(tipoPlanStr);
                totalOptativas = Integer.parseInt(totalOptativasStr);
                duracion = Integer.parseInt(duracionStr);

                // Validar rangos de los valores
                if (tipoPlan < 1 || tipoPlan > 5) {
                    mostrarDialogoCentrado(
                        "El tipo de plan debe ser un número entre 1 y 5.",
                        "Error de Validación",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (totalOptativas < 0) {
                    mostrarDialogoCentrado(
                        "El número de optativas no puede ser negativo.",
                        "Error de Validación",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (duracion <= 0) {
                    mostrarDialogoCentrado(
                        "La duración de la carrera debe ser mayor a 0.",
                        "Error de Validación",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                mostrarDialogoCentrado(
                    "Por favor ingrese valores numéricos válidos.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Intentar agregar la carrera
                gestion.AgregarCarrera(nombre, tipoPlan, duracion);

                // Si llegamos aquí, la carrera se agregó exitosamente
                mostrarDialogoCentrado(
                    "¡Carrera registrada exitosamente!",
                    "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

                // Limpiar los campos después del registro exitoso
                limpiarCampos();

            } catch (IllegalArgumentException ex) {
                // Capturar cualquier error específico al agregar la carrera
                mostrarDialogoCentrado(
                    "Error al registrar la carrera: " + ex.getMessage(),
                    "Error de Registro",
                    JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException ex) {
            // Capturar cualquier otro error inesperado
            mostrarDialogoCentrado(
                "Error inesperado al procesar el registro: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_agregarCarreraAltaCarreraActionPerformed

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
        nombreAltaCarrera.setText("  Ingrese nombre de la nueva carrera");
        nombreAltaCarrera.setForeground(Color.GRAY);

        tipoPlanAltaCarrera.setText("  Ingrese tipo de plan para la condicion de cursada: 1 = A, 2 = B, 3 = C, 4 = D, 5 = E");
        tipoPlanAltaCarrera.setForeground(Color.GRAY);

        totalOptativasAltaCarrera.setText("  Ingrese total de optativas de la carrera");
        totalOptativasAltaCarrera.setForeground(Color.GRAY);

        duracionAltaCarrera.setText("  Ingrese duracion de la carrera");
        duracionAltaCarrera.setForeground(Color.GRAY);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCarreraAltaCarrera;
    private javax.swing.JTextField duracionAltaCarrera;
    private javax.swing.JTextField nombreAltaCarrera;
    private javax.swing.JPanel panelContenidoAltaCarrera;
    private javax.swing.JTextField tipoPlanAltaCarrera;
    private javax.swing.JLabel tituloAltaCarrera;
    private javax.swing.JTextField totalOptativasAltaCarrera;
    // End of variables declaration//GEN-END:variables
}
