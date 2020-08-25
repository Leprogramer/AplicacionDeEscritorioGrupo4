/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author Julius
 */
public interface CategoriaInterface {
    
    public String agregarCategoria (Categoria categoria);
    public String eliminarCategoria (Categoria categoria);
    public String actualizarCategorias (Categoria categoria);
    public Categoria buscarCategoria(Categoria categoria);
    public ArrayList<Categoria> listarCategorias ();
    
}
