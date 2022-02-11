package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost/empleados_db";
    private final String USUARIO = "postgres";
    private final String CLAVE = "admin";
    private Connection cn;

    public Conexion() {
        cn = null;
    }

    public Connection conectar() {
        if (cn == null) {
            try {
                Class.forName(DRIVER);
                cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            } catch (SQLException | ClassNotFoundException e) {
            }
        }
        return cn;
    }
}
