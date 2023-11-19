package servicio;

import java.io.Serializable;

public class Servicios implements Serializable {


    private int id_servicio;
    private String nomb_servicio;
    private String descripcion_serivicio;
    private int valor;

    public Servicios(int id_servicio, String nomb_servicio, String descripcion_servicio, int valor) {
        this.id_servicio = id_servicio;
        this.nomb_servicio = nomb_servicio;
        this.descripcion_serivicio = descripcion_servicio;
        this.valor = valor;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNomb_servicio() {
        return nomb_servicio;
    }

    public void setNomb_servicio(String nomb_servicio) {
        this.nomb_servicio = nomb_servicio;
    }

    public String getDescripcion_serivicio() {
        return descripcion_serivicio;
    }

    public void setDescripcion_serivicio(String descripcion_serivicio) {
        this.descripcion_serivicio = descripcion_serivicio;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Servicios{" +
                "id_servicio=" + id_servicio +
                ", nomb_servicio='" + nomb_servicio + '\'' +
                ", descripcion_serivicio='" + descripcion_serivicio + '\'' +
                ", valor=" + valor +
                '}';
    }
}
