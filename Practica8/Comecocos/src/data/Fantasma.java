/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.Comecocos.*;

/**
 * Metodo que representa a un fantasma. Sus datos miembro son las coodenadas
 * su estado para saber si es comestible y el tipo de fantasma
 * @author david
 */
public class Fantasma {
    
    public static final int AMARILLO=5;
    public static final int AZUL=6;
    public static final int ROJO=7;
    public static final int ROSA=8;
    
    private int x;
    private int y;
    private int tipo;
    private int direccion;
    private boolean comestible;
    
    public Fantasma(int tipo_){
        x = 6 + tipo_;
        y = 15;
        direccion = -1;
        tipo = tipo_;
        
    }
    
    /**
     * Metodo para fijar la direccion en la que se mueve el fantasma
     * @param direccion_ entero para fijar la direccion deseada
     */
    public void setDireccion(int direccion_){
        direccion = direccion_;
    }
    
    public void mueve(){
        if(direccion == ARRIBA){
            y--;
        }
        else if(direccion == ABAJO){
            y++;
        }
        else if(direccion == DERECHA){
            x++;
        }
        else if(direccion == IZQUIERDA){
            x--;
        }
    }
    
    /**
     * Metodo para devolver cual es la direccion que tiene
     * el fantasma
     * @return 
     */
    public int getDireccion(){
        return direccion;
    }
    
    /**
     * Devuelve la coordenada y
     * @return coordenada y
     */
    public int getX(){
        return x;
    }
    
    /**
     * Devuelve la coordenada y
     * @return coordenada y
     */
    public int getY(){
        return y;
    }
    
    /**
     * Selecciona el tipo de fantasma (De entre los cuatro disponibles)
     * @param t tipo de fantasma.
     */
    public void setTipo(int t){
        tipo=t;
    }
    
    /**
     * Obtiene el tipo de fanstama
     * @return el tipo de fantasma
     */
    public int getTipo(){
        return tipo;
    }
    
}
