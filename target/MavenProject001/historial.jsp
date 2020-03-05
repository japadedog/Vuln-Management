<%-- 
    Document   : historial
    Created on : 19 feb. 2020, 11:06:26
    Author     : japa
--%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Historial del usuario: ${nom}</h1>
 
                <table border="1">

            <thead>
                <tr bgcolor="skyblue">
                    <th>ID del docuemnto</th>
                    <th>NOMBRE</th>
                    <th>path documento</th>
                    <th>version_documento</th>
                    <th>hash_md5</th>
                    <th>hash_sha1</th>
                    <th>hash_sha256</th>
                    <th>documento_relacionado</th>
                    <th>fecha_entrega</th>
                    <th>nro_sprint </th>
                    <th>nombre_sprint </th>
                    <th>estado_documento </th>
                    <th>alcance	 </th>
                    <th>conclusion </th>
                    <th>id_persona </th>
                    <th>id_idea </th>
                    <th>id_celula </th>
                    <th>id_usuario</th>
                    <th>id_origen </th>
                    <th>id_revision </th>
                    </tr>  
            <%        
            HttpSession session1 = request.getSession();
            Usuario id_usuario = (Usuario) request.getSession().getAttribute("tipo");
            String  nom = id_usuario.getNombre();
            int nose = id_usuario.getId_usuario();
            
            if(session1.getAttribute("usu") == null){
            
                response.sendRedirect("login.jsp");
            }
            else{
                    Connection con=null;
                    Statement sta=null;
                    ResultSet rs=null;
                    
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/backlog?user=root&password=");
                        //inicio statement             
                        sta=con.createStatement();
                        //ejecuto el select
                        rs=sta.executeQuery("select * from documento where id_usuario ='"+nose+"'");
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
                    <th><a href="FormularioVulnerabilidades.jsp?id_documento=<%=rs.getString(1)%>"></a>retomar</th>
                </tr>                            
                      <%       
                        }
               sta.close();
              rs.close();
               con.close();

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
