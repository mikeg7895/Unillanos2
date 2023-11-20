package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
    private String url = "jdbc:mysql://localhost:3306/java";
    private String user = "root";
    private String password = "";
    private static Connection conexion;
    private static Conexion conexionMysql;

    private Conexion(){
    }

    private void ConexionMysql() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conexion = DriverManager.getConnection(this.url, this.user, this.password);
    }

    public static Connection netMysql() throws SQLException, ClassNotFoundException {
        if(conexionMysql == null){
            conexionMysql = new Conexion();
            conexionMysql.ConexionMysql();
        }
        return conexion;
    }

}
