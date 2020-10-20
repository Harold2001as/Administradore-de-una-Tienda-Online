package com.pascualbravo.TiendaOnline.Servicios.impl;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Categorias;
import com.pascualbravo.TiendaOnline.Dao.Conexion.AdministradorConexion;
import com.pascualbravo.TiendaOnline.Servicios.iface.CategoriasDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDaoImpl implements CategoriasDao {

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM categorias " + "WHERE categoria_id = ?";

    @Override
    public Categorias obtenerIdCategoria(int id) throws SQLException {
//Declaramos variables
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Categorias categorias = null;
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
                categorias = new Categorias();
                categorias.setCategoria_id(resultSet.getInt("categoria_id"));
                categorias.setNombre(resultSet.getString("nombre"));
                categorias.setDescripcion(resultSet.getString("descripcion"));
                categorias.setStock(resultSet.getInt("stock"));
            }
            return categorias;
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
    public List<String> llenarComboboxCategorias() throws SQLException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> lista=new ArrayList<>();
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement = conexion.prepareStatement("select nombre from categorias");
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
