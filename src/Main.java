/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Conecta
 */

import interfaces.PanelPrincipal;
import logica.PrecargaDatos;
import logica.Gestion;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una instancia de la clase Gestion
        Gestion gestion = new Gestion();
        
        //precarga datos
        PrecargaDatos.precargar(gestion);

        //Lanzar la GUI
        java.awt.EventQueue.invokeLater(() -> {
            new PanelPrincipal(gestion).setVisible(true);
        });
    }
}
