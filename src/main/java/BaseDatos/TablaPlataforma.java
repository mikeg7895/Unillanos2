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
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setInt(1, objeto.getId());
        statement.setString(2, objeto.getNombre());
        statement.setString(3, objeto.getVersión());
        statement.executeUpdate();

        getConexion().commit();
    }

    @Override
    public void actualizar(Plataforma objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE plataforma SET " + columna + " = ? WHERE nombre = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getNombre());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        getConexion().commit();
    }

    @Override
    public void eliminar(Plataforma objeto) throws SQLException {
        String sql = "DELETE FROM plataforma WHERE nombre = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, objeto.getNombre());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        getConexion().commit();
    }
}
