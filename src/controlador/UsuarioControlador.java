
package controlador;

import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.JFrmMenuPrincipal;
import vista.JFrmUsuario;
import vista.MDIAdministrador;

/**
 *
 * @author edgar
 */
public class UsuarioControlador  implements ActionListener{
    //enlazar dao y vista (instanciar ambos)
    UsuarioDao dao = new UsuarioDao();
    JFrmUsuario formulario = new JFrmUsuario();
    //instanciar la clase Usuario, para asignar los valores y enviarlos al dao
    Usuario usuario = new Usuario();
    //instarnciar nuevamente la clase Usuario, para recibir los datos de las busquedas (select)
    Usuario usuarioSelect = new Usuario();
    
    //crear un constructor que reciba a la vista(formulario)
    public UsuarioControlador(JFrmUsuario vista) {
        formulario = vista; //enlazando la lógica con la vista
        //agregar eventos para los controles
        formulario.jBtnIniciarSesion.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==formulario.jBtnIniciarSesion) {
            obtenerValores();
            
        }
    }
    
    public void obtenerValores(){
        //importante: si el dato es numerico se debe convertir Integer.parseInt, Double.parseDouble, etc.
        usuario.setNombreUsuario(formulario.jTxtNombreUsuario.getText());
        usuario.setContrasenia(String.valueOf(formulario.jTxtPassword.getPassword()));
        
        JOptionPane.showMessageDialog(formulario, usuario.toString()); //verificar que los controles envien los datos que se desean operar en el dao (insert, update, delete, select)
        
        //recibir los datos de la busqueda (select)
        usuarioSelect = dao.iniciarSesion(usuario);
        
        //verificar si usuario y contraseña son correctos (comparo los datos del formulario con los de la busqueda
        if (usuarioSelect.getNombreUsuario().equals(usuario.getNombreUsuario())){
            //mostrar un menu de opciones
            JFrmMenuPrincipal frmMenu = new JFrmMenuPrincipal();
            frmMenu.setVisible(true);
            
        }
        
        
    }
    
}
