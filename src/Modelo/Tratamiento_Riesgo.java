/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * id_tratamiento
 * nombre_estado
 */
public class Tratamiento_Riesgo {
    
    private int id_tratamiento;
    private String nombre_estado;

    public Tratamiento_Riesgo(int id_tratamiento, String nombre_estado) {
        this.id_tratamiento = id_tratamiento;
        this.nombre_estado = nombre_estado;
    }

    public Tratamiento_Riesgo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) throws Exception
    {
        if(id_tratamiento !=0)
        {
            this.id_tratamiento = id_tratamiento;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
        
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) throws Exception
    {
        if(nombre_estado.trim().length()!=0)
        {
            this.nombre_estado = nombre_estado;
        }
        else
        {
            throw new Exception ("El nombre del estado no puede estar vacío");
        }
    }
    
    
    
}
