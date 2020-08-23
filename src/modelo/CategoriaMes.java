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
public class CategoriaMes {
    private int correlativo;
    private int categoriaId;
    private int tipoCategoria;
    private int mesId;
    private String anio;
    private int monto;
    private int usuarioId;
    
    public CategoriaMes() {
        
    }

    public CategoriaMes(int correlativo, int categoriaId, int tipoCategoria, int mesId, String anio, int monto, int usuarioId) {
        this.correlativo = correlativo;
        this.categoriaId = categoriaId;
        this.tipoCategoria = tipoCategoria;
        this.mesId = mesId;
        this.anio = anio;
        this.monto = monto;
        this.usuarioId = usuarioId;
    }

    /*
    @Override
    public String toString() {
        return "Usuario{" + "usuarioId=" + usuarioId + ", nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + ", paisId=" + paisId + ", tipoUsuario=" + tipoUsuario + '}';
    }*/
    
    
    
    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(int tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public int getMesId() {
        return mesId;
    }

    public void setMesId(int mesId) {
        this.mesId = mesId;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
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

