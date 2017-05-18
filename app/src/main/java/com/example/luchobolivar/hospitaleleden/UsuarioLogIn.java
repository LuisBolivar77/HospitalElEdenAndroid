package com.example.luchobolivar.hospitaleleden;

/**
 * Created by LuchoBolivar on 5/17/17.
 */

public class UsuarioLogIn {

    static int identificacion;
    static String nombre;
    static String apellido;
    static String telefono;
    static String email;
    static String direccion;
    static int genero;
    static String username;
    static String password;
    static String rol;

    public UsuarioLogIn() {
    }


    public static int getIdentificacion() {
        return identificacion;
    }

    public static void setIdentificacion(int identificacion) {
        UsuarioLogIn.identificacion = identificacion;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        UsuarioLogIn.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        UsuarioLogIn.apellido = apellido;
    }

    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        UsuarioLogIn.telefono = telefono;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UsuarioLogIn.email = email;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static void setDireccion(String direccion) {
        UsuarioLogIn.direccion = direccion;
    }

    public static int getGenero() {
        return genero;
    }

    public static void setGenero(int genero) {
        UsuarioLogIn.genero = genero;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UsuarioLogIn.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UsuarioLogIn.password = password;
    }

    public static String getRol() {
        return rol;
    }

    public static void setRol(String rol) {
        UsuarioLogIn.rol = rol;
    }
}
