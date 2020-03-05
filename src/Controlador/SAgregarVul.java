package Controlador;

import Conexion.Conexion;
import Conexion.sql;
import Dao.IntermediarioDao;
import Dao.VulnerabilidadDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Vulnerabilidad;
import javax.servlet.http.HttpSession;
import Modelo.*;

/**
 *
 * @author japa
 */
public class SAgregarVul extends HttpServlet {

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
            
            
            
            
           //----------------------------------------------------------------------------------- 
           
           //zona del ajax para que funcione en las vista de buscar usuario (no se por que solo funciona en este servlet)
           
           Conexion cn = new Conexion();
           String cad=request.getParameter("q");
           try{
            cn.getCon();
            String sql="select * from aplicacion where nombre_aplicacion like '"+cad+"%';";
            cn.st=cn.getCon().createStatement();
            cn.rt=cn.st.executeQuery(sql);
            int i=1;
            while (cn.rt.next()){
                if ((i%2)!=0){
                out.println("<tr bgcolor='#00FF00'><td>"+cn.rt.getString(1)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(2)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(3)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(4)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(5)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(6)+"</td><td>"+" - "+"</td>");
                }else{
                out.println("<tr><td>"+cn.rt.getString(1)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(2)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(3)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(4)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(5)+"</td><td>"+" - "+"</td><td>"+cn.rt.getString(6)+"</td><td>"+" - "+"</td>");
                }
                out.println("<td>"+"//"+"</td></tr>");
                i++;
            }
            }catch(Exception e){
            out.print(e.toString());
            }
            
            
            

            
            //-----------------------------------------------------------------------------
            
            //zona del formulario
            int IDDOC = 0;
                try {
                    IDDOC = (int) request.getSession().getAttribute("IDDOC"); 
                } catch (Exception e) {
                    IDDOC = Integer.parseInt(request.getParameter("id_documento"));
                    
                    
                    
                }
            //int IDDOC = (int) request.getSession().getAttribute("IDDOC");//para extraer y usar la id del documento relacionado 
            String nombre_vulnerabilidad = request.getParameter("nombre_vulnerabilidad");
            String url_servicio = request.getParameter("url_servicio");
            String descripcion_vulnerabilidad = request.getParameter("descripcion_vulnerabilidad");
            String impacto_vulnerabilidad = request.getParameter("impacto_vulnerabilidad");
            String recomendaciones_vulnerabilidad = request.getParameter("recomendaciones_vulnerabilidad");
            String id_estado_mitigacion = request.getParameter("id_estado_mitigacion");
            String fecha_mitigacion = request.getParameter("fecha_mitigacion");
            String cvss = request.getParameter("cvss");
            String fecha_propuesta = request.getParameter("fecha_propuesta");
            String pasos = request.getParameter("pasos");
            String path_poc = request.getParameter("path_poc");
            String num_incidente = request.getParameter("num_incidente");
            String cwe = request.getParameter("id_cwe");
            String owasp = request.getParameter("id_owasp_2017");
            String criticidad = request.getParameter("id_criticidad");
            String ambiente = request.getParameter("id_ambiente");
            String tratamiento_riesgo = request.getParameter("id_tratamiento_riesgo");
            Usuario id_usuario = (Usuario) request.getSession().getAttribute("tipo");
            String empresa = request.getParameter("id_empresa");
            String aplicacion = request.getParameter("id_aplicacion");
            String id_categoria = request.getParameter("id_categoria");
            
            String error = "";
            
            if(nombre_vulnerabilidad.equals("") || nombre_vulnerabilidad == null || descripcion_vulnerabilidad.equals("") || descripcion_vulnerabilidad == null || id_estado_mitigacion.equals("") ||id_estado_mitigacion == null || fecha_mitigacion.equals("") ||fecha_mitigacion== null || cvss.equals("") ||cvss == null || fecha_propuesta.equals("") ||fecha_propuesta == null || pasos.equals("") || pasos == null || path_poc.equals("")|| path_poc == null || num_incidente.equals("")|| num_incidente == null){
                error = "El campos es obligatorio";
                request.getSession().setAttribute("mensaje", error);
                response.sendRedirect("error.jsp");
            } else {
                
                //consulta sql pa id incrementable:
                sql s = new sql();
                //implementando clase 
                int Id = s.id_incrementableV();
                
                //variables para cambiar tipos 
                int id_estado = 0;
                int cwe1 = 0;
                int owasp1 = 0;
                int criticidad1 = 0;
                int ambiente1 = 0 ;
                int tratamiento_riesgo1 = 0;
                int usuario1 = 0;
                int empresa1 = 0;
                int aplicacion1 = 0;
                int categoria1 = 0;
                int num_incid1 = 0;
        
                    // cambio de String a int
                    id_estado = Integer.parseInt(id_estado_mitigacion);
                    cwe1 = Integer.parseInt(cwe);
                    owasp1 = Integer.parseInt(owasp);
                    criticidad1= Integer.parseInt(criticidad);
                    ambiente1= Integer.parseInt(ambiente);
                    tratamiento_riesgo1=Integer.parseInt(tratamiento_riesgo);
                    empresa1= Integer.parseInt(empresa);
                    aplicacion1= Integer.parseInt(aplicacion);
                    categoria1= Integer.parseInt(id_categoria);

                    
                    Vulnerabilidad vul = new Vulnerabilidad(Id, nombre_vulnerabilidad, url_servicio, descripcion_vulnerabilidad,impacto_vulnerabilidad ,recomendaciones_vulnerabilidad, id_estado,fecha_mitigacion , cvss, fecha_propuesta, pasos, path_poc, num_incidente,id_usuario.getId_usuario(),categoria1,owasp1,criticidad1,tratamiento_riesgo1,cwe1,aplicacion1,ambiente1,empresa1); //crea clase vulnerabilidad                   
                    Intermediario in = new Intermediario(IDDOC, Id);//crea clase intermediario
                    vulnerabilidadDao.create(vul);//guarda clase
                    intermediarioDao.create(in);//guarda clase
                    request.getSession().setAttribute("IDDOC",IDDOC); //para reutiliar la id documento
                    response.sendRedirect("FormularioVulnerabilidades.jsp");//recarga la pagina para usar
                    
                    
                
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
