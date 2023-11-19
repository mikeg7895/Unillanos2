package BaseDatos;

import servicio.DetalleVentaServicio;
import servicio.Servicios;
import servicio.VentaServicio;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablaDetalleCompra extends Operaciones<VentaServicio> {
    public TablaDetalleCompra() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insertar(VentaServicio objeto) throws SQLException {
        String sql = "INSERT INTO detallecompra (num_venta, nomb_venta, tipo_servicio, codigo_persona, id_servicio) " +
                "VALUES (?, ?, ?, ?, ?)";
        conexion.conexion.setAutoCommit(false);

        for(DetalleVentaServicio detalleVentaServicio : objeto.getDtl_venta()){
            PreparedStatement statement = conexion.conexion.prepareStatement(sql);
            statement.setInt(1, objeto.getNum_venta());
            statement.setString(2, objeto.getNomb_venta());
            statement.setString(3, detalleVentaServicio.getTipo_servicio());
            statement.setInt(4, objeto.getPersona().getId());
            statement.setInt(5, detalleVentaServicio.getServicio().getId_servicio());
            statement.executeUpdate();
        }

        conexion.conexion.commit();
    }

    @Override
    public void actualizar(VentaServicio objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE detallecompra SET " + columna + " = ? WHERE nomb_venta = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getNomb_venta());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        conexion.conexion.commit();
    }

    @Override
    public void eliminar(VentaServicio objeto) throws SQLException {
        String sql = "DELETE FROM detallecompra WHERE nomb_venta = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setString(1, objeto.getNomb_venta());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        conexion.conexion.commit();
    }

    public void generarFactura(VentaServicio objeto) throws SQLException {
        String sql = "SELECT * FROM detallecompra d JOIN servicio s ON d.id_servicio=s.id WHERE num_venta = ?";
        conexion.conexion.setAutoCommit(false);

        PreparedStatement statement = conexion.conexion.prepareStatement(sql);
        statement.setInt(1, objeto.getNum_venta());

        ResultSet resultado = statement.executeQuery();
        int total = 0;

        while(resultado.next()){
            String nobre = resultado.getString("nombre");
            int valor = resultado.getInt("valor");
            total = total+valor;
            System.out.println("Producto: " + nobre + " valor: " + valor);
        }
        System.out.println("Total: " + total);

        conexion.conexion.commit();
    }
}
