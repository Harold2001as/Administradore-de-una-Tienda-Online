package com.pascualbravo.TiendaOnline.Servicios.impl;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Productos;
import com.pascualbravo.TiendaOnline.Dao.Conexion.AdministradorConexion;
import com.pascualbravo.TiendaOnline.Servicios.iface.ProductosDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductosDaoImpl implements ProductosDao {

    private static final String SQL_INSERT = "insert into productos(nombre,descripcion,"
            + "precio,stock,fecha,imagen,proveedor_id,categoria_id) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_SELECT = "select p.producto_id,p.nombre , "
            + "p.descripcion,p.precio ,p.stock ,p.fecha ,p.imagen , "
            + "p2.nombre as proveedor,c.nombre as categoria from productos p "
            + "inner join proveedores p2 on p.proveedor_id =p2.proveedor_id "
            + "inner join categorias c on p.categoria_id =c.categoria_id ";
    private static final String SQL_DELETE = "delete from productos where producto_id=?";

    private static final String SQL_UPDATE = "update productos set(nombre,descripcion,precio,stock,fecha,imagen,proveedor_id,categoria_id)\n"
                + "=(?,?,?,?,?,?,?,?) where producto_id=?";

    private static final String SQL_SELECT_BY_ID = "select m.*, g.name genderName "
            + "from movie m "
            + "inner join gender g on m.gender_id = g.gender_id "
            + "WHERE m.movie_id = ?";

    @Override
    public boolean crear(Productos productos) throws SQLException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement = conexion.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, productos.getNombre());
            preparedStatement.setString(2, productos.getDescripcion());
            preparedStatement.setDouble(3, productos.getPrecio());
            preparedStatement.setInt(4, productos.getStock());
            preparedStatement.setDate(5, (java.sql.Date.valueOf(productos.getFecha())));
            preparedStatement.setString(6, productos.getImagen());
            preparedStatement.setInt(7, productos.getId_Proveedores());
            preparedStatement.setInt(8, productos.getId_Categoría());
            // Actualiza,crea,elimina
            preparedStatement.executeUpdate();

            return true;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    @Override
    public boolean eliminar(int id) throws SQLException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement = conexion.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            // Actualiza,crea,elimina
            preparedStatement.executeUpdate();
            return true;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }


    @Override
    public String[][] mostrarProductos() throws SQLException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
         PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;
        String[][] lista = null;
        int filas=0;
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement1 = conexion.prepareStatement("select count(*)as filas from productos p ");
            resultSet=preparedStatement1.executeQuery();
            while (resultSet.next()) {
             filas = resultSet.getInt("filas"); 
            }
            lista = new String[filas][9];
            preparedStatement = conexion.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            int contador = 0;
            while (resultSet.next()) {

                lista[contador][0] = Integer.toString(resultSet.getInt("producto_id"));
                lista[contador][1] = (resultSet.getString("nombre"));
                lista[contador][2] = (resultSet.getString("descripcion"));
                lista[contador][3] = Float.toString(resultSet.getFloat("precio"));
                lista[contador][4] = Integer.toString(resultSet.getInt("stock"));
                lista[contador][5] = (resultSet.getDate("fecha").toLocalDate()).toString();
                lista[contador][6] = (resultSet.getString("imagen"));
                lista[contador][7] = (resultSet.getString("proveedor"));
                lista[contador][8] = (resultSet.getString("categoria"));
                contador++;
            }
            return lista;
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
    public boolean actualizar(int id, Productos productos) throws SQLException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement = conexion.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, productos.getNombre());
            preparedStatement.setString(2, productos.getDescripcion());
            preparedStatement.setDouble(3, productos.getPrecio());
            preparedStatement.setInt(4,productos.getStock());
            preparedStatement.setDate(5, (java.sql.Date.valueOf(productos.getFecha())));
            preparedStatement.setString(6, productos.getImagen());
            preparedStatement.setInt(7,productos.getId_Proveedores());
            preparedStatement.setInt(8, productos.getId_Categoría());
            preparedStatement.setInt(9, (id));
            // Actualiza,crea,elimina
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            return true;
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
