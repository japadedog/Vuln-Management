package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Dao.UsuarioDao;
import Modelo.Usuario;
import Modelo.Word;

/**
 * Servlet implementation class SDescargarExcel1
 */
public class SDescargarExcel1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	
      
                	
                	
          
        	
        
        	
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
    
    public void downloadExcel(HttpServletRequest request,HttpServletResponse response) throws IOException { 

              File file = new File("Segmentdetail.xlsx"); 

              XSSFWorkbook workbook = new XSSFWorkbook(); 
              XSSFSheet spreadsheet = workbook.createSheet("SegmentLogs Info");
              spreadsheet.setDefaultColumnWidth(20);
             
           
         
             FileOutputStream out = new FileOutputStream(file);
             workbook.write(out);
             downloadFile(file,response);
             out.close();
             workbook.close();

    }

    private void downloadFile(File file, HttpServletResponse response){

        try {         
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("content-disposition", "attachment; filename=Segmentdetail.xlsx");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            FileInputStream fin = null;
            try {
                fin = new FileInputStream(file);
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
            final int size = 1024;
            try {
                response.setContentLength(fin.available());
                final byte[] buffer = new byte[size];
                ServletOutputStream outputStream = null;

                outputStream = response.getOutputStream();
                int length = 0;
                while ((length = fin.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
                fin.close();
                outputStream.flush();
                outputStream.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }catch (final Exception ex){
            ex.printStackTrace();
    }

}
    
    
    
    

}