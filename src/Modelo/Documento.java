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
 * id_documento int
 * nombre_documento 
 * path_documento
 * version_documento int
 * hash_md5 
 * hash_sha1
 * hash_sha256
 * documento_relacionado
 * fecha_entrega DATE
 * nro_sprint 
 * nombre_sprint
 * estado_documento
 * alcance
 * conclusion
 * 
 * 
 */
public class Documento {
    
    private int id_documento;
    private String nombre_documento;
    private String path_documento;
    private int version_documento;
    private String hash_md5;
    private String hash_sha1;
    private String hash_sha256;
    private String documento_relacionado;
    private String fecha_entrega;
    private int nro_sprint;
    private String nombre_sprint;
    private boolean estado_documento;
    private String alcance;
    private String conclusion;
    
    private int persona;
    private String proyecto;
    private int celula;
    private int usuario;
    private int origen;
    private int revision;

    public Documento(int id_documento, String nombre_documento, String path_documento, int version_documento, String hash_md5, String hash_sha1, String hash_sha256, String documento_relacionado, String fecha_entrega, int nro_sprint, String nombre_sprint, boolean estado_documento, String alcance, String conclusion, int persona, String proyecto, int celula, int usuario, int origen, int revision) {
        this.id_documento = id_documento;
        this.nombre_documento = nombre_documento;
        this.path_documento = path_documento;
        this.version_documento = version_documento;
        this.hash_md5 = hash_md5;
        this.hash_sha1 = hash_sha1;
        this.hash_sha256 = hash_sha256;
        this.documento_relacionado = documento_relacionado;
        this.fecha_entrega = fecha_entrega;
        this.nro_sprint = nro_sprint;
        this.nombre_sprint = nombre_sprint;
        this.estado_documento = estado_documento;
        this.alcance = alcance;
        this.conclusion = conclusion;
        this.persona = persona;
        this.proyecto = proyecto;
        this.celula = celula;
        this.usuario = usuario;
        this.origen = origen;
        this.revision = revision;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getNombre_documento() {
        return nombre_documento;
    }

    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    public String getPath_documento() {
        return path_documento;
    }

    public void setPath_documento(String path_documento) {
        this.path_documento = path_documento;
    }

    public int getVersion_documento() {
        return version_documento;
    }

    public void setVersion_documento(int version_documento) {
        this.version_documento = version_documento;
    }

    public String getHash_md5() {
        return hash_md5;
    }

    public void setHash_md5(String hash_md5) {
        this.hash_md5 = hash_md5;
    }

    public String getHash_sha1() {
        return hash_sha1;
    }

    public void setHash_sha1(String hash_sha1) {
        this.hash_sha1 = hash_sha1;
    }

    public String getHash_sha256() {
        return hash_sha256;
    }

    public void setHash_sha256(String hash_sha256) {
        this.hash_sha256 = hash_sha256;
    }

    public String getDocumento_relacionado() {
        return documento_relacionado;
    }

    public void setDocumento_relacionado(String documento_relacionado) {
        this.documento_relacionado = documento_relacionado;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getNro_sprint() {
        return nro_sprint;
    }

    public void setNro_sprint(int nro_sprint) {
        this.nro_sprint = nro_sprint;
    }

    public String getNombre_sprint() {
        return nombre_sprint;
    }

    public void setNombre_sprint(String nombre_sprint) {
        this.nombre_sprint = nombre_sprint;
    }

    public boolean isEstado_documento() {
        return estado_documento;
    }

    public void setEstado_documento(boolean estado_documento) {
        this.estado_documento = estado_documento;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public int getCelula() {
        return celula;
    }

    public void setCelula(int celula) {
        this.celula = celula;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }
    
    
    // método para listar Usuarios en combo box :
    
    
   

    
}
