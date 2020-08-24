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
    private int categoriaId;
    private String nombre;
    private int tipo_categoria_id;

    
     public Categoria (){
}
    
    
    public Categoria(int categoriaId, String nombre, int tipo_categoria_id) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.tipo_categoria_id = tipo_categoria_id;
    }

    

    

    @Override
    public String toString() {
        return "Categoria{" + "categoriaId=" + categoriaId + ", nombre=" + nombre + ", tipo_categoria_id=" + tipo_categoria_id + '}';
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo_categoria_id() {
        return tipo_categoria_id;
    }

    public void setTipo_categoria_id(int tipo_categoria_id) {
        this.tipo_categoria_id = tipo_categoria_id;
    }

   
    
    
}