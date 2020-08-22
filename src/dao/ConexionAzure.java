/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controlador.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ConexionAzure {
     //Connection es una clase de la API de Java por ello se debe importar
    private Connection miConexion;
    private static final String URL = "jdbc:mysql://mysqlgrupo4.mysql.database.azure.com/planificador_2020";
    private static final String USER = "Admin1@mysqlgrupo4";
    //el usuario que estoy utilizando no cuenta contraseña se colocan comillas para abrir y cerrar sin espacio
    private static final String PASSWORD = "Grupo41!";

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }

    public void abrirConexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            miConexion = DriverManager.getConnection(URL, USER, PASSWORD);
             System.out.println("Conexión a la base de datos con éxito ");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en conexion" + ex);
        }
    }

    public void cerrarConexion() {
        try {
            if (miConexion != null) {
                if (miConexion.isClosed() == false) {
                    miConexion.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar: " + ex);
        }
    }
}
