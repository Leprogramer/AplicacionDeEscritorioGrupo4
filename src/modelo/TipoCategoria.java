/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Julius
 */
public class TipoCategoria {
    private int tipoCategoria;
    private String nombre;
    
      public TipoCategoria() {
        
    }

    public TipoCategoria(int tipoCategoria, String nombre) {
        this.tipoCategoria = tipoCategoria;
        this.nombre = nombre;
    }
    
   
   
    
    @Override
    public String toString() {
        return "TipoCategoria{" + "tipoCategoria=" + tipoCategoria + ", nombre=" + nombre + '}';
    }
    

    public int getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(int tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

      
}
