/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author VAIO
 */
public class Cliente {

    int ID_CLIENTE;
    String NOMBRE;
    String RUT;
    String APELLIDO;
    String DIRECCION;
    String COMUNA;
    String EMAIL;
    String FECHA_NAC;
    String PASS;

    public Cliente() {
    }

//    public Cliente(String NOMBRE, String PASS) {
//        this.NOMBRE = NOMBRE;
//        this.PASS = PASS;
//    }

    public Cliente(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public Cliente(int ID_CLIENTE, String NOMBRE, String RUT, String APELLIDO, String DIRECCION, String COMUNA, String EMAIL, String FECHA_NAC, String PASS) {
        this.ID_CLIENTE = ID_CLIENTE;
        this.NOMBRE = NOMBRE;
        this.RUT = RUT;
        this.APELLIDO = APELLIDO;
        this.DIRECCION = DIRECCION;
        this.COMUNA = COMUNA;
        this.EMAIL = EMAIL;
        this.FECHA_NAC = FECHA_NAC;
        this.PASS = PASS;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getCOMUNA() {
        return COMUNA;
    }

    public void setCOMUNA(String COMUNA) {
        this.COMUNA = COMUNA;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getFECHA_NAC() {
        return FECHA_NAC;
    }

    public void setFECHA_NAC(String FECHA_NAC) {
        this.FECHA_NAC = FECHA_NAC;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

}
