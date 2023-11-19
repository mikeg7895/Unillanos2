package login;

import java.io.Serializable;

public class UsuarioRegistrado implements Serializable {
    private Usuario usuario;
    private Plataforma plataforma;

    public UsuarioRegistrado(Usuario usuario, Plataforma plataforma) {
        this.usuario = usuario;
        this.plataforma = plataforma;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "UsuariosRegistrado{" + "usuario=" + usuario + ", plataforma=" + plataforma + '}';
    }

}
