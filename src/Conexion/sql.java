package Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rocío del Mar Mágica
 */
public class sql {
    
    //clase para crear un id incrementable:
    
    public int id_incrementable(){
        int id = 1; //lo igualamos a 1
        
        //vamos a hacer una consulta en la bdd pa obtener el último ID
        PreparedStatement ps = null;
        ResultSet rs = null;//para recorrer
        //tambien tenemos que importar toda la clase que vamos a necesitar
        //obtener conexion
        Conexion db = new  Conexion();
        
        try {
            ps = db.getCon().prepareStatement("SELECT MAX(id_usuario) FROM usuario "); //consulta pa buscar el id maximo
            //esta consulta nos da el id máximo, le sumamos 1 para que el id sea incrementable
            rs = ps.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1) + 1; //sumar +1
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error"+ex.getMessage());
        }
        finally
        {
            try {
                ps.close();
                rs.close();
                db.cerrarConexion();
            }
            catch (Exception ex)
            {
                
            }
        }
        return id;
        
    }
    
    //incrementable vulnerabilidades:
    
    public int id_incrementableV(){
        int id = 1; //lo igualamos a 1
        
        //vamos a hacer una consulta en la bdd pa obtener el último ID
        PreparedStatement ps = null;
        ResultSet rs = null;//para recorrer
        //tambien tenemos que importar toda la clase que vamos a necesitar
        //obtener conexion
        Conexion db = new  Conexion();
        
        try {
            ps = db.getCon().prepareStatement("SELECT MAX(id_vulnerabilidad) FROM vulnerabilidad "); //consulta pa buscar el id maximo
            //esta consulta nos da el id máximo, le sumamos 1 para que el id sea incrementable
            rs = ps.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1) + 1; //sumar +1
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error"+ex.getMessage());
        }
        finally
        {
            try {
                ps.close();
                rs.close();
                db.cerrarConexion();
            }
            catch (Exception ex)
            {
                
            }
        }
        return id;
        
    }
public int id_incrementableD(){
        int id = 1; //lo igualamos a 1
        
        //vamos a hacer una consulta en la bdd pa obtener el último ID
        PreparedStatement ps = null;
        ResultSet rs = null;//para recorrer
        //tambien tenemos que importar toda la clase que vamos a necesitar
        //obtener conexion
        Conexion db = new  Conexion();
        
        try {
            ps = db.getCon().prepareStatement("SELECT MAX(id_documento) FROM documento "); //consulta pa buscar el id maximo
            //esta consulta nos da el id máximo, le sumamos 1 para que el id sea incrementable
            rs = ps.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1) + 1; //sumar +1
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error"+ex.getMessage());
        }
        finally
        {
            try {
                ps.close();
                rs.close();
                db.cerrarConexion();
            }
            catch (Exception ex)
            {
                
            }
        }
        return id;
        
    }    
    
}
