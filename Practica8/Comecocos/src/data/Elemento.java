/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author david
 */
public class Elemento {
    
    private int fila;
    private int columna;
    /** 
     * Creates a new instance of Elemento 
     * @param f fila
     * @param c columna
     */
    public Elemento(int f,int c) {
        fila=f;
        columna=c;
    }
    
    /**
     * Obtiene la fila de este Elemento
     * @return la fila de este Elemento
     */
    public int getFila(){
        return fila;
    }
    
     /**
     * Obtiene la columna de este Elemento
     * @return la columna de este Elemento
     */
    public int getColumna(){
        return columna;
    }
    
    /**
     * Define la fila de este Elemento
     * @param valor el nuevo valor para la fila de este Elemento
     */
    public void setFila(int valor){
        fila=valor;
    }
    
    /**
     * Define la columna de este Elemento
     * @param valor el nuevo valor para la columna de este Elemento
     */    
    public void setColumna(int valor){
        columna=valor;
    }
    
}
