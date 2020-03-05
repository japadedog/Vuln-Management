/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * id_cwe
 * nombre_cwe
 * descripcion_cwe
 * nro_cwe 
 */
public class Cwe {
    
    private int id_cwe;
    private String nombre_cwe;
    private String descripcion_cwe;
    private int nro_cwe;

    public Cwe(int id_cwe, String nombre_cwe, String descripcion_cwe, int nro_cwe) {
        this.id_cwe = id_cwe;
        this.nombre_cwe = nombre_cwe;
        this.descripcion_cwe = descripcion_cwe;
        this.nro_cwe = nro_cwe;
    }

    public Cwe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getId_cwe() {
        return id_cwe;
    }

    public void setId_cwe(int id_cwe) throws Exception
    {
        if(id_cwe !=0)
        {
            this.id_cwe = id_cwe;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
    }

    public String getNombre_cwe() {
        return nombre_cwe;
    }

    public void setNombre_cwe(String nombre_cwe) throws Exception
    {
        if(nombre_cwe.trim().length()!=0)
        {
            this.nombre_cwe = nombre_cwe;
        }
        else
        {
            throw new Exception ("El nombre del CWE no puede estar vacío");
        }
    }

    public String getDescripcion_cwe() {
        return descripcion_cwe;
    }

    public void setDescripcion_cwe(String descripcion_cwe) {
        this.descripcion_cwe = descripcion_cwe;
    }

    public int getNro_cwe() {
        return nro_cwe;
    }

    public void setNro_cwe(int nro_cwe)  throws Exception
    {
        if(nro_cwe !=0)
        {
            this.nro_cwe = nro_cwe;
        }
        else
        {
            throw new Exception("El número no puede estar vacío");
        }
    }
    
}
