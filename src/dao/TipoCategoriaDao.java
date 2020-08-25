/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.TipoCategoriaInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TipoCategoria;

/**
 *
 * @author Julius
 */
public class TipoCategoriaDao implements TipoCategoriaInterface {

    private String mensaje; //mensaje insert, update, delete
    private TipoCategoria datosBusqueda; //cuando se haga una busqueda los datos se almacenaran en este objeto y se retornara
    private ArrayList<TipoCategoria> listaTipoCategoria = new ArrayList();

    private ConexionAzure conexion = new ConexionAzure(); // conexion con la base de datos remota en Azure
    private PreparedStatement ejecutar; //preparar y ejecutar el SQL en la base de datos
    private ResultSet resultadoSelect; //Ejecutar y almacenar los Select
    private String sql; //colocar el SQL
    private int cantidadRegistros; //conocer la cantidad de registros afectados por el SQL

    @Override
    public String agregarTipoCategoria(TipoCategoria tipoCategoria) {
        try {
            conexion.abrirConexion();
            sql = "insert into tipo_categoria(tipo_categoria_id, nombre) values(?,?)";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, tipoCategoria.getTipoCategoria());
            ejecutar.setString(2, tipoCategoria.getNombre());

            //ejecutar el codigo
            cantidadRegistros = ejecutar.executeUpdate();
            if (cantidadRegistros > 0) {
                mensaje = "Nombre almacenado con éxito";
            } else {
                mensaje = "No se pudo almacenar el Nombre, verifique datos e intente de nuevo";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("TipoCategoriaDao, error en metodo agregarUsuario: " + ex);
            mensaje = "Error al agregar nombre";
        } finally {
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String eliminarTipoCategoria(TipoCategoria tipoCategoria) {
        try {
            conexion.abrirConexion();
            sql = "delete from tipo_categoria where tipo_categoria_id=?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, tipoCategoria.getTipoCategoria());
            //ejecutar el codigo
            cantidadRegistros = ejecutar.executeUpdate();
            if (cantidadRegistros > 0) {
                mensaje = "Nombre eliminado con éxito";
            } else {
                mensaje = "No se pudo eliminar el Nombre, el id no existe";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("TipoCategoriaDao, error en metodo eliminarNombre: " + ex);
            mensaje = "Error al eliminar Nombre";
        } finally {
            conexion.cerrarConexion();
        }

        return mensaje;
    }

    @Override
    public String actualizarTipoCategoria(TipoCategoria tipoCategoria) {
        try {
            conexion.abrirConexion();
            sql = "update tipo_categoria set nombre=?  where tipo_categoria_id = ?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas

            ejecutar.setString(1, tipoCategoria.getNombre());
            ejecutar.setInt(2, tipoCategoria.getTipoCategoria());

            //ejecutar el codigo
            cantidadRegistros = ejecutar.executeUpdate();
            if (cantidadRegistros > 0) {
                mensaje = "Nombre modificado con éxito";
            } else {
                mensaje = "No se pudo modificar el Nombre, verifique datos e intente de nuevo";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("TipoCategoriaDao, error en metodo modificarNombre: " + ex);
            mensaje = "Error al modificar Nombre";
        } finally {
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public ArrayList<TipoCategoria> listarTiposCategorias() {
        try {
            conexion.abrirConexion();
            sql = "select * from tipo_categoria";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //ejecutar el codigo
            resultadoSelect = ejecutar.executeQuery();

            while (resultadoSelect.next()) {
                //asignar datos localizados al objeto
                datosBusqueda = new TipoCategoria();
                datosBusqueda.setTipoCategoria(resultadoSelect.getInt("tipo_categoria_id"));
                datosBusqueda.setNombre(resultadoSelect.getString("nombre"));
                listaTipoCategoria.add(datosBusqueda);
            }

        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("TipoCategoriaDao, error en metodo modificarNombre: " + ex);
            datosBusqueda = new TipoCategoria();//Unicamente se inicia el objeto

        } finally {
            conexion.cerrarConexion();
        }

        return listaTipoCategoria;
    }

    @Override
    public TipoCategoria buscarTipoCategoria(TipoCategoria tipoCategoria) {
        try {
            conexion.abrirConexion();
            sql = "select * from tipo_categoria where tipo_categoria_id = ?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, tipoCategoria.getTipoCategoria());
            //ejecutar el codigo
            resultadoSelect = ejecutar.executeQuery();
            resultadoSelect.next(); // posicionarse en el primer registro
            //asignar datos localizados al objeto
            datosBusqueda = new TipoCategoria();

            datosBusqueda.setTipoCategoria(resultadoSelect.getInt("tipo_categoria_id"));
            datosBusqueda.setNombre(resultadoSelect.getString("nombre"));

        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("TipoCategoriaDao, error en metodo modificarNombre: " + ex);
            datosBusqueda = new TipoCategoria();//Unicamente se inicia el objeto

        } finally {
            conexion.cerrarConexion();
        }
        return datosBusqueda;

    }

}
