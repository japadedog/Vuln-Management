package Controlador;

import Dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Modelo.Usuario;

/**
 *
 * @author VAIO
 */
public class SActualizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
        UsuarioDao usuarioDao;
        

    public void init() {

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
                
            }else
            {

            
            //aqui se tomas los datos del formulario
            String ID_USARIO = request.getParameter("ID_USARIO");
            String NOMBRE = request.getParameter("NOMBRE");
            String PASSWORD = request.getParameter("PASSWORD");
            String TOKEN_CSRT = request.getParameter("TOKEN_CSRT");
            String ULTIMA_CONEXION = request.getParameter("ULTIMA_CONEXION");
            String CORREO = request.getParameter("CORREO");
            String ID_TIPO_USUARIO = request.getParameter("ID_TIPO_USUARIO");
            String error = "";
            // metodo para validar que no este vacio
            if (NOMBRE.equals("") || NOMBRE == null) {
                error = "El campos es obligatorio";
                request.getSession().setAttribute("mensaje", error);
                response.sendRedirect("error.jsp");
            } else {
                int Id = 0;//variable para hacer el cambio de string a int
                int tipo = 0;//variable para hacer el cambio de string a int
                try {
                    Id = Integer.parseInt(ID_USARIO);//cambio de valor 
                    tipo = Integer.parseInt(ID_TIPO_USUARIO);//cambio de valor
                    Usuario c = new Usuario(Id, NOMBRE, PASSWORD, TOKEN_CSRT, ULTIMA_CONEXION, CORREO, tipo);
                    usuarioDao.update(c);//se realiza la accion
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
