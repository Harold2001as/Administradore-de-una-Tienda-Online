/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.TiendaOnline.Controlador.utilidades;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Productos;
import com.pascualbravo.TiendaOnline.Servicios.iface.ProductosDao;
import com.pascualbravo.TiendaOnline.Servicios.iface.TiendaServicio;
import com.pascualbravo.TiendaOnline.Servicios.impl.Implementaciones;
import com.pascualbravo.TiendaOnline.Servicios.impl.ProductosDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Windows 10
 */
//Esta clase se utiliza para manejar los datos de la tabla
public class GridProducto {


      private DefaultTableModel tableModelMovie;

   public void fillGrid(String[] Columnas, JTable tabla) throws  SQLException {
        String[][] m=null;
        ProductosDao productosDao;
        productosDao = new ProductosDaoImpl();
        m = productosDao.mostrarProductos();
        tabla.setModel(new DefaultTableModel (m,Columnas));        
    }
}


