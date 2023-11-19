package BaseDatos;

import login.Plataforma;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TablaPlataforma extends Operaciones<Plataforma> {
    public TablaPlataforma() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insertar(Plataforma objeto) throws SQLException {
        String sql = "INSERT INTO plataforma (id, nombre, version) VALUES (?, ?, ?)";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setInt(1, objeto.getId());
        statement.setString(2, objeto.getNombre());
        statement.setString(3, objeto.getVersión());
        statement.executeUpdate();

        conexion.conexion.commit();
    }

    @Override
    public void actualizar(Plataforma objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE plataforma SET " + columna + " = ? WHERE nombre = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getNombre());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        conexion.conexion.commit();
    }

    @Override
    public void eliminar(Plataforma objeto) throws SQLException {
        String sql = "DELETE FROM plataforma WHERE nombre = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, objeto.getNombre());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        conexion.conexion.commit();
    }
}
