package Parque;

public class Parque {
    private String Nombre;
    private String Ubicacion;
    private double Superficie;

    public Parque(String nombre, String ubicacion, double superficie) {
        this.Nombre = nombre;
        this.Ubicacion = ubicacion;
        this.Superficie = superficie;
    }

    public Parque() {
        this.Nombre = "Parque desconocido";
        this.Ubicacion = "Ubicación desconocida";
        this.Superficie = 0.0;
    }

    // Getters y Setters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public double getSuperficie() {
        return Superficie;
    }

    public void setSuperficie(double Superficie) {
        this.Superficie = Superficie;
    }

    @Override
    public String toString() {
        return "Parque{" +
                "nombre='" + Nombre + '\'' +
                ", ubicacion='" + Ubicacion + '\'' +
                ", superficie=" + Superficie +
                '}';
    }
}
