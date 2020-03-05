/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 id_celula
 * nombre_celula
 * id_persona
 * 
 */
public class Celula {
    
    private int id_celula;
    private String nombre_celula;
    private int id_persona;
    private Personas personas;

    public Celula(int id_celula, String nombre_celula, int id_persona, Personas personas) {
        this.id_celula = id_celula;
        this.nombre_celula = nombre_celula;
        this.id_persona = id_persona;
        this.personas = personas;
    }

    public int getId_celula() {
        return id_celula;
    }

    public void setId_celula(int id_celula) throws Exception
    {
        if(id_celula !=0)
        {
            this.id_celula = id_celula;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
        
    }

    public String getNombre_celula() {
        return nombre_celula;
    }

    public void setNombre_celula(String nombre_celula) throws Exception
    {
        if(nombre_celula.trim().length() !=0)
        {
            this.nombre_celula = nombre_celula;
        }
        else
        {
            throw new Exception ("El nombre de la célula no puede estar vacío");
        }
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) throws Exception
    {
        if(id_persona !=0)
        {
            this.id_persona = id_persona;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }
    
    
}
