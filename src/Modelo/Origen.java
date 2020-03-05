/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * id_origen
 * nombre_origen
 * 
 */
public class Origen {
    
    private int id_origen;
    private String nombre_origen;

    public Origen(int id_origen, String nombre_origen) {
        this.id_origen = id_origen;
        this.nombre_origen = nombre_origen;
    }

    public int getId_origen() {
        return id_origen;
    }

    public void setId_origen(int id_origen) throws Exception
    {
        if(id_origen !=0)
        {
            this.id_origen = id_origen;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
        
    }

    public String getNombre_origen() {
        return nombre_origen;
    }

    public void setNombre_origen(String nombre_origen) throws Exception
    {
        if(nombre_origen.trim().length() !=0)
        {
            this.nombre_origen = nombre_origen;
        }
        else
        {
            throw new Exception ("El nombre de origen no puede estar vacío");
        }
        
    }
    
}
