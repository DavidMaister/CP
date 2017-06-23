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
    private int vidas;
    long timeInicio = System.currentTimeMillis()/1000;
    long timeReferencia;
    long timeNivel;
    long timeRestante ;
       
    /**
     * Constructor de la clase, que inicializa la referencia utilizadas por
     * la hebra al TetrisMidlet, establece el retardo en milisegundos
     * entre movimiento y movimiento de la Figura actual, y comienza a ejecutar
     * la hebra. 
     * @param fr frame a utilizar
     */
    public Mueve(ComecocosFrame fr,int nivel){
        frame=fr;
        nivelActual = nivel;
        delay= actualizaRetardo(nivelActual);
        continuar=true;
        suspendFlag=true;
        timeNivel = 100 - 5 * nivelActual;
        timeRestante = timeNivel;
    }
    
    
    /**
     * Metodo que ejecuta la hebra principal que haga que se muevan los 
     * componentes del comecocos. Es un bucle que provoca que se muevan
     * los elementos.
     */
    @Override
    public void run(){
        long timeAnterior = timeInicio;
        
        int dirAmarillo;
        int dirAzul;
        int dirRojo;
        int dirRosa;
        int contadorFan = 100;
        int contadorComestible = 0;
        int puntosActual = 0;
        int contadorMuerteAmarillo = 0;
        int contadorMuerteAzul = 0;
        int contadorMuerteRojo = 0;
        int contadorMuerteRosa = 0;
        int puntosComestible = 100; //para poder llevar la cuenta de los fantasmas que se comen
                              //pudiendo asi dar mas puntos conforme mas fantasmas se comen en
                              //el periodo que dura un comestible
        System.out.println("Empieza run");
        vidas = 3;
        
        try {
            while(continuar){
                synchronized(this){
                    while(suspendFlag){
                        wait();
                    }
                }
                Thread.sleep(delay);
                //movemos al comecococos
                if(!frame.getLaberinto().seChoca(frame.getComecocos(), frame.getComecocos().getDireccion())){
                    frame.getComecocos().mueve();
                    puntosActual = frame.getLaberinto().actualizaMapa(frame.getComecocos());
                }
                //si pasamos por una ficha grande pasamos al estado de comestible
                //durante un periodo de tiempo
                if(puntosActual == 50){
                    contadorComestible = 22;
                    frame.getLaberinto().setComestible(true);
                    puntosComestible = 100;
                }
                
                //comprobamos si comemos ficha y si era la ultima para actualizar el nivel
                if(puntosActual > 0 && frame.getLaberinto().finNivel()){
                    
                    nivelActual++;
                    delay = actualizaRetardo(nivelActual);
                    //añadimos la puntuacion del tiempo que le resta al nivel
                    frame.getLaberinto().aumentaPuntuacion((int) (timeRestante * 10));
                }
                
                //para que vayan saliendo cada poco le añadimos contadores a los fantasmas
                if(contadorFan < 95 && contadorMuerteAmarillo == 0){
                    //movemos al amarillo
                    frame.getAmarillo().setDireccion(getDireccionFantasmaChase(frame.getAmarillo()));
                    if(!frame.getLaberinto().seChoca(frame.getAmarillo(), frame.getAmarillo().getDireccion())){
                        frame.getAmarillo().mueve();
                    }
                }
                
                if(contadorFan < 75 && contadorMuerteAzul == 0){
                    //movemos al azul
                    frame.getAzul().setDireccion(getDireccionFantasmaChase(frame.getAzul()));
                    if(!frame.getLaberinto().seChoca(frame.getAzul(), frame.getAzul().getDireccion())){
                        frame.getAzul().mueve();
                    }
                }
                
                if(contadorFan < 50 && contadorMuerteRojo == 0){
                    //movemos al rojo
                    frame.getRojo().setDireccion(getDireccionFantasmaRandom(frame.getRojo()));
                    if(!frame.getLaberinto().seChoca(frame.getRojo(), frame.getRojo().getDireccion())){
                        frame.getRojo().mueve();
                    }
                }
                
                if(contadorFan < 25 && contadorMuerteRosa == 0){
                    //movemos al rosa
                    frame.getRosa().setDireccion(getDireccionFantasmaRandom(frame.getRosa()));
                    if(!frame.getLaberinto().seChoca(frame.getRosa(), frame.getRosa().getDireccion())){
                        frame.getRosa().mueve();
                    }
                }
                
                //cada iteracion el contador de salida de los fantasmas decrementa hasta que no haga falta
                if(contadorFan > 1)
                    contadorFan--;
                
                //comprobamos si comemos al amarillo
                if(frame.getComecocos().getX() == frame.getAmarillo().getX() &&
                       frame.getComecocos().getY() == frame.getAmarillo().getY()){
                    if(frame.getLaberinto().getComestible()){
                        frame.getAmarillo().setX(6 + frame.getAmarillo().getTipo());
                        frame.getAmarillo().setY(15);
                        contadorMuerteAmarillo = 15;
                        //añadimos los puntos correspondientes
                        puntosComestible = puntosComestible *2;
                        frame.getLaberinto().aumentaPuntuacion(puntosComestible);
                    }
                    else{
                        reiniciar();
                        vidas--;
                    }
                }
                
                //comprobamos si comemos al azul
                if(frame.getComecocos().getX() == frame.getAzul().getX() &&
                       frame.getComecocos().getY() == frame.getAzul().getY()){
                    if(frame.getLaberinto().getComestible()){
                        frame.getAzul().setX(6 + frame.getAzul().getTipo());
                        frame.getAzul().setY(15);
                        contadorMuerteAzul = 15;
                        //añadimos los puntos correspondientes
                        puntosComestible = puntosComestible *2;
                        frame.getLaberinto().aumentaPuntuacion(puntosComestible);
                    }
                    else{
                        reiniciar();
                        vidas--;
                    }
                }
                
                //comprobamos si comemos al rojo
                if(frame.getComecocos().getX() == frame.getRojo().getX() &&
                       frame.getComecocos().getY() == frame.getRojo().getY()){
                    if(frame.getLaberinto().getComestible()){
                        frame.getRojo().setX(6 + frame.getRojo().getTipo());
                        frame.getRojo().setY(15);
                        contadorMuerteRojo = 15;
                        //añadimos los puntos correspondientes
                        puntosComestible = puntosComestible *2;
                        frame.getLaberinto().aumentaPuntuacion(puntosComestible);
                    }
                    else{
                        reiniciar();
                        vidas--;
                    }
                }
                
                //comprobamos si comemos al rosa
                if(frame.getComecocos().getX() == frame.getRosa().getX() &&
                       frame.getComecocos().getY() == frame.getRosa().getY()){
                    if(frame.getLaberinto().getComestible()){
                        frame.getRosa().setX(6 + frame.getRosa().getTipo());
                        frame.getRosa().setY(15);
                        contadorMuerteRosa = 15;
                        //añadimos los puntos correspondientes
                        puntosComestible = puntosComestible *2;
                        frame.getLaberinto().aumentaPuntuacion(puntosComestible);
                        
                    }
                    else{
                        reiniciar();
                        vidas--;
                    }
                }
                
                //si estamos en estado de comestible comprobamos la situacion
                if(contadorComestible > 0){
                    contadorComestible--;
                    //si llegamos a 0 en elcontador se acaba el estado de comestible
                    if(contadorComestible == 0){
                        frame.getLaberinto().setComestible(false);
                    }
                }
                
                //acortamos los contadores de muerte de los fantasmas en caso de que haga falta
                if(contadorMuerteAmarillo > 0)
                    contadorMuerteAmarillo--;
                if(contadorMuerteAzul > 0)
                    contadorMuerteAzul--;
                if(contadorMuerteRojo > 0)
                    contadorMuerteRojo--;
                if(contadorMuerteRosa > 0)
                    contadorMuerteRosa--;
                
                //comprobamos el tiempo restante
                if(timeAnterior != System.currentTimeMillis()/1000-timeInicio){
                    timeAnterior = System.currentTimeMillis()/1000-timeInicio;
                    timeRestante--;
                }
                if(timeRestante == 0){
                    vidas--;
                    reiniciar();
                }
                
                
                //actualizamos los textos a mostrar
                frame.setPuntuacion(frame.getLaberinto().getPuntuacion());
                frame.setVidas(vidas);
                frame.setNivel(nivelActual);
                frame.setTime(System.currentTimeMillis()/1000-timeInicio);
                frame.setRestante(timeRestante);
                
                if(vidas == 0){
                    System.out.println("Has perdido la partida.");
                    System.out.println("Puntuacion: "+frame.getLaberinto().getPuntuacion());
                    try{
                    frame.setRecord(frame.getLaberinto().getPuntuacion());
                    } catch(RuntimeException ex){
                        System.out.println("Error en la llamada a establecer el record");
                    }
                    terminar();
                }
                
                //repintamos
                if(frame.getLaberinto()!=null)
                    frame.getPanel().repaint();
            }
            reiniciar();
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
        double maximo = Double.NEGATIVE_INFINITY;
        int direccionMin = fan.getDireccion(); //valor de inicializacion
        int direccionMax = fan.getDireccion();
        int direccion = fan.getDireccion();

            if(fan.getX() == 0 || fan.getX() == 27)
                return inverso;     //caso que el fantasma se queda encerrado en el limite del mapa

            if(Comecocos.ARRIBA != inverso && !frame.getLaberinto().seChoca(fan, Comecocos.ARRIBA)){
                if(distancia(fan.getX(), fan.getY() - 1) < minimo){      //calculamos la distancia con la poscion si se moviera hacia arriba
                    direccionMin = Comecocos.ARRIBA;
                    minimo = distancia(fan.getX(), fan.getY() - 1);
                }
                if(distancia(fan.getX(), fan.getY() - 1) > maximo){      //calculamos la distancia con la poscion si se moviera hacia arriba
                    direccionMax = Comecocos.ARRIBA;
                    maximo = distancia(fan.getX(), fan.getY() - 1);
                }
                
            }
            if(Comecocos.ABAJO != inverso && !frame.getLaberinto().seChoca(fan, Comecocos.ABAJO)){
                if(distancia(fan.getX(), fan.getY() + 1) < minimo){      //posicion si se moviera hacia abajo
                    direccionMin = Comecocos.ABAJO;
                    minimo = distancia(fan.getX(), fan.getY() + 1);
                }
                if(distancia(fan.getX(), fan.getY() + 1) > maximo){      //posicion si se moviera hacia abajo
                    direccionMax = Comecocos.ABAJO;
                    maximo = distancia(fan.getX(), fan.getY() + 1);
                }
            }
            if(Comecocos.DERECHA != inverso && !frame.getLaberinto().seChoca(fan, Comecocos.DERECHA)){
                if(distancia(fan.getX() + 1, fan.getY()) < minimo){      //posicion si se moviera hacia la derecha
                    direccionMin = Comecocos.DERECHA;
                    minimo = distancia(fan.getX() + 1, fan.getY());
                }
                if(distancia(fan.getX() + 1, fan.getY()) > maximo){      //posicion si se moviera hacia la derecha
                    direccionMax = Comecocos.DERECHA;
                    maximo = distancia(fan.getX() + 1, fan.getY());
                }
                
            }
            if(Comecocos.IZQUIERDA != inverso && !frame.getLaberinto().seChoca(fan, Comecocos.IZQUIERDA)){
                if(distancia(fan.getX() - 1, fan.getY()) < minimo){      //posicion si se moviera hacia la izquierda
                    direccionMin = Comecocos.IZQUIERDA;
                    minimo = distancia(fan.getX() - 1, fan.getY());
                }
                if(distancia(fan.getX() - 1, fan.getY()) > maximo){      //posicion si se moviera hacia la izquierda
                    direccionMax = Comecocos.IZQUIERDA;
                    maximo = distancia(fan.getX() - 1, fan.getY());
                }
            }
        
        //comprobamos si estamos en estado de comestible
        if(frame.getLaberinto().getComestible())
            direccion = direccionMax;
        else
            direccion = direccionMin;
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
    
    public void reiniciar(){
        frame.getComecocos().setX(1);
        frame.getComecocos().setY(1);
        frame.getComecocos().setDireccion(-1);
        frame.getAmarillo().setX(6 + frame.getAmarillo().getTipo());
        frame.getAmarillo().setY(15);
        frame.getAzul().setX(6 + frame.getAzul().getTipo());
        frame.getAzul().setY(15);
        frame.getRojo().setX(6 + frame.getRojo().getTipo());
        frame.getRojo().setY(15);
        frame.getRosa().setX(6 + frame.getRosa().getTipo());
        frame.getRosa().setY(15);
        timeRestante = timeNivel;
        suspender();
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
    
    /**
     * La siguiente función actualiza el retardo que espera la hebra
     * para mover. El nivel más lento será
     * el 0 (retardo 250) y el más rápido el 10 (retardo 50)
     */
    private int actualizaRetardo(int nivel) {
        if (nivel>10) nivel=10;
        else if (nivel<0) nivel=0;
        
        //actualizamos tambien el retardo
        timeNivel = 100 - 5 * nivelActual;
        timeRestante = timeNivel;
        return (280-(nivel*20));
    }
}
