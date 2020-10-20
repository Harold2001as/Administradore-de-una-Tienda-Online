
/*
*-INTERFAZ-
*En esta Interfaz vamos a crear todos los metodos Abstractos que va a utilizar
*nuestro proyecto
*/
package com.pascualbravo.TiendaOnline.Servicios.iface;

import com.pascualbravo.TiendaOnline.ClasesPropiedades.Productos;
import java.io.IOException;


public interface TiendaServicio {
   
    
    public void AgregarProducto(Productos producto, String Ruta) throws IOException;

    public void BorrarProducto(int idProducto, String Ruta)throws IOException;
    
    public void ActualizarProducto(int idProducto, Productos producto, String Ruta)throws IOException;
    public Productos BuscarIdProducto(int idProducto, String Ruta) throws IOException ;
    
    public String[][] MostrarProductos(String Ruta)throws IOException;

}
//    public Movie getMovieById(int id, String path) throws IOException;  
//    public List<Movie> getMovies(String path) throws IOException;