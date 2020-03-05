/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * id_criticidad
 * nombre_criticidad
 * kri
 */
public class Criticidad {
    
    private int id_criticidad;
    private String nombre_criticidad;
    private int kri;

    public Criticidad(int id_criticidad, String nombre_criticidad, int kri) {
        this.id_criticidad = id_criticidad;
        this.nombre_criticidad = nombre_criticidad;
        this.kri = kri;
    }

    public Criticidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_criticidad() {
        return id_criticidad;
    }

    public void setId_criticidad(int id_criticidad) throws Exception
    {
        if(id_criticidad !=0)
        {
            this.id_criticidad = id_criticidad;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
        
    }

    public String getNombre_criticidad() {
        return nombre_criticidad;
    }

    public void setNombre_criticidad(String nombre_criticidad) throws Exception 
    {
        if (nombre_criticidad.trim().length() !=0)
        {
            this.nombre_criticidad = nombre_criticidad;
        }
        else
        {
            throw new Exception ("El nombre de la criticidad no puede estar vacío");
        }
    }

    public int getKri() {
        return kri;
    }

    public void setKri(int kri) throws Exception
    {
        if(kri !=0)
        {
            this.kri = kri;
        }
        else
        {
            throw new Exception ("El kri no puede estar vacío");
        }      
    }
    
    
}
