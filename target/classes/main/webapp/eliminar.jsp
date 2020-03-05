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
                
        <title>Eliminar Usuarios</title>
        
        <!--header-->
                <img src="imagenes/eliminarusuarios.jpg">        
        
    </head>
    <body>
        <% 
            HttpSession session1 = request.getSession();
            
            if(session1.getAttribute("usu") == null){
            
                response.sendRedirect("login.jsp");
            }
            
        %>
    <center><h1>Eliminar Usuarios</h1></center>
        <%
       String ID_USARIO=request.getParameter("ID_Usuario");
       
                  
                    Connection con=null;
                    Statement sta=null;
                    ResultSet rs=null;
                    
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/backlog?user=root&password=");
                        //inicio statement             
                        sta=con.createStatement();
                        //ejecuto el select
                        rs=sta.executeQuery("select * from usuario where id_usuario ='"+ID_USARIO+"'");
                        //resultado del select se guarda en resultset
                        while(rs.next()){ //paso fila por fila y muestro el resultado en tabla
                            
        
        %>
    
    
    
        <form action="Eliminar" method="POST">
            <br>
            <center>ID_USUARIO <input type="text" name="ID_USUARIO" readonly="readonly" value="<%=rs.getString(1)%>" /><br/></center>
            <br>
            <center><input type="submit" value="Eliminar" name="Eliminar" /></center>
        </form>
    
            <br>
            <center><a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>
        <br>
        <%       
                        }
              // sta.close();
               //rs.close();
               //con.close();

                    }catch(Exception e){
                        
                    }

                         %>
        
        
        
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    
            <!-- footer -->
            <img src="imagenes/futter.jpg">
        
    

<%-- Bootstrap --%>            
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


    </body>
</html>