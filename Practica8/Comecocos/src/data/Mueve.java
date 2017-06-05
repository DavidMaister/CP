/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import guicomecocos.ComecocosFrame;

/**
 * Esta clase implementa una hebra que hace que se mueva continuamente el comecocos.
 * La hebra se encarga también de ir refrescando la pantalla
 * dónde se dibuja todo. Además controla si la Figura
 * choca. 
 */
public class Mueve implements Runnable{
    private int delay;
    private boolean continuar;
    private boolean suspendFlag;
    private ComecocosFrame frame;
    private int nivelActual;
       
    /**
     * Constructor de la clase, que inicializa la referencia utilizadas por
     * la hebra al TetrisMidlet, establece el retardo en milisegundos
     * entre movimiento y movimiento de la Figura actual, y comienza a ejecutar
     * la hebra. 
     */
    public Mueve(ComecocosFrame fr,int nivel){
        frame=fr;
        //delay= actualizaRetardo(nivel);
        nivelActual = nivel;
        continuar=true;
        suspendFlag=true;
    }
    
    

}
