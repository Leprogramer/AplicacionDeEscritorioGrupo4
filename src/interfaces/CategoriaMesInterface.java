/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.CategoriaMes;

/**
 *
 * @author Julius
 */
public interface CategoriaMesInterface {
    public String agregarCategoriaMes (CategoriaMes categoriaMes);
    public String eliminarCategoriaMes(CategoriaMes categoriaMes);
    public String actualizarCategoriaMes (CategoriaMes categoriaMes);
    public CategoriaMes buscarCategoriaMes(CategoriaMes categoriaMes);
    
}
