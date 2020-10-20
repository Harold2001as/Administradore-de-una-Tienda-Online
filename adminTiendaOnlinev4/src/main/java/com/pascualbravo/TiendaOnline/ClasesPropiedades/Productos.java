/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pascualbravo.TiendaOnline.ClasesPropiedades;

import java.time.LocalDate;


public class Productos {
     private int id_Producto;
     private String nombre;
     private String descripcion;
     private float precio;
     private int stock;
     private LocalDate fecha;
     private String imagen;
     private int id_Proveedores; 
     private int id_Categoría;

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId_Proveedores() {
        return id_Proveedores;
    }

    public void setId_Proveedores(int id_Proveedores) {
        this.id_Proveedores = id_Proveedores;
    }

    public int getId_Categoría() {
        return id_Categoría;
    }

    public void setId_Categoría(int id_Categoría) {
        this.id_Categoría = id_Categoría;
    }
    
    @Override
    public String toString() {
        return getId_Producto()+";"+nombre+";"+descripcion+";"+precio+";"+stock+";"
                +fecha+";"+imagen+";"+id_Proveedores+";"+id_Categoría+"\r\n";
    }

}
