/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * Esta clase representa una laberinto con una determinada Anchura
 * y Altura, en la que cada celda puede estar VACIA, contener
 * un BLOQUE (muro exterior) o un punto PEQUEÑO o GRANDE
 * y, por ultimo, una puerta.
 * El laberinto creado es 28x31
 */
public class Laberinto {
    
    //valores antiguos
    public static final char VACIA  = ' ';
    
    public static final char PEQUENA = '.'; //mismos para los nuevos
    public static final char GRANDE = 'o';
    public static final char PUERTA = 'P';
    
    //valores nuevos
    public static final char A = 'A';
    public static final char a = 'a';
    public static final char B = 'B';
    public static final char b = 'b';
    public static final char D = 'D';
    public static final char d = 'd';
    public static final char e = 'e';
    public static final char f = 'f';
    public static final char g = 'g';
    public static final char h = 'h';
    public static final char I = 'I';
    public static final char i = 'i';
    public static final char m = 'm';
    public static final char n = 'n';
    public static final char UNO = '1';
    public static final char DOS = '2';
    public static final char TRES = '3';
    public static final char CUATRO = '4';
    public static final char CINCO = '5';
    public static final char SEIS = '6';
    public static final char SIETE = '7';
    public static final char OCHO = '8';
    
    
    private int anchura = 28;
    private int altura = 31;
    private int puntuacion = 0;
    private boolean comestible;
    
    private char[][] celdas;
    
    /**
     * Crea espacio para un laberinto con anchura igual a w  y altura
     */
    public Laberinto(){
        celdas= new char[altura][anchura];
        comestible = false;
    }
    
    /**
     * Devuelve la anchura de la rejilla.
     * @return la anchura de la rejilla
     */
    public int getAnchura(){
        return anchura;
    }
    
    /**
     * Devuelve la altura de la rejilla.
     * @return la altura de la rejilla
     */
    public int getAltura(){
        return altura;
    }
    
    /**
     * Establece el tipo de celda en las coordenadas x e y de este Laberinto
     *  @param x coordenada x (columna)
     * @param y coordenada y (fila)
     * @param valor el tipo de celda (VACIA, PUERTA, BLOQUE, grande o pequeña)
     */
    public void assignTipoCelda(int x,int y,char valor){
        celdas[x][y]= valor;
    }
    
    
    
    
    private final static String rejillaInicial[]={
        "1AAAAAAAAAAAAfeAAAAAAAAAAAA2",
        "I............di............D",
        "I.5BB6.5BBB6.di.5BBB6.5BB6.D",
        "IoD  I.D   I.di.D   I.D  IoD",
        "I.7AA8.7AAA8.78.7AAA8.7AA8.D",
        "I..........................D",
        "I.5bb6.56.5bbbbbb6.56.5bb6.D",
        "I.6aa8.di.7aa65aa8.di.7aa8.D",
        "I......di....di....di......D",
        "3BBBB6.d7bb6 di 5bb8i.5BBBB4",
        "     I.d5aa8 78 7aa6i.D     ",
        "     I.di          di.D     ",
        "     I.di 5BBPPBB6 di.D     ",
        "AAAAA8.78 D      I 78.7AAAAA",
        "      .   D      I   .      ",
        "BBBBB6.56 D      I 56.5BBBBB",
        "     I.di 7AAAAAA8 di.D     ",
        "     I.di          di.D     ",
        "     I.di 5bbbbbb6 di.D     ",
        "1AAAA8.78 7aa65aa8 78.7AAAA2",
        "I............di............D",
        "I.5bb6.5bbb6.di.5bbb6.5bb6.D",
        "I.7a6i.7aaa8.78.7aaa8.d5a8.D",
        "Io..di................di..oD",
        "gb6.di.56.5bbbbbb6.56.di.5bm",
        "ha8.78.di.7aa65aa8.di.78.7an",
        "I......di....di....di......D",
        "I.5bbbb87bb6.di.5bb87bbbb6.D",
        "I.7aaaaaaaa8.78.7aaaaaaaa8.D",
        "I..........................D",
        "3BBBBBBBBBBBBBBBBBBBBBBBBBB4"
    };
    
    /**
     * Asigna el valor correspondiente a cada punto de la celda, en todas las celdas de esta
     * Rejilla.
     */
    public void initRejilla(){
        int i,j;
        int contador = 0;
        
        for(i=0; i < rejillaInicial.length; i++){
            for(j=0; j < rejillaInicial[i].length();j++){
                celdas[i][j]= rejillaInicial[i].charAt(j);
            }
        }
    }
    
    /**
     * Obtiene el tipo de celda en las coordenadas x e y de esta Rejilla
     * @param x coordenada x (columna)
     * @param y coordenada y (fila)
     * @return el tipo de Celda en la coordenada x,y.
     */
    public char getTipoCelda(int x,int y){
        return celdas[x][y];
    }
    
    /**
     * Devuelve el estado actual. (Pac persigue a fan, o fantasmas a pac).
     * @return true si es estado comestible o false si no
     */
    public boolean getComestible(){
        return comestible;
    }
    
    
    
    /**
     * Indica si al mover la figura una celda según la direccion indicada, se chocará
     * @param fig la Figura que queremos comprobar si se chocará
     * @param direccion de movimiento (Figura.ABAJO,Figura.DERECHA o FIGURA.IZQUIERDA)
     * @return true si se choca, false en caso contrario
     */
    public boolean seChoca(Comecocos fig, int direccion){
        boolean seChoca = true;
        //ojo porque la manera de x e y, no es la misma que la busqueda en una matriz
        int xPac = fig.getX();
        int yPac = fig.getY();
        int xMatriz = yPac;
        int yMatriz = xPac;
        int xSigMatriz = xMatriz;   //por incializar
        int ySigMatriz = yMatriz;   //por inicializar
        //hay que tener en cuenta como funciona getTipoCelda, devuelve las coordenadas de una matriz,
        //no funciona igual que los ejes x, y.
        //vamos a escoger con cuidado cuales son  la x y la y siguientes en la matriz
        if(direccion == Comecocos.ABAJO){
            xSigMatriz = xMatriz + 1;
            ySigMatriz = yMatriz;
        } else if(direccion == Comecocos.ARRIBA){
            xSigMatriz = xMatriz - 1;
            ySigMatriz = yMatriz;
        } else if(direccion == Comecocos.DERECHA){
            xSigMatriz = xMatriz;
            ySigMatriz = yMatriz + 1;
        } else if(direccion == Comecocos.IZQUIERDA){
            xSigMatriz = xMatriz;
            ySigMatriz = yMatriz - 1;
        }
        
        if(xSigMatriz >= altura || xSigMatriz < 0 || ySigMatriz >= anchura || ySigMatriz < 0){
            System.out.println("Alcanzado limite del mapa");
            return true;
        }
        
        //comprobamos si se choca o no
        if((getTipoCelda(xSigMatriz, ySigMatriz) == Laberinto.VACIA) || (getTipoCelda(xSigMatriz, ySigMatriz) == Laberinto.PEQUENA)  ||
           (getTipoCelda(xSigMatriz, ySigMatriz) == Laberinto.GRANDE)){
            seChoca = false;
        }
        return seChoca;
    }
    
    
    /**
     * Indica si al mover la figura una celda según la direccion indicada, se chocará
     * @param fig la Figura que queremos comprobar si se chocará
     * @param direccion de movimiento (Figura.ABAJO,Figura.DERECHA o FIGURA.IZQUIERDA)
     * @return true si se choca, false en caso contrario
     */
    public boolean seChoca(Fantasma fig, int direccion){
        boolean seChoca = true;
        //ojo porque la manera de x e y, no es la misma que la busqueda en una matriz
        int xPac = fig.getX();
        int yPac = fig.getY();
        int xMatriz = yPac;
        int yMatriz = xPac;
        int xSigMatriz = xMatriz;   //por incializar
        int ySigMatriz = yMatriz;   //por inicializar
        //hay que tener en cuenta como funciona getTipoCelda, devuelve las coordenadas de una matriz,
        //no funciona igual que los ejes x, y.
        //vamos a escoger con cuidado cuales son  la x y la y siguientes en la matriz
        if(direccion == Comecocos.ABAJO){
            xSigMatriz = xMatriz + 1;
            ySigMatriz = yMatriz;
        } else if(direccion == Comecocos.ARRIBA){
            xSigMatriz = xMatriz - 1;
            ySigMatriz = yMatriz;
        } else if(direccion == Comecocos.DERECHA){
            xSigMatriz = xMatriz;
            ySigMatriz = yMatriz + 1;
        } else if(direccion == Comecocos.IZQUIERDA){
            xSigMatriz = xMatriz;
            ySigMatriz = yMatriz - 1;
        }
        
        if(xSigMatriz >= altura || xSigMatriz < 0 || ySigMatriz >= anchura || ySigMatriz < 0){
            System.out.println("Alcanzado limite del mapa");
            return true;
        }
        
        //comprobamos si se choca o no
        if((getTipoCelda(xSigMatriz, ySigMatriz) == Laberinto.VACIA) || (getTipoCelda(xSigMatriz, ySigMatriz) == Laberinto.PEQUENA)  ||
           (getTipoCelda(xSigMatriz, ySigMatriz) == Laberinto.GRANDE || (getTipoCelda(xSigMatriz, ySigMatriz) == Laberinto.PUERTA))){
            seChoca = false;
        }
        return seChoca;
    }
    
    
    /**
     * Metodo que actualiza el laberinto en caso de que pacman pase por un punto.
     * Si pasa por un punto, pequeño o grande, se le suma 10 o 50 puntos, respectivamente
     * a la puntuacion. Ademas cambia el laberinto de manera que queda vacia la
     * celda por la que ha pasado
     * @param coco Comecocos en juego, necesitamos saber sus coordenadas
     * @return devuelve el numero de puntuacion añadido tras el paso por la celda en la que se encuentra el comecocos
     */
    public int actualizaMapa(Comecocos coco){
        int xMatriz = coco.getY();
        int yMatriz = coco.getX();
        
        if(getTipoCelda(xMatriz, yMatriz) == Laberinto.PEQUENA){
            puntuacion = puntuacion + 10;
            assignTipoCelda(xMatriz, yMatriz, Laberinto.VACIA);
            return 10;
        } else if(getTipoCelda(xMatriz, yMatriz) == Laberinto.GRANDE){
            puntuacion = puntuacion + 50;
            assignTipoCelda(xMatriz, yMatriz, Laberinto.VACIA);
            return 50;
        }
        return 0;
    }
    
    /**
     * Metodo para aumentar puntos
     * @param puntos cantidad de puntos a aumentar
     */
    public void aumentaPuntuacion(int puntos){
        puntuacion = puntuacion + puntos;
    }
    
    /**
     * Se comprueba si se ha acabado el nivel
     * @return devuelve true si se acaba nivel y false si no
     */
    public boolean finNivel(){
        for(int i=0; i < rejillaInicial.length; i++){
            for(int j=0; j < rejillaInicial[i].length();j++){
                if(celdas[i][j] == Laberinto.PEQUENA || celdas[i][j] == Laberinto.GRANDE){
                    return false;
                }
            }
        }
        return false;
    }
}



