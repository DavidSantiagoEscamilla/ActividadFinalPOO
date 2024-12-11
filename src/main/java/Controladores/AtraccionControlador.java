package Controladores;

import ParqueClases.Atraccion;
import java.util.ArrayList;
import java.util.List;

public class AtraccionControlador {
        private List<Atraccion> atracciones; 

    public AtraccionControlador() {  
        this.atracciones = new ArrayList<>();
    }

    public void agregarAtraccion(Atraccion atraccion) {
        atracciones.add(atraccion);
    }

    public List<Atraccion> obtenerAtracciones() {
        return new ArrayList<>(atracciones);
    }

    public void eliminarAtraccion(Atraccion atraccion) {
        atracciones.remove(atraccion);
    }

    public void actualizarAtraccion(Atraccion atraccion, String nombre, String tipo, double precio) {
        atraccion.setNombre(nombre);
        atraccion.setTipo(tipo);
        atraccion.setPrecio(precio);
    }

}
