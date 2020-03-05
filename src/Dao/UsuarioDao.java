/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Usuario;

/**
 *
 * @author VAIO
 */
public class UsuarioDao {

    private static final String sql_insert = "INSERT INTO usuario(id_usuario, nombre_usuario, password, token_csrf, ultima_conexion, correo_electronico, TIPO_USUARIO_id_tipo_usuario) VALUES (?,?,?,?,?,?,?)";
    private static final String sql_delete = "DELETE FROM usuario WHERE id_usuario=?";
    private static final String sql_delete2 = "UPDATE usuario SET TIPO_USUARIO_id_tipo_usuario=? WHERE id_usuario= ?";
    private static final String sql_update = "UPDATE usuario SET nombre_usuario=?, password=?, token_csrf=?, ultima_conexion=?, correo_electronico=?, TIPO_USUARIO_id_tipo_usuario=? WHERE id_usuario= ?";
    private static final String sql_update1 = "UPDATE usuario SET ultima_conexion=? WHERE nombre_usuario= ?";
    private static final String sql_read = "SELECT * FROM usuario WHERE id_usuario= ?";
    private static final String sql_readAll = "SELECT * FROM usuario";
    private static final String sql_read2 = "SELECT * FROM usuario WHERE nombre_usuario= ? and password= ? ";
    private static final String sql_tipo = "SELECT TIPO_USUARIO_id_tipo_usuario FROM usuario WHERE nombre_usuario= ? and password= ? ";

    private static final Conexion con = Conexion.estadoConexion();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Mutates Crude  
    public boolean create(Usuario cli) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_insert);
            ps.setInt(1, cli.getId_usuario());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getPassword());
            ps.setString(4, cli.getToken_csrf());
            ps.setString(5, cli.getUltima_conexion());
            ps.setString(6, cli.getCorreo_electronico());
            ps.setInt(7, cli.getId_tipo_usuario());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    public boolean delete(int id_usuario) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_delete);
            ps.setInt(1, id_usuario);
            if (ps.executeUpdate() > 1) {
                if (ps.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }
    public boolean delete2(int id_usuario) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_delete2);
            ps.setInt(1, 4);
            ps.setInt(2, id_usuario);
            if (ps.executeUpdate() > 1) {
                if (ps.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    public boolean update(Usuario cli) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_update);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getPassword());
            ps.setString(3, cli.getToken_csrf());
            ps.setString(4, cli.getUltima_conexion());
            ps.setString(5, cli.getCorreo_electronico());
            ps.setInt(6, cli.getId_tipo_usuario());
            
            ps.setInt(7, cli.getId_usuario());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }
     public boolean update1(String todayAsString ,String nombre) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_update1);
            
            ps.setString(1, todayAsString);
            ps.setString(2, nombre);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

//hacer de esta manera lo de rellenar con el id documento pa las vulnerabilidades (nose)
    public Usuario read(int id_usuario) {
        PreparedStatement ps;
        ResultSet rs;
        Usuario clie = null;
        try {
            ps = con.getCon().prepareStatement(sql_read);
            ps.setInt(1, id_usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                clie = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
            return clie;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return clie;
    }
    

    

    public List<Usuario> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            ps = con.getCon().prepareStatement(sql_readAll);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return usuarios;
    }

    public boolean autenticacion(String nombre, String password) {
        PreparedStatement ps;
        ResultSet rs;
        try {

            ps = con.getCon().prepareStatement(sql_read2);
            ps.setString(1, nombre);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    //combobox
    
    
    public ResultSet consultarLista(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM tipo_usuario");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
    
    } public Usuario tipo_usu(String nombre, String password) {
        PreparedStatement ps;
        ResultSet rs;
        Usuario clie = null;
        try {
            ps = con.getCon().prepareStatement(sql_read2);
            ps.setString(1, nombre);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()) {
                clie = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
            return clie;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return clie;
    }
    
    
}

            
        
       