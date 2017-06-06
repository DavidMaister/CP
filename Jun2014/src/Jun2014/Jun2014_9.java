/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jun2014;

/**
 *
 * @author david
 */
public class Jun2014_9 {
    public static void main(String[] args){
        //main para hacer pruebas
        Coleccion coleccion = new Coleccion(6);
        
        int longit = 10;
        for(int i = 0; i < longit; i++){
            coleccion.add(new Rectangulo(i, i));
        }
        coleccion.addAt(new Rectangulo(10,10), 4);
        System.out.println("El area es: ");
        for(int j = 0; j < coleccion.getPosActual(); j++){
            System.out.println(coleccion.getAt(j).getArea());
        }
        //System.out.println(coleccion.getAt(coleccion.getPosActual() - 1).getArea());
    }
}
    
abstract class Figura {
    double dim1, dim2;

    Figura(double a, double b) {
        dim1 = a;       
        dim2 = b;
    }
    public abstract double getArea();
}

class Rectangulo extends Figura {

    Rectangulo(double a, double b) {
        super(a, b);
    }
    @Override
    public double getArea(){
        return dim1*dim2;
    }
}

class Triangulo extends Figura {
    Triangulo(double a, double b) {
        super(a, b);
    }
    
    @Override
    public double getArea(){
        return dim1*dim2/2;
    }
}

class Coleccion{
    
    Figura[] coleccion;
    int posActual;
    int longitud;
    
    public Coleccion(){
        this(100);
    }
    
    public Coleccion(int longi){
        longitud = longi;
        posActual = 0;
        coleccion = new Figura[longitud];
    }
    
    public int getPosActual(){
        return posActual;
    }
    
    public Figura getAt(int i){
        if(i >= 0 && i <= posActual){
            return coleccion[i];
        }
        return null;
    }
    
    public void add(Figura fig){
        if(posActual +  1 == coleccion.length){
           coleccion = doblarCapacidad(coleccion); 
        }
        
        coleccion[posActual] = fig;
        posActual++;
    }
    
    public void addAt(Figura fig, int pos){
        
        if(pos < 0 || pos> posActual)
            return;
        if(posActual + 1 == coleccion.length)
            coleccion = doblarCapacidad(coleccion);
        
        Figura[] nueva = new Figura[coleccion.length];
        
        //hacemos una copia del nuevo array hasta la posicion
        System.arraycopy(coleccion, 0, nueva, 0, pos );
        nueva[pos] = fig;
        System.arraycopy(coleccion, pos, nueva, pos + 1, coleccion.length - pos - 1);
        coleccion = nueva;
        posActual++;
        
        
        
    }
    
    private Figura[] doblarCapacidad(Figura[] origen){
        Figura[] nuevoArray = new Figura[2*origen.length];
        //copiamos el array
        System.arraycopy(origen, 0, nuevoArray, 0, origen.length);
        //al igualar los objetos, el objeto al que apuntaba origen lo perdemos
        //origen = nuevoArray;
        return nuevoArray;
    }
}

