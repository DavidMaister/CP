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
public class CalculoAreaPoligono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner conin = new Scanner(System.in);
        int n;
        
        System.out.println("Introdude numero de puntos del poligono:");
        n = conin.nextInt();
        //Creamos el poligono
        Poligono poli = new Poligono();
        Punto punto = new Punto();
        
        //leemos por la entrada estandar los puntos uno a uno
        for(int i= 0; i < n; i++){
            punto.leer(conin);
            poli.addPunto(punto);
        }
        System.out.println("El poligono introducido es:");
        System.out.println(poli.toString());
        
        
        System.out.println("El perimetro del poligono es: "+poli.perimetro());
    }
    
}
