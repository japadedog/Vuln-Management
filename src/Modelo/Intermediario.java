/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author japa
 */
public class Intermediario {
 
    private int id_documento;
    private int id_vulnerabilidad;

    public Intermediario(int id_documento, int id_vulnerabilidad) {
        this.id_documento = id_documento;
        this.id_vulnerabilidad = id_vulnerabilidad;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public int getId_vulnerabilidad() {
        return id_vulnerabilidad;
    }

    public void setId_vulnerabilidad(int id_vulnerabilidad) {
        this.id_vulnerabilidad = id_vulnerabilidad;
    }
    
    
}
