<%@page import="Modelo.Vulnerabilidad"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>la ID DEL DOCUMETO ES: ${IDDOC}</title>
    </head>
    <body>
         <table border="1">

            <thead>
                <tr bgcolor="skyblue">
                    <th>id_vulnerabilidad</th>
                    <th>nombre_vulnerabilidad</th>
                    <th>url_servicio</th>
                    <th>descripcion_vulnerabilidad</th>
                    <th>impacto_vulnerabilidad</th>
                    <th>recomendaciones_vulnerabilidad</th>
                    <th>id_estado_mitigacion</th>
                    <th>fecha_mitigacion</th>
                    <th>cvss</th>
                    <th>fecha_propuesta</th>
                    <th>pasos</th>
                    <th>path_poc</th>
                    <th>num_incidente</th>
                    <th>id_usuario</th>
                    <th>id_categoria</th>
                    <th>id_owasp_2017</th>
                    <th>id_criticidad</th>
                    <th>id_tratamiento_riesgo</th>
                    <th>id_cwe</th>
                    <th>id_aplicacion</th>
                    <th>id_ambiente</th>
                    <th>id_empresa</th>
                    <th>AGREGAR</th>
                
                    </tr> 
       
        <%
       int app = (int)request.getSession().getAttribute("app");
      
       
                  
                    Connection con=null;
                    Statement sta=null;
                    ResultSet rs=null;
                    
            HttpSession session1 = request.getSession();
            String usuario;
            String pass;
            
            if(session1.getAttribute("usu") == null){
                    
                response.sendRedirect("login.jsp");
            }
            else{
                    
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/backlog?user=root&password=");
                        //inicio statement             
                        sta=con.createStatement();
                        //ejecuto el select
                        rs=sta.executeQuery("select*from vulnerabilidad where id_aplicacion ='"+app+"'");
                        //resultado del select se guarda en resultset
                        while(rs.next()){ //paso fila por fila y muestro el resultado en tabla
                            
        
    %>
            <tr>
                    <th><%=rs.getString(1)%></th>
                    <th><%=rs.getString(2)%></th>
                    <th><%=rs.getString(3)%></th>
                    <th><%=rs.getString(4)%></th>
                    <th><%=rs.getString(5)%></th>
                    <th><%=rs.getString(6)%></th>
                    <th><%=rs.getString(7)%></th>
                    <th><%=rs.getString(8)%></th>
                    <th><%=rs.getString(9)%></th>
                    <th><%=rs.getString(10)%></th>
                    <th><%=rs.getString(11)%></th>
                    <th><%=rs.getString(12)%></th>
                    <th><%=rs.getString(13)%></th>
                    <th><%=rs.getString(14)%></th>
                    <th><%=rs.getString(15)%></th>
                    <th><%=rs.getString(16)%></th>
                    <th><%=rs.getString(17)%></th>
                    <th><%=rs.getString(18)%></th>
                    <th><%=rs.getString(19)%></th>
                    <th><%=rs.getString(20)%></th>
                    <th><%=rs.getString(21)%></th>
                    <th><%=rs.getString(22)%></th>
                    <th><a href="FormularioVul.jsp?id_vulnerabilidad=<%=rs.getString(1)%>">ELIGIR</a></th>
                    
                </tr>        

                              <%       
                     }
              // sta.close();
               //rs.close();
               //con.close();

                    }catch(Exception e){
                        
                    }
                }
                         %>    
                            
            </thead>

        </table>
        
            <br>
                    <center><a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>
     <!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
         <form action="Logout" method="POST">
            <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
        </form>
    
    <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
    </body>
</html>
