package login;

import Seguridad.Encriptar;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginUsuario {
    private UsuarioRegistrado usuarioRegistrado;
    private boolean activo;


    public UsuarioRegistrado getUsuariosRegistrados() {
        return usuarioRegistrado;
    }

    public void setUsuariosRegistrados(UsuarioRegistrado usuariosRegistrados) {
        this.usuarioRegistrado = usuariosRegistrados;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        if(activo){
            return "LoginUsuarios{" + "usuariosRegistrados=" + usuarioRegistrado + '}';
        }
        return "Usuario no activo";
    }

    public void cerrarSesion(){
        this.activo = false;
        System.out.println("Sesion cerrada con exito");
    }

}
