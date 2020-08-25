/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CategoriaMesDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CategoriaMes;
import vista.JFrmIngresosPlanificados;

/**
 *
 * @author Julius
 */
public class IngresosPlanificadosControlador implements ActionListener {
    
    CategoriaMesDao dao = new CategoriaMesDao();
    JFrmIngresosPlanificados formulario = new JFrmIngresosPlanificados();
    
    //instanciar la clase Usuario, para asignar los valores y enviarlos al dao
    CategoriaMes categoriaMes = new CategoriaMes();
    
    //instarnciar nuevamente la clase Usuario, para recibir los datos de las busquedas (select)
    CategoriaMes categoriaMesSelect = new CategoriaMes();

    public IngresosPlanificadosControlador(JFrmIngresosPlanificados vista) {
        formulario = vista;
        formulario.jBtnSumarIngresosPlanificados.addActionListener (this);
        
    }
    
        
    

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==formulario.jBtnSumarIngresosPlanificados) {
            obtenerValores();
    }
    
    
   
}

    public void obtenerValores() {
        categoriaMes.setMonto(formulario.jTxtMontoIngresoIngresosPlanificados.getText());
        
    }
}