/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.TiendaOnline.Controlador;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Productos;
import com.pascualbravo.TiendaOnline.Controlador.utilidades.GridProducto;
import com.pascualbravo.TiendaOnline.Servicios.iface.CategoriasDao;
import com.pascualbravo.TiendaOnline.Servicios.iface.ProductosDao;
import com.pascualbravo.TiendaOnline.Servicios.iface.ProveedoresDao;
import com.pascualbravo.TiendaOnline.Servicios.impl.CategoriasDaoImpl;
import com.pascualbravo.TiendaOnline.Servicios.impl.ProductosDaoImpl;
import com.pascualbravo.TiendaOnline.Servicios.impl.ProveedoresDaoImpl;
import com.pascualbravo.TiendaOnline.utilidades.Util;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Windows 10
 */
public class controlProductos {

    private static controlProductos instance = null;
    private final ProductosDao productosDao;
    private final ProveedoresDao proveedoresDao;
    private final CategoriasDao categoriasDao;
    private final GridProducto gridProducto;
    private Productos producto;
    private int id, stock, idProveedor, idCategoria;
    private String nombre, descripcion, url, Direccion;
    private float precio;
    private LocalDate fecha;

    public void RecibirDatos(String nombre, String descripcion, float precio,
            int stock, LocalDate fecha, String url, int idProveedor, int idCategoria) {
 
        this.stock = stock;
        this.idProveedor = idProveedor;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.precio = precio;
        this.fecha = fecha;
    }

    public void llenarComboBox(JComboBox combo1,JComboBox combo2) {
        List<String> lista = new ArrayList<>();
        try {
            lista = proveedoresDao.llenarComboboxProveedores();
            for (String hola : lista) {
                combo1.addItem(hola);
            }
            lista.clear();
            lista = categoriasDao.llenarComboboxCategorias();
            for (String hola : lista) {
                combo2.addItem(hola);
            }
        } catch (Exception e) {
        }
    }

    private void setearDatos() {
        producto.setId_Producto(Math.round(id));
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setFecha(fecha);
        producto.setImagen(url);
        producto.setId_Proveedores(idProveedor);
        producto.setId_Categoría(idCategoria);
    }

    private controlProductos() {
        gridProducto = new GridProducto();
        productosDao = new ProductosDaoImpl();
        producto = new Productos();
        proveedoresDao = new ProveedoresDaoImpl();
        categoriasDao = new CategoriasDaoImpl();
    }

    // Singleton
    public static controlProductos getInstance() {
        if (instance == null) {
            instance = new controlProductos();
        }
        return instance;
    }


    private boolean ValidarCampo(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return true;
    }

    public String ValidarCampos(String id, String name, String description, String precio,
            String stock, String fecha, String imagen, String idProvedor, String idCategoria) {
        StringBuilder builder = new StringBuilder();

//        if (!ValidarCampo(id)) {
//            builder.append("ID del producto es requerido\n");
//        } else if (!id.matches(Util.REGULAR_EXPRESSION_ONLY_NUMBERS)) {
//            builder.append("ID del producto solo permite números\n");
//        }

        if (!ValidarCampo(name)) {
            builder.append("Nombre del producto es requerido\n");
        }

        if (!ValidarCampo(description)) {
            builder.append("Descripción del producto es requerido\n");
        }
        if (!ValidarCampo(precio)) {
            builder.append("Precio del producto es requerido\n");
        } else if (!precio.matches(Util.REGULAR_EXPRESSION_ONLY_NUMBERS_FLOAT)) {
            builder.append("Precio del producto solo permite números\n");
        }

        if (!ValidarCampo(stock)) {
            builder.append("Cantidad del producto es requerido\n");
        } else if (!stock.matches(Util.REGULAR_EXPRESSION_ONLY_NUMBERS)) {
            builder.append("Cantidad del producto solo permite números\n");
        }

        if (!ValidarCampo(imagen)) {
            builder.append("Imagen del producto es requerido\n");
        }

//        if (!ValidarCampo(idProvedor)) {
//            builder.append("IdProveedor del producto es requerido\n");
//        } else if (!idProvedor.matches(Util.REGULAR_EXPRESSION_ONLY_NUMBERS)) {
//            builder.append("IdProveedor del producto solo permite números\n");
//        }
//
//        if (!ValidarCampo(idCategoria)) {
//            builder.append("IdCategoria del producto es requerido\n");
//        } else if (!idCategoria.matches(Util.REGULAR_EXPRESSION_ONLY_NUMBERS)) {
//            builder.append("IdCategoria del producto solo permite números\n");
//        }

        if (!ValidarCampo(fecha)) {
            builder.append("Fecha del producto es requerido\n");
        } else if (!fecha.trim().matches(Util.REGULAR_EXPRESSION_DATE)) {
            builder.append("Fecha del producto invalida. Recuerde que la fecha debe tener el formato yyyy-MM-dd\n");
        }
        return builder.toString();
    }

    public boolean eliminar(int id) throws SQLException {
        setearDatos();
        if (productosDao.eliminar(id)) {
            return true;
        }
        return false;
    }

    public void llenartabla(String[] Columnas, JTable tabla) throws SQLException {
        gridProducto.fillGrid(Columnas, tabla);
    }

    public boolean agregar() throws SQLException {
        setearDatos();
        if (productosDao.crear(producto)) {
            return true;
        }
        return false;
    }

    public boolean actualizar(int id) throws SQLException {
        setearDatos();
        if (productosDao.actualizar(id,producto)) {
            return true;
        }
        return false;
    }

    public void clearText(JTextField clear) {
        clear.setText("");
    }

    private boolean validateField(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
