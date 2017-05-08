

import java.io.*;

class FileSize{
  public static void main(String args[]) throws IOException{
    int i;
    int bytes = 0;
    FileInputStream fin;
    try {
      fin = new FileInputStream(args[0]);
    } catch(FileNotFoundException e) {
      System.out.println("Fichero no encontrado");
      return;
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Uso: MostrarFichero Fichero");
      return;
    }
    // lee caracteres hasta que se encuentra EOF
    do {
      i = fin.read();
      bytes++;
      System.out.print((byte) i+" ");
    } while(i != -1);
    System.out.println();
    System.out.println("Numero de Bytes del fichero: " +bytes);
    fin.close();

  }
}
