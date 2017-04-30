/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

/**
 *
 * @author david
 */
public class ComparableAlgoritmos {
    
    static Figura mayor(Figura[] array){
        int mayor = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i].compareTo(array[mayor]) > 0){
                mayor = i;
            }
        }
        return array[mayor];
    }
    
    static void ordena(Figura[] array){
        int j;
        boolean flag = true;   
        Figura aux;   //holding variable

        //ordenar mediante burbuja
        while(flag){
            flag= false;    //set flag to false awaiting a possible swap
            for( j=0; j < array.length - 1; j++){
                if(array[j].compareTo(array[j + 1]) > 0){   // intercambiamos si es
                    aux = array[j];               
                    array[j] = array[j+1];
                    array[j+1] = aux;
                    flag = true;             
                } 
            } 
        } 
    }
    
}
