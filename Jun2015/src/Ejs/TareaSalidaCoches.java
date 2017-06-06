package Ejs;

import java.util.Random;

public class TareaSalidaCoches implements Runnable{

  Random random;
  Parking parking;

  public TareaSalidaCoches(Parking parking_){
    parking = parking_;
    random = new Random();
  }

  @Override
  public void run(){

    try{
      while(true){
        parking.salidaCoche();
        Thread.sleep(random.nextInt(1000));
      }
    } catch(InterruptedException ex){
      System.out.println("Excepcion en la hebra salidaCoche");
    }
  }
}
