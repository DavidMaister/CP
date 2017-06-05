/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jun2013_4_buffer;

/**
 *
 * @author david
 */
public class Buffer {
    
    int[] arrayInt;
    boolean ocupado;
    int posicion;
    
    
    /**
     * Constructor del buffer
     * @param dim 
     */
    public Buffer(int dim){
        arrayInt = new int[dim];
        ocupado = false;
        posicion = 0;
    }
    
    public synchronized void set(int num) throws InterruptedException{
        while(ocupado == true){
            wait();
        }
        
        arrayInt[posicion] = num;
        System.out.println("El productor escribe: "+num+" en la posicion: "+posicion);
        posicion++;
        ocupado = true;
        notifyAll();
    }
    
    public synchronized int get() throws InterruptedException{
        while(ocupado == false){
            wait();
        }
        ocupado = false;
        notifyAll();
        System.out.println("El consumidor lee de la posicion: "+(posicion - 1));
        return arrayInt[posicion - 1];
    }
}
