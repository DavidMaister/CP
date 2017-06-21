/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejs;

import java.util.concurrent.*;

/**
 *
 * @author david
 */
public class Sept2015_8 {
    
    public static void main(String[] args){
        
        
    }
    
    public double valorMedio(int[] elementos){
        
        
        RecursiveTask<Double> task = new Tarea(elementos, 0, elementos.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }
}

class Tarea extends RecursiveTask<Double>{
    
    int[] elementos;
    int posInferior;
    int posSuperior;
    int umbral = 1000;
    
    public Tarea(int[] elementos, int posInferior, int posSuperior){
        this.elementos = elementos;
        this.posInferior = posInferior;
        this.posSuperior = posSuperior;
    }
    
    @Override
    public Double compute(){
        double suma = 0;
        if(posSuperior - posInferior < umbral){
            for(int i = posInferior; i < posSuperior; i++){
                suma = suma + elementos[i];
            }
            return suma/elementos.length;
        }
        else{
            int posMedia = (posSuperior + posInferior)/2;
            RecursiveTask<Double> derecha = new Tarea(elementos, posInferior, posMedia);
            RecursiveTask<Double> izquierda = new Tarea(elementos, posMedia, posSuperior); 
            derecha.fork();
            izquierda.fork();
            return  new Double(derecha.join().doubleValue() + izquierda.join().doubleValue()) /2;
            
        }
       
    }
}
