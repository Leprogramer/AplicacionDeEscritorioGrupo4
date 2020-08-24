/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.CategoriaMes;

/**
 *
 * @author admin
 */
public class PruebasJulio {
    public static void main(String[] args) {
        CategoriaMesDao dao = new CategoriaMesDao();
        String mensaje;
        CategoriaMes categoriaMes = new CategoriaMes(); //asignar valores al usuario
        CategoriaMes datosLocalizado = new CategoriaMes();//colocar los datos del usuario cuando se realice una busqueda
        
        
        /*
        //Eliminar Mes
        categoriaMes.setCorrelativo(2);
        mensaje = dao.eliminarCategoriaMes(categoriaMes);
        System.out.println(mensaje);
        */
        
       /*
        //Modificar
        categoriaMes.setCorrelativo(1);
        categoriaMes.setCategoriaId(1);
        categoriaMes.setTipoCategoria(1);
        categoriaMes.setMesId(1);
        categoriaMes.setAnio(2020);
        categoriaMes.setMonto(1000);
        categoriaMes.setUsuarioId(1);
        mensaje = dao.actualizarCategoriaMes(categoriaMes);
                
        System.out.println(mensaje);
        */
        
      
        //Buscar
        categoriaMes.setCorrelativo(15);
        datosLocalizado = dao.buscarCategoriaMes(categoriaMes);
        System.out.println(datosLocalizado.toString());
      
        
        /*
      categoriaMes.setCorrelativo(15);
        categoriaMes.setCategoriaId(1);
        categoriaMes.setTipoCategoria(1);
        categoriaMes.setMesId(1);
        categoriaMes.setAnio(2020);
        categoriaMes.setMonto(1000);
        categoriaMes.setUsuarioId(1);
        mensaje = dao.agregarCategoriaMes(categoriaMes);
                
        System.out.println(mensaje);
        */
    }
}
