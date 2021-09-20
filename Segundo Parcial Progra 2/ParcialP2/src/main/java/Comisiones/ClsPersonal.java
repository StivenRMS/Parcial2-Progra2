/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comisiones;

/**
 *
 * @author ramos
 */
public class ClsPersonal {
    
    public int codigo;
    public String nombre;
    public double enero;
    public double febrero;
    public double marzo;

    @Override
    public String toString() {
        return "ClsPersonal{" + "codigo=" + codigo + ", nombre=" + nombre + ", enero=" + enero + ", febrero=" + febrero + ", marzo=" + marzo + ", Ventatotal=" + Ventatotal + ", promedio=" + promedio + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEnero() {
        return enero;
    }

    public void setEnero(double enero) {
        this.enero = enero;
    }

    public double getFebrero() {
        return febrero;
    }

    public void setFebrero(double febrero) {
        this.febrero = febrero;
    }

    public double getMarzo() {
        return marzo;
    }

    public void setMarzo(double marzo) {
        this.marzo = marzo;
    }

    public double getVentatotal() {
        return Ventatotal;
    }

    public void setVentatotal(double Ventatotal) {
        this.Ventatotal = Ventatotal;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    private double Ventatotal;
    private double promedio;
    
    
}
