<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- funcion del ajax  -->
        <script>
            function showHint1(str)
            {
                if (str.length == 0) {
                    document.getElementById("txtHint").innerHTML = "";
                    return;
                } else {
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                            document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
                        }
                    }
                    xmlhttp.open("GET", "FormularioVulnerabilidades?q=" + str, true);
                    xmlhttp.send();
                }
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!-- BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!--header-->
    <img src="imagenes/formulariovulnerabilidades.jpg">         

    <title>Formulario Vulnerabilidades | Inside Security</title>
</head>
<body>
    <%
        HttpSession session1 = request.getSession();

        if (session1.getAttribute("usu") == null) {

            response.sendRedirect("login.jsp");
        }

    %>
<center><h1>Formulario Vulnerabilidades </h1></center>
<br>

<br>
<% String id_documento = request.getParameter("id_documento");
%>  
<form action="FormularioVulnerabilidades" method="POST" style="background-color: lavender">

    <input type="hidden" name="id_documento" readonly="readonly" value="<%=id_documento%>" /><br/>
    <input type="text" name="nombre_vulnerabilidad" value=""/>NOMBRE VULNERABILIDAD *<br/>
    <input type="text" name="url_servicio" value="" />URL SERVICIO<br/>
    <script language="javascript" type="text/javascript">
        function getData() {
            var textarea = document.getElementsByName("descripcion_vulnerabilidad");
            alert(textarea[0].value);
        }
    </script>

    <textarea  name="descripcion_vulnerabilidad" class="siva"></textarea>
    <a href="javascript:getData()"></a>Descripcion Vulnerabilidad *
    <br> 
    <input type="text" name="impacto_vulnerabilidad" value="" />Impacto de la  Vulnerabilidad<br/>
    <input type="text" name="recomendaciones_vulnerabilidad" value="" />Recomendaciones<br/>
    <select name="id_estado_mitigacion">
        <option value="0"> No Mitigado</option>
        <option value="1"> Mitigado</option>
    </select> Mitigacion
    <br>
    <input type="text" name="fecha_mitigacion" placeholder="YYYY-MM-DD" required pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" title="Enter a date in this format YYYY-MM-DD">Fecha Mitigacion* (yyyy-mm-dd)<br>
    <input type="text" name="cvss" value="" />cvss *<br/>
    <input type="text" name="fecha_propuesta" placeholder="YYYY-MM-DD" required pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" title="Enter a date in this format YYYY-MM-DD">Fecha Propuesta* (yyyy-mm/-dd)<br>
    <input type="text" name="pasos" value="" />Pasos* <br/>
    <input type="text" name="path_poc" value="" />Path Poc* <br/>
    <input type="text" name="num_incidente" value="" />Num Incidente* <br>

    <!-- cajitas combobox -->



  
    Seleccione Categoria:<br>
    <jsp:useBean id="id_categoria" scope="page" class="Dao.VulnerabilidadDao" />
    <% ResultSet rc = id_categoria.consultarListaCategoria(); %>
    <select name="id_categoria">
        <option>
            Seleccione Categoria </option> 

        <%
            while (rc.next()) {

        %>

        <option  value="<%=rc.getString("id_categoria")%>" > <%=rc.getString("nombre_categoria")%> </option> 
        <%
            }
        %>

    </select><br>
    Seleccione owasp_2017:<br>
    <jsp:useBean id="id_owasp_2017" scope="page" class="Dao.VulnerabilidadDao" />
    <% ResultSet rw = id_owasp_2017.consultarListaOwasp(); %>
    <select name="id_owasp_2017">
        <option>
            Seleccione owasp_2017 </option> 

        <%
            while (rw.next()) {

        %>

        <option  value="<%=rw.getString("id_owasp_2017")%>" > <%=rw.getString("titulo_owasp")%> </option> 
        <%
            }
        %>

    </select>
    <br>Seleccione Criticidad<br>
    <jsp:useBean id="id_criticidad" scope="page" class="Dao.VulnerabilidadDao" />
    <% ResultSet rcr = id_criticidad.consultarListaCriticidad(); %>
    <select name="id_criticidad">
        <option>
            Seleccione criticidad </option> 

        <%
            while (rcr.next()) {

        %>

        <option  value="<%=rcr.getString("id_criticidad")%>" > <%=rcr.getString("nombre_criticidad")%> </option> 
        <%
            }
        %>

    </select>

    <br>
    Seleccione Tratamiento Riesgo<br>
    <jsp:useBean id="id_tratamiento_riesgo" scope="page" class="Dao.VulnerabilidadDao" />
    <% ResultSet rtr = id_tratamiento_riesgo.consultarListaTratamiento_riesgo(); %>
    <select name="id_tratamiento_riesgo">
        <option>
            Seleccione tratamiento Riesgo </option> 

        <%
            while (rtr.next()) {

        %>

        <option  value="<%=rtr.getString("id_tratamiento_riesgo")%>" > <%=rtr.getString("nombre_estado")%> </option> 
        <%
            }
        %>

    </select>
    <br>
     Seleccione CWE <br>
    <jsp:useBean id="id_cwe" scope="page" class="Dao.VulnerabilidadDao" />
    <% ResultSet rcwe = id_cwe.consultarListaCwe(); %>
    <select name="id_cwe">
        <option>
            Seleccione cwe </option> 

        <%
            while (rcwe.next()) {

        %>

        <option  value="<%=rcwe.getString("id_cwe")%>" > <%=rcwe.getString("nombre_cwe")%> </option> 
        <%
            }
        %>

    </select>
    <br> Seleccione Aplicacion <br>
    <jsp:useBean id="id_aplicacion" scope="page" class="Dao.VulnerabilidadDao" />
    <% ResultSet ra = id_aplicacion.consultarListaAplicacion(); %>
    <select name="id_aplicacion">
        <option>
            Seleccione aplicacion </option> 

        <%
            while (ra.next()) {

        %>

        <option  value="<%=ra.getString("id_aplicacion")%>" > <%=ra.getString("nombre_aplicacion")%> </option> 
        <%
            }
        %>

    </select>
    <br>
 Seleccione Empresa: <br>
    <jsp:useBean id="id_empresa" scope="page" class="Dao.VulnerabilidadDao" />
    <% ResultSet rem = id_empresa.consultarListaEmpresa(); %>
    <select name="id_empresa">
        <option>
            Seleccione empresa </option> 

        <%
            while (rem.next()) {

        %>

        <option  value="<%=rem.getString("id_empresa")%>" > <%=rem.getString("nombre_empresa")%> </option> 
        <%
            }
        %>

    </select>
    <br>
    Seleccione Ambiente: <br>
    <jsp:useBean id="id_ambiente" scope="page" class="Dao.VulnerabilidadDao" />
    <% ResultSet ram = id_ambiente.consultarListaAmbiente(); %>
    <select name="id_ambiente">
        <option>
            Seleccione ambiente </option> 

        <%
            while (ram.next()) {

        %>

        <option  value="<%=ram.getString("id_ambiente")%>" > <%=ram.getString("nombre_ambiente")%> </option> 
        <%
            }
        %>

    </select>
    <br>

    <br>

    <center>
        <input type="submit" value="Agregar Vulnerabilidad" name="FormularioVulnerabilidades" class="btn btn-primary"  role="button"/>
    </center>
</form>


<!-- formuario busqueda de vulneravilidades en aplicaciones -->           
<form action="mostrar" method="POST">
    ID Aplicacion: <input type="number" name="id_aplicacion" value="" /><br/>
    <input type="hidden" name="id_documento" readonly="readonly" value="<%=id_documento%>" /><br/>

    <br>

    <center>
        <input type="submit" value="Buscar" name="mostrar" class="btn btn-primary"  role="button"/>
    </center>
</form><br>
 <center><a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver..</button></a></center>
<!--//////////////////////////////////cerra session////////////////////////////////////////////////////////////-->    
<form action="Logout" method="POST">
    <input type="submit" value="cerrar Sesion" name="??" class="btn btn-primary"  role="button"/>
</form>

<!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

<section>
    <input type="text" name="busqueda" id="txt1" onkeyup="showHint1(this.value)" placeholder="buscar aplicaciones">
</section>

<section id="txtHint">
</section>


<!-- footer -->
<img src="imagenes/futter.jpg">
</body>
</html>