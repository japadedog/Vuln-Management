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
        <!--header-->
                <img src="imagenes/buscarusuarios.jpg">         
            
        
                <title>Buscar Usuario</title>
    </head>
    <body>
         <% 
            HttpSession session1 = request.getSession();
            
            if(session1.getAttribute("usu") == null){
            
                response.sendRedirect("login.jsp");
            }
            
        %>
        <center><h1>Buscar</h1></center>
        <br>
         <script>
        function showHint1(str)
{
if (str.length==0) { 
    document.getElementById("txtHint").innerHTML="";
    return;
} else {
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","Leer?ajax="+str,true);
    xmlhttp.send();
}    
}
        </script>
        <center>
        <section>
        <input type="text" name="busqueda" id="txt1" onkeyup="showHint1(this.value)" placeholder="buscar...">
    </section>
    
    <section id="txtHint">
        </section>
        
        </center>
        
        
        
        
        
        
        
        
        
        
        
       <!--
        <center><form action="Leer" method="POST">
            ID_Usuario <input type="text" name="ID_USARIO" value="" /><br/>
            
            <br>
            
            
            <center>
            <input type="submit" value="Buscar" name="Buscar" class="btn btn-primary"  role="button"/>
            </center>
        </form></center>
        -->
        <br>
        <br>
                <center><a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>

        <br>
        <br>
        <br>
         <!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
         <form action="Logout" method="POST">
            <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
        </form>
    
    <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
                        <br>
      
                <!-- footer -->
            <img src="imagenes/futter.jpg">      
    </body>
</html>