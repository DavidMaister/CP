
import java.util.Scanner;
public class ReplaceText{
  public static void main(String args[]) throws java.io.IOException{

    java.io.File fileOriginal;
    java.io.File fileNuevo;
    Scanner input;
    String antiguo;
    String nuevo;
    if(args.length == 4){
      //Creamos objeto File del fichero orginal
      fileOriginal = new java.io.File(args[0]);
      //Creamos objeto File del nuevo fichero
      fileNuevo = new java.io.File(args[1]);
      //Scanner para el fichero orginal
      input = new Scanner(fileOriginal);
      //Creamos el fichero
      java.io.PrintWriter output = new java.io.PrintWriter(fileNuevo);
      //Guardamos los string que queremos cambiar
      antiguo = args[2];
      nuevo = args[3];
      String linea;
      while (input.hasNext()) {
        linea = input.nextLine();
        linea = linea.replaceAll(antiguo, nuevo);
        output.println(linea);
      }

      output.close();
      input.close();
    }
  }
}
