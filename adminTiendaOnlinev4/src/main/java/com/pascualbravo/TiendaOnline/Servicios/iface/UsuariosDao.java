package com.pascualbravo.TiendaOnline.Servicios.iface;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Usuarios;
import java.sql.SQLException;

public interface UsuariosDao {

    boolean iniciarSesion(String email,String Contraseña)throws SQLException;
    
    Usuarios crearUsuario(Usuarios usuarios)throws SQLException;
}
