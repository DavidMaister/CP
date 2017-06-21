/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejs;

import java.util.Date;

/**
 *
 * @author david
 */
class A {
    public A(int x) {
    System.out.println("Llamando al constructor A(int x) de la clase A" );
    }
}

class B extends A {
    public B(int f){
                super(f);

        System.out.println("Llamando al constructor sin argumentos de la clase B" );
    }
 }

 public class C {
 public static void main(String[] args) {
 B b = new B(4);
 A a = new A(5);
 Date d = new Date();
 a = b;
 }
 }
