<%@page import="Modelo.Vulnerabilidad"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DATOS</title>
    </head>
    <body>

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
                    <th>boton </th>
                </tr> 

                <%
                    String c = (String) request.getSession().getAttribute("usu");

                    Connection con = null;
                    Statement sta = null;
                    ResultSet rs = null;

                    HttpSession session1 = request.getSession();

                    if (session1.getAttribute("usu") == null) {

                        response.sendRedirect("login.jsp");
                    } else {

                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost/backlog?user=root&password=");
                            //inicio statement             
                            sta = con.createStatement();
                            //ejecuto el select
                            rs = sta.executeQuery("select D.id_documento, D.nombre_documento, D.path_documento, D.version_documento, D.hash_md5, D.hash_sha1, D.hash_sha256, D.documento_relacionado, D.fecha_entrega, D.nro_sprint, D.nombre_sprint, D.estado_documento, D.alcance, D.conclusion, P.nombre_persona, PRO.nombre_proyecto, C.nombre_celula, U.nombre_usuario, O.nombre_origen, R.nombre_revision from documento D join persona P on D.id_persona = P.id_persona join proyecto PRO on D.id_idea = PRO.id_idea join celula C on D.id_celula = C.id_celula join usuario U on D.id_usuario = U.id_usuario join origen O on D.id_origen = O.id_origen join revision R on D.id_revision = R.id_revision where U.nombre_usuario ='" + c + "'");
                            //resultado del select se guarda en resultset
                            while (rs.next()) { //paso fila por fila y muestro el resultado en tabla


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
                    <th><a href="SMostarDoc?id_documento=<%=rs.getString(1)%>"></a>ELIGIR</th>

                </tr>        

                <%
                            }

                        } catch (Exception e) {

                        }
                    }
                %>    

            </thead>

        </table>


        <br>
    <center><a href="MenuUsuario.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>
    <!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
    <form action="Logout" method="POST">
        <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
    </form>
</body>
</html>
