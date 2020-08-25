/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author admin
 */
public class Pais {
    private int paisId;
    private String nombre;
    private String nombreMoneda;
    private String simbolo;
    
    
     public Pais() {
        
    }

    public Pais(int paisId, String nombre, String nombreMoneda, String simbolo) {
        this.paisId = paisId;
        this.nombre = nombre;
        this.nombreMoneda = nombreMoneda;
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Pais{" + "paisId=" + paisId + ", nombre=" + nombre + ", nombreMoneda=" + nombreMoneda + ", simbolo=" + simbolo + '}';
    }

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
