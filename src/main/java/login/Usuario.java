package login;

import Seguridad.Encriptar;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;

    public Usuario(String nombre, String apellido, String correo, String contraseña) throws NoSuchAlgorithmException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        // Encriptamos la contraseña
        this.contraseña = Encriptar.encriptar(contraseña);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }
}
