/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.UsuarioInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author edgar
 */
public class UsuarioDao  implements UsuarioInterface{
    private String mensaje; //mensaje insert, update, delete
    private ArrayList<Usuario> listaUsuarios; //para retornar la lista de usuarios
    private Usuario datosBusqueda; //cuando se haga una busqueda los datos se almacenaran en este objeto y se retornara
    
    private ConexionAzure conexion = new ConexionAzure(); // conexion con la base de datos remota en Azure
    private PreparedStatement ejecutar; //preparar y ejecutar el SQL en la base de datos
    private ResultSet resultadoSelect; //Ejecutar y almacenar los Select
    private String sql; //colocar el SQL
    private int cantidadRegistros; //conocer la cantidad de registros afectados por el SQL
    
    @Override
    public String agregarUsuario(Usuario usuario) {
        try {
            conexion.abrirConexion();
            sql = "insert into usuarios(usuario_id, nombre, apellido, nombre_usuario, contrasenia, pais_id, tipo_usuario_id) values(?,?,?,?,md5(?),?,?)";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, usuario.getUsuarioId());
            ejecutar.setString(2, usuario.getNombre());
            ejecutar.setString(3, usuario.getApellido());
            ejecutar.setString(4, usuario.getNombreUsuario());
            ejecutar.setString(5, usuario.getContrasenia());
            ejecutar.setInt(6, usuario.getPaisId());
            ejecutar.setInt(7, usuario.getTipoUsuario());
            //ejecutar el codigo
            cantidadRegistros=ejecutar.executeUpdate();
            if (cantidadRegistros>0) {
                mensaje="Usuario almacenado con éxito";
            }else{
                mensaje="No se pudo almacenar el Usuario, verifique datos e intente de nuevo";
            }            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("UsuarioDao, error en metodo agregarUsuario: " + ex);
            mensaje ="Error al agregar usuario";
        }finally{
             conexion.cerrarConexion();
         }
        return mensaje;
    }

    @Override
    public String eliminarUsuario(Usuario usuario) {
         try {
            conexion.abrirConexion();
            sql = "delete from usuarios where usuario_id=?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, usuario.getUsuarioId());
             //ejecutar el codigo
            cantidadRegistros=ejecutar.executeUpdate();
            if (cantidadRegistros>0) {
                mensaje="Usuario eliminado con éxito";
            }else{
                mensaje="No se pudo eliminar el Usuario, el id no existe";
            }            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("UsuarioDao, error en metodo eliminarUsuario: " + ex);
            mensaje ="Error al eliminar usuario";
        }finally{
             conexion.cerrarConexion();
         }
         
        return mensaje;
    }

    @Override
    public String actualizarUsuario(Usuario usuario) {
          try {
            conexion.abrirConexion();
            sql = "update usuarios set nombre=? , apellido=? , nombre_usuario=?, contrasenia=md5(?), pais_id=?, tipo_usuario_id = ?  where usuario_id = ?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setString(1, usuario.getNombre());
            ejecutar.setString(2, usuario.getApellido());
            ejecutar.setString(3, usuario.getNombreUsuario());
            ejecutar.setString(4, usuario.getContrasenia());
            ejecutar.setInt(5, usuario.getPaisId());
            ejecutar.setInt(6, usuario.getTipoUsuario());
            ejecutar.setInt(7, usuario.getUsuarioId());
            //ejecutar el codigo
            cantidadRegistros=ejecutar.executeUpdate();
            if (cantidadRegistros>0) {
                mensaje="Usuario modificado con éxito";
            }else{
                mensaje="No se pudo modificar el Usuario, verifique datos e intente de nuevo";
            }            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("UsuarioDao, error en metodo modificarUsuario: " + ex);
            mensaje ="Error al modificar usuario";
        }finally{
             conexion.cerrarConexion();
         }
        return mensaje;
    }

    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        try {
            conexion.abrirConexion();
            sql = "select * from usuarios where usuario_id = ?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, usuario.getUsuarioId());
            //ejecutar el codigo
            resultadoSelect = ejecutar.executeQuery();
            resultadoSelect.next(); // posicionarse en el primer registro
            //asignar datos localizados al objeto
            datosBusqueda=new Usuario();
            datosBusqueda.setUsuarioId(resultadoSelect.getInt("usuario_id"));
            datosBusqueda.setNombre(resultadoSelect.getString("nombre"));
            datosBusqueda.setApellido(resultadoSelect.getString("apellido"));
            datosBusqueda.setPaisId(resultadoSelect.getInt("pais_id"));
            datosBusqueda.setTipoUsuario(resultadoSelect.getInt("tipo_usuario_id"));
            datosBusqueda.setContrasenia(resultadoSelect.getString("contrasenia"));
            datosBusqueda.setNombreUsuario(resultadoSelect.getString("nombre_usuario"));
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("UsuarioDao, error en metodo modificarUsuario: " + ex);
            datosBusqueda=new Usuario();//Unicamente se inicia el objeto
           
        }finally{
             conexion.cerrarConexion();
         }
        return datosBusqueda;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario iniciarSesion(Usuario usuario) {
        try {
            conexion.abrirConexion();
            sql = "select * from usuarios where nombre_usuario =? and contrasenia=md5(?)";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setString(1, usuario.getNombreUsuario());
            ejecutar.setString(2,usuario.getContrasenia());
            //ejecutar el codigo
            resultadoSelect = ejecutar.executeQuery();
            resultadoSelect.next(); // posicionarse en el primer registro
            //asignar datos localizados al objeto
            datosBusqueda=new Usuario();
            datosBusqueda.setUsuarioId(resultadoSelect.getInt("usuario_id"));
            datosBusqueda.setNombre(resultadoSelect.getString("nombre"));
            datosBusqueda.setApellido(resultadoSelect.getString("apellido"));
            datosBusqueda.setPaisId(resultadoSelect.getInt("pais_id"));
            datosBusqueda.setTipoUsuario(resultadoSelect.getInt("tipo_usuario_id"));
            datosBusqueda.setContrasenia(resultadoSelect.getString("contrasenia"));
            datosBusqueda.setNombreUsuario(resultadoSelect.getString("nombre_usuario"));
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("UsuarioDao, error en metodo iniciarSesion: " + ex);
            datosBusqueda=new Usuario();//Unicamente se inicia el objeto
           
        }finally{
             conexion.cerrarConexion();
         }
        return datosBusqueda;
    }
    
    
}
