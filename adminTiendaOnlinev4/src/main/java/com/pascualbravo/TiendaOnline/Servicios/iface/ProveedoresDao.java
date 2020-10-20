
package com.pascualbravo.TiendaOnline.Servicios.iface;
import com.pascualbravo.TiendaOnline.ClasesPropiedades.Proveedores;
import java.sql.SQLException;
import java.util.List;


public interface ProveedoresDao {   
      Proveedores obtenerIdProveedores(int id) throws SQLException;
      List<String>  llenarComboboxProveedores() throws SQLException;
}