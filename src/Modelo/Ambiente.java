/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * id_ambiente
 * nombre_ambiente
 */
public class Ambiente {
    
    private int id_ambiente;
    private String nombre_ambiente;

    public Ambiente(int id_ambiente, String nombre_ambiente) {
        this.id_ambiente = id_ambiente;
        this.nombre_ambiente = nombre_ambiente;
    }

    public Ambiente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_ambiente() {
        return id_ambiente;
    }

    public void setId_ambiente(int id_ambiente) {
        this.id_ambiente = id_ambiente;
    }

    public String getNombre_ambiente() {
        return nombre_ambiente;
    }

    public void setNombre_ambiente(String nombre_ambiente) throws Exception
    {
        if(nombre_ambiente.trim().length()!=0)
        {
            this.nombre_ambiente = nombre_ambiente;
        }
        else
        {
            throw new Exception ("El nombre del ambiente no puede estar vacío");
        }
    }
    
}
