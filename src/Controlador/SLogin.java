/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.UsuarioDao;
import Modelo.Usuario;
import java.io.IOException;
import java.text.DateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import  java.text.SimpleDateFormat;  
import  java.util.Date;  
import javax.servlet.http.HttpSession;


/**
 *
 * @author VAIO
 */
public class SLogin extends HttpServlet {

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
        {
            //datos formulario
            String usuario = request.getParameter("NOMBRE");
            String pass = request.getParameter("PASS");
            
         
            
            String pattern = "yyyy/MM/dd";

            
            DateFormat df = new SimpleDateFormat(pattern);

            
            Date today = Calendar.getInstance().getTime();        
            
            String todayAsString = df.format(today);

            
            
            boolean ok = usuarioDao.autenticacion(usuario, pass);
            if (ok) {
                
                Usuario tipo = usuarioDao.tipo_usu(usuario, pass);
                HttpSession misession= request.getSession(true);
                misession.setAttribute("usu",usuario);
                misession.setAttribute("tipo",tipo);
                
                if(tipo.getId_tipo_usuario()== 1) {
                usuarioDao.update1(todayAsString, usuario);
                RequestDispatcher dispar = request.getRequestDispatcher("menu.jsp");
                dispar.forward(request, response);  
                } else if(tipo.getId_tipo_usuario()== 2)
                {
                usuarioDao.update1(todayAsString, usuario);
                RequestDispatcher dispar = request.getRequestDispatcher("MenuUsuario.jsp");
                dispar.forward(request, response); 
            }  else if(tipo.getId_tipo_usuario()== 4)
                {
                
                RequestDispatcher dispar = request.getRequestDispatcher("login.jsp");
                dispar.forward(request, response); 
            }  
                
                
            } else {
                RequestDispatcher dispar = request.getRequestDispatcher("login.jsp");
                dispar.forward(request, response);
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
