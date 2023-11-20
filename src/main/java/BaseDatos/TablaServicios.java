package BaseDatos;

import servicio.Servicios;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TablaServicios extends Operaciones<Servicios> {
    public TablaServicios() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insertar(Servicios objeto) throws SQLException {
        String sql = "INSERT INTO servicio (id, nombre, valor, descripcion) VALUES (?, ?, ?, ?)";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setInt(1, objeto.getId_servicio());
        statement.setString(2, objeto.getNomb_servicio());
        statement.setInt(3, objeto.getValor());
        statement.setString(4, objeto.getDescripcion_serivicio());
        statement.executeUpdate();

        getConexion().commit();
    }

    @Override
    public void actualizar(Servicios objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE servicio SET " + columna + " = ? WHERE nombre = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getNomb_servicio());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        getConexion().commit();
    }

    @Override
    public void eliminar(Servicios objeto) throws SQLException {
        String sql = "DELETE FROM servicio WHERE nombre = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, objeto.getNomb_servicio());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        getConexion().commit();
    }

}
