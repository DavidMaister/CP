/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import guicomecocos.ComecocosFrame;
import java.util.Random;
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
     * @param fr frame a utilizar
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
    @Override
    public void run(){
        int dirAmarillo;
        int dirAzul;
        int dirRojo;
        int dirRosa;
        int contadorFan = 100;
        System.out.println("Empieza run");
        
        try {
            while(continuar){
                synchronized(this){
                    while(suspendFlag){
                        wait();
                    }
                }
                Thread.sleep(300);
                //movemos al comecococos
                if(!frame.getLaberinto().seChoca(frame.getComecocos(), frame.getComecocos().getDireccion())){
                    frame.getComecocos().mueve();
                    frame.getLaberinto().actualizaMapa(frame.getComecocos());
                }
                
                //para que vayan saliendo cada poco le añadimos contadores a los fantasmas
                if(contadorFan < 95){
                    //movemos al amarillo
                    frame.getAmarillo().setDireccion(getDireccionFantasmaChase(frame.getAmarillo()));
                    if(!frame.getLaberinto().seChoca(frame.getAmarillo(), frame.getAmarillo().getDireccion())){
                        frame.getAmarillo().mueve(); 
                    }
                }
                
                if(contadorFan < 75){
                    //movemos al azul
                    frame.getAzul().setDireccion(getDireccionFantasmaChase(frame.getAzul()));
                    if(!frame.getLaberinto().seChoca(frame.getAzul(), frame.getAzul().getDireccion())){
                        frame.getAzul().mueve();
                    }
                }
                
                if(contadorFan < 50){
                    //movemos al rojo
                    frame.getRojo().setDireccion(getDireccionFantasmaRandom(frame.getRojo()));
                    if(!frame.getLaberinto().seChoca(frame.getRojo(), frame.getRojo().getDireccion())){
                        frame.getRojo().mueve();
                    }
                }
                
                if(contadorFan < 25){
                    //movemos al rosa
                    frame.getRosa().setDireccion(getDireccionFantasmaRandom(frame.getRosa()));
                    if(!frame.getLaberinto().seChoca(frame.getRosa(), frame.getRosa().getDireccion())){
                        frame.getRosa().mueve();
                    }
                }
                
                
                //cada iteracion el contador decrementa
                if(contadorFan > 20)
                    contadorFan--;
                
                //repintamos
                if(frame.getLaberinto()!=null)
                    frame.getPanel().repaint();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Mueve.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion en metodo run de mueve");
        }
    }
    
    
    /**
     * Metodo para decidir cual debe ser la direccion que debe
     * tomar el fantasma. Para ello se calcula la direccion que sea que más
     * acerque el fantasma al comecocos
     * @param fan fantasma dado para calcular la direccion
     * @return devuleve la direccion indicando la direccion a seguir
     */
    public int getDireccionFantasmaChase(Fantasma fan){
        int inverso = getSentidoInverso(fan.getDireccion());
        double minimo = Double.POSITIVE_INFINITY;
        int direccion = fan.getDireccion(); //valor de inicializacion
        
        if(fan.getX() == 0 || fan.getX() == 27)
            return inverso;     //caso que el fantasma se queda encerrado en el limite del mapa
        
        if(Comecocos.ARRIBA != inverso && !frame.getLaberinto().seChoca(fan, Comecocos.ARRIBA)){
            if(distancia(fan.getX(), fan.getY() - 1) < minimo){      //calculamos la distancia con la poscion si se moviera hacia arriba
                direccion = Comecocos.ARRIBA;
                minimo = distancia(fan.getX(), fan.getY() - 1);
            }
        }
        if(Comecocos.ABAJO != inverso && !frame.getLaberinto().seChoca(fan, Comecocos.ABAJO)){
            if(distancia(fan.getX(), fan.getY() + 1) < minimo){      //posicion si se moviera hacia abajo
                direccion = Comecocos.ABAJO;
                minimo = distancia(fan.getX(), fan.getY() + 1);
            }
        }
        if(Comecocos.DERECHA != inverso && !frame.getLaberinto().seChoca(fan, Comecocos.DERECHA)){
            if(distancia(fan.getX() + 1, fan.getY()) < minimo){      //posicion si se moviera hacia la derecha
                direccion = Comecocos.DERECHA;
                minimo = distancia(fan.getX() + 1, fan.getY());
            }
        }
        if(Comecocos.IZQUIERDA != inverso && !frame.getLaberinto().seChoca(fan, Comecocos.IZQUIERDA)){
            if(distancia(fan.getX() - 1, fan.getY()) < minimo){      //posicion si se moviera hacia la izquierda
                direccion = Comecocos.IZQUIERDA;
                minimo = distancia(fan.getX() - 1, fan.getY());
            }
        }
        return direccion;
    }
    
    /**
     * Metodo para calcular cual debe ser la siguiente direccion
     * tomada por el fantasma. Para ello la direccion se toma de forma 
     * aleatoria, salvo por que no puede ir en sentido inverso a su direccion
     * @param fan fantasma dado para calcular su siguiente direccion
     * @return entero que indica la direccion que debe tomar
     */
    public int getDireccionFantasmaRandom(Fantasma fan){
        int inverso = getSentidoInverso(fan.getDireccion());
        int direccion = fan.getDireccion(); //incializamos variable
        Random random = new Random();
        boolean enabled = false;
        if((fan.getX() == 1 || fan.getX() == 26) && fan.getY() == 14 )
            return inverso;  //caso que el fantasma se queda encerrado en el limite del mapa
        while(!enabled){
            direccion = random.nextInt(4);  ///hay 4 posibles direcciones
            if(direccion != inverso && !frame.getLaberinto().seChoca(fan, direccion))
                enabled = true;
        }
        return direccion;
    }
    
    /**
     * Devuelve cual es el sentido inverso de la direccion actual
     * @param direccion direccion actual
     * @return 
     */
    public int getSentidoInverso(int direccion){
        int sentido = 0;
        switch (direccion) {
            case Comecocos.ABAJO:
                sentido = Comecocos.ARRIBA;
                break;
            case Comecocos.ARRIBA:
                sentido = Comecocos.ABAJO;
                break;
            case Comecocos.DERECHA:
                sentido = Comecocos.IZQUIERDA;
                break;
            case Comecocos.IZQUIERDA:
                sentido = Comecocos.DERECHA;
                break;
            default:
                break;
        }
        return sentido;
    }
    
    /**
     * Devuelve la distancia desde unas coordenadas hasta el comecocos
     * @param x coordenada x
     * @param y coordenada y
     * @return 
     */
    public double distancia(int x, int y){
        double distancia;
        distancia = Math.sqrt((x-frame.getComecocos().getX())*(x-frame.getComecocos().getX()) + 
                (y-frame.getComecocos().getY())*(y-frame.getComecocos().getY()));
        return distancia;
    }
    
    /**
     * Detiene momentaneamente la ejecución de la hebra, haciendo que la Figura actual
     * quede parada.
     */
    synchronized public void suspender(){
        frame.getPanel().repaint();
        suspendFlag=true;
    }
    
    /**
     * Reanuda el movimiento de la hebra. La Figura actual vuelve  a moverse.
     */
    public synchronized void reanudar(){
        if(frame.getPanel()!=null)
            frame.getPanel().repaint();
        suspendFlag = false;
        notify();
    }
    
    /**
     * Termina la ejecución de la hebra.
     */
    public void terminar(){
        continuar=false;
    }
    
    /**
     * Devuelve si la hebra ha terminado su ejecución
     * @return true si la hebra ha terminado su ejecución
     */
    public boolean getTerminado(){
        return !continuar;
    }
    
    /**
     * Nos dice si la hebra está o no parada.
     * @return true si la hebra de movimiento está parada, false en otro caso
     */
    synchronized public boolean getParado(){
        return suspendFlag;
    }
}
