
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.*"%>
<%@page import="org.apache.poi.xwpf.usermodel.XWPFDocument" %>
<%@page import="org.apache.poi.xwpf.usermodel.XWPFRun" %>
<%@page import="org.apache.poi.xwpf.usermodel.XWPFParagraph" %>

<%@page import="org.apache.poi.ss.usermodel.Workbook" %>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook" %>
<%@page import="org.apache.poi.ss.usermodel.Sheet" %>
<%@page import="org.apache.poi.ss.util.WorkbookUtil" %>
<%@page import="org.apache.poi.ss.usermodel.Row" %>
<%@page import="org.apache.poi.ss.usermodel.Cell" %>
<%@page import="org.apache.poi.ss.usermodel.CellStyle" %>
<%@page import="org.apache.poi.ss.usermodel.FillPatternType" %>
<%@page import="org.apache.poi.ss.usermodel.IndexedColors" %>
<%@page import="java.sql.*"%>
<%@page import="Modelo.*"  %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREACION DE ARCHIVOS WORD Y EXCEL</title>
    </head>
    <body>
        
        <%
        
            
            %>
            
            <br/><br/>
            
            <%
            //CREAR ARCHIVO EXCEL
            
            Workbook libro = new HSSFWorkbook();
            
            Sheet sheet = libro.createSheet();
            
            CellStyle style = libro.createCellStyle();
            style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            
            
            Row row0 = sheet.createRow(0);
            Cell celda = row0.createCell(0);
            Cell celda2 = row0.createCell(1);
            Cell celda3 = row0.createCell(2);
            Cell celda4 = row0.createCell(3);
            Cell celda5 = row0.createCell(4);
            Cell celda6 = row0.createCell(5);
            Cell celda7 = row0.createCell(6);
            Cell celda8 = row0.createCell(7);
            Cell celda9 = row0.createCell(8);
            Cell celda10 = row0.createCell(9);
            Cell celda11 = row0.createCell(10);
            Cell celda12 = row0.createCell(11);
            Cell celda13 = row0.createCell(12);
            Cell celda14 = row0.createCell(13);
            Cell celda15 = row0.createCell(14);
            Cell celda16 = row0.createCell(15);
            Cell celda17 = row0.createCell(16);
            Cell celda18 = row0.createCell(17);
            Cell celda19 = row0.createCell(18);
            Cell celda20 = row0.createCell(19);
            Cell celda21 = row0.createCell(20);
            Cell celda22 = row0.createCell(21);
            Cell celda23 = row0.createCell(22);
            
            
            
            
                                 celda.setCellValue("ID documento");
                                 celda.setCellStyle(style);
                                 celda2.setCellValue("ID vulnerabilidad");
                                 celda2.setCellStyle(style);
                                 celda3.setCellValue("Nombre vulnerabilidad");
                                 celda3.setCellStyle(style);
                                 celda4.setCellValue("url servicio");
                                 celda4.setCellStyle(style);
                                 celda5.setCellValue("Descripcion ");
                                 celda5.setCellStyle(style);
                                 celda6.setCellValue("Impacto");
                                 celda6.setCellStyle(style);
                                 celda7.setCellValue("Recomendaciones");
                                 celda7.setCellStyle(style);
                                 celda8.setCellValue("Estado Mitigacion");
                                 celda8.setCellStyle(style);
                                 celda9.setCellValue("Fecha Mitigacion");
                                 celda9.setCellStyle(style);
                                 celda10.setCellValue("Cvss");
                                 celda10.setCellStyle(style);
                                 celda11.setCellValue("Fecha_propuesta");
                                 celda11.setCellStyle(style);
                                 celda12.setCellValue("Pasos");
                                 celda12.setCellStyle(style);
                                 celda13.setCellValue("Path_poc");
                                 celda13.setCellStyle(style);
                                 celda14.setCellValue("Num_incidente");
                                 celda14.setCellStyle(style);
                                 celda15.setCellValue("Usuario");
                                 celda15.setCellStyle(style);
                                 celda16.setCellValue("Categoria");
                                 celda16.setCellStyle(style);
                                 celda17.setCellValue("Owasp_2017");
                                 celda17.setCellStyle(style);
                                 celda18.setCellValue("Criticidad");
                                 celda18.setCellStyle(style);
                                 celda19.setCellValue("Tratamiento_riesgo");
                                 celda19.setCellStyle(style);
                                 celda20.setCellValue("Cwe");
                                 celda20.setCellStyle(style);
                                 celda21.setCellValue("Aplicacion");
                                 celda21.setCellStyle(style);
                                 celda22.setCellValue("Ambiente");
                                 celda22.setCellStyle(style);
                                 celda23.setCellValue("Empresa");
                                 celda23.setCellStyle(style);
            
         	String id_documento = request.getParameter("id_documento");
            int c = 0;
            c = Integer.parseInt(id_documento);
            int rowNon = 1;
            Row row = sheet.createRow(rowNon++);
            int  cellnum = 1;
            Cell cell = row.createCell(cellnum++);
            
               
                          
                            Connection con=null;
                            Statement sta=null;
                            ResultSet rs=null;
                           
                            
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/backlog?user=root&password=");
                                //inicio statement             
                                sta=(Statement) con.createStatement();
                                //ejecuto el select
                                //esta llama solo las vulnerabilidades del doc
                                //rs=sta.executeQuery("select I.id_documento, V.id_vulnerabilidad, V.nombre_vulnerabilidad, V.url_servicio, V.descripcion_vulnerabilidad, V.impacto_vulnerabilidad, V.recomendaciones_vulnerabilidad, V.id_estado_mitigacion, V.fecha_mitigacion, V.cvss, V.fecha_propuesta, V.pasos, V.path_poc, V.num_incidente, U.nombre_usuario, C.nombre_categoria, O.titulo_owasp, CR.nombre_criticidad, T.nombre_estado, CW.nombre_cwe, A.nombre_aplicacion, AM.nombre_ambiente, E.nombre_empresa from intermediario I join vulnerabilidad V on I.id_vulnerabilidad = V.id_vulnerabilidad join usuario U on V.id_usuario = U.id_usuario join categoria C on V.id_categoria = C.id_categoria join owasp O on V.id_owasp_2017 = O.id_owasp_2017 join criticidad CR on V.id_criticidad = CR.id_criticidad join tratamiento_riesgo T on V.id_tratamiento_riesgo = T.id_tratamiento_riesgo join cwe CW on V.id_cwe = CW.id_cwe join aplicacion A on V.id_aplicacion = A.id_aplicacion join ambiente AM on V.id_ambiente = AM.id_ambiente join empresa E on V.id_empresa = E.id_empresa where I.id_documento ='"+c+"'");
                                //esta llama todo los datos 
                                rs=sta.executeQuery("select D.id_documento,V.id_vulnerabilidad, V.nombre_vulnerabilidad, V.url_servicio, V.descripcion_vulnerabilidad, V.impacto_vulnerabilidad, V.recomendaciones_vulnerabilidad, V.id_estado_mitigacion, V.fecha_mitigacion, V.cvss, V.fecha_propuesta, V.pasos, V.path_poc, V.num_incidente, U.nombre_usuario, Ca.nombre_categoria, Ow.titulo_owasp, CR.nombre_criticidad, T.nombre_estado, CW.nombre_cwe, A.nombre_aplicacion, AM.nombre_ambiente, E.nombre_empresa, D.id_documento, D.nombre_documento, D.path_documento, D.version_documento, D.hash_md5, D.hash_sha1, D.hash_sha256, D.documento_relacionado, D.fecha_entrega, D.nro_sprint, D.nombre_sprint, D.estado_documento, D.alcance, D.conclusion, P.nombre_persona, PRO.nombre_proyecto, C.nombre_celula, O.nombre_origen, R.nombre_revision from documento D join persona P on D.id_persona = P.id_persona join proyecto PRO on D.id_idea = PRO.id_idea join celula C on D.id_celula = C.id_celula join usuario U on D.id_usuario = U.id_usuario join origen O on D.id_origen = O.id_origen join revision R on D.id_revision = R.id_revision join intermediario I join vulnerabilidad V on I.id_vulnerabilidad = V.id_vulnerabilidad join categoria Ca on V.id_categoria = Ca.id_categoria join owasp Ow on V.id_owasp_2017 = Ow.id_owasp_2017 join criticidad CR on V.id_criticidad = CR.id_criticidad join tratamiento_riesgo T on V.id_tratamiento_riesgo = T.id_tratamiento_riesgo join cwe CW on V.id_cwe = CW.id_cwe join aplicacion A on V.id_aplicacion = A.id_aplicacion join ambiente AM on V.id_ambiente = AM.id_ambiente join empresa E on V.id_empresa = E.id_empresa where D.id_documento ='"+c+"'");
                                //resultado del select se guarda en resultset
                                while(rs.next()){
                                    
                                 row = sheet.createRow(rowNon++);
                                 row.createCell(0).setCellValue(rs.getString(1));
                                 row.createCell(1).setCellValue(rs.getString(2));
                                 row.createCell(2).setCellValue(rs.getString(3));
                                 row.createCell(3).setCellValue(rs.getString(4));
                                 row.createCell(4).setCellValue(rs.getString(5));
                                 row.createCell(5).setCellValue(rs.getString(6));
                                 row.createCell(6).setCellValue(rs.getString(7));
                                 row.createCell(7).setCellValue(rs.getString(8));
                                 row.createCell(8).setCellValue(rs.getString(9));
                                 row.createCell(9).setCellValue(rs.getString(10));
                                 row.createCell(10).setCellValue(rs.getString(11));
                                 row.createCell(11).setCellValue(rs.getString(12));
                                 row.createCell(12).setCellValue(rs.getString(13));
                                 row.createCell(13).setCellValue(rs.getString(14));
                                 row.createCell(14).setCellValue(rs.getString(15));
                                 row.createCell(15).setCellValue(rs.getString(16));
                                 row.createCell(16).setCellValue(rs.getString(17));
                                 row.createCell(17).setCellValue(rs.getString(18));
                                 row.createCell(18).setCellValue(rs.getString(19));
                                 row.createCell(19).setCellValue(rs.getString(20));
                                 row.createCell(20).setCellValue(rs.getString(21));
                                 row.createCell(21).setCellValue(rs.getString(22));
                                 row.createCell(22).setCellValue(rs.getString(23));
                                 
                                 row.createCell(23).setCellValue(rs.getString(24));
                                 row.createCell(24).setCellValue(rs.getString(25));
                                 row.createCell(25).setCellValue(rs.getString(26));
                                 row.createCell(26).setCellValue(rs.getString(27));
                                 row.createCell(27).setCellValue(rs.getString(28));
                                 row.createCell(28).setCellValue(rs.getString(29));
                                 row.createCell(29).setCellValue(rs.getString(30));
                                 row.createCell(30).setCellValue(rs.getString(31));
                                 row.createCell(31).setCellValue(rs.getString(32));
                                 row.createCell(32).setCellValue(rs.getString(33));
                                 row.createCell(33).setCellValue(rs.getString(34));
                                 row.createCell(34).setCellValue(rs.getString(35));
                                 row.createCell(35).setCellValue(rs.getString(36));
                                 row.createCell(36).setCellValue(rs.getString(37));
                                 row.createCell(37).setCellValue(rs.getString(38));
                                 row.createCell(38).setCellValue(rs.getString(39));
                                 row.createCell(39).setCellValue(rs.getString(40));
                                 row.createCell(40).setCellValue(rs.getString(41));
                                 row.createCell(41).setCellValue(rs.getString(42));
                                }
                            }catch(SQLException exception){
                            }
            
            try{
            	
                
                FileOutputStream file2 = new FileOutputStream("C:\\Users\\japa\\Desktop\\Excel.xls");
                libro.write(file2);
                
                file2.close();
                out.print("ARCHIVO EXCEL HA SIDO CREADO EXITOSAMENTE");
                
                
                         

                

               
                
                
            }catch(Exception e){
                out.print("Exception: "+e.getMessage());
            }
            
        %>
        
        
        
    </body>
</html>
