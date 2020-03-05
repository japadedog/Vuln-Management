package Dao;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Cliente;

/**
 * ClASE PARA COPIAR - PEGAR - MODIFICAR
 * 
 */
public class ClienteDao {

    private static final String sql_insert = "INSERT INTO CLIENTE(ID_CLIENTE, NOMBRE, RUT, APELLIDO, DIRECCION, COMUNA, EMAIL, FECHA_NAC, PASS) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String sql_delete = "DELETE FROM CLIENTE WHERE ID_CLIENTE=?";
    private static final String sql_update = "UPDATE CLIENTE SET NOMBRE= ?, RUT= ?, APELLIDO= ?, DIRECCION= ?, COMUNA= ?, EMAIL= ?, FECHA_NAC= ?, PASS= ? WHERE ID_CLIENTE= ?";
    private static final String sql_read = "SELECT * FROM CLIENTE WHERE ID_CLIENTE= ?";
    private static final String sql_readAll = "SELECT * FROM CLIENTE";
    private static final String sql_read2 = "SELECT * FROM CLIENTE WHERE NOMBRE= ? and PASS= ? ";

    private static final Conexion con = Conexion.estadoConexion();

    public boolean create(Cliente cli) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_insert);
            ps.setInt(1, cli.getID_CLIENTE());
            ps.setString(2, cli.getNOMBRE());
            ps.setString(3, cli.getRUT());
            ps.setString(4, cli.getAPELLIDO());
            ps.setString(5, cli.getDIRECCION());
            ps.setString(6, cli.getCOMUNA());
            ps.setString(7, cli.getEMAIL());
            ps.setString(8, cli.getFECHA_NAC());
            ps.setString(9, cli.getPASS());
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

    public boolean delete(int id_cliente) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_delete);
            ps.setInt(1, id_cliente);
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

    public boolean update(Cliente cli) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_update);
            ps.setString(1, cli.getNOMBRE());
            ps.setString(2, cli.getRUT());
            ps.setString(3, cli.getAPELLIDO());
            ps.setString(4, cli.getDIRECCION());
            ps.setString(5, cli.getCOMUNA());
            ps.setString(6, cli.getEMAIL());
            ps.setString(7, cli.getFECHA_NAC());
            ps.setString(8, cli.getPASS());
            ps.setInt(9, cli.getID_CLIENTE());
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

    public Cliente read(int id_cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Cliente clie = null;
        try {
            ps = con.getCon().prepareStatement(sql_read);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                clie = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
            return clie;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return clie;
    }

    public List<Cliente> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Cliente> clientes = new ArrayList();
        try{
        	ps = con.getCon().prepareStatement(sql_readAll);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return clientes;
    }

   /** public boolean autenticacion(String nombre, String pass) {
        PreparedStatement ps;
        ResultSet rs;
        try {

            ps = con.getCon().prepareStatement(sql_read2);
            ps.setString(1, nombre);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }**/
}
