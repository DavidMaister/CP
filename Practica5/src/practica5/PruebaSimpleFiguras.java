/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class PruebaSimpleFiguras {
    
    public static void main(String[] args){
        
        double radio, alto, ancho;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el radio: ");
        Circulo circulo = new Circulo(scanner.nextDouble());
        System.out.println("Introduce el ancho y alto: ");
        Rectangulo rectangulo = new Rectangulo(scanner.nextDouble(), scanner.nextDouble());
        
        //System.out.println(circulo);      //usa el toString de la clase Circulo
        //System.out.println(rectangulo);
        
        imprime(circulo);
        imprime(rectangulo);
        
        //creamos delimitador de circulo
        System.out.println("Rectangulo delimitador de circulo: ");
        Rectangulo delimitador = rectanguloDelimitador(circulo);
        imprime(delimitador);
        
        //comparamos rectangulo y circulo
        System.out.println("Comparamos con circulo con rectagulo: "+circulo.compareTo(rectangulo));
    
    }
    
    
    //ejemplo de ligadura dinamica y polimorfismo
    static void imprime(Figura figura){
        String cadena;
        Date dateActual = new Date();
        long tiempo;
        tiempo = dateActual.getTime() - figura.getFechaCreacion().getTime();
        cadena = figura.getClass().getSimpleName();
        cadena = cadena + "\nTiempo desde su creación: "+tiempo+" milisegundos";
        cadena = cadena + "\nArea: "+figura.getArea() + "\nPerimetro: "+figura.getPerimetro();
        System.out.println(cadena);
    }
    
    //ejemplo de casting explicito y operador instanceof
    static Rectangulo rectanguloDelimitador(Figura figura){
        Rectangulo delimitador = new Rectangulo();
        if(figura instanceof Circulo){
            delimitador.setAlto(((Circulo) figura).getRadio() *2);
            delimitador.setAncho(((Circulo) figura).getRadio() *2);
        }
        else if(figura instanceof Rectangulo){
            delimitador.setAlto(((Rectangulo) figura).getAlto());
            delimitador.setAncho(((Rectangulo) figura).getAncho());
        }
        return delimitador;
    }
    
}
