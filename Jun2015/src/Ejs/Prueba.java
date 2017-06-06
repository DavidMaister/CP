/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejs;

/**
 *
 * @author david
 */
public class Prueba {

    public static void main(String[] args) {

        Object fruta = new Manzana();

        Object manzana = (Fruta) fruta;

        }
    }

    class Fruta {
    }

    class Manzana extends Fruta {
    }
