package Dao;
import java.sql.PreparedStatement;
import Conexion.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Intermediario;


/**
 *
 * @author japa
 */
public class IntermediarioDao {
    
    private static final String sql_insert = "INSERT INTO intermediario(id_documento,id_vulnerabilidad) VALUES (?,?)";
    private static final Conexion con = Conexion.estadoConexion();
    
    //funcion para guardar datos en intermediario(tabla)
    public boolean create(Intermediario in) {
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(sql_insert);
            ps.setInt(1, in.getId_documento());
            ps.setInt(2, in.getId_vulnerabilidad());
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
    

}
