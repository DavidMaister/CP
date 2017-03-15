/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoareapoligono;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class Punto {
    
    private double coordx, coordy;
    
    Punto(){
        coordx = 0;
        coordy = 0;
    }
    
    public double getX(){
        return coordx;
    }
    
    public double getY(){
        return coordy;
    }
    
    public void setCoordenadas(double x, double y){
        coordx = x;
        coordy = y;
    }
    
    
    public void leer(Scanner conin){
        System.out.print("Introduce las coordenadas x e y separadas por un espacio: ");
        coordx = conin.nextDouble();
        coordy = conin.nextDouble();
    }
    
    
    public String toString(){
    
    return coordx+" "+coordy;
    }
    
    
    public double calcularDistanciaEuclidea(Punto punto){
        // distancia es la raiz de la diferencia de cada coordenada al cuadrado
        double distancia;
        distancia = Math.sqrt((coordx-punto.coordx)*(coordx-punto.coordx) + (coordy-punto.coordy)*(coordy-punto.coordy));
        return distancia;
    }
    public Punto calcularPuntoMedio(Punto punto){
        Punto puntoMedio = new Punto();
        puntoMedio.coordx = (punto.coordx + coordx)/2;
        puntoMedio.coordy = (punto.coordy + coordy)/2;
    
    
        return puntoMedio;
    }
    
}
