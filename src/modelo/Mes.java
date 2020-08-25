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
public class Mes {
   private int mesId;
   private String nombre;

    public Mes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public String toString() {
        return "Mes{" + "mesId=" + mesId + ", nombre=" + nombre + '}';
    }
   
   
    public Mes(int mesId, String nombre) {
        this.mesId = mesId;
        this.nombre = nombre;
    }

    public int getMesId() {
        return mesId;
    }

    public void setMesId(int mesId) {
        this.mesId = mesId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
