/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.TiendaOnline.Servicios.impl;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Usuarios;
import com.pascualbravo.TiendaOnline.Dao.Conexion.AdministradorConexion;
import com.pascualbravo.TiendaOnline.Servicios.iface.UsuariosDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDaoImpl implements UsuariosDao {

    static final String SQL_SEARCH = "select*from usuarios u "
            + "where u.email =? and u.contraseña=?";
    private static final String SQL_INSERT = "insert into usuarios(usuario_id,nombre,"
            + "telefono,direccion,email,contraseña,edad,n_compras,perfil_id)"
            + "values(?,?,?,?,?,?,?,?,?);";

    @Override
    public boolean iniciarSesion(String email, String Contraseña) throws SQLException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement = conexion.prepareStatement(SQL_SEARCH);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, Contraseña);
            resultSet = preparedStatement.executeQuery();
            System.out.println("entroo");
            while (resultSet.next()) {
                return true;
            }
            return false;

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
    public Usuarios crearUsuario(Usuarios usuarios) throws SQLException {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        try {
            conexion = AdministradorConexion.obtenerConexion();
            preparedStatement = conexion.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, usuarios.getUsuario_id());
            preparedStatement.setString(2, usuarios.getNombre());
            preparedStatement.setString(3, usuarios.getTelefono());
            preparedStatement.setString(4, usuarios.getDireccion());
            preparedStatement.setString(5, usuarios.getEmail());
            preparedStatement.setString(6, usuarios.getContraseña());
            preparedStatement.setInt(7, usuarios.getEdad());
             preparedStatement.setInt(8, usuarios.getN_compras());
            preparedStatement.setInt(9, usuarios.getPerfil_id());
            // Actualiza,crea,elimina
            preparedStatement.executeUpdate();
            return usuarios;
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
