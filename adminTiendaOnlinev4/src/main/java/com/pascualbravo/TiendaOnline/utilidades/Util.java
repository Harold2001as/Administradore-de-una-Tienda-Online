/*
*Esta clase nos permite utilizar metodos estaticos sin necesidad de instanciarlos
*El constructor tiene que ser privado y para poder utlizar los metodos sin necesidad
*de instanciar
 */
package com.pascualbravo.TiendaOnline.utilidades;

import com.pascualbravo.TiendaOnline.Dao.Conexion.AdministradorConexion;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {

    public static final String REGULAR_EXPRESSION_ONLY_NUMBERS = "^[0-9]*$";

    public static final String REGULAR_EXPRESSION_ONLY_NUMBERS_FLOAT = "[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)";

    //yyyy-MM-dd
    public static final String REGULAR_EXPRESSION_DATE = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";

    private Util() {

    }

    //Este Metodo nos sirve para ver si un archivo en cierta ruta ya existe(retornando un boolean)
    public static boolean ComprobarExistencia(String Ruta) {
        File file = new File(Ruta);
        return file.exists();
    }
    
    public static int RetornarId(String consulta) throws SQLException {
        Connection conexion = null;
       
        PreparedStatement preparedStatement = null;
        int bandera=0;
        ResultSet resultSet=null;
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement = conexion.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                 bandera =resultSet.getInt("numero");
            }
            return bandera;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
}

