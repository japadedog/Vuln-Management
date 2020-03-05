<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
               
        <!-- BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!--header-->
                <img src="imagenes/exito.jpg">     
        
        <title>Éxito | Iside Security </title>
    </head>
    <body>
        
        <center><h1>El resultado de su acción ha tenido éxito :) </h1></center>

        <center><h5> Regrese para realizar más acciones :</h5></center>
        
        

        <%
            String error = (String) request.getSession().getAttribute("mensaje");
        %>
        <h1> <%out.println(error);%></h1>
        
                <br>
        <center><a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>
        
        
        
                
              <!-- footer -->
            <img src="imagenes/futter.jpg">
        
    </body>
</html>