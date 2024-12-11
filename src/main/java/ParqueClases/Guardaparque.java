/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueClases;

public class Guardaparque 
{
    private String Nombre;
    private int Antiguedad;
    private String Especialidad;

    public Guardaparque(String Nombre, int Antiguedad, String Especialidad) 
    {
        this.Nombre = Nombre;
        this.Antiguedad = Antiguedad;
        this.Especialidad = Especialidad;
    }

    
    public Guardaparque() 
    {
        this.Nombre = "No hay GuardaParque";
        this.Especialidad = "Sin GuardaParque";
        this.Antiguedad = 0;
    }

    
    public String getNombre() 
    {
        return Nombre;
    }

    public void setNombre(String Nombre) 
    {
        this.Nombre = Nombre;
    }

    public int getAntiguedad() 
    {
        return Antiguedad;
    }

    public void setAntiguedad(int antiguedad) 
    {
        this.Antiguedad = antiguedad;
    }

    public String getEspecialidad() 
    {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) 
    {
        this.Especialidad = Especialidad;
    }

    @Override
    public String toString() 
    {
        return "Guardaparque{" +
                "nombre = '" + Nombre + '\'' +
                ", antiguedad = " + Antiguedad +
                ", especialidad = '" + Especialidad + '\'' +
                '}';
    }
}
