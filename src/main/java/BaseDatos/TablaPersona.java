package BaseDatos;

import personas.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablaPersona extends Operaciones<Persona>{
    public TablaPersona() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insertar(Persona objeto) throws SQLException {
        String sql = "INSERT INTO persona (codigo, nombre, edad, profesion) VALUES (?, ?, ?, ?)";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setInt(1, objeto.getId());
        statement.setString(2, objeto.getNombre());
        statement.setInt(3, objeto.getEdad());
        statement.setString(4, objeto.getProfesion());
        statement.executeUpdate();

        conexion.conexion.commit();
    }

    @Override
    public void actualizar(Persona objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE persona SET " + columna + " = ? WHERE nombre = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getNombre());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        conexion.conexion.commit();
    }

    @Override
    public void eliminar(Persona objeto) throws SQLException {
        String sql = "DELETE FROM persona WHERE nombre = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, objeto.getNombre());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        conexion.conexion.commit();
    }

    public void consultarMayores(int edad) throws SQLException {
        String sql = "SELECT * FROM persona WHERE edad >= ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setInt(1, edad);

        ResultSet resultado = statement.executeQuery();

        while(resultado.next()){
            String nombre = resultado.getString("nombre");
            int edadres = resultado.getInt("edad");

            System.out.println("Nombre: " + nombre + "edad: " + edadres);
        }
    }
}
