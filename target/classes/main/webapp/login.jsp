<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="imagenes/estilo.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Backlog</title>
      
    </head>
    <body>
    <center>
        <div id="cuadro">
            <form method="POST"  action="Login">
                <p id="titulo">INICIAR SESION</p>
                <p class="card-text text-center mb-4 text-danger">Para ingresar debes estar previamente registrado</p>

                <hr>
                <br/><br/>
                <label id="subtitulo1">NOMBRE </label>
                <br/><br/>
                <input type="text" name="NOMBRE" value="" />
                <br/><br/>                
                <label id="subtitulo2">CLAVE </label>
                <br/><br/>                
                <input type="PASSWORD" name="PASS" value="" />
                <br/><br/>
                <input type="submit"  value="Iniciar Sesion" id="boton1"/>
                <br/><br/>
            </form>
        </div>   
    </center>
</body>
</html>
