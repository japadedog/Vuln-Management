/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * Documento documento
 * Vulnerabilidad vulnerabilidad
 */
public class Intermedio {
    
    private Vulnerabilidad vulnerabilidad;
    private Documento documento;

    public Intermedio(Vulnerabilidad vulnerabilidad, Documento documento) {
        this.vulnerabilidad = vulnerabilidad;
        this.documento = documento;
    }

    public Vulnerabilidad getVulnerabilidad() {
        return vulnerabilidad;
    }

    public void setVulnerabilidad(Vulnerabilidad vulnerabilidad) {
        this.vulnerabilidad = vulnerabilidad;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
     
}
