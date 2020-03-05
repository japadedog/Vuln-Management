/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author japa
 */
public class Personas {
    private int id_persona;
    private String nombre_persona;
    private String correo_electronico;
    private boolean estado;
    private String cargo;
    private String subgerencia;
    private String gerencia;
    
    
    public Personas (int id_persona,String nombre_persona,String correo_electronico, boolean estado,String cargo,String subgerencia,String gerencia) throws Exception
    {
        this.id_persona = id_persona;
        setNombre_persona(nombre_persona);
        setCorreo_electronico(correo_electronico);
        this.estado = estado;
        setCargo(cargo);
        setSubgerencia(subgerencia);
        setGerencia(gerencia);       
    }
    
    public Personas()
    {
        
    }
    public int getId_persona()
    {
        return id_persona;
    }
    public String getNombre_persona()
    {
        return nombre_persona;
    }
    public String getCorreo_electronico()
    {
        return correo_electronico;
    }
    public String getEstado()
    {
        return estado ? "":"" ;
    }
    public String getCargo()
    {
        return cargo;
    }
    public String getSubgerencia()
    {
        return subgerencia;
    }
    public String getGerencia()
    {
        return gerencia;
    }
    public void setId_persona(int id_persona) throws Exception
    {
       if(id_persona != 0)
        {
            this.id_persona = id_persona;
        }
        else
        {
            throw new Exception("El la id no puede estar vacia.");
        } 
    }
    public void setNombre_persona(String nombre_persona) throws Exception
    {
        if(nombre_persona.trim().length() != 0)
        {
            this.nombre_persona = nombre_persona;
        }
        else
        {
            throw new Exception("El nombre no puede estar vacia.");
        }
    }
    public void setCorreo_electronico(String correo_electronico) throws Exception
    {
        if(correo_electronico.trim().length() != 0)
        {
            this.correo_electronico = correo_electronico;
        }
        else
        {
            throw new Exception("El correo no puede estar vacia.");
        }
    }
    public void setEstado() 
    {
            this.estado = !this.estado;
       
    }
    public void setCargo(String cargo) throws Exception
    {
        if(cargo.trim().length() != 0)
        {
            this.cargo = cargo;
        }
        else
        {
            throw new Exception("El cargo no puede estar vacia.");
        }
    }
    public void setSubgerencia(String subgerencia) throws Exception
    {
        if(subgerencia.trim().length() != 0)
        {
            this.subgerencia = subgerencia;
        }
        else
        {
            throw new Exception("El subgerencia no puede estar vacia.");
        }
    }
     public void setGerencia(String gerencia) throws Exception
    {
        if(gerencia.trim().length() != 0)
        {
            this.gerencia = gerencia;
        }
        else
        {
            throw new Exception("El gerencia no puede estar vacia.");
        }
    }




    
}
