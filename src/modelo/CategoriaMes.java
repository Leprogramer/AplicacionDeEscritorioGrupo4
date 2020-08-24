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
    private int anio;
    private int monto;
    private int usuarioId;
    
    public CategoriaMes() {
        
    }

    public CategoriaMes(int correlativo, int categoriaId, int tipoCategoria, int mesId, int anio, int monto, int usuarioId) {
        this.correlativo = correlativo;
        this.categoriaId = categoriaId;
        this.tipoCategoria = tipoCategoria;
        this.mesId = mesId;
        this.anio = anio;
        this.monto = monto;
        this.usuarioId = usuarioId;
    }

    

    @Override
    public String toString() {
        return "CategoriaMes{" + "correlativo=" + correlativo + ", categoriaId=" + categoriaId + ", tipoCategoria=" + tipoCategoria + ", mesId=" + mesId + ", anio=" + anio + ", monto=" + monto + ", usuarioId=" + usuarioId + '}';
    }
    
    
    
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

