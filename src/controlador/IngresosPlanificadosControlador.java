/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CategoriaDao;
import dao.CategoriaMesDao;
import dao.TipoCategoriaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.CategoriaMes;
import modelo.TipoCategoria;
import vista.JFrmIngresosPlanificados;

/**
 *
 * @author Julius
 */
public class IngresosPlanificadosControlador implements ActionListener {

    //DaoTipoCategoria, Modelo
    TipoCategoriaDao tipoCategoriadao = new TipoCategoriaDao();
    ArrayList<TipoCategoria> listaTipoCategoria = new ArrayList();

    //DaoCategoria
    CategoriaDao categoriaDao = new CategoriaDao();
    ArrayList<Categoria> listaCategoria = new ArrayList();

    //daoCategoriaMes
    CategoriaMesDao daoCategoriaMes = new CategoriaMesDao();
    ArrayList<CategoriaMes> listaCategoriasMeses = new ArrayList();

    JFrmIngresosPlanificados formulario = new JFrmIngresosPlanificados();

    //instanciar la clase Usuario, para asignar los valores y enviarlos al dao
    CategoriaMes categoriaMes = new CategoriaMes();

    //instarnciar nuevamente la clase Usuario, para recibir los datos de las busquedas (select)
    CategoriaMes categoriaMesSelect = new CategoriaMes();
    //String para recibir mensaje al insertar, eliminar o actualizar
    private String mensaje;

    public IngresosPlanificadosControlador(JFrmIngresosPlanificados vista) {
        formulario = vista;
        formulario.jBtnGuardarIngresosEgresos.addActionListener(this);

        //agregar eventos a los jComboBox
        formulario.jCmbCategoria.addActionListener(this);
        formulario.jCmbTipoCategoria.addActionListener(this);
        //cargar las lista displegables (JComboBox)
        cargarCategorias();
        cargarTiposCategorias();
        cargarTablaIngresosEgresos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formulario.jBtnGuardarIngresosEgresos) {
            obtenerValores();
            mensaje = daoCategoriaMes.agregarCategoriaMes(categoriaMes);
            JOptionPane.showMessageDialog(formulario, mensaje);
        }

        if (e.getSource() == formulario.jCmbTipoCategoria) {
            System.out.println("clic en lista tipo categoria");
            //asignado el codigo correspondiente al tipo de categoria seleccionado
            formulario.jLblCodigoTipoCategoria.setText(String.valueOf(listaTipoCategoria.get(formulario.jCmbTipoCategoria.getSelectedIndex()).getTipoCategoria()));
        }
        if (e.getSource() == formulario.jCmbCategoria) {
            System.out.println("clic en lista categoria");
            formulario.jLblCodigoCategoria.setText(String.valueOf(listaCategoria.get(formulario.jCmbCategoria.getSelectedIndex()).getTipo_categoria_id()));
        }

    }

    public void guardarCategoriasMeses() {

    }

    public void obtenerValores() {

        //categoriaMes.setCorrelativo(0); ya no es necesario porque es autonumerico
        categoriaMes.setCategoriaId(Integer.parseInt(formulario.jLblCodigoCategoria.getText()));
        categoriaMes.setTipoCategoria(Integer.parseInt(formulario.jLblCodigoTipoCategoria.getText()));
        categoriaMes.setAnio(formulario.jDateIngresosEgresos.getCalendar().get(Calendar.YEAR));
        categoriaMes.setMesId(formulario.jDateIngresosEgresos.getCalendar().get(Calendar.MONTH) + 1);
        categoriaMes.setMonto(Integer.parseInt(formulario.jTxtMontoIngresoIngresosPlanificados.getText()));
        categoriaMes.setUsuarioId(1); //codigo fijo

    }

    public void cargarTiposCategorias() {
        //modelo para cargar datos al comboBox
        DefaultComboBoxModel modeloComboTipoCategoria = new DefaultComboBoxModel();

        //cargar datos de la base de datos en el ArrayList
        listaTipoCategoria = tipoCategoriadao.listarTiposCategorias();

        for (TipoCategoria tipoCategoria : listaTipoCategoria) {
            System.out.println(tipoCategoria.toString());
            modeloComboTipoCategoria.addElement(tipoCategoria.getNombre());
        }
        //cargando al como el modelo que es llenado por el arrayList en el ciclo
        this.formulario.jCmbTipoCategoria.setModel(modeloComboTipoCategoria);
    }

    public void cargarCategorias() {
        DefaultComboBoxModel modeloComboCategoria = new DefaultComboBoxModel();
        //cargar datos de la base de datos en el ArrayList
        listaCategoria = categoriaDao.listarCategorias();
        for (Categoria categoria : listaCategoria) {
            System.out.println(categoria.toString());
            modeloComboCategoria.addElement(categoria.getNombre());
        }
        //cargando al como el modelo que es llenado por el arrayList en el ciclo
        this.formulario.jCmbCategoria.setModel(modeloComboCategoria);
    }

    public void cargarTablaIngresosEgresos() {
        DefaultTableModel modeloTabla = new DefaultTableModel();

        listaCategoriasMeses = daoCategoriaMes.listarCategoriasMeses();

        //asignar titulos al modelo (titulos de columna)
        modeloTabla.addColumn("Correlativo");
        modeloTabla.addColumn("categoria_id");
        modeloTabla.addColumn("tipo_categoria");
        modeloTabla.addColumn("mes_id");
        modeloTabla.addColumn("año");
        modeloTabla.addColumn("monto");
        
        //se establece la cantidad de columnas que es igual a la cantidad de titulos
        Object[] columna = new Object[6];

        for (CategoriaMes categoriaMes : listaCategoriasMeses) {
            System.out.println(categoriaMes.toString());
            //asignan los valores a cada columna
            columna[0] = categoriaMes.getCorrelativo();
            columna[1] = categoriaMes.getCategoriaId();
            columna[2] = categoriaMes.getTipoCategoria();
            columna[3] = categoriaMes.getMesId();
            columna[4] = categoriaMes.getAnio();
            columna[5] = categoriaMes.getMonto();
            
            modeloTabla.addRow(columna);
        }

        formulario.jTblIngresosEgresos.setModel(modeloTabla);

    }
}
