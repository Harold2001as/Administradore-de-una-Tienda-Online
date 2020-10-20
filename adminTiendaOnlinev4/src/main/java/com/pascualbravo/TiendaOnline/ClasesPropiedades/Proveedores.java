package com.pascualbravo.TiendaOnline.ClasesPropiedades;

public class Proveedores {

    private int proveedor_id;
    private String nombre;
    private String telefono;
    private String direccion;

    /**
     * @return the proveedor_id
     */
    public int getProveedor_id() {
        return proveedor_id;
    }

    /**
     * @param proveedor_id the proveedor_id to set
     */
    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
