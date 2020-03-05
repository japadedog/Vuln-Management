/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * id_owasp_2017
 * titulo_owasp
 * hereda tipo_owasp
 * 
 */
public class Owasp {
    
    private int id_owasp_2017;
    private String titulo_owasp;
    private Tipo_Owasp tipo_owasp;

    public Owasp(int id_owasp_2017, String titulo_owasp, Tipo_Owasp tipo_owasp) {
        this.id_owasp_2017 = id_owasp_2017;
        this.titulo_owasp = titulo_owasp;
        this.tipo_owasp = tipo_owasp;
    }

    public Owasp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_owasp_2017() {
        return id_owasp_2017;
    }

    public void setId_owasp_2017(int id_owasp_2017) throws Exception
    {
        if(id_owasp_2017 != 0)
        {
           this.id_owasp_2017 = id_owasp_2017;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
    }

    public String getTitulo_owasp() {
        return titulo_owasp;
    }

    public void setTitulo_owasp(String titulo_owasp) throws Exception
    {
        if(titulo_owasp.trim().length()!= 0)
        {
            this.titulo_owasp = titulo_owasp;
        }
        else
        {
            throw new Exception ("El título no puede estar vacío");
        }
    }

    public Tipo_Owasp getTipo_owasp() {
        return tipo_owasp;
    }

    public void setTipo_owasp(Tipo_Owasp tipo_owasp) {
        this.tipo_owasp = tipo_owasp;
    }
    
    
    
    
}
