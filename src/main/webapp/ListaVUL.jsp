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
                    <th>ID del Docuemnto</th>
                    <th>NOMBRE</th>
                    <th>Path Documento</th>
                    <th>Version Documento</th>
                    <th>hash_md5</th>
                    <th>hash_sha1</th>
                    <th>hash_sha256</th>
                    <th>Documento Relacionado</th>
                    <th>Fecha Entrega</th>
                    <th>Nro Sprint </th>
                    <th>Nombre Sprint </th>
                    <th>Estado Documento </th>
                    <th>Alcance	 </th>
                    <th>Conclusion </th>
                    <th>Personal Encargado</th>
                    <th>Id Del Proyecto </th>
                    <th>Celula </th>
                    <th>Usuario</th>
                    <th>Origen </th>
                    <th>Revision </th>
                </tr> 

                <%
                    String app = (String) request.getSession().getAttribute("doc");

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
                            rs = sta.executeQuery("select D.id_documento, D.nombre_documento, D.path_documento, D.version_documento, D.hash_md5, D.hash_sha1, D.hash_sha256, D.documento_relacionado, D.fecha_entrega, D.nro_sprint, D.nombre_sprint, D.estado_documento, D.alcance, D.conclusion, P.nombre_persona, PRO.nombre_proyecto, C.nombre_celula, U.nombre_usuario, O.nombre_origen, R.nombre_revision from documento D join persona P on D.id_persona = P.id_persona join proyecto PRO on D.id_idea = PRO.id_idea join celula C on D.id_celula = C.id_celula join usuario U on D.id_usuario = U.id_usuario join origen O on D.id_origen = O.id_origen join revision R on D.id_revision = R.id_revision where id_documento ='" + app + "'");
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
                    <th><a href="Descargar.jsp?id_documento=<%=rs.getString(1)%>">Excel</a></th>
                    <th><a href="SDescargarExcel1?id_documento=<%=rs.getString(1)%>">Word</a></th>
                    
                </tr>        

                <%
                            }
                            // sta.close();
                            //rs.close();
                            //con.close();

                        } catch (Exception e) {

                        }
                        con.close();
                    }
                %>    

            </thead>

        </table>

        <table border="1">

            <thead>
                <tr bgcolor="skyblue">
                    <th>ID Documento</th>
                    <th>ID Vulnerabilidad</th>
                    <th>Nombre de la Vulnerabilidad</th>
                    <th>URL del Servicio</th>
                    <th>Descripcion</th>
                    <th>Impacto Vulnerabilidad</th>
                    <th>Recomendaciones</th>
                    <th>Estado de la Mitigacion</th>
                    <th>Fecha Mitigacion</th>
                    <th>cvss</th>
                    <th>Fecha Propuesta</th>
                    <th>Pasos</th>
                    <th>Path</th>
                    <th>Num Incidente</th>
                    <th>Usuario</th>
                    <th>Categoria</th>
                    <th>OWASP_2017</th>
                    <th>Criticidad</th>
                    <th>Tratamiento de Riesgo</th>
                    <th>CWE</th>
                    <th>Aplicacion</th>
                    <th>Ambiente</th>
                    <th>Empresa</th>


                </tr> 

                <%
                    String c = (String) request.getSession().getAttribute("doc");

                    Connection con1 = null;
                    Statement sta1 = null;

                    ResultSet r = null;

                    if (session1.getAttribute("usu") == null) {

                        response.sendRedirect("login.jsp");
                    } else {

                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            con1 = DriverManager.getConnection("jdbc:mysql://localhost/backlog?user=root&password=");
                            //inicio statement             
                            sta1 = con1.createStatement();
                            //ejecuto el select
                            r = sta1.executeQuery("select I.id_documento, V.id_vulnerabilidad, V.nombre_vulnerabilidad, V.url_servicio, V.descripcion_vulnerabilidad, V.impacto_vulnerabilidad, V.recomendaciones_vulnerabilidad, V.id_estado_mitigacion, V.fecha_mitigacion, V.cvss, V.fecha_propuesta, V.pasos, V.path_poc, V.num_incidente, U.nombre_usuario, C.nombre_categoria, O.titulo_owasp, CR.nombre_criticidad, T.nombre_estado, CW.nombre_cwe, A.nombre_aplicacion, AM.nombre_ambiente, E.nombre_empresa from intermediario I join vulnerabilidad V on I.id_vulnerabilidad = V.id_vulnerabilidad join usuario U on V.id_usuario = U.id_usuario join categoria C on V.id_categoria = C.id_categoria join owasp O on V.id_owasp_2017 = O.id_owasp_2017 join criticidad CR on V.id_criticidad = CR.id_criticidad join tratamiento_riesgo T on V.id_tratamiento_riesgo = T.id_tratamiento_riesgo join cwe CW on V.id_cwe = CW.id_cwe join aplicacion A on V.id_aplicacion = A.id_aplicacion join ambiente AM on V.id_ambiente = AM.id_ambiente join empresa E on V.id_empresa = E.id_empresa where I.id_documento ='" + c + "'");
                            //resultado del select se guarda en resultset
                            while (r.next()) { //paso fila por fila y muestro el resultado en tabla


                %>
                <tr>
                    <th><%=r.getString(1)%></th>
                    <th><%=r.getString(2)%></th>
                    <th><%=r.getString(3)%></th>
                    <th><%=r.getString(4)%></th>
                    <th><%=r.getString(5)%></th>
                    <th><%=r.getString(6)%></th>
                    <th><%=r.getString(7)%></th>
                    <th><%=r.getString(8)%></th>
                    <th><%=r.getString(9)%></th>
                    <th><%=r.getString(10)%></th>
                    <th><%=r.getString(11)%></th>
                    <th><%=r.getString(12)%></th>
                    <th><%=r.getString(13)%></th>
                    <th><%=r.getString(14)%></th>
                    <th><%=r.getString(15)%></th>
                    <th><%=r.getString(16)%></th>
                    <th><%=r.getString(17)%></th>
                    <th><%=r.getString(18)%></th>
                    <th><%=r.getString(19)%></th>
                    <th><%=r.getString(20)%></th>
                    <th><%=r.getString(21)%></th>
                    <th><%=r.getString(22)%></th>
                    <th><%=r.getString(23)%></th>
                    

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
    
    <!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
    <form action="Logout" method="POST">
        <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
    </form>

    <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
</body>
</html>
