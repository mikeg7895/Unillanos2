package personas;

import java.io.Serializable;

public class PersonaCargo implements Serializable {
    private Persona persona;
    private Cargo cargo;
    private Empresa empresa;

    public PersonaCargo(Persona persona, Cargo cargo, Empresa empresa) {
        this.persona = persona;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    public Persona getPersona() {
        return persona;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void saludar(){
        System.out.println("Hola, soy " + persona.getNombre() + " y mi puesto en la empresa " +
                empresa.getNombreEmpresa() + " es: " + cargo.getNombreCargo());
    }

    @Override
    public String toString() {
        return "PersonaCargo{" +
                "persona=" + persona +
                ", cargo=" + cargo +
                ", empresa=" + empresa +
                '}';
    }
}
