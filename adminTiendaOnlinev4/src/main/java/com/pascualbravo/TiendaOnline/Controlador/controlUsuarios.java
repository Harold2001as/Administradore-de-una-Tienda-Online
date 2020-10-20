/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.TiendaOnline.Controlador;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Usuarios;
import com.pascualbravo.TiendaOnline.Servicios.iface.UsuariosDao;
import com.pascualbravo.TiendaOnline.Servicios.impl.UsuariosDaoImpl;
import java.sql.SQLException;

/**
 *
 * @author Arenas
 */
public class controlUsuarios {

    private final UsuariosDao usuariosDao;
    private final Usuarios usuarios;
    private int cedula, edad, N_compras, perfilId;
    private String nombre, telefono, direccion, email, contraseña;

    public controlUsuarios() {
        usuariosDao = new UsuariosDaoImpl();
        usuarios = new Usuarios();
    }

    public boolean InicioSesion(String email, String Contraseña) throws SQLException {

        if (usuariosDao.iniciarSesion(email, Contraseña)) {
            return true;
        }
        return false;
    }

    public boolean CrearUsuario() throws SQLException {
        if (usuariosDao.crearUsuario(usuarios) != null) {
            return true;
        }
        return false;
    }

    public void RecibirDatos(String cedula, String nombre, String telefono, String direccion,
            String email, String contraseña, String edad, String N_compras, String perfilId) {
        this.cedula = Integer.parseInt(cedula);
        this.edad = Integer.parseInt(edad);
        this.N_compras = Integer.parseInt(N_compras);
        this.perfilId = Integer.parseInt(perfilId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.contraseña = contraseña;
        usuarios.setUsuario_id(this.cedula);
        usuarios.setContraseña(this.contraseña);
        usuarios.setDireccion(this.direccion);
        usuarios.setEdad(this.edad);
        usuarios.setEmail(this.email);
        usuarios.setN_compras(this.N_compras);
        usuarios.setPerfil_id(this.perfilId);
        usuarios.setNombre(this.nombre);
        usuarios.setTelefono(this.telefono);
   
    }
}
