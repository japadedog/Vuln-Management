/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Rocío del Mar Mágica
 id_proyecto
 * id_idea
 * nombre_proyecto
 * jefe_proyecto
 * subgerente
 * ano_proyecto
 */
public class Proyecto {
    
    private int id_proyecto;
    private int id_idea;
    private String nombre_proyecto;
    private String jefe_proyecto;
    private String subgerente;
    private Date ano_proyecto;

    public Proyecto(int id_proyecto, int id_idea, String nombre_proyecto, String jefe_proyecto, String subgerente, Date ano_proyecto) {
        this.id_proyecto = id_proyecto;
        this.id_idea = id_idea;
        this.nombre_proyecto = nombre_proyecto;
        this.jefe_proyecto = jefe_proyecto;
        this.subgerente = subgerente;
        this.ano_proyecto = ano_proyecto;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) throws Exception
    {
        if(id_proyecto !=0)
        {
            this.id_proyecto = id_proyecto;
        }
        else
        {
            throw new Exception("El id no puede estar vacío");
        }
    }

    public int getId_idea() {
        return id_idea;
    }

    public void setId_idea(int id_idea) throws Exception
    {
        if(id_idea !=0)
        {
            this.id_idea = id_idea;
        }
        else
        {
            throw new Exception("El id no puede estar vacío");
        }
        
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) throws Exception
    {
        if(nombre_proyecto.trim().length()!=0)
        {
            this.nombre_proyecto = nombre_proyecto;
        }
        else
        {
            throw new Exception("El nombre del proyecto no puede estar vacío");
        }
    }

    public String getJefe_proyecto() {
        return jefe_proyecto;
    }

    public void setJefe_proyecto(String jefe_proyecto) throws Exception
    {
        if(jefe_proyecto.trim().length()!=0)
        {
            this.jefe_proyecto = jefe_proyecto;
        }
        else
        {
            throw new Exception("El jefe del proyecto no puede estar vacío");
        }
    }

    public String getSubgerente() {
        return subgerente;
    }

    public void setSubgerente(String subgerente) throws Exception
    {
        if(subgerente.trim().length()!=0)
        {
            this.subgerente = subgerente;
        }
        else
        {
            throw new Exception("El subgerente del proyecto no puede estar vacío");
        }
    }

    public Date getAno_proyecto() {
        return ano_proyecto;
    }

    public void setAno_proyecto(Date ano_proyecto) {
        this.ano_proyecto = ano_proyecto;
    }
    
    
    
}
