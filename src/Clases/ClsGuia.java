/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClsGuia {

    private int _Identificador;
    private String _cedCliente;
    private String _nomCliente;
    private String _apellCliente;
    private String _dirCliente;
    private String _fechaCliente;
    private String _telefCliente;
    private String _emailCliente;

    public ClsGuia() {
        _Identificador = 0;
        _cedCliente = null;
        _nomCliente = null;
        _apellCliente = null;
        _dirCliente = null;
        _fechaCliente = null;
        _telefCliente = null;
        _emailCliente = null;
    }

    public void leer(ResultSet cliente) throws SQLException {
        _Identificador = cliente.getInt("Identificador");
        _cedCliente=cliente.getString("cedCliente");
        _nomCliente = cliente.getString("nomCliente");
        _apellCliente = cliente.getString("apellCliente");
        _dirCliente = cliente.getString("dirCliente");
        _fechaCliente = cliente.getString("fechaCliente");
        _telefCliente = cliente.getString("telefCliente");
        _emailCliente = cliente.getString("emailCliente");
    }

    public int getIdentificador() {
        return _Identificador;
    }

    public void setIdentificador(int _Identificador) {
        this._Identificador = _Identificador;
    }

    public String getCedCliente() {
        return _cedCliente;
    }

    public void setCedCliente(String _cedCliente) {
        this._cedCliente = _cedCliente;
    }

    public String getNomCliente() {
        return _nomCliente;
    }

    public void setNomCliente(String _nomCliente) {
        this._nomCliente = _nomCliente;
    }

    public String getApellCliente() {
        return _apellCliente;
    }

    public void setApellCliente(String _apellCliente) {
        this._apellCliente = _apellCliente;
    }

    public String getDirCliente() {
        return _dirCliente;
    }

    public void setDirCliente(String _dirCliente) {
        this._dirCliente = _dirCliente;
    }

    public String getFechaCliente() {
        return _fechaCliente;
    }

    public void setFechaCliente(String _fechaCliente) {
        this._fechaCliente = _fechaCliente;
    }

    public String getTelefCliente() {
        return _telefCliente;
    }

    public void setTelefCliente(String _telefCliente) {
        this._telefCliente = _telefCliente;
    }

    public String getEmailCliente() {
        return _emailCliente;
    }

    public void setEmailCliente(String _emailCliente) {
        this._emailCliente = _emailCliente;
    }

}
