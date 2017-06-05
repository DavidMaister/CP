/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sept2013_4_fork;

import java.util.concurrent.*;

/**
 *
 * @author david
 */
public class Sept2013_4_Fork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Crea una lista
        final int N = 9000000;
        int[] lista = new int[N];
        for (int i = 0; i < lista.length; i++)
        lista[i] = i;
        long tiempoInicial = System.currentTimeMillis();
        int maximo = max(lista);
        
        System.out.println("\nEl numero maximo es " + maximo);
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Numero de procesadores: " +
        Runtime.getRuntime().availableProcessors());
        System.out.println("Tiempo empleado: " + (tiempoFinal - tiempoInicial)
        + " milisegundos");

    }
    
    public static int max(int[] lista){
        RecursiveTask<Integer> task = new MaxTask(lista, 0, lista.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }
    
}
