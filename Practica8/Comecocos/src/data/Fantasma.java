/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.Comecocos.*;

/**
 * Metodo que representa a un fantasma. Sus datos miembro son las coodenadas,
 * la direccion y el tipo de fantasma
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
     * Establece la coordenada x
     * @param x_ coordenada x
     */
    public void setX(int x_){
        x = x_;
    }
    
    
    /**
     * Establece la coordenada y
     * @param y_ coordenada y
     */
    public void setY(int y_){
        y = y_;
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
