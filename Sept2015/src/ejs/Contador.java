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
public class Contador {
 public int contador;
 public Contador( int c) {
 contador = c;
 }
 public Contador() {
 contador = 1 ;
 }
 }

  class Test {
 public static void main(String[] args) {
 Contador miContador = new Contador();
 int nveces = 0 ;

 for ( int i = 0 ; i < 100 ; i++)
 incrementa(miContador, nveces);

 System.out.println( "contador es " + miContador.contador);
 System.out.println( "nveces es " + nveces);
 }

 public static void incrementa(Contador c, int nveces) {
 c.contador++;
 nveces++;
}
}
