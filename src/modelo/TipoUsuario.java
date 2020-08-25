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
public class TipoUsuario {
    private int tipoUsuarioId;
    private String nombre;
    private String descripcion;

    
     @Override
    public String toString() {
        return "TipoUsuario{" + "tipoUsuarioId=" + tipoUsuarioId + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    public TipoUsuario(int tipoUsuarioId, String nombre, String descripcion) {
        this.tipoUsuarioId = tipoUsuarioId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(int tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
   

    
}
