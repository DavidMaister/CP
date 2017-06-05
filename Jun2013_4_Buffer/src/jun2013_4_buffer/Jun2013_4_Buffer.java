/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jun2013_4_buffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author david
 */
public class Jun2013_4_Buffer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int dim = 4;
        
        ExecutorService programa = Executors.newCachedThreadPool();
        Buffer buffer = new Buffer(dim);
        
        Consumidor consumidor = new Consumidor(buffer, dim);
        Productor productor = new Productor(buffer, dim);
        
        programa.execute(consumidor);
        programa.execute(productor);
        programa.shutdown();
    }
    
}
