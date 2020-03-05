/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.IntermediarioDao;
import Dao.VulnerabilidadDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Modelo.Intermediario;

/**
 *
 * @author japa
 */
public class ServletMostrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    VulnerabilidadDao vulnerabilidadDao; 
    IntermediarioDao intermediarioDao;
    
    //para que funcione
    public void init() {
    String pass =getServletContext().getInitParameter("jdbcPassword");

        vulnerabilidadDao = new VulnerabilidadDao();
        intermediarioDao = new IntermediarioDao();
    }
    //para trabajar fechas en la base de datos 
     private static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
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
            
            int IDDOC = (int) request.getSession().getAttribute("IDDOC");//para extraer y usar la id del documento relacionado 
            String id = request.getParameter("id");
            
            int id2 = 0;
            
            id2 = Integer.parseInt(id);
            
            Intermediario in = new Intermediario(IDDOC, id2);
            intermediarioDao.create(in);
            request.getSession().setAttribute("IDDOC",IDDOC); //para reutiliar la id documento
            response.sendRedirect("FormularioVulnerabilidades.jsp");//recarga la pagina para usar
            
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
