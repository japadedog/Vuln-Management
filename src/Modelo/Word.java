package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Word {


    public static void GeneralArchivo() throws Exception{

    	 String filepath = "C:\\Users\\japa\\Desktop\\Doc.docx";
         String outpath = "C:\\Users\\japa\\Desktop\\DocDeSalida.docx";
         String outFileName = randomString().toString();

         String path = "C:\\Users\\japa\\Desktop\\"+outFileName+".docx";
         

         XWPFDocument doc = new XWPFDocument(new FileInputStream(filepath));
         for (XWPFParagraph p : doc.getParagraphs()){

             int numberOfRuns = p.getRuns().size();

             // Collate text of all runs
             StringBuilder sb = new StringBuilder();
             for (XWPFRun r : p.getRuns()){
                 int pos = r.getTextPosition();
                 if(r.getText(pos) != null) {
                     sb.append(r.getText(pos));
                 }
             }
             
             //
             
             int c = 10;
         

             Connection con=null;
             Statement sta=null;
             ResultSet rsV=null;
             ResultSet rsD=null;
             
             
             Class.forName("com.mysql.jdbc.Driver");
             con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/backlog?user=root&password=");
             //inicio statement             
             sta=(Statement) con.createStatement();
             //ejecuto el select
             //rsV=sta.executeQuery("select I.id_documento, V.id_vulnerabilidad, V.nombre_vulnerabilidad, V.url_servicio, V.descripcion_vulnerabilidad, V.impacto_vulnerabilidad, V.recomendaciones_vulnerabilidad, V.id_estado_mitigacion, V.fecha_mitigacion, V.cvss, V.fecha_propuesta, V.pasos, V.path_poc, V.num_incidente, U.nombre_usuario, C.nombre_categoria, O.titulo_owasp, CR.nombre_criticidad, T.nombre_estado, CW.nombre_cwe, A.nombre_aplicacion, AM.nombre_ambiente, E.nombre_empresa from intermediario I join vulnerabilidad V on I.id_vulnerabilidad = V.id_vulnerabilidad join usuario U on V.id_usuario = U.id_usuario join categoria C on V.id_categoria = C.id_categoria join owasp O on V.id_owasp_2017 = O.id_owasp_2017 join criticidad CR on V.id_criticidad = CR.id_criticidad join tratamiento_riesgo T on V.id_tratamiento_riesgo = T.id_tratamiento_riesgo join cwe CW on V.id_cwe = CW.id_cwe join aplicacion A on V.id_aplicacion = A.id_aplicacion join ambiente AM on V.id_ambiente = AM.id_ambiente join empresa E on V.id_empresa = E.id_empresa where I.id_documento ='"+c+"'");
             rsD=sta.executeQuery("select D.id_documento, D.nombre_documento, D.path_documento, D.version_documento, D.hash_md5, D.hash_sha1, D.hash_sha256, D.documento_relacionado, D.fecha_entrega, D.nro_sprint, D.nombre_sprint, D.estado_documento, D.alcance, D.conclusion, P.nombre_persona, PRO.nombre_proyecto, C.nombre_celula, U.nombre_usuario, O.nombre_origen, R.nombre_revision from documento D join persona P on D.id_persona = P.id_persona join proyecto PRO on D.id_idea = PRO.id_idea join celula C on D.id_celula = C.id_celula join usuario U on D.id_usuario = U.id_usuario join origen O on D.id_origen = O.id_origen join revision R on D.id_revision = R.id_revision where D.id_documento = '"+c+"'");
             //resultado del select se guarda en resultset
             
             

             // Continue if there is text and contains "test"
             if(sb.length() > 0 && sb.toString().contains("Automata15454lkjhgfdrtyujkl52")) {
                 // Remove all existing runs
                 for(int i = 0; i < numberOfRuns; i++) {
                     p.removeRun(i);
                 }
                 String text = sb.toString().replaceAll("Automata15454lkjhgfdrtyujkl52", rsD.getString(1));
                 // Add new run with updated text
                 XWPFRun run = p.createRun();
                 run.setText(text);
                 p.addRun(run);
             }
         }
        doc.write(new FileOutputStream(outpath));
        doc.close();
		
     }
    
    
    
    
    public static String randomString()throws Exception {
    	
    	 String algorithm = "HmacSHA256";
    	    KeyGenerator kg = KeyGenerator.getInstance(algorithm);
    	    SecretKey key = kg.generateKey();
    	    Mac mac = Mac.getInstance(algorithm);
    	    mac.init(key);
    	    String message = "This is the message";
    	    byte[] tag = mac.doFinal(message.getBytes());
    	    String encodedTag = javax.xml.bind.DatatypeConverter.printBase64Binary(tag);
    	
    	return encodedTag;
    }
	
}
