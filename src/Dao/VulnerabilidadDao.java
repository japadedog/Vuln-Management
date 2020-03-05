/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Vulnerabilidad;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author japa
 */
public class VulnerabilidadDao {
    
    private static final String sql_insert = "INSERT INTO vulnerabilidad(id_vulnerabilidad, nombre_vulnerabilidad, url_servicio, descripcion_vulnerabilidad, impacto_vulnerabilidad, recomendaciones_vulnerabilidad, id_estado_mitigacion, fecha_mitigacion, cvss, fecha_propuesta, pasos, path_poc, num_incidente, id_usuario, id_categoria, id_owasp_2017, id_criticidad, id_tratamiento_riesgo, id_cwe, id_aplicacion, id_ambiente, id_empresa) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String sql_delete = "DELETE FROM VUlNERABILIDAD WHERE id_vulnerabilidad=?";
    private static final String sql_update = "UPDATE VUlNERABILIDAD SET nombre_vulnerabilidad=?, url_servicio=?, descripcion_vulnerabilidad=?, impacto_vulnerabilidad=?, recomendaciones_vulnerabilidad=?, id_estado_mitigacion=?, fecha_mitigacion=?, cvss,fecha_propuesta=?, pasos=?, path_poc=?, num_incidente=?, cwe=?, owasp=?, criticidad=?, ambiente=?, tratamiento_riesgo=?, usuario=?, empresa=?, aplicacion=? WHERE id_vulnerabilidad= ?";
    private static final String sql_read = "SELECT * FROM VUlNERABILIDAD WHERE id_vulnerabilidad= ?";
    private static final String sql_read2 = "SELECT * FROM vulnerabilidad WHERE id_aplicacion= ?";
    private static final String sql_readAll = "SELECT * FROM VUlNERABILIDAD";
    

    private static final Conexion con = Conexion.estadoConexion();
///// crear y guardar 
    public boolean create(Vulnerabilidad vul) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_insert);
            ps.setInt(1, vul.getId_vulnerabilidad());
            ps.setString(2, vul.getNombre_vulnerabilidad());
            ps.setString(3, vul.getUrl_servicio());
            ps.setString(4, vul.getDescripcion_vulnerabilidad());
            ps.setString(5, vul.getImpacto_vulnerabilidad());
            ps.setString(6, vul.getRecomendaciones_vulnerabilidad());
            ps.setInt(7, vul.getId_estado_mitigacion());
            ps.setString(8, vul.getFecha_mitigacion());
            ps.setString(9,vul.getCvss());
            ps.setString(10, vul.getFecha_propuesta());
            ps.setString(11, vul.getPasos());
            ps.setString(12, vul.getPath_poc());
            ps.setString(13, vul.getNum_incidente());
            ps.setInt(14, vul.getUsuario());
            ps.setInt(15, vul.getCategoria());
            ps.setInt(16, vul.getOwasp());
            ps.setInt(17, vul.getCriticidad());
            ps.setInt(18, vul.getTratamiento_riesgo());
            ps.setInt(19, vul.getCwe());
            ps.setInt(20, vul.getAplicacion());
            ps.setInt(21, vul.getAmbiente());
            ps.setInt(22, vul.getEmpresa());
            
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
    ///////// buscar y mostrar
    public Vulnerabilidad read(int id_aplicacion) {
        PreparedStatement ps;
        ResultSet rs;
        Vulnerabilidad vulnerabilidad = null;
        try {
            ps = con.getCon().prepareStatement(sql_read2);
            ps.setInt(1, id_aplicacion);
            rs = ps.executeQuery();
            while (rs.next()) {
                vulnerabilidad = new Vulnerabilidad(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12), rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getInt(16),rs.getInt(17),rs.getInt(18),rs.getInt(19),rs.getInt(20),rs.getInt(21),rs.getInt(22));
            }
            return vulnerabilidad;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return vulnerabilidad;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //    metodo para llenar los combobox 
     public ResultSet consultarListaUsuario(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM usuario");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
      public ResultSet consultarListaCategoria(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM categoria");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
      public ResultSet consultarListaOwasp(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM owasp");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
      
     public ResultSet consultarListaCriticidad(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM criticidad");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
     
     public ResultSet consultarListaTratamiento_riesgo(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM tratamiento_riesgo");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
     
     public ResultSet consultarListaCwe(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM cwe");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
     
      public ResultSet consultarListaAplicacion(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM aplicacion");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
      
      public ResultSet consultarListaEmpresa(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM empresa");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
     
      public ResultSet consultarListaAmbiente(){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM ambiente");
            rs = ps.executeQuery();
        }
        catch(SQLException e){
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
                }
        finally {
            con.cerrarConexion();
        }
        
        return rs;
     }
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      public static Vulnerabilidad read3(int id_aplicacion) {
        PreparedStatement ps;
        ResultSet rs;
        Vulnerabilidad per = null;
        try {
            ps = con.getCon().prepareStatement(sql_read2);
            ps.setInt(1, id_aplicacion);
            rs = ps.executeQuery();
            while (rs.next()) {
                per = new Vulnerabilidad(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12), rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getInt(16),rs.getInt(17),rs.getInt(18),rs.getInt(19),rs.getInt(20),rs.getInt(21),rs.getInt(22));
            }
            return per;
        } catch (SQLException ex) {
            Logger.getLogger(VulnerabilidadDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return per;
    }
    
    
    
    
}
