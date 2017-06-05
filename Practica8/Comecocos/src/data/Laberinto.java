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
    
    public static final char VACIA  = ' ';
    public static final char BLOQUE = 'B';
    public static final char PEQUENA = '.';
    public static final char GRANDE = 'o';
    public static final char PUERTA = 'P';
    
    
    private int anchura = 28;
    private int altura = 31;
    
    private char[][] celdas;
    
    /**
     * Crea espacio para un laberinto con anchura igual a w  y altura
     */
    public Laberinto(){
        celdas= new char[altura][anchura];
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
     * Establece el tipo de celda en las coordenadas x e y de esta Laberinto
     *  @param x coordenada x (columna)
     * @param y coordenada y (fila)
     * @param valor el tipo de celda (VACIA, PUERTA, BLOQUE, grande o pequeña)
     */
    public void assignTipoCelda(int x,int y,char valor){
        celdas[x][y]= valor ;
    }
    
    /**
     * String que define el estado inicial del laberinto
     */
    private final static String rejillaInicial[]={
        "BBBBBBBBBBBBBBBBBBBBBBBBBBBB",
        "B............BB............B",
        "B.BBBB.BBBBB.BB.BBBBB.BBBB.B",
        "BoBBBB.BBBBB.BB.BBBBB.BBBBoB",
        "B.BBBB.BBBBB.BB.BBBBB.BBBB.B",
        "B..........................B",
        "B.BBBB.BB.BBBBBBBB.BB.BBBB.B",
        "B.BBBB.BB.BBBBBBBB.BB.BBBB.B",
        "B......BB....BB....BB......B",
        "BBBBBB.BBBBB BB BBBBB.BBBBBB",
        "     B.BBBBB BB BBBBB.B     ",
        "     B.BB          BB.B     ",
        "     B.BB BBBPPBBB BB.B     ",
        "BBBBBB.BB B      B BB.BBBBBB",
        "      .   B      B   .      ",
        "BBBBBB.BB B      B BB.BBBBBB",
        "     B.BB BBBBBBBB BB.B     ",
        "     B.BB          BB.B     ",
        "BBBBBB.BB BBBBBBBB BB.BBBBBB",
        "B............BB............B",
        "B.BBBB.BBBBB.BB.BBBBB.BBBB.B",
        "B.BBBB.BBBBB.BB.BBBBB.BBBB.B",
        "Bo..BB................BB..oB",
        "BBB.BB.BB.BBBBBBBB.BB.BB.BBB",
        "BBB.BB.BB.BBBBBBBB.BB.BB.BBB",
        "B......BB....BB....BB......B",
        "B.BBBBBBBBBB.BB.BBBBBBBBBB.B",
        "B.BBBBBBBBBB.BB.BBBBBBBBBB.B",
        "B..........................B",
        "BBBBBBBBBBBBBBBBBBBBBBBBBBBB"
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
                System.out.print(rejillaInicial[i].charAt(j));
                celdas[i][j]= rejillaInicial[i].charAt(j);
            }
            System.out.println();
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
     * Indica si al mover la figura una celda según la direccion indicada, se chocará
     * @param fig la Figura que queremos comprobar si se chocará
     * @param direccion de movimiento (Figura.ABAJO,Figura.DERECHA o FIGURA.IZQUIERDA)
     * @return true si se choca, false en caso contrario
     */
    public boolean seChoca(Comecocos fig, int direccion){
        Elemento elemento;
        
        //hay que tener en cuenta como funciona getTipoCelda, devuelve las coordenadas de una matriz,
        //no funciona igual que los ejes x, y.
        if(direccion == Comecocos.IZQUIERDA){
            if(getTipoCelda(fig.getX(), fig.getY() - 1) == BLOQUE || getTipoCelda(fig.getX(), fig.getY() - 1) == PUERTA){
                return true;
            }
        }
        
        if(direccion == Comecocos.DERECHA){
            if(getTipoCelda(fig.getX(), fig.getY() + 1) == BLOQUE || getTipoCelda(fig.getX(), fig.getY() + 1) == PUERTA){
                return true;
            }
        }
        
        if(direccion == Comecocos.ABAJO){
            if(getTipoCelda(fig.getX() + 1, fig.getY()) == BLOQUE || getTipoCelda(fig.getX() + 1, fig.getY()) == PUERTA){
                return true;
            }
        }
        
        if(direccion == Comecocos.ARRIBA){
            if(getTipoCelda(fig.getX() - 1, fig.getY()) == BLOQUE || getTipoCelda(fig.getX() - 1, fig.getY()) == PUERTA){
                return true;
            }
        }
        
        return false;
    }
}
