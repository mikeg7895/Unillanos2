package personas;

public class Docente extends Persona {
    private String codigoDocente;

    public Docente(int id, String nombre, int edad, String codigoDocente) {
        super(id, nombre, edad, "Docente");
        this.codigoDocente = codigoDocente;
    }

    public String getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    @Override
    public String toString() {
        return super.toString() + ", Código de Docente: " + codigoDocente;
    }
}
