package Ejs;

import java.util.Random;
public class TareaEntradaCoches implements Runnable{

  Random random;
  Parking parking;

  public TareaEntradaCoches(Parking parking_){
    parking = parking_;
    random = new Random();
  }

  @Override
  public void run(){
    try{
      while(true){
        parking.entradaCoche();
        Thread.sleep(random.nextInt(1000));
      }
    } catch(InterruptedException ex){
      System.out.println("Excepcion en la hebra entradaCoche");
    }
  }
}
