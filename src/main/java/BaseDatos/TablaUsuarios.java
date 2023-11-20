package BaseDatos;

import Seguridad.Encriptar;
import login.UsuarioRegistrado;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablaUsuarios extends Operaciones<UsuarioRegistrado> {

    public TablaUsuarios() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insertar(UsuarioRegistrado objeto) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, contraseña, id_plataforma) VALUES (?, ?, ?, ?, ?)";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, objeto.getUsuario().getNombre());
        statement.setString(2, objeto.getUsuario().getApellido());
        statement.setString(3, objeto.getUsuario().getCorreo());
        statement.setString(4, objeto.getUsuario().getContraseña());
        statement.setInt(5, objeto.getPlataforma().getId());
        statement.executeUpdate();

        getConexion().commit();
    }

    @Override
    public void actualizar(UsuarioRegistrado objeto, String columna, String valor) throws SQLException {
        String sql = "UPDATE usuarios SET " + columna + " = ? WHERE nombre = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, valor);
        statement.setString(2, objeto.getUsuario().getNombre());

        int filas = statement.executeUpdate();
        System.out.println("Filas afectadas: " + filas);

        getConexion().commit();
    }

    @Override
    public void eliminar(UsuarioRegistrado objeto) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE nombre = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, objeto.getUsuario().getNombre());

        int filas = statement.executeUpdate();
        System.out.println("Filas adectadas: " + filas);

        getConexion().commit();
    }

    public void login(String correo, String contraseña) throws SQLException, NoSuchAlgorithmException {
        contraseña = Encriptar.encriptar(contraseña);
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";
        getConexion().setAutoCommit(false);

        PreparedStatement statement = getConexion().prepareStatement(sql);
        statement.setString(1, correo);
        statement.setString(2, contraseña);

        ResultSet resultado = statement.executeQuery();

        if(resultado.next()){
            String nombre = resultado.getString("nombre");
            System.out.println("Bienvenido " + nombre);
        }else{
            System.out.println("Usuario incorrecto");
        }

        getConexion().commit();
    }
}
