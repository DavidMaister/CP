/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sept;

/**
 *
 * @author david
 */
class Persona {
x    public String getInfo() {
 return "Persona";
 }

 public void printPersona() {
 System.out.println(getInfo());
}
}

 class Estudiante extends Persona {
 public String getInfo() {
 return "Estudiante";
 }
 }

 public class Test {
 public static void main(String[] args) {
 new Persona().printPersona();
 new Estudiante().printPersona();
 }
 }