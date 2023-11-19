package BaseDatos;

import personas.Empresa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TablaEmpresa extends Operaciones<Empresa>{

    public TablaEmpresa() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insertar(Empresa objeto) throws SQLException {
        String sql = "INSERT INTO empresa (nombre) VALUES (?)";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, objeto.getNombreEmpresa());
        statement.executeUpdate();

        conexion.conexion.commit();
    }

    @Override
    public void actualizar(Empresa objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE empresa SET " + columna + " = ? WHERE nombre = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getNombreEmpresa());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        conexion.conexion.commit();
    }

    @Override
    public void eliminar(Empresa objeto) throws SQLException {
        String sql = "DELETE FROM empresa WHERE nombre = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, objeto.getNombreEmpresa());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        conexion.conexion.commit();
    }
}
