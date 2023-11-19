package login;

import java.io.Serializable;

public class Plataforma implements Serializable {
    private int id;
    private String nombre;
    private String versión;

    public Plataforma(int id, String nombre, String versión) {
        this.id = id;
        this.nombre = nombre;
        this.versión = versión;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersión() {
        return versión;
    }

    public void setVersión(String versión) {
        this.versión = versión;
    }

    @Override
    public String toString() {
        return "Plataforma{" + "nombre=" + nombre + ", versi\u00f3n=" + versión + '}';
    }

}
