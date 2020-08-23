/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author admin
 */
public class PruebasJulio {
    public static void main(String[] args) {
        CategoriaMesDao mesDao = new CategoriaMesDao();
        String mensaje;
        CategoriaMesDao categoriaMes = new CategoriaMesDao(); //asignar valores al usuario
        CategoriaMesDao datosLocalizado = new CategoriaMesDao();//colocar los datos del usuario cuando se realice una busqueda
        
        
        
        //Eliminar Mes
        categoriaMes.setCorrelativo(1);
        mensaje = CategoriaMesDao.eliminarCategoriaMes(categoriaMes);
        
        
        
        
        
        
        
        //Modificar
        categoriaMes.setCorrelativo(1);
        categoriaMes.setCategoriaId("Persona");
        categoriaMes.setTipoCategoria("Inventada");
        categoriaMes.setMesId("persona");
        categoriaMes.setAnio("123456");
        categoriaMes.setMonto(1);
        categoriaMes.setUsuarioId(1);
        mensaje = CategoriaMesDao.actualizarCategoriaMes(categoriaMes);
                
        System.out.println(mensaje);
        
        
        
        //Buscar
        categoriaMes.setCorrelativo(1);
        datosLocalizado = CategoriaMesDao.buscarCategoriaMes(categoriaMes);
        System.out.println(datosLocalizado.toString());
        
        
        
        
    }
}
