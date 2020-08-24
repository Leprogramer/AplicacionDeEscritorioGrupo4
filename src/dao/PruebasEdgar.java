/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.TipoCategoria;

/**
 *
 * @author admin
 */
public class PruebasEdgar {
    
    public static void main(String[] args) {
        TipoCategoriaDao dao = new TipoCategoriaDao() {
            @Override
            public TipoCategoria buscarTipoCategoria(TipoCategoria tipoCategoria) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        String mensaje = null;
        TipoCategoria tipoCategoria = new TipoCategoria(); //asignar valores al usuario
        TipoCategoria datosLocalizado = new TipoCategoria();//colocar los datos del usuario cuando se realice una busqueda
        
        
        //Eliminar Mes
        tipoCategoria.setTipoCategoria(1);
        mensaje = dao.eliminarTipoCategoria(tipoCategoria);
        System.out.println(mensaje);
        
        
        /*
         //Modificar
        tipoCategoria.setTipoCategoria(1);
        tipoCategoria.setNombre(mensaje);
        
        mensaje = dao.actualizarTipoCategoria(tipoCategoria);
                
        System.out.println(mensaje);
        */
        /*
        //Buscar
        tipoCategoria.setTipoCategoria(1);
        datosLocalizado = dao.buscarTipoCategoria(tipoCategoria);
        System.out.println(datosLocalizado.toString());
        */
        
        /*
        tipoCategoria.setTipoCategoria(1);
        tipoCategoria.setNombre("Juan");
        mensaje = dao.agregarTipoCategoria(tipoCategoria);
                
        System.out.println(mensaje);
        */
    }
}
    

   
    
