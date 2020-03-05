<%-- 
    Document   : BuscarDocumento
    Created on : 20 feb. 2020, 15:48:03
    Author     : japa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>busquedas</title>
    </head>
    <body>
        
         <form action="SMostarDoc" method="POST">
            buscar por id del documento <input type="number" name="id_documento" value="" /><br/>
           
            <br>
            <center>
            <input type="submit" value="Buscar" name="mostrar" class="btn btn-primary"  role="button"/>
            </center>
        </form>
        Busqueda por Fechas
        <form action="SBuscarFechas" method="POST">
            fecha inicio<input type="text" name="fecha_entrega1" value="" />
            fecha fin<input type="text" name="fecha_entrega2" value="" />
            <br>
            <center>
            <input type="submit" value="Buscar" name="mostrar" class="btn btn-primary"  role="button"/>
            </center>
        </form>
        Busqueda por Nombre
        <form action="SBuscarNombre" method="POST">
            NOMBRE DOCUMENTO<input type="text" name="nombre_documento" value="" />
            <br>
            <center>
            <input type="submit" value="Buscar" name="mostrar" class="btn btn-primary"  role="button"/>
            </center>
        </form>
        <br>
        Buscar por Pentester
        <form action="SBuscarPorUsuario" method="POST">
            NOMBRE PENTESTE<input type="text" name="nombre_usuario" value="" />
            <br>
            <center>
            <input type="submit" value="Buscar" name="mostrar" class="btn btn-primary"  role="button"/>
            </center>
        </form>
         <br>
       
        <br>
        <center><a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>
    <!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
    <form action="Logout" method="POST">
        <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
    </form>

        
        
       
        
        
    </body>
</html>
