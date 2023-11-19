package servicio;

import personas.Persona;

import java.io.Serializable;
import java.util.List;

public class VentaServicio implements Serializable {

    private int num_venta;
    private String nomb_venta;
    private List<DetalleVentaServicio> dtl_venta;
    private Persona persona;

    public VentaServicio(int num_venta, String nomb_venta, List<DetalleVentaServicio> dtl_venta, Persona persona) {
        this.num_venta = num_venta;
        this.nomb_venta = nomb_venta;
        this.dtl_venta = dtl_venta;
        this.persona = persona;
    }

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public String getNomb_venta() {
        return nomb_venta;
    }

    public void setNomb_venta(String nomb_venta) {
        this.nomb_venta = nomb_venta;
    }

    public List<DetalleVentaServicio> getDtl_venta() {
        return dtl_venta;
    }

    public void setDtl_venta(List<DetalleVentaServicio> dtl_venta) {
        this.dtl_venta = dtl_venta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void mostrarVenta(){
        System.out.println("Venta a " + this.persona.getNombre() + "de los servicios:\n");
        for(DetalleVentaServicio detalleVentaServicio : this.dtl_venta){
            System.out.println(detalleVentaServicio.getServicio().getNomb_servicio() + "   Valor: " +
                    detalleVentaServicio.getServicio().getValor() + "\n");
        }
    }

    @Override
    public String toString() {
        return "VentaServicio{" +
                "num_venta=" + num_venta +
                ", nomb_venta='" + nomb_venta + '\'' +
                ", dtl_venta=" + dtl_venta +
                ", persona=" + persona +
                '}';
    }
}
