
package com.pascualbravo.TiendaOnline.Servicios.iface;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Categorias;
import java.sql.SQLException;
import java.util.List;

public interface CategoriasDao {
    
      Categorias obtenerIdCategoria(int id) throws SQLException;
      List<String>  llenarComboboxCategorias() throws SQLException;
}
