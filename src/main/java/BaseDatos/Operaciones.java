package BaseDatos;

import java.sql.*;

public abstract class Operaciones<T1> {
    protected Conexion conexion;

    public Operaciones() throws SQLException, ClassNotFoundException {
        this.conexion = new Conexion();
    }

    public abstract void insertar(T1 objeto) throws SQLException;

    public abstract void actualizar(T1 objeto, String columna, String valor) throws SQLException;

    public abstract void eliminar(T1 objeto) throws SQLException;
}
