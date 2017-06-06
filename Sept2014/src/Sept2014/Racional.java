/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sept2014;

/**
 *
 * @author david
 */
public class Racional extends Number implements Comparable<Racional>{
    
    long numerador;
    long denominador;
    
    public Racional(){
        numerador = 0;
        denominador = 1;
    }
    
    public Racional(long numerador_, long denominador_){
        long divisor = mcd(numerador_, denominador_);
        numerador = numerador_/divisor;
        denominador = denominador_/ divisor;
    }
    
    public static void main(String[] args){
        System.out.println("MCD: "+mcd(21, 4));
        
        Number[] array = new Number[100];
    }
    
    /**
     * Calcula el minimo comun multiplo. 
     * @param num1 
     * @param num2
     * @return 
     */
    public static long mcd(long num1, long num2){
        long mcd;
        long a,b;
        if(num1 == 0){
            return num2;
        }
        if(num2 == 0){
            return num1;
        }
        if(num1 > num2){
            a = num1;
            b = num2;
        }
        else{
            a = num2;
            b = num1;
        }
        mcd = b;
        long r = a % b;
        
        for(long i = r; i > 0; i--){
            if(b % i == 0 && r % i == 0){
                mcd = i;
            }
        }
        return mcd;
    }
    
    @Override
    public int intValue(){
        return (int)(numerador/denominador);
    }
    
    @Override
    public long longValue(){
        return numerador/denominador;
    }
    
    @Override
    public float floatValue(){
        return numerador/denominador;
    }
    
    @Override
    public double doubleValue(){
        return numerador/denominador;
    }
    
    @Override
    public int compareTo(Racional r){
        return (int)(numerador/denominador - r.numerador/r.denominador);
    }
    
    /**
     * Dice si son iguales  o no
     * @param r
     * @return 
     */
    public boolean equals(Racional r){
        boolean iguales = false;
        if(numerador/denominador == r.numerador/r.denominador){
            iguales = true;
        }
       return iguales;
    }
    
    @Override
    public String toString(){
        if(denominador == 1){
            return ""+numerador;
        }
        else
            return numerador+"/"+denominador;
    }
}
