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
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setInt(1, objeto.getId_servicio());
        statement.setString(2, objeto.getNomb_servicio());
        statement.setInt(3, objeto.getValor());
        statement.setString(4, objeto.getDescripcion_serivicio());
        statement.executeUpdate();

        conexion.conexion.commit();
    }

    @Override
    public void actualizar(Servicios objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE servicio SET " + columna + " = ? WHERE nombre = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getNomb_servicio());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        conexion.conexion.commit();
    }

    @Override
    public void eliminar(Servicios objeto) throws SQLException {
        String sql = "DELETE FROM servicio WHERE nombre = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, objeto.getNomb_servicio());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        conexion.conexion.commit();
    }

}
