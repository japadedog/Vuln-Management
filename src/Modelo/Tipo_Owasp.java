/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * idtipo_owasp / owasp_tipo
 */
public class Tipo_Owasp {
    
    private int idtipo_owasp;
    private String owasp_tipo;

    public Tipo_Owasp(int idtipo_owasp, String owasp_tipo) {
        this.idtipo_owasp = idtipo_owasp;
        this.owasp_tipo = owasp_tipo;
    }

    public int getIdtipo_owasp() {
        return idtipo_owasp;
    }

    public void setIdtipo_owasp(int idtipo_owasp) throws Exception
    {
        if (idtipo_owasp !=0)
        {
            this.idtipo_owasp = idtipo_owasp;
        }
        else
        {
            throw new Exception ("El id no puede estar vacío");
        }
        
    }

    public String getOwasp_tipo() {
        return owasp_tipo;
    }

    public void setOwasp_tipo(String owasp_tipo) throws Exception
    {
        if(owasp_tipo.trim().length()!= 0)
        {
            this.owasp_tipo = owasp_tipo;    
        }
        else
        {
            throw new Exception ("El tipo de owasp no puede estar vacío");
        }
        
    }
        
}
