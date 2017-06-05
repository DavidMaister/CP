/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sept2013_4_fork;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author david
 */
public class MaxTask extends RecursiveTask<Integer> {
    
    private final static int UMBRAL = 1000;
    private int[] lista;
    private int posInferior;
    private int posSuperior;

    public MaxTask(int[] lista, int posInferior, int posSuperior) {
        this.lista = lista;
        this.posInferior = posInferior;
        this.posSuperior = posSuperior;
    }
    
    
    @Override
    public Integer compute(){
        if (posSuperior - posInferior < UMBRAL) {
            int max = lista[0];
            for (int i = posInferior; i < posSuperior; i++)
                if (lista[i] > max)
                    max = lista[i];
            return new Integer(max);
        }
        else {
            int posMedia = (posInferior + posSuperior) / 2;
            RecursiveTask<Integer> izquierda = new MaxTask(lista, posInferior, posMedia);
            RecursiveTask<Integer> derecha = new MaxTask(lista, posMedia, posSuperior);
            derecha.fork();
            izquierda.fork();
            return new Integer(Math.max(izquierda.join().intValue(), derecha.join().intValue()));
        }
        
    }
    
}
