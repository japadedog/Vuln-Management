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
        <% 
            HttpSession session1 = request.getSession();
            
            if(session1.getAttribute("usu") == null){
            
                response.sendRedirect("login.jsp");
            }
            
        %>
    <center><h1>Actualizar registro cliente</h1></center>
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
                        rs=sta.executeQuery("select*from usuario where id_usuario='"+ID_USARIO+"'");
                        //resultado del select se guarda en resultset
                        while(rs.next()){ //paso fila por fila y muestro el resultado en tabla
                            
        
    %>
     <!--
    <br>
        <!-- formulario 
        <form action="Actualizar" method="POST" readonly="readonly" style="background-color: lavender">
            <input type="text" name="ID_USARIO" value="" />ID_USARIO<br/>
            <input type="text" name="NOMBRE" value="" />NOMBRE<br/>
            <input type="text" name="PASSWORD" value="" />PASSWORD<br/>
            <input type="text" name="TOKEN_CSRT" value="" />TOKEN_CSRT<br/>
            <input type="text" name="ULTIMA_CONEXION" value="" />ULTIMA_CONEXION<br/>
            <input type="text" name="CORREO" value="" />CORREO<br/>
            <input type="text" name="ID_TIPO_USUARIO" value="" />ID_TIPO_USUARIO<br/>
          
            <br>
            <center>
            <input type="submit" value="Actualizar" name="Actualizar" class="btn btn-primary"  role="button"/>
            </center>
        </form>
    <br>
        --> 
         <br>
        <form action="Actualizar" method="POST" align="center" style="background-color: lavender">
          
            <label for="ID_USARIO">ID_USARIO</label>
            <input type="text" name="ID_USARIO" readonly="readonly"  value="<%=rs.getString(1)%>" /><br/>
            
           <label for="NOMBRE">NOMBRE</label>
            <input type="text" name="NOMBRE" value="<%=rs.getString(2)%>" /><br/>
            
            <label for="PASSWORD">PASSWORD</label>
            <input type="text" name="PASSWORD" value="<%=rs.getString(3)%>" /><br/>
            
            <label for="TOKEN_CSRT">TOKEN_CSRT</label>
            <input type="text" name="TOKEN_CSRT" value="<%=rs.getString(4)%>" /><br/>
            
            <label for="ULTIMA_CONEXION">ULTIMA_CONEXION</label>
            <input type="text" name="ULTIMA_CONEXION" value="<%=rs.getString(5)%>" /><br/>
            
            <label for="CORREO">CORREO</label>
            <input type="text" name="CORREO" value="<%=rs.getString(6)%>" /><br/>
            
            <label for="ID_TIPO_USUARIO">ID_TIPO_USUARIO</label>
            <input type="text" name="ID_TIPO_USUARIO" value="<%=rs.getString(7)%>" /><br/>            
            <br>
            <center>
            <input type="submit" value="Actualizar" name="Actualizar" class="btn btn-primary"  role="button"/><br/>
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
              <!-- footer -->
            <img src="imagenes/futter.jpg">
<%-- Bootstrap --%>            
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

            
        
    </body>
</html>