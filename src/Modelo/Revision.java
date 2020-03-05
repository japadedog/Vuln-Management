/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * id_revision
 * nombre_revision
 * 
 */
public class Revision {
    
    private int id_revision;
    private String nombre_revision;

    public Revision(int id_revision, String nombre_revision) {
        this.id_revision = id_revision;
        this.nombre_revision = nombre_revision;
    }

    public int getId_revision() {
        return id_revision;
    }

    public void setId_revision(int id_revision) throws Exception
    {
        if(id_revision !=0)
        {
            this.id_revision = id_revision;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
    }

    public String getNombre_revision() {
        return nombre_revision;
    }

    public void setNombre_revision(String nombre_revision) {
        this.nombre_revision = nombre_revision;
    }
    
    
    
}
