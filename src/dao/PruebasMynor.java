/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controlador.*;
import java.sql.SQLException;
import modelo.Usuario;


/**
 *
 * @author admin
 */
public class PruebasMynor {
    public static void main(String[] args) {
        UsuarioDao usuarioDao = new UsuarioDao();
        String mensaje;
        Usuario usuario = new Usuario(); //asignar valores al usuario
        Usuario datosLocalizado = new Usuario();//colocar los datos del usuario cuando se realice una busqueda
        
        //eliminar
        /*
        usuario.setUsuarioId(5);
        mensaje = usuarioDao.eliminarUsuario(usuario);
        */
        
        
        //insertar
        /*
        usuario.setUsuarioId(5);
        usuario.setNombre("Persona");
        usuario.setApellido("Inventada");
        usuario.setNombreUsuario("persona");
        usuario.setContrasenia("123456");
        usuario.setTipoUsuario(1);
        usuario.setPaisId(1);
        mensaje = usuarioDao.agregarUsuario(usuario);
        */
        
         
        //modificar
        /*
        usuario.setUsuarioId(3);
        usuario.setNombre("Persona");
        usuario.setApellido("Inventada");
        usuario.setNombreUsuario("persona");
        usuario.setContrasenia("123456");
        usuario.setTipoUsuario(1);
        usuario.setPaisId(1);
        mensaje = usuarioDao.actualizarUsuario(usuario);
                
        System.out.println(mensaje);
        */
        //Buscar
        usuario.setUsuarioId(3);
        datosLocalizado = usuarioDao.buscarUsuario(usuario);
        System.out.println(datosLocalizado.toString());
    }
}
