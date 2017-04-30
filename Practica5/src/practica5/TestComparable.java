/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author david
 */
public class TestComparable {
    
    public static void main(String[] args){
        
        Figura figura[];
        if(args.length > 2){
            figura = randomArrayFiguras(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        }
        else{
            figura = randomArrayFiguras(100, 0.4, 50);
        }
        
        int ncirculos = 0;
        for(int i = 0; i< figura.length; i++){
            if(figura[i] instanceof Circulo)
                ncirculos++;
        }
        System.out.println("Numero de circulos: "+ncirculos);
        
        //mostramos por pantalla cual es la figura mayor
        System.out.println("La mayor figura es: ");
        Figura mayor = ComparableAlgoritmos.mayor(figura);
        System.out.println(mayor.toString());
        
        Figura clonado[] = figura.clone();
        Arrays.sort(clonado);
        
        //enseñamos el array ordenado, solo mostraremos las areas para que se vea mejor
        ComparableAlgoritmos.ordena(figura);
        for(int i = 0; i< figura.length; i++){
            System.out.println("Area: "+clonado[i].getArea());
        }
    
    }
    
    
    static Figura randomFigura(double prob, double dimMax){
        Random random = new Random();
        Figura figura;
        if(random.nextDouble() < prob){
            figura = new Circulo(random.nextDouble()*(dimMax/2));
        }
        else {
            figura = new Rectangulo( random.nextDouble()*dimMax,  random.nextDouble()*dimMax);
        }
        return figura;
    }
    
    
    static Figura[] randomArrayFiguras(int nfiguras, double prob, int dimMax){
        Figura arrayFiguras[] = new Figura[nfiguras];
        for(int i = 0; i < nfiguras; i++){
            arrayFiguras[i] = randomFigura(prob, dimMax);
        }
        return arrayFiguras;
    }
}
