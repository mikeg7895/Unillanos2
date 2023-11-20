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
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, objeto.getNombreEmpresa());
        statement.executeUpdate();

        getConexion().commit();
    }

    @Override
    public void actualizar(Empresa objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE empresa SET " + columna + " = ? WHERE nombre = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getNombreEmpresa());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        getConexion().commit();
    }

    @Override
    public void eliminar(Empresa objeto) throws SQLException {
        String sql = "DELETE FROM empresa WHERE nombre = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, objeto.getNombreEmpresa());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        getConexion().commit();
    }
}
