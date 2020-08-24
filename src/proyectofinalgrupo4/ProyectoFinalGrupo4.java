/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo4;

import controlador.UsuarioControlador;
import java.util.Locale;
import vista.JFrmUsuario;

/**
 *
 * @author admin
 */
public class ProyectoFinalGrupo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //instanciar el formulario a mostrar al usuario
        JFrmUsuario frmUsuario = new JFrmUsuario();
        //instancio el controlador y le envio el formulario que solicita en en constructor
        UsuarioControlador usuarioControlador  = new UsuarioControlador(frmUsuario);
        //hacer visible el formulario
        frmUsuario.setVisible(true);
        //centrar el formulario
        frmUsuario.setLocationRelativeTo(null);
    }
    
}
