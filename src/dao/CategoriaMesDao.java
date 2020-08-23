/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.CategoriaMesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CategoriaMes;


/**
 *
 * @author Julius
 */
public class CategoriaMesDao implements CategoriaMesInterfacesInterface {

    static String eliminarCategoriaMes(CategoriaMesDao categoriaMes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static CategoriaMesDao buscarCategoriaMes(CategoriaMesDao categoriaMes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static String actualizarCategoriaMes(CategoriaMesDao categoriaMes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String mensaje; //mensaje insert, update, delete
     private CategoriaMes datosBusqueda; //cuando se haga una busqueda los datos se almacenaran en este objeto y se retornara
    
    private ConexionAzure conexion = new ConexionAzure(); // conexion con la base de datos remota en Azure
    private PreparedStatement ejecutar; //preparar y ejecutar el SQL en la base de datos
    private ResultSet resultadoSelect; //Ejecutar y almacenar los Select
    private String sql; //colocar el SQL
    private int cantidadRegistros; //conocer la cantidad de registros afectados por el SQL
    
    
    public String agregarCategoriaMes (CategoriaMes categoriaMes) {
        try {
            conexion.abrirConexion();
            sql = "insert into categorias_meses(correlativo, categoria_id, tipo_categoria, mes_id, anio, monto, usuario_id) values(?,?,?,?,md5(?),?,?)";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, categoriaMes.getCorrelativo());
            ejecutar.setInt(2, categoriaMes.getCategoriaId());
            ejecutar.setInt(3, categoriaMes.getTipoCategoria());
            ejecutar.setInt(4, categoriaMes.getMesId());
            ejecutar.setString(5, categoriaMes.getAnio());
            ejecutar.setInt(6, categoriaMes.getMonto());
            ejecutar.setInt(7, categoriaMes.getUsuarioId());
            //ejecutar el codigo
            cantidadRegistros=ejecutar.executeUpdate();
            if (cantidadRegistros>0) {
                mensaje="Mes almacenado con éxito";
            }else{
                mensaje="No se pudo almacenar el Mes, verifique datos e intente de nuevo";
            }            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaMesDao, error en metodo agregarUsuario: " + ex);
            mensaje ="Error al agregar mes";
        }finally{
             conexion.cerrarConexion();
         }
        return mensaje;
    }

    
    public String eliminarCategoriaMes(CategoriaMes categoriaMes) {
         try {
            conexion.abrirConexion();
            sql = "delete from Categoriames where usuario_id=?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, categoriaMes.getCorrelativo());
             //ejecutar el codigo
            cantidadRegistros=ejecutar.executeUpdate();
            if (cantidadRegistros>0) {
                mensaje="Mes eliminado con éxito";
            }else{
                mensaje="No se pudo eliminar el Mes, el id no existe";
            }            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaMesDao, error en metodo eliminarMes: " + ex);
            mensaje ="Error al eliminar usuario";
        }finally{
             conexion.cerrarConexion();
         }
         
        return mensaje;
    }
    
    public String actualizarCategoriaMes (CategoriaMes categoriaMes) {
          try {
            conexion.abrirConexion();
            sql = "update usuarios set correlativo=? , categoria=? , tipo_categoria=?, mes_id=md5(?), anio=?, monto = ?, usuario_id = ?,  where usuario_id = ?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
            ejecutar.setInt(1, categoriaMes.getCorrelativo());
            ejecutar.setInt(2, categoriaMes.getCategoriaId());
            ejecutar.setInt(3, categoriaMes.getTipoCategoria());
            ejecutar.setInt(4, categoriaMes.getMesId());
            ejecutar.setString(5, categoriaMes.getAnio());
            ejecutar.setInt(6, categoriaMes.getMonto());
            ejecutar.setInt(7, categoriaMes.getUsuarioId());
            //ejecutar el codigo
            cantidadRegistros=ejecutar.executeUpdate();
            if (cantidadRegistros>0) {
                mensaje="Mes modificado con éxito";
            }else{
                mensaje="No se pudo modificar el Mes, verifique datos e intente de nuevo";
            }            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaMesDao, error en metodo modificarMes: " + ex);
            mensaje ="Error al modificar usuario";
        }finally{
             conexion.cerrarConexion();
         }
        return mensaje;
    }

  
    public CategoriaMes buscarCategoriaMes(CategoriaMes categoriaMes) {
        try {
            conexion.abrirConexion();
            sql = "select * from categorias_meses where usuario_id = ?";//por cada campo se coloca una incognita
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            //asignar valores para las incognitas
             ejecutar.setInt(1, categoriaMes.getCorrelativo());
            //ejecutar el codigo
            resultadoSelect = ejecutar.executeQuery();
            resultadoSelect.next(); // posicionarse en el primer registro
            //asignar datos localizados al objeto
            datosBusqueda=new CategoriaMes();
            datosBusqueda.setCorrelativo(resultadoSelect.getInt("correlativo"));
            datosBusqueda.setCategoriaId(resultadoSelect.getInt("categoria_id"));
            datosBusqueda.setTipoCategoria(resultadoSelect.getInt("tipo_categoria"));
            datosBusqueda.setMesId(resultadoSelect.getInt("mes_id"));
            datosBusqueda.setAnio(resultadoSelect.getString("anio"));
            datosBusqueda.setMonto(resultadoSelect.getInt("monto"));
            datosBusqueda.setUsuarioId(resultadoSelect.getInt("usuario_id"));
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CategoriaMesDao, error en metodo modificarUsuario: " + ex);
            datosBusqueda=new CategoriaMes();//Unicamente se inicia el objeto
           
        }finally{
             conexion.cerrarConexion();
         }
        return datosBusqueda;
    }

    void setCorrelativo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setCategoriaId(String persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setTipoCategoria(String inventada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMesId(String persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setAnio(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMonto(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setUsuarioId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
