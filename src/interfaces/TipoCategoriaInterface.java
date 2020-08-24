/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.TipoCategoria;

/**
 *
 * @author Julius
 */
public interface TipoCategoriaInterface {
    public String agregarTipoCategoria(TipoCategoria tipoCategoria);
    public String eliminarTipoCategoria(TipoCategoria tipoCategoria);
    public String actualizarTipoCategoria(TipoCategoria tipoCategoria);
    public  TipoCategoria buscarTipoCategoria(TipoCategoria tipoCategoria);
    
    
    
    
}
