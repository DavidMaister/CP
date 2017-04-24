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
public class Rectangulo extends Figura{
    
    private double ancho;
    private double alto;
    
    Rectangulo(){
        ancho = 0;
        alto = 0;
    }
    
    Rectangulo(double anchoEntrada, double altoEntrada){
        ancho = anchoEntrada;
        alto = altoEntrada;
    }
    
    public double getAncho(){
        return ancho;
    }
    
    public void setAncho(double anchoEntrada){
        ancho = anchoEntrada;
    }
    
    public double getAlto(){
        return alto;
    }
    
    public void setAlto(double altoEntrada){
        alto = altoEntrada;
    }

    public double getArea() {
        double area;
        area = ancho * alto;
        return area;
    }

    public double getPerimetro() {
        double perimetro;
        perimetro = 2*ancho + 2*alto;
        return perimetro;
    }
    
    @Override
    public String toString(){
        String cadena = "";
        cadena = super.toString()+"\nAncho: "+getAncho()+"\nAlto: "+getAlto();
        
        return cadena;
    }
    
    
}
