

import java.io.*;
class TestFileStream{

  public static void main(String args[]) throws IOException{
    int i;
    FileOutputStream temp;

    FileInputStream reader;

    try {
      temp = new FileOutputStream("temp.dat");
      reader = new FileInputStream("temp.dat");
    } catch(FileNotFoundException e) {
      System.out.println("Fichero no encontrado");
      return;
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Uso: MostrarFichero Fichero");
      return;
    }

    for(int j=0; j <= 10; j++){
        temp.write(j);
        i = reader.read();
        if(i != -1) System.out.print((byte) i+" ");
    }
    temp.close();
    reader.close();

  }
}
