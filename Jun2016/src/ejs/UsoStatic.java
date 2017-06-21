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
public class UsoStatic {
    private static Entero entero1 = new Entero();
    private static Entero entero2 = new Entero();

    static {
        System.out.println(entero1.length);
    }
    public static void main(String[] args) {
        entero1.length = 2;
        entero2.length = 8;
        System.out.println(entero1.length);
        System.out.println(entero2.length);
    }
}
class Entero {
    public static int length = 0;
}
