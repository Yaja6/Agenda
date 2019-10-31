/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5.Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClsConexion {
    private Connection base;
    private Statement tabla;
    private ResultSet guia;

     public ClsConexion(String dirbase) {
        try {
            base = DriverManager.getConnection("jdbc:ucanaccess://" + dirbase);
            System.out.println("***CONEXIÓN EXITOSA***");
            tabla = base.createStatement(ResultSet.FETCH_UNKNOWN, ResultSet.TYPE_SCROLL_SENSITIVE);

        } catch (Exception err) {
            System.out.println("***CONEXIÓN FALLIDA***" + err);
        }
     }
     public ResultSet _guia() {
        return guia;
    }

    
    public boolean consulta(String _tabla) throws SQLException {
        boolean comprobar = false;
        String comando = " SELECT * FROM " + _tabla;
       guia = null;
        tabla.execute(comando);
        guia= tabla.getResultSet();
        if (guia != null) {
            comprobar = true;
        }
        return comprobar;
    }
    
     public boolean verguia(int clave) throws SQLException {
        guia = null;
        boolean comprobar = false;
        String comando = "SELECT * FROM Clientes WHERE Identificador  = " + clave;
        tabla.execute(comando);
        guia = tabla.getResultSet();
        if (guia != null) {
            comprobar = true;
        }
        return comprobar;
    }

     public boolean registrarCliente(String ced,String n, String a, String f, String d, String c, String e) throws SQLException {
        guia = null;
        boolean registrar = false;
        try {
            String insertar = "INSERT INTO Clientes"
                    + "(cedCliente,nomCliente,apellCliente,fechaCliente,dirCliente,telefCliente,emailCliente)"
                    + "VALUES"
                    + "('" +ced + "','"+ n + "','" + a + "','" + f + "','" + d + "','" + c + "','" + e + "');";
            tabla = base.createStatement();
            tabla.execute(insertar);
            guia = tabla.getResultSet();
            if (guia != null) {
                registrar = true;
            }
        } catch (SQLException re) {
            System.out.println("No" + re);
        }
        return registrar;
    }
     public void siguiente() {
        try {

            if (!(guia.next())) {
                guia.first();
            }
        } catch (SQLException err) {
            System.out.println("***ERROR AL RECORRER");
        }
    }

    public void anterior() {
        try {
            if (!(guia.previous())) {
                guia.last();
            }
        } catch (SQLException err) {
            System.out.println("***ERROR AL RECORRER");
        }
    }
}
