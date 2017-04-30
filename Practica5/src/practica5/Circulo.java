/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

/**
 *
 * @author david
 */
public class Circulo extends Figura implements Comparable<Figura>{
    
    private double radio;
    
    Circulo(){
        radio = 0;
    }
    
    Circulo(double radioEntrada){
        radio = radioEntrada;
    }
    
    public double getRadio(){
        return radio;
    }
    
    public void setRadio(double radioEntrada){
        radio = radioEntrada;
    }

    public double getArea() {
        double area;
        area = Math.PI*radio*radio;
        return area;
    }

    public double getPerimetro() {
        double perimetro;
        perimetro = 2*Math.PI*radio;
        return perimetro;
    }
    
    
    @Override
    public String toString(){
        String cadena = "";
        cadena = super.toString()+"\nRadio: "+getRadio();
        
        return cadena;
    }

    @Override
    public int compareTo(Figura figura) {
        return super.compareTo(figura);
        
    } 
}
