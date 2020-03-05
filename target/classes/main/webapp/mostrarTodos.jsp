<%@page import="java.sql.*"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios | Inside Security </title>
    </head>
    <body>
        <h1>Mostrar todos los usuarios registrados</h1>
 
                <table border="1">

            <thead>
                <tr bgcolor="skyblue">
                    <th>ID_Uusuario</th>
                    <th>NOMBRE</th>
                    <th>PASSWORD</th>
                    <th>TOKEN_CSRF</th>
                    <th>ULTIMA CONEXION</th>
                    <th>CORREO</th>
                    <th>TIPO</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                     </tr>  
                    <%
                    
            HttpSession session1 = request.getSession();
            
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
                        rs=sta.executeQuery("select*from usuario");
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
                    <th><a href="Actualizar.jsp?ID_Usuario=<%=rs.getString(1)%>"></a>Editar</th>
                    <th><a href="eliminar.jsp?ID_Usuario=<%=rs.getString(1)%>"></a>Eliminar</th>
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