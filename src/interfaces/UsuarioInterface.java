/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author admin
 */
public interface UsuarioInterface {
    //metodos que se implementaran en el Dao del Usuario
    public String agregarUsuario(Usuario usuario);
    public String eliminarUsuario(Usuario usuario);
    public String actualizarUsuario(Usuario usuario);
    public Usuario buscarUsuario(Usuario usuario);
    public Usuario iniciarSesion(Usuario usuario);
    public ArrayList<Usuario> listarUsuarios();
}
