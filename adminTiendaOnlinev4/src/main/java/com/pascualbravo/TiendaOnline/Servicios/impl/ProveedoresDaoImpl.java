package com.pascualbravo.TiendaOnline.Servicios.impl;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Proveedores;
import com.pascualbravo.TiendaOnline.Dao.Conexion.AdministradorConexion;
import com.pascualbravo.TiendaOnline.Servicios.iface.ProveedoresDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Arenas
 */
public class ProveedoresDaoImpl implements ProveedoresDao {

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM categorias " + "WHERE categoria_id = ?";

    @Override
    public Proveedores obtenerIdProveedores(int id) throws SQLException {
//Declaramos variables
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Proveedores proveedores = null;
        try {
            //obtenemos la conexion
            conexion = AdministradorConexion.obtenerConexion();
            //el peparedStamented le asignamos la conexion y la consulta
            preparedStatement = conexion.prepareStatement(SQL_SELECT_BY_ID);
            //indicamos el indice y la variable
            preparedStatement.setInt(1, id);
            //ejecutamos la consulta y se lo asignamos a un result set
            resultSet = preparedStatement.executeQuery();
            //leemos el result set y se lo asignamos a la clase categeoria
            if (resultSet.next()) {
                proveedores = new Proveedores();
                proveedores.setProveedor_id(resultSet.getInt("proveedor_id"));
                proveedores.setNombre(resultSet.getString("nombre"));
                proveedores.setTelefono(resultSet.getString("telefono"));
                proveedores.setDireccion(resultSet.getString("direccion"));
            }
            return proveedores;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    @Override
    public List<String> llenarComboboxProveedores() throws SQLException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> lista=new ArrayList<>();
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement = conexion.prepareStatement("select nombre from proveedores");
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
               lista.add(resultSet.getString("nombre"));
            }
            return lista;
           
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
