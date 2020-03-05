/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 id_aplicacion
 * nombre_aplicacion
 * tech_lider_app
 * pais_app
 * gerencia_responsable
 * criticidad
 */
public class Aplicacion {
    
    private int id_aplicacion;
    private String nombre_aplicacion;
    private String tech_lider_app;
    private String pais_app;
    private String gerencia_responsable;
    private String criticidad;

    public Aplicacion(int id_aplicacion, String nombre_aplicacion, String tech_lider_app, String pais_app, String gerencia_responsable, String criticidad) {
        this.id_aplicacion = id_aplicacion;
        this.nombre_aplicacion = nombre_aplicacion;
        this.tech_lider_app = tech_lider_app;
        this.pais_app = pais_app;
        this.gerencia_responsable = gerencia_responsable;
        this.criticidad = criticidad;
    }

    public Aplicacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_aplicacion() {
        return id_aplicacion;
    }

    public void setId_aplicacion(int id_aplicacion) throws Exception
    {
        if(id_aplicacion !=0)
        {
            this.id_aplicacion = id_aplicacion;
        }
        else
        {
            throw new Exception("El id no puede estar vacío");
        }
    }

    public String getNombre_aplicacion() {
        return nombre_aplicacion;
    }

    public void setNombre_aplicacion(String nombre_aplicacion) throws Exception
    {
        if(nombre_aplicacion.trim().length()!=0)
        {
            this.nombre_aplicacion = nombre_aplicacion;
        }
        else
        {
            throw new Exception ("El nombre de la aplicación no puede estar vacío");
        }
    }

    public String getTech_lider_app() {
        return tech_lider_app;
    }

    public void setTech_lider_app(String tech_lider_app) {
        this.tech_lider_app = tech_lider_app;
    }

    public String getPais_app() {
        return pais_app;
    }

    public void setPais_app(String pais_app) {
        this.pais_app = pais_app;
    }

    public String getGerencia_responsable() {
        return gerencia_responsable;
    }

    public void setGerencia_responsable(String gerencia_responsable) {
        this.gerencia_responsable = gerencia_responsable;
    }

    public String getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(String criticidad) throws Exception
    {
        if(criticidad.trim().length()!=0)
        {
            this.criticidad = criticidad;
        }
        else
        {
            throw new Exception ("La criticidad no puede estar vacía");
        }
        
    }
    
    
    
}
