package personas;

import java.io.Serializable;

public class Cargo implements Serializable {
    private String nombreCargo;

    public Cargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    @Override
    public String toString() {
        return "Nombre del Cargo: " + nombreCargo;
    }
}
