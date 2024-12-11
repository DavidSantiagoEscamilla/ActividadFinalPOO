/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueClases;

public class Atraccion 
{
    private String Nombre;
    private String Tipo;
    private double Precio;

    public Atraccion(String Nombre, String Tipo, double Precio) 
    {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Precio = Precio;
    }

    
    public Atraccion() 
    {
        this.Nombre = "Atraccion Desconocida";
        this.Tipo = "Tipo de Atraccion Desconocido";
        this.Precio = 0.0;
    }

    
    public String getNombre() 
    {
        return Nombre;
    }

    public void setNombre(String Nombre) 
    {
        this.Nombre = Nombre;
    }

    public String getTipo() 
    {
        return Tipo;
    }

    public void setTipo(String Tipo) 
    {
        this.Tipo = Tipo;
    }

    public double getPrecio() 
    {
        return Precio;
    }

    public void setPrecio(double Precio) 
    {
        this.Precio = Precio;
    }

    @Override
    public String toString() 
    {
        return "Atraccion{" +
                "nombre = '" + Nombre + '\'' +
                ", tipo = '" + Tipo + '\'' +
                ", precio = " + Precio +
                '}';
    }
}
