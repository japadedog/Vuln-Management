
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%-- CODIGO BOOTSTRAP--%>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
 
        <title>Bienvenido a tu Perfil de Administrador</title>
        
        <%-- BARRA DE MENÚ --%>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Bienvenido ! </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp"> Home <span class="sr-only">(current)</span></a>
                </li>
            <li class="nav-item">
                    <a class="nav-link" href="#">Panel Usuarios</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Panel Vulnerabilidades</a>
            </li>

        </div>
      </li>
    </ul>
  </div>
</nav>
       
                  <!--header-->
                <img src="imagenes/login.jpg">   
    
    <%--  FIN DE NAVBAR --%>
    
    <BR>
        
    </head>
    <body>
        
        <% 
            HttpSession session1 = request.getSession();
            
            if(session1.getAttribute("usu") == null){
            
                response.sendRedirect("login.jsp");
            }
            
        %>
        
    <center><h1>Bienvenido al Panel!</h1></center>
        <center><h5>En esta sección cuentas con ver o crear vulnerabilidades.</h5></center>
        <br>
        <br>
        <center><a class="btn btn-primary" href="ListaPropia.jsp" role="button">Ver Documentos</a>
        <br>
        <br>
        <a class="btn btn-primary" href="FormularioDocumentacion.jsp" role="button">Crear Vulerabilidades</a>
        <br> </center>

        <form action="Logout" method="POST">
            <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
        </form>

<%-- Bootstrap --%>            
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
            
                
<br>
<br>
<br>

              <!-- footer -->
            <img src="imagenes/futter.jpg">
        
    </body>
    
  
    
</html>