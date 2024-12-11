package Controladores;

import ParqueClases.Guardaparque;
import java.util.ArrayList;
import java.util.List;

public class GuardaparqueControlador {
        private List<Guardaparque> guardaparques;  // Lista para almacenar los guardaparques

    public GuardaparqueControlador() {
        this.guardaparques = new ArrayList<>();
    }

    public void agregarGuardaparque(Guardaparque guardaparque) {
        guardaparques.add(guardaparque);
    }

    public List<Guardaparque> obtenerGuardaparques() {
        return new ArrayList<>(guardaparques);
    }

    public void eliminarGuardaparque(Guardaparque guardaparque) {
        guardaparques.remove(guardaparque);
    }

    public void actualizarGuardaparque(Guardaparque guardaparque, String nombre, int antiguedad, String especialidad) {
        guardaparque.setNombre(nombre);
        guardaparque.setAntiguedad(antiguedad);
        guardaparque.setEspecialidad(especialidad);
    }
}
