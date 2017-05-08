
import java.io.*;
import java.util.Scanner;

class TransformarABinarioTSP{

  public static void main(String args[]) throws IOException{

    int i;
    DataOutputStream salidaWrite;
    DataInputStream salidaRead;
    File entrada;

    try {
      entrada = new File(args[0]);
      salidaWrite = new DataOutputStream(new FileOutputStream(args[1]));
      salidaRead = new DataInputStream(new FileInputStream(args[1]));
    } catch(FileNotFoundException e) {
      System.out.println("Fichero no encontrado");
      return;
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Uso: MostrarFichero Fichero");
      return;
    }

    //creamos Scanner para poder leer los datos de la isntancia TSP
    Scanner scannerEntrada = new Scanner(entrada);
    int dimension = scannerEntrada.nextInt(); //leemos la dimension
    double leido;
    double leerCoordenadas;

    for(i = 0; i < dimension; i++){
      //codigo de la ciudad
      salidaWrite.writeDouble(scannerEntrada.nextDouble());

      //las dos coordenadas
      salidaWrite.writeDouble( scannerEntrada.nextDouble());
      salidaWrite.writeDouble( scannerEntrada.nextDouble());

      //lo leemos y lo mostramos por pantalla
      //leemos el codigo
      leido = salidaRead.readDouble();
      System.out.print((int)leido+" ");
      leerCoordenadas = salidaRead.readDouble();
      //primera coordenada
      System.out.print(leerCoordenadas+" ");
      leerCoordenadas = salidaRead.readDouble();
      //segunda coordenada
      System.out.print(leerCoordenadas+" ");

      System.out.println();
    }
    scannerEntrada.close();
    salidaWrite.close();
    salidaRead.close();
  }
}
