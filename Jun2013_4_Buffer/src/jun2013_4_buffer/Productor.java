/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jun2013_4_buffer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Productor implements Runnable{
    
    int longitud;
    Buffer buffer;
    
    public Productor(Buffer buffer_, int dim){
        longitud = dim;
        buffer = buffer_;
    }
    
    @Override
    public void run(){
        //bucle en el que insertamos los numeros que nos dice la variable longitud
        for(int i= 0; i < longitud; i++){
            try {
                buffer.set(i);
                System.out.println("Productor produce");
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }
    }
}
