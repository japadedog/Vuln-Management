<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<!-- agregar pal cmbox -->


<!DOCTYPE html>
<html lang="en" xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Documentación | Inside Security</title>
        
        <!-- BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!--header-->
                <img src="imagenes/formulariodocumentos.jpg">         

    </head>
    
    
    <body>
        <% 
            HttpSession session1 = request.getSession();
            
            if(session1.getAttribute("usu") == null){
            
                response.sendRedirect("login.jsp");
            }
            
        %>


    <center><h1>Formulario Documentacion</h1></center>

        <!-- formulario -->
        
        <form action="SAgregarDocumento" method="POST" style="background-color: lavender">
           
           <input type="text" name="nombre_documento" value="" />Nombre del Documento *<br/>                                                                       </lu> 
            <input type="text" name="path_documento" value="" />Path del Documento *<br/>
            <input type="number" name="version_documento" value="" />Version Documento *<br/>
            <input type="text" name="hash_md5" value="" />hash_md5 *<br/>
            <input type="text" name="hash_sha1" value="" />hash_sha1 *<br/>
            <input type="text" name="hash_sha256" value="" />hash_sha256 *<br/>
            <input type="text" name="documento_relacionado" value="" />Documentación Relacionado <br/>
            <input type="text" name="fecha_entrega" placeholder="YYYY-MM-DD" required pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" title="Enter a date in this format YYYY-MM-DD">Fecha Entrega* (yyyy-mm-dd)<br>
            <input type="number" name="nro_sprint" value="" />Nro del Sprint <br/>
            <input type="text" name="nombre_sprint" value="" />Nombre del Sprint <br/>
            <input type="text" name="estado_documento" value="false" readonly="readonly"/>Estado Documento* <br/>
            <input type="text" name="alcance" value="" />Alcance* <br/>
          
  
            <script language="javascript" type="text/javascript">
                function getData() {
                   var textarea = document.getElementsByName("conclusion");
                   alert(textarea[0].value);
                }
            </script>
           
               <textarea  name="conclusion" class="siva"></textarea>
               <a href="javascript:getData()"></a>Conclusion*
               <br>
            
            
            <!-- cajitas combobox -->
            Persona Encargada :   
            <jsp:useBean id="id_persona" scope="page" class="Dao.DocumentoDao"/>
            <% ResultSet rt = id_persona.consultarListaPersona(); %>
            <select name="id_persona">
                <option>
                    Seleccione su opcion (persona?) </option> 

                    <%
                    while(rt.next()){
                        
                    %>
                    
                <option  value="<%=rt.getString("id_persona") %>" > <%=rt.getString("nombre_persona") %> </option> 
                    <%
                      }
                    %>
                                
            </select>
                    
                    <br>
            Seleccione el Proyecto:     
            <jsp:useBean id="id_idea" scope="page" class="Dao.DocumentoDao" />
            <% ResultSet rp = id_idea.consultarListaProyecto(); %>
            <select name="id_idea">
                <option>
                    Seleccione el proyecto </option> 

                    <%
                    while(rp.next()){
                        
                    %>
                    
                <option  value="<%=rp.getString("id_idea") %>" > <%=rp.getString("nombre_proyecto") %> </option> 
                    <%
                      }
                    %>
                                
            </select>
            
            <br>
             Seleccione la Celula:       
            <jsp:useBean id="id_celula" scope="page" class="Dao.DocumentoDao" />
            <% ResultSet rc = id_celula.consultarListaCelula(); %>
            <select name="id_celula">
                <option>
                    Seleccione la Celula </option> 

                    <%
                    while(rc.next()){
                        
                    %>
                    
                <option  value="<%=rc.getString("id_celula") %>" > <%=rc.getString("nombre_celula") %> </option> 
                    <%
                      }
                    %>
                               
            </select>
            <br>
            Seleccione el Origen:             
            <jsp:useBean id="id_origen" scope="page" class="Dao.DocumentoDao" />
            <% ResultSet ro = id_origen.consultarListaOrigen(); %>
            <select name="id_origen">
                <option>
                    Seleccione origen </option> 

                    <%
                    while(ro.next()){
                        
                    %>
                    
                <option  value="<%=ro.getString("id_origen") %>" > <%=ro.getString("nombre_origen") %> </option> 
                    <%
                      }
                    %>
                                
            </select>
                    
                    <br>
            Seleccione la Revision:
            <jsp:useBean id="id_revision" scope="page" class="Dao.DocumentoDao" />
            <% ResultSet rr = id_revision.consultarListaRevision(); %>
            <select name="id_revision">
                <option>
                    Seleccione la revision </option> 

                    <%
                    while(rr.next()){
                        
                    %>
                    
                <option  value="<%=rr.getString("id_revision") %>" > <%=rr.getString("nombre_revision") %> </option> 
                    <%
                      }
                    %>
                                
            </select>
                       
            <br>
            
            <!-- boton -->
            <center>
                <a href="FormularioVulnerabilidades.jsp"><input type="submit" value="Agregar Vulnerabilidad" name="FormularioVulnerabilidades" class="btn btn-primary"  role="button"/></a>
            </center>
        </form>
    
                    <!-- boton -->
                    <br>
                   
            <center><a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>
        <br>
        
         <!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
         <a href="historial.jsp"><button type="button">historial de documentos</button></a>
    
    <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
    
        
        
        
         <!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
         <form action="Logout" method="POST">
            <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
        </form>
    
    <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
    
                <!-- footer -->
            <img src="imagenes/futter.jpg">
    </body>
</html>