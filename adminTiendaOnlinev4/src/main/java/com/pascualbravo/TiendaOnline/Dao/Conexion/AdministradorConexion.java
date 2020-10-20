
//En esta clase especificamos todo lo referente con la base de datos
package com.pascualbravo.TiendaOnline.Dao.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AdministradorConexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/admiTiendaOnline";
    private static final String USER = "postgres";
    private static final String PASSWORD = "harold29as";
    
    public static Connection obtenerConexion() throws SQLException {
        //retornamos la conexion a la base de datos
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

