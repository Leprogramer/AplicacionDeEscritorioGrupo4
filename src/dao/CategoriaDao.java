/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.CategoriaInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author Julius
 */
public class CategoriaDao implements CategoriaInterface {

    private String mensaje; //mensaje insert, update, delete
    private Categoria datosBusqueda; //cuando se haga una busqueda los datos se almacenaran en este objeto y se retornara
    private ArrayList<Categoria> listaCategorias = new ArrayList(); //Obtener la lista de categorias de la base de datos

    private ConexionAzure conexion = new ConexionAzure(); // conexion con la base de datos remota en Azure
    private PreparedStatement ejecutar; //preparar y ejecutar el SQL en la base de datos
    private ResultSet resultadoSelect; //Ejecutar y almacenar los Select
    private String sql; //colocar el SQL
    private int cantidadRegistros; //conocer la cantidad de registros afectados por el SQL

    public String agregarCategoria(Categoria categoria) {
        try {
            conexion.abrirConexion();
            sql = "insert into categoria (categoria_id, nombre, tipo_categoria) values(?,?,?)";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, categoria.getCategoriaId());
            ejecutar.setString(2, categoria.getNombre());
            ejecutar.setInt(3, categoria.getTipo_categoria_id());

            //ejecutar el codigo
            cantidadRegistros = ejecutar.executeUpdate();
            if (cantidadRegistros > 0) {
                mensaje = "Nombre almacenado con éxito";
            } else {
                mensaje = "No se pudo almacenar el Nombre, verifique datos e intente de nuevo";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaDao, error en metodo agregarUsuario: " + ex);
            mensaje = "Error al agregar mes";
        } finally {
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    public String eliminarCategoria(Categoria categoria) {
        try {
            conexion.abrirConexion();
            sql = "delete from categoria where categoria_id=?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, categoria.getCategoriaId());
            //ejecutar el codigo
            cantidadRegistros = ejecutar.executeUpdate();
            if (cantidadRegistros > 0) {
                mensaje = "Nombre eliminado con éxito";
            } else {
                mensaje = "No se pudo eliminar el nombre, el id no existe";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaDao, error en metodo eliminarNombre: " + ex);
            mensaje = "Error al eliminar usuario";
        } finally {
            conexion.cerrarConexion();
        }

        return mensaje;
    }

    public String actualizarCategoria(Categoria categoria) {
        try {
            conexion.abrirConexion();
            sql = "update categoria set nombre=? , tipo_categoria-id=? where nombre = ?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas

            ejecutar.setString(1, categoria.getNombre());
            ejecutar.setInt(2, categoria.getTipo_categoria_id());
            ejecutar.setInt(3, categoria.getCategoriaId());

            //ejecutar el codigo
            cantidadRegistros = ejecutar.executeUpdate();
            if (cantidadRegistros > 0) {
                mensaje = "Nombre modificado con éxito";
            } else {
                mensaje = "No se pudo modificar el Nombre, verifique datos e intente de nuevo";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaMesDao, error en metodo modificarMes: " + ex);
            mensaje = "Error al modificar usuario";
        } finally {
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    public Categoria buscarCategoria(Categoria categoria) {
        try {
            conexion.abrirConexion();
            sql = "select * from categoria where categoria_id = ?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, categoria.getCategoriaId());
            //ejecutar el codigo
            resultadoSelect = ejecutar.executeQuery();
            resultadoSelect.next(); // posicionarse en el primer registro
            //asignar datos localizados al objeto
            datosBusqueda = new Categoria();

            datosBusqueda.setCategoriaId(resultadoSelect.getInt("categoria_id"));
            datosBusqueda.setNombre(resultadoSelect.getString("nombre"));
            datosBusqueda.setTipo_categoria_id(resultadoSelect.getInt("tipo_categoria_id"));

        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaDao, error en metodo modificarUsuario: " + ex);
            datosBusqueda = new Categoria(); //Unicamente se inicia el objeto

        } finally {
            conexion.cerrarConexion();
        }
        return datosBusqueda;
    }

    @Override
    public String actualizarCategorias(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> listarCategorias() {
        try {
            conexion.abrirConexion();
            sql = "select * from categoria";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);

            //ejecutar el codigo
            resultadoSelect = ejecutar.executeQuery();
            while (resultadoSelect.next()) {
                //asignar datos localizados al objeto
                datosBusqueda = new Categoria();
                datosBusqueda.setCategoriaId(resultadoSelect.getInt("categoria_id"));
                datosBusqueda.setNombre(resultadoSelect.getString("nombre"));
                datosBusqueda.setTipo_categoria_id(resultadoSelect.getInt("tipo_categoria_id"));
                listaCategorias.add(datosBusqueda); //llenando la lista de categorias
            }

        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaDao, error en metodo modificarUsuario: " + ex);
            datosBusqueda = new Categoria(); //Unicamente se inicia el objeto
            
        } finally {
            conexion.cerrarConexion();
        }
        return listaCategorias;
    }

}
