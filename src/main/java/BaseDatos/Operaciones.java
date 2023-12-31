package BaseDatos;

import java.sql.*;

public abstract class Operaciones<T1> {
    private Connection conexion;

    public Operaciones() throws SQLException, ClassNotFoundException {
        this.conexion = Conexion.netMysql();
    }

    public Connection getConexion(){
        return this.conexion;
    }

    public abstract void insertar(T1 objeto) throws SQLException;

    public abstract void actualizar(T1 objeto, String columna, String valor) throws SQLException;

    public abstract void eliminar(T1 objeto) throws SQLException;
}
