
package com.pascualbravo.TiendaOnline.Servicios.iface;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Productos;
import java.sql.SQLException;
import java.util.List;

public interface ProductosDao {
    
    public boolean crear(Productos productos) throws SQLException;
    
    public boolean eliminar(int id)throws SQLException;
    
//    public Producto obtenerIdProductos(int id);
    
    public String[][] mostrarProductos() throws SQLException;
    
    public boolean actualizar(int id, Productos productos)throws SQLException;
    
}
