/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejs;

/**
 *
 * @author david
 */
public class Jun2015_9 <Object>{
    
    public Object mayorArray(Object[] array){
        
        Object mayor = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i].compareTo(mayor) > 0)
                mayor = array[i];
        }
        return mayor;
    }
    
}
