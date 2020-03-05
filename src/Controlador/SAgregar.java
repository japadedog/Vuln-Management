package Controlador;


import Conexion.sql;
import Dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;
import Controlador.SAgregar;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VAIO
 */
public class SAgregar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs ClienteDao
     */
    UsuarioDao usuarioDao;

    public void init() {
    String pass =getServletContext().getInitParameter("jdbcPassword");

        usuarioDao = new UsuarioDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String usu = (String) session.getAttribute("usu");
            
            if (usu == null){
            response.sendRedirect("login.jsp"); 
                
            }else{
                
            
            //aqui se tomas los datos del formulario
            String NOMBRE = request.getParameter("NOMBRE");
            String PASSWORD = request.getParameter("PASSWORD");
            String TOKEN_CSRF = request.getParameter("TOKEN_CSRF");
            String ULTIMA_CONEXION = request.getParameter("ULTIMA_CONEXION");
            String CORREO = request.getParameter("CORREO");
            String ID_TIPO_USUARIO = request.getParameter("id_tipo_usuario");
            
            String error = "";
            
            //evitar error null
            if (NOMBRE.equals("") || NOMBRE == null) {
                error = "El campos es obligatorio";
                request.getSession().setAttribute("mensaje", error);
                response.sendRedirect("error.jsp");
            } else {
                
                //consulta sql id incrementable:
                sql s = new sql();
                //implementando clase 
                int Id = s.id_incrementable();
                int TIPO = 0;
                try {
                    
                    TIPO = Integer.parseInt(ID_TIPO_USUARIO); //cambio valor
                    Usuario u = new Usuario(Id, NOMBRE, PASSWORD, TOKEN_CSRF, ULTIMA_CONEXION, CORREO, TIPO);
                    usuarioDao.create(u); 
                    response.sendRedirect("principal.jsp");
                } catch (NumberFormatException e) {
                    error = "este campo es de tipo numerio" + e.getMessage();
                    request.getSession().setAttribute("mensaje", error);
                    response.sendRedirect("error.jsp");
                } catch (Exception ex) {
                    error = "error:" + ex.getMessage();
                    request.getSession().setAttribute("mensaje", error);
                    response.sendRedirect("error.jsp");
                }
            }
        }
      }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
