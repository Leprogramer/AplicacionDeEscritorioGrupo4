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
public class ObjetivoFinanciero {
    private int objetivoFinancieroId;
    private String nombre;
    private int mesId;
    private int anio;
    private int monto;
    private int usuarioId;
    
    
    public ObjetivoFinanciero(int objetivoFinancieroId, String nombre, int mesId, int anio, int monto, int usuarioId) {
        this.objetivoFinancieroId = objetivoFinancieroId;
        this.nombre = nombre;
        this.mesId = mesId;
        this.anio = anio;
        this.monto = monto;
        this.usuarioId = usuarioId;
    }

    public ObjetivoFinanciero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     @Override
    public String toString() {
        return "ObjetivoFinanciero{" + "objetivoFinancieroId=" + objetivoFinancieroId + ", nombre=" + nombre + ", mesId=" + mesId + ", anio=" + anio + ", monto=" + monto + ", usuarioId=" + usuarioId + '}';
    }
    
    
    public int getObjetivoFinancieroId() {
        return objetivoFinancieroId;
    }

    public void setObjetivoFinancieroId(int objetivoFinancieroId) {
        this.objetivoFinancieroId = objetivoFinancieroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMesId() {
        return mesId;
    }

    public void setMesId(int mesId) {
        this.mesId = mesId;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

   

    
    
}
