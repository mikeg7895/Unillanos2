package personas;

public class Empleado extends Persona {
    private String codigoEmpleado;

    public Empleado(int id, String nombre, int edad, String codigoEmpleado) {
        super(id, nombre, edad, "Empleado");
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    @Override
    public String toString() {
        return super.toString() + ", Código de Empleado: " + codigoEmpleado;
    }
}
