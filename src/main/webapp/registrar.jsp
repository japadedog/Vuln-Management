<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        
        
        <title>Registrar Usuario</title>
    </head>
    <body>
        <img src="imagenes/registrarusuario.jpg">
        
        <% 
            HttpSession session1 = request.getSession();
            
            if(session1.getAttribute("usu") == null){
            
                response.sendRedirect("login.jsp");
            }
            
        %>
        
    <center><h1>Rellena el formulario para ingresar un nuevo usuario</h1></center>
    <br>

    <!-- modifique action con nuevo servlet--> 
        <form action="registrar" method="POST" style="background-color: lavender">
            
            
            <input type="text" name="NOMBRE" value=""style="background-color: lightblue" />     NOMBRE<br/>
            <input type="text" name="PASSWORD" value="" style="background-color: lightblue" />      PASSWORD<br/>
            <input type="text" name="TOKEN_CSRF" value="" style="background-color: lightblue"/>     TOKEN_CSRF<br/>
            <input type="text" name="ULTIMA_CONEXION" value="" style="background-color: lightblue"/>     ULTIMA CONEXION<br/>
            <input type="text" name="CORREO" value="" style="background-color: lightblue"/>     CORREO ELECTRONICO<br/>
            <!-- este debe ser combobox -->
            
            <jsp:useBean id="id_tipo_usuario" scope="page" class="Dao.UsuarioDao" />
            <% ResultSet rt = id_tipo_usuario.consultarLista(); %>
            <select name="id_tipo_usuario">
                <option>
                    Seleccione su opcion </option> 

                    <%
                    while(rt.next()){
                        
                    %>
                    
                <option  value="<%=rt.getString("id_tipo_usuario") %>" > <%=rt.getString("descripcion") %> </option> 
                    <%
                      }
                    %>
                                
            </select>
            <input type="submit" value="registrar" name="registrar" />  <!-- class="btn btn-primary"  role="button"/> -->
        <br>
        
    
        </form>
    
        <br>
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