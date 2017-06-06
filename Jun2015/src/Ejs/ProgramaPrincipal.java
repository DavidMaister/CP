package Ejs;

import java.util.concurrent.*;
public class ProgramaPrincipal{


  public static void main(String[] args){

    Parking parking = new Parking(100);
    ExecutorService programa = Executors.newCachedThreadPool();

    programa.execute(new TareaSalidaCoches(parking));
    programa.execute(new TareaEntradaCoches(parking));
    programa.shutdown();

  }
}
