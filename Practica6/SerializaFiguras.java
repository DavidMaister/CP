

import java.io.*;
import java.util.Random;

class SerializaFiguras{

    public static void main(String args[]) throws IOException, ClassNotFoundException{
        Random random = new Random();
      // Crea un flujo de salida
      ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(args[0]));

      // Crea un flujo de entrada para el fichero array.dat
      ObjectInputStream input = new ObjectInputStream(new FileInputStream(args[0]));

      //creamos las 100 figuras

      double prob = 0.5;
      for(int i = 0; i < 100; i++){
        //creamos la figura aleatoriamente
        Figura figura;
        if(random.nextDouble() < prob){
            figura = new Circulo(random.nextDouble()*(20/2));
        }
        else {
            figura = new Rectangulo( random.nextDouble()*20,  random.nextDouble()*20);
        }
        //escribimos la figura en el archivo
        output.writeObject(figura);

      }

      //ahora leemos los objetos del fichero creado
      Figura figuraLectura;
      for(int j = 0; j < 100; j++){
          figuraLectura = (Figura) input.readObject();
          System.out.println(figuraLectura);

      }

      output.close();
      input.close();
    }

}
