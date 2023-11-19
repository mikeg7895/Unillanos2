package personas;

public class Estudiante extends Persona{
    private String numeroMatricula;

    public Estudiante(int id, String nombre, int edad, String numeroMatricula) {
        super(id, nombre, edad, "Estudiante");
        this.numeroMatricula = numeroMatricula;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public void saludar(){
        System.out.println("Hola, soy " + super.nombre + " y soy " + super.profesion + " y mi edad es: " +
                super.edad + " mi matricula es " + this.numeroMatricula);
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de Matrícula: " + numeroMatricula;
    }
}
