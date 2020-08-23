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
public class Categoria {
    private int categriaId;
    private String nombre;
    private int tipoCategoria;

    public int getCategriaId() {
        return categriaId;
    }

    public void setCategriaId(int categriaId) {
        this.categriaId = categriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(int tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public Categoria(int categriaId, int nombre, int tipoCategoria) {
        this.categriaId = categriaId;
        this.nombre = this.nombre;
        this.tipoCategoria = tipoCategoria;
    }
    
    public Categoria() {
        
    }

    public int getCategoriaId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
