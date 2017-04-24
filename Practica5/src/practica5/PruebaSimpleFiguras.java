/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

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
        
        System.out.println(circulo);
        System.out.println(rectangulo);
    
    }
    
}
