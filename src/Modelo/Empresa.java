/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * id_empresa
 * nombre_empresa
 * 
 */
public class Empresa {
    
    private int id_empresa;
    private String nombre_empresa;

    public Empresa(int id_empresa, String nombre_empresa) {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
    }

    public Empresa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) throws Exception
    {
        if(id_empresa !=0){
            this.id_empresa = id_empresa;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) throws Exception
    {
        if(nombre_empresa.trim().length() !=0)
        {
            this.nombre_empresa = nombre_empresa;
        }
        else
        {
            throw new Exception ("El nombre de la empresa no puede estar vacío");
        }
    }
    
    
    
}
