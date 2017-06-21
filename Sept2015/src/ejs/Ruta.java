/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejs;

/**
 *
 * @author david
 */

class Localizacion {
    
    private double longitud;
    private double latitud;
    private double altura;
    
    public Localizacion(double lon, double lat, double alt){
        longitud=lon;
        latitud=lat;
        altura=alt;
    }

    public double getLongitud(){
        return longitud;
    }
    public double getLatitud(){
        return latitud;
    }
    public double getAltura(){
        return altura;
    }
}

public class Ruta {
    private Localizacion[] locs; // Secuencia de localizaciones: locs[i]!=locs[i+1]
    
    
    public Ruta(){
        locs = new Localizacion[0];
    }
    
    public double longitud(){
        double longitud = 0;
        for(int i = 0; i < locs.length - 1; i++){
            longitud = longitud + distancia(locs[i], locs[i + 1]);
        }
        return longitud;
    }
    
    public static double distancia(Localizacion l1, Localizacion l2){
        return Math.sqrt(  (l1.getAltura() - l2.getAltura())*(l1.getAltura() - l2.getAltura())
                        +  (l1.getLatitud()- l2.getLatitud())*(l1.getLatitud()- l2.getLatitud())
                        +  (l1.getLongitud()- l2.getLongitud())*(l1.getLongitud()- l2.getLongitud())   );
    }
    
    public void añadir(double longitud, double latitud, double altura){
        Localizacion nuevoLoc = new Localizacion(longitud, latitud, altura);
        
        //añadimos la nueva localizacion al vector locs
        //creamos un array con un tamaño uno mayor al antiguo
        Localizacion[] nuevoLocs = new Localizacion[locs.length + 1];
        System.arraycopy(locs, 0, nuevoLocs, 0, locs.length - 1);
        nuevoLocs[nuevoLocs.length - 1] = nuevoLoc;
        locs = nuevoLocs;
        
    }
}
