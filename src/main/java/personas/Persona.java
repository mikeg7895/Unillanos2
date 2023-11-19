package personas;

import java.io.Serializable;

public class Persona implements Serializable {

    protected int id;
    protected String nombre;
    protected int edad;

    protected String profesion;

    public Persona(int id, String nombre, int edad, String profesion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void saludar(){
        System.out.println("Hola, soy " + this.nombre + " y mi edad es " + this.edad);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
