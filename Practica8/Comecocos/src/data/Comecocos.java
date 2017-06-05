/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *  Clase que representa al comecocos, este necesita la
 * direccion y las coordenadas en las que se encuentra
 * @author david
 */
public class Comecocos {
    
    public static final int ARRIBA = 0;
    public static final int ABAJO = 1;
    public static final int DERECHA = 2;
    public static final int IZQUIERDA = 3;
    
    private int x;
    private int y;
    private int direccion;
    
    public Comecocos(){
        x = 1;
        y = 1;
    }
    
    
    /**
     * Metodo para fijar la direccion en la que se mueve el comecocos
     * @param direccion_ entero para fijar la direccion deseada
     */
    public void setDireccion(int direccion_){
        direccion = direccion_;
    }
    
    /**
     * Metodo que hace mover al comecocos en la direccion
     * a la que se esta moviendo
     */
    public void mueve(){
        if(direccion == ARRIBA){
            y++;
        }
        else if(direccion == ABAJO){
            y--;
        }
        else if(direccion == DERECHA){
            x++;
        }
        else if(direccion == IZQUIERDA){
            x--;
        }
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
    
}
