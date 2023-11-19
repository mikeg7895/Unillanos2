package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql implements IConexion{
    private String url = "jdbc:mysql://localhost:3306/java";
    private String user = "root";
    private String password = "";
    protected Connection conexion;

    
    public ConexionMysql() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conexion = DriverManager.getConnection(this.url, this.user, this.password);
    }

    public Connection getConexion(){
        return this.conexion;
    }

    public void cerrar() throws SQLException {
        this.conexion.close();
    }
}
