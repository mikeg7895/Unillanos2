package servicio;

import java.io.Serializable;
import java.util.List;

public class Facturacion implements Serializable {

    private double num_factura;
    private int total;
    private VentaServicio servicios;

    public Facturacion(double num_factura, VentaServicio servicios) {
        this.num_factura = num_factura;
        this.servicios = servicios;
        this.total = calcularTotal(servicios);
    }

    public double getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(double num_factura) {
        this.num_factura = num_factura;
    }

    public VentaServicio getServicios() {
        return servicios;
    }

    public void setServicios(VentaServicio servicios) {
        this.servicios = servicios;
    }

    private int calcularTotal(VentaServicio servicios){
        int total = 0;
       List<DetalleVentaServicio> detalleVentaServicio = servicios.getDtl_venta();
       for(DetalleVentaServicio detalle : detalleVentaServicio){
           total = total + detalle.getServicio().getValor();
       }
       return total;
    }

    public void mostrarFactura(){
        System.out.println("Productos:\n");
        for(DetalleVentaServicio ventas : this.servicios.getDtl_venta()){
            System.out.println(ventas.getServicio().getNomb_servicio() + "   Valor: " +
                    ventas.getServicio().getValor());
        }
        System.out.println("Total : " + this.total);
    }



    @Override
    public String toString() {
        return "Facturacion{" +
                "num_factura=" + num_factura +
                ", total=" + total +
                ", servicios=" + servicios +
                '}';
    }
}
