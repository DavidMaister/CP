package Ejs;

import java.util.Random;

public class Parking{

  boolean[] plazas; //true es que estan libres
  int nPlazas;



  public Parking(int nPlazas_){
    nPlazas = nPlazas_;
    plazas = new boolean[nPlazas];
    //al principio estan todas libres
    for(int i = 0; i < nPlazas; i++){
      plazas[i] = true;
    }
  }

  public synchronized void entradaCoche() throws InterruptedException{
    Random random = new Random();
    int i;
    boolean aux = true;

    try{

      while(isLleno()){
        wait();
      }
      while(aux){
        i = random.nextInt(nPlazas - 1);
        if(plazas[i] == true){
          plazas[i] = false; //el coche entra en la plaza i
          System.out.println("Entrada de coche en plaza: "+i+". Plazas ocupadas: "+getOcupadas());
          aux = false; // nos salimos del while
          notifyAll();
        }
      }
    } catch(InterruptedException ex){
      System.out.println("Excepcion en entradaCoche");
    }

  }

  public synchronized void salidaCoche() throws InterruptedException{

    Random random = new Random();
    boolean aux = true;
    int i;
    try{
      while(isVacio()){
        wait();
      }
      while(aux){
        i = random.nextInt(nPlazas - 1);
        if(plazas[i] == false){
          plazas[i] = true; //la plaza se queda libre
          System.out.println("Salida de coche de plaza: "+i+". Plazas ocupadas: "+getOcupadas());
          aux = false;
          notifyAll();
        }
      }

    } catch(InterruptedException ex){
        System.out.println("Excepcion en salidaCoche");
    }
  }

  public boolean isLleno(){

    for(int i = 0; i < nPlazas; i++){
      if(plazas[i] == true)
        return false;
    }
    return true;
  }

  public boolean isVacio(){

    for(int i = 0; i < nPlazas; i++){
      if(plazas[i] == false)
        return false;
    }
    return true;
  }

  public int getOcupadas(){
    int ocupadas = 0;
    for(int i = 0; i < nPlazas; i++){
      if(plazas[i] == false)
      ocupadas++;
    }
    return ocupadas;
  }

}
