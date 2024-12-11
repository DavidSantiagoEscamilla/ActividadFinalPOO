package Controladores;

import ParqueClases.Parque;
import java.util.ArrayList;
import java.util.List;

public class ParqueControlador {
    private List<Parque> parques;  

    public ParqueControlador() {
        this.parques = new ArrayList<>();
    }

    public void agregarParque(Parque parque) {
        parques.add(parque);
    }

    public List<Parque> obtenerParques() {
        return new ArrayList<>(parques);
    }

    public void eliminarParque(Parque parque) {
        parques.remove(parque);
    }

    public void actualizarParque(Parque parque, String nombre, String ubicacion, double superficie) {
        parque.setNombre(nombre);
        parque.setUbicacion(ubicacion);
        parque.setSuperficie(superficie);
    }
}
