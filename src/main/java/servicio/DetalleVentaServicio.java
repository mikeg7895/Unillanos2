package servicio;

import java.io.Serializable;

public class DetalleVentaServicio implements Serializable {

    private int num_ventaServicio;
    private String tipo_servicio;
    private Servicios servicio;

    public DetalleVentaServicio(int num_ventaServicio, String tipo_servicio, Servicios servicio) {
        this.num_ventaServicio = num_ventaServicio;
        this.tipo_servicio = tipo_servicio;
        this.servicio = servicio;
    }

    public int getNum_ventaServicio() {
        return num_ventaServicio;
    }

    public void setNum_ventaServicio(int num_ventaServicio) {
        this.num_ventaServicio = num_ventaServicio;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "DetalleVentaServicio{" + "num_ventaServicio=" + num_ventaServicio + ", tipo_servicio=" + tipo_servicio + ", Servicio=" + servicio + '}';
    }


}
