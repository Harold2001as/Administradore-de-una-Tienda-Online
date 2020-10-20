/*

 */
package com.pascualbravo.TiendaOnline.Servicios.impl;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Productos;
import com.pascualbravo.TiendaOnline.Servicios.iface.TiendaServicio;
import com.pascualbravo.TiendaOnline.utilidades.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Implementaciones implements TiendaServicio {

    @Override
    public void AgregarProducto(Productos producto, String Ruta) throws IOException {

        if (!Util.ComprobarExistencia(Ruta)) {//Verificar que el archivo de esa ruta no exista 
            File file = new File(Ruta);//Instancia la clase file y crea el objeto
            file.createNewFile();//crea el archivo
        }
        //la clase filewriter sirve para escribir en el archivo
        FileWriter EscribirEnArchivo = new FileWriter(Ruta, true);//Instancia la clase filewriter y crea el objeto
        EscribirEnArchivo.write(producto.toString());
        EscribirEnArchivo.close();
        Util.ComprobarExistencia(Ruta);
    }

    @Override
    public void BorrarProducto(int idProducto, String Ruta) throws IOException {
        String[][] m = new String[1][1];//Inicializamos Una matriz
        m = MostrarProductos(Ruta);
//Buscamos y Borramos
        for (int i = 0; i < m.length; i++) {
            if (m[i][0].equals(Integer.toString(idProducto))) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = "VACIO";
                }
            }
        }
//limipiamos el documento de texto
        BufferedWriter Leer = new BufferedWriter(new FileWriter(Ruta));
        Leer.write("");
//Agregamos Al documento
        String Con = "";
        FileWriter Escribir = new FileWriter(Ruta);
        for (int i = 0; i < m.length; i++) {
            if (!m[i][0].equals("VACIO")) {
                for (int j = 0; j < m[i].length; j++) {
                    Con += m[i][j] + ";";
                }
                Escribir.write(Con + "\r\n");
                Con = "";
            }
        }
        //Finalizamos 
        Leer.close();
        Escribir.close();
    }

    @Override
    public void ActualizarProducto(int idProducto, Productos producto, String Ruta) throws IOException {
        String[][] m = new String[1][1];//Inicializamos Una matriz
        m = MostrarProductos(Ruta);
//Buscamos y Cambiamos
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][0].equals(Integer.toString(idProducto))) {

                    m[i][1] = producto.getNombre();
                    m[i][2] = producto.getDescripcion();
                    m[i][3] = Float.toString(producto.getPrecio());
                    m[i][4] = Integer.toString(producto.getStock());
                    m[i][5] = (producto.getFecha()).toString();
                    m[i][6] = producto.getImagen();
                    m[i][7] = Integer.toString(producto.getId_Proveedores());
                    m[i][8] = Integer.toString(producto.getId_Categoría());
                }
            }
        }
//limipiamos el documento de texto
        BufferedWriter Leer = new BufferedWriter(new FileWriter(Ruta));
        Leer.write("");
//Agregamos Al documento
        String Con = "";
        FileWriter Escribir = new FileWriter(Ruta);
        for (int i = 0; i < m.length; i++) {
            if (!m[i][0].equals("VACIO")) {
                for (int j = 0; j < m[i].length; j++) {
                    Con += m[i][j] + ";";
                }
                Escribir.write(Con + "\r\n");
                Con = "";
            }
        }
        //Finalizamos 
        Leer.close();
        Escribir.close();
    }

    @Override
    public String[][] MostrarProductos(String Ruta) throws IOException {
        String[][] Matriz;//matriz a la que le vamos asignar los datos
        BufferedReader LeerArchivo = new BufferedReader(new FileReader(Ruta));
        String LineaActual;//Esta Variable es la que toma toda la linea del txt
        int contador = 0;//Esta variable sirve para recorrer la matriz

        Matriz = new String[(int) LeerArchivo.lines().count()][9];
        LeerArchivo = new BufferedReader(new FileReader(Ruta));

        while ((LineaActual = LeerArchivo.readLine()) != null) {
            String[] Contenido = LineaActual.split(";");
            for (int i = 0; i < 9; i++) {
                Matriz[contador][i] = Contenido[i];
            }
            contador++;
        }
        LeerArchivo.close();
        return Matriz;
    }

    public Productos BuscarIdProducto(int idProducto, String Ruta) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            if (!Util.ComprobarExistencia(Ruta)) {
                return null;
            }
            bufferedReader = new BufferedReader(new FileReader(Ruta));
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] lineas = linea.split(";");
                if (idProducto == Integer.parseInt(lineas[0])) {
                    Productos producto = new Productos();
                    return producto;
                }
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return null;
    }
}
