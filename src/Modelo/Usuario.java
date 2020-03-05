/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author japa
 */
public class Usuario {
    
    private int id_usuario;
    private String nombre;
    private String password;
    private String token_csrf;
    private String ultima_conexion;
    private String correo_electronico;
    private int id_tipo_usuario;

    public Usuario(int id_usuario, String nombre, String password, String token_csrf, String ultima_conexion, String correo_electronico, int id_tipo_usuario) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.token_csrf = token_csrf;
        this.ultima_conexion = ultima_conexion;
        this.correo_electronico = correo_electronico;
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
    
    
    
    public Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken_csrf() {
        return token_csrf;
    }

    public void setToken_csrf(String token_csrf) {
        this.token_csrf = token_csrf;
    }

    public String getUltima_conexion() {
        return ultima_conexion;
    }

    public void setUltima_conexion(String ultima_conexion) {
        this.ultima_conexion = ultima_conexion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }
    
}
