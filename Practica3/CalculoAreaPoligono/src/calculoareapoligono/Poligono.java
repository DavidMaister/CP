/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoareapoligono;

import static java.lang.System.arraycopy;

/**
 *
 * @author david
 */
public class Poligono {
    
    private Punto ptos[]; // array con los vértices del Poligono
    private int numPuntos; // número de vértices que tiene ahora el Poligono
    
    //Constructor sin parámetros para crear un polı́gono vacı́o.
    Poligono(){
        ptos = new Punto[4];
        numPuntos = 0;
    }
    
    
    //añade un punto (vérti-
    //ce) a un Poligono . Antes de añadir el punto, el método debe com-
    //probar si es posible añadirlo (o sea, si cabe en el array). Si no cabe,   
    //deberá crearse un nuevo array para los puntos con el doble de capa-
    //cidad a la que tenga actualmente, y se copiarán los puntos antiguos
    //en el nuevo array.
    public void addPunto(Punto p){
        if(numPuntos == ptos.length){
            Punto[] aux = new Punto[numPuntos*2];
            arraycopy(ptos, 0, aux, 0, ptos.length);
            ptos = aux;
        }
        ptos[numPuntos] = new Punto();
        ptos[numPuntos].setCoordenadas(p.getX(), p.getY());
        numPuntos++;
    }
    
    // devuelve el número de vértices que tiene actualmente el Poligono.
    public int numberOfPuntos(){
        return numPuntos;
    }
    
    //devuelve el n-ésimo punto de un Poligono. 
    //Devuelve null si ese punto no existe en el polı́gono.
    public Punto getPunto(int n){
        
        if(n > numPuntos){
        return null;
        }
        Punto aux = new Punto();
        aux.setCoordenadas(ptos[n-1].getX(), ptos[n-1].getY());
        return aux;    
    }
    
    
    //devuelva un String con el
    //número de vértices y las coordenadas x e y de cada vértice 
    public String toString(){
        String cadena;
        cadena = numPuntos+"\n";
        for(int i= 0; i < numPuntos;i++){  
            cadena = cadena + ptos[i].toString()+"\n";
        }
        return cadena;
    }
    
    
    //calcular perimetro del poligono
    public double perimetro(){
        //El perimetro solo tiene sentido si tiene un minimo de tres lados
        if(numberOfPuntos()<3)
            return 0;
        
        Punto aux = new Punto();
        double perimetro = 0;
        
        for(int i=1; i< numberOfPuntos() - 1;i++){
            aux = getPunto(i);
            perimetro = perimetro + aux.calcularDistanciaEuclidea(getPunto(i+1));
        }
        aux = getPunto(numberOfPuntos());
        perimetro = perimetro + aux.calcularDistanciaEuclidea(getPunto(0));
        return perimetro;
        
    }
    
    
}
