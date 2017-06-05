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
public class Consumidor implements Runnable{
    
    Buffer buffer;
    int contador;
    int longitud;
    
    public Consumidor(Buffer buffer_, int longitud_){
        buffer = buffer_;
        contador = 0;
        longitud = longitud_;
    }
    
    @Override
    public void run(){
        while(contador < longitud){
           try{
               buffer.get();
               contador++;
               System.out.println("Consumidor consume. contador: "+contador);
           } catch (InterruptedException ex){
               ex.getStackTrace();
           }
       }
    }
    
    public int getContador(){
        return contador;
    }
}
