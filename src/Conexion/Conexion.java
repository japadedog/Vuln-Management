package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

//clase para conexion con la bd

public class Conexion {
    public static Conexion instancia;
    private Connection con;
    public String db="backlog"; /*Aqui debes escribir el nombre de la bd*/
    public String usuario="root"; /*Aqui debes escribir el usuario de la bd*/
    public String clave=""; /*Aqui debes escribir el clave de la bd*/
    public static Statement st=null;
    public static ResultSet rt=null;

    public Conexion() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost/"+db,usuario,clave);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    public static Conexion estadoConexion(){
        if (instancia==null) {
            instancia=new Conexion();            
        }
        return instancia;
    }

    public  Connection getCon() {
        return con;
    }
    

    public void cerrarConexion() {
        instancia=null;
    }

}
