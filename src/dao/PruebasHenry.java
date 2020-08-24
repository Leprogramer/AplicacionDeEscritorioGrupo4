/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Categoria;

/**
 *
 * @author admin
 */
public class PruebasHenry {
     public static void main(String[] args) {
        CategoriaDao dao = new CategoriaDao();
        String mensaje;
        Categoria categoria = new Categoria(); //asignar valores al usuario
        Categoria datosLocalizado = new Categoria();//colocar los datos del usuario cuando se realice una busqueda

        /*categoria.setCategoriaId(1);
        mensaje = dao.eliminarCategoria(categoria);
        System.out.println(mensaje);*/
      
        /*
        //Modificar
        
        categoria.setCategoriaId(1);
        categoria.setNombre("Juan");
        categoria.setTipo_categoria_id(1);
        
        mensaje = dao.actualizarCategoria(categoria);
                
        System.out.println(mensaje);
        */
        
       /*
        //Buscar
        categoria.setCategoriaId(1);
        datosLocalizado = dao.buscarCategoria(categoria);
        System.out.println(datosLocalizado.toString());
     */
       
        /*
      categoria.setCategoriaId(1);
        categoria.setCategoriaId(1);
        categoria.setNombre("Juan");
        categoria.setTipo_categoria_id(1);
        
        mensaje = dao.agregarCategoria(categoria);
                
        System.out.println(mensaje);
       
      */  
     }
     
     
     
     
}
