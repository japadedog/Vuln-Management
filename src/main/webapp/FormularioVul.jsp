<%@page import="java.sql.*"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     
        <title>Actualizar Usuario</title>
        <!--header-->
                <img src="imagenes/actualizarusuarios.jpg">         
    </head>
   <body>
    <center><h1>Verifique Los Datos</h1></center>
    <%
         
            HttpSession session1 = request.getSession();
            
            if(session1.getAttribute("usu") == null){
            
                response.sendRedirect("login.jsp");
            }
            
        
       String id_vulnerabilidad=request.getParameter("id_vulnerabilidad");
       
                  
                    Connection con=null;
                    Statement sta=null;
                    ResultSet rs=null;
                    
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/backlog?user=root&password=");
                        //inicio statement             
                        sta=con.createStatement();
                        //ejecuto el select
                        rs=sta.executeQuery("select*from vulnerabilidad where id_vulnerabilidad='"+id_vulnerabilidad+"'");
                        //resultado del select se guarda en resultset
                        while(rs.next()){ //paso fila por fila y muestro el resultado en tabla
                            
        
    %>
         <br>
        <form action="FormularioVulnerabilidades2" method="POST" align="center" style="background-color: lavender">
          
            <label for="id_vulnerabilidad">id_vulnerabilidad</label>
            <input type="text" name="id_vulnerabilidad" readonly="readonly"  value="<%=rs.getString(1)%>" /><br/>
            
           <label for="nombre_vulnerabilidad">nombre_vulnerabilidad</label>
            <input type="text" name="nombre_vulnerabilidad"readonly="readonly" value="<%=rs.getString(2)%>" /><br/>
            
            <label for="url_servicio">url_servicio</label>
            <input type="text" name="url_servicio" readonly="readonly" value="<%=rs.getString(3)%>" /><br/>
            
            <label for="descripcion_vulnerabilidad">descripcion_vulnerabilidad</label>
            <input type="text" name="descripcion_vulnerabilidad" readonly="readonly" value="<%=rs.getString(4)%>" /><br/>
            
            <label for="impacto_vulnerabilidad">impacto_vulnerabilidad</label>
            <input type="text" name="impacto_vulnerabilidad" readonly="readonly" value="<%=rs.getString(5)%>" /><br/>
            
            <label for="recomendaciones_vulnerabilidad">recomendaciones_vulnerabilidad</label>
            <input type="text" name="recomendaciones_vulnerabilidad" readonly="readonly" value="<%=rs.getString(6)%>" /><br/>
            
            <label for="id_estado_mitigacion">id_estado_mitigacion</label>
            <input type="text" name="id_estado_mitigacion" readonly="readonly" value="<%=rs.getString(7)%>" /><br/>

            <label for="fecha_mitigacion">fecha_mitigacion</label>
            <input type="text" name="fecha_mitigacion" value="" /><br/>
            
            <label for="cvss">cvss</label>
            <input type="text" name="cvss" readonly="readonly" value="<%=rs.getString(9)%>" /><br/>
            
            <label for="fecha_propuesta">fecha_propuesta (YYYY/MM/DD)</label>
            <input type="text" name="fecha_propuesta" value="<%=rs.getString(10)%>" /><br/>
            
            <label for="pasos">pasos</label>
            <input type="text" name="pasos" readonly="readonly" value="<%=rs.getString(11)%>" /><br/>
            
            <label for="path_poc">path_poc</label>
            <input type="text" name="path_poc" readonly="readonly" value="<%=rs.getString(12)%>" /><br/>
            
            <label for="num_incidente">num_incidente</label>
            <input type="text" name="num_incidente"readonly="readonly" value="<%=rs.getString(13)%>" /><br/>
            
            <label for="id_usuario">id_usuario</label>
            <input type="text" name="id_usuario"readonly="readonly" value="<%=rs.getString(14)%>" /><br/>
            
            <label for="id_categoria">id_categoria</label>
            <input type="text" name="id_categoria" readonly="readonly" value="<%=rs.getString(15)%>" /><br/>
            
            <label for="id_owasp_2017">id_owasp_2017</label>
            <input type="text" name="id_owasp_2017" readonly="readonly" value="<%=rs.getString(16)%>" /><br/>
            
            <label for="id_criticidad">id_criticidad</label>
            <input type="text" name="id_criticidad" readonly="readonly" value="<%=rs.getString(17)%>" /><br/>
            
            <label for="id_tratamiento_riesgo">id_tratamiento_riesgo</label>
            <input type="text" name="id_tratamiento_riesgo"readonly="readonly" value="<%=rs.getString(18)%>" /><br/>
            
            <label for="id_cwe">id_cwe</label>
            <input type="text" name="id_cwe" readonly="readonly" value="<%=rs.getString(19)%>" /><br/>
            
            <label for="id_aplicacion">id_aplicacion</label>
            <input type="text" name="id_aplicacion"readonly="readonly" value="<%=rs.getString(20)%>" /><br/>
            
            <label for="id_empresa">id_empresa</label>
            <input type="text" name="id_empresa"readonly="readonly" value="<%=rs.getString(21)%>" /><br/>
            
            <label for="id_ambiente">id_ambiente</label>
            <input type="text" name="id_ambiente" readonly="readonly" value="<%=rs.getString(22)%>" /><br/>
            <br>
           
            
            <center>
            <input type="submit" value="Agregar Vulnerabilidad" name="FormularioVulnerabilidades" class="btn btn-primary"  role="button"/>
            </center>
        
        </form>
    <br>
                              <%       
                        }
              // sta.close();
               //rs.close();
               //con.close();

                    }catch(Exception e){
                        
                    }

                         %>
                         
            <!-- boton -->
            <center><a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>

            <br>
            
             <!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
         <form action="Logout" method="POST">
            <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
        </form>
    
    <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
              <!-- footer -->
            <img src="imagenes/futter.jpg">
<%-- Bootstrap --%>            
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

            
        
    </body>
</html>