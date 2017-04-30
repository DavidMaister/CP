/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Date;

/**
 *
 * @author david
 */
public abstract class Figura{
    
    private final Date fechaCreacion;
    
    protected Figura(){
        fechaCreacion = new Date();
    }
    
    public Date getFechaCreacion(){
        return fechaCreacion;
    }
    
    @Override
    public String toString(){
        String cadena;
        //this hace referencia al objeto que lo esta ejecutando
        cadena = this.getClass().getSimpleName()+" creado el "+fechaCreacion+"\n"+"Area: "+getArea()+"\n"+"Perimetro: "+getPerimetro();
        
        return cadena;
    }
    
    public int compareTo(Figura figura){
        int resultado;
        resultado = (int) (getArea() - figura.getArea());
        if(resultado < 1 && resultado > 0){
            resultado = 1;      //evitamos que sea con decimales para el caso menor que 1
        }
        return resultado;
    }
    
    
    public abstract double getArea();
    
    public abstract double getPerimetro();
    
}
