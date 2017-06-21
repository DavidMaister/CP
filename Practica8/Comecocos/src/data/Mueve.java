/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import guicomecocos.ComecocosFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    /**
     * Metodo que ejecuta la hebra principal que haga que se muevan los 
     * componentes del comecocos. Es un bucle que provoca que se muevan
     * los elementos.
     */
    public void run(){
        System.out.println("Empieza run");
        
        try {
            
            while(continuar){
                
            Thread.sleep(800);
            if(!frame.getLaberinto().seChoca(frame.getComecocos(), frame.getComecocos().getDireccion())){
                System.out.println("Se mueve");
                frame.getComecocos().mueve();
                System.out.println("PacMan esta en: "+frame.getComecocos().getX()+", " +frame.getComecocos().getY());
            }
            if(frame.getLaberinto()!=null)
                frame.getPanel().repaint();
            
            
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Mueve.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion en la mueve");
        }
        
    }
    
    
    
    

}
