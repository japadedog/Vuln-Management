/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rocío del Mar Mágica
 * 
 * id_vulnerabilidad
 * nombre_vulnerabilidad
 * url_servicio
 * descripcion_vulnerabilidad
 * impacto_vulnerabilidad
 * recomendaciones_vulnerabilidad
 * id_estado_mitigacion
 * fecha_mitigacion
 * ----
 * id_cwe
 * id_owasp
 * id_categoria
 * id_criticidad
 * id_ambiente
 * id_tratamiento_riesgo
 * id_usuario
 * id_empresa
 * id_aplicacion
 * -----
 * cvss  string
 * fecha_propuesta
 * pasos LONGTEXT
 * path_poc
 * num_incidente 
 * 
 * 
 */
public class Vulnerabilidad {
    private int id_vulnerabilidad;
    private String nombre_vulnerabilidad;
    private String url_servicio;
    private String descripcion_vulnerabilidad;
    private String impacto_vulnerabilidad;
    private String recomendaciones_vulnerabilidad;
    private int id_estado_mitigacion;
    private String fecha_mitigacion;
    private String cvss;
    private String fecha_propuesta;
    private String pasos;
    private String path_poc;
    private String num_incidente;

    
    private int usuario;
    private int categoria;
    private int owasp;
    private int criticidad;
    private int tratamiento_riesgo;
    private int cwe;
    private int aplicacion;
    private int ambiente;
    private int empresa;

    public int getId_vulnerabilidad() {
        return id_vulnerabilidad;
    }

    public void setId_vulnerabilidad(int id_vulnerabilidad) {
        this.id_vulnerabilidad = id_vulnerabilidad;
    }

    public String getNombre_vulnerabilidad() {
        return nombre_vulnerabilidad;
    }

    public void setNombre_vulnerabilidad(String nombre_vulnerabilidad) {
        this.nombre_vulnerabilidad = nombre_vulnerabilidad;
    }

    public String getUrl_servicio() {
        return url_servicio;
    }

    public void setUrl_servicio(String url_servicio) {
        this.url_servicio = url_servicio;
    }

    public String getDescripcion_vulnerabilidad() {
        return descripcion_vulnerabilidad;
    }

    public void setDescripcion_vulnerabilidad(String descripcion_vulnerabilidad) {
        this.descripcion_vulnerabilidad = descripcion_vulnerabilidad;
    }

    public String getImpacto_vulnerabilidad() {
        return impacto_vulnerabilidad;
    }

    public void setImpacto_vulnerabilidad(String impacto_vulnerabilidad) {
        this.impacto_vulnerabilidad = impacto_vulnerabilidad;
    }

    public String getRecomendaciones_vulnerabilidad() {
        return recomendaciones_vulnerabilidad;
    }

    public void setRecomendaciones_vulnerabilidad(String recomendaciones_vulnerabilidad) {
        this.recomendaciones_vulnerabilidad = recomendaciones_vulnerabilidad;
    }

    public int getId_estado_mitigacion() {
        return id_estado_mitigacion;
    }

    public void setId_estado_mitigacion(int id_estado_mitigacion) {
        this.id_estado_mitigacion = id_estado_mitigacion;
    }

    public String getFecha_mitigacion() {
        return fecha_mitigacion;
    }

    public void setFecha_mitigacion(String fecha_mitigacion) {
        this.fecha_mitigacion = fecha_mitigacion;
    }

    public String getCvss() {
        return cvss;
    }

    public void setCvss(String cvss) {
        this.cvss = cvss;
    }

    public String getFecha_propuesta() {
        return fecha_propuesta;
    }

    public void setFecha_propuesta(String fecha_propuesta) {
        this.fecha_propuesta = fecha_propuesta;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public String getPath_poc() {
        return path_poc;
    }

    public void setPath_poc(String path_poc) {
        this.path_poc = path_poc;
    }

    public String getNum_incidente() {
        return num_incidente;
    }

    public void setNum_incidente(String num_incidente) {
        this.num_incidente = num_incidente;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getOwasp() {
        return owasp;
    }

    public void setOwasp(int owasp) {
        this.owasp = owasp;
    }

    public int getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(int criticidad) {
        this.criticidad = criticidad;
    }

    public int getTratamiento_riesgo() {
        return tratamiento_riesgo;
    }

    public void setTratamiento_riesgo(int tratamiento_riesgo) {
        this.tratamiento_riesgo = tratamiento_riesgo;
    }

    public int getCwe() {
        return cwe;
    }

    public void setCwe(int cwe) {
        this.cwe = cwe;
    }

    public int getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(int aplicacion) {
        this.aplicacion = aplicacion;
    }

    public int getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(int ambiente) {
        this.ambiente = ambiente;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public Vulnerabilidad(int id_vulnerabilidad, String nombre_vulnerabilidad, String url_servicio, String descripcion_vulnerabilidad, String impacto_vulnerabilidad, String recomendaciones_vulnerabilidad, int id_estado_mitigacion, String fecha_mitigacion, String cvss, String fecha_propuesta, String pasos, String path_poc, String num_incidente, int usuario, int categoria, int owasp, int criticidad, int tratamiento_riesgo, int cwe, int aplicacion, int ambiente, int empresa) {
        this.id_vulnerabilidad = id_vulnerabilidad;
        this.nombre_vulnerabilidad = nombre_vulnerabilidad;
        this.url_servicio = url_servicio;
        this.descripcion_vulnerabilidad = descripcion_vulnerabilidad;
        this.impacto_vulnerabilidad = impacto_vulnerabilidad;
        this.recomendaciones_vulnerabilidad = recomendaciones_vulnerabilidad;
        this.id_estado_mitigacion = id_estado_mitigacion;
        this.fecha_mitigacion = fecha_mitigacion;
        this.cvss = cvss;
        this.fecha_propuesta = fecha_propuesta;
        this.pasos = pasos;
        this.path_poc = path_poc;
        this.num_incidente = num_incidente;
        this.usuario = usuario;
        this.categoria = categoria;
        this.owasp = owasp;
        this.criticidad = criticidad;
        this.tratamiento_riesgo = tratamiento_riesgo;
        this.cwe = cwe;
        this.aplicacion = aplicacion;
        this.ambiente = ambiente;
        this.empresa = empresa;
    }

    public Vulnerabilidad() {
    }


 
    
    
    
}
