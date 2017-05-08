import java.util.Scanner;
public class ReadData {
  public static void main(String[] args) throws java.io.IOException {
    // Crear objeto File
    java.io.File file = new java.io.File("scores.txt");
    // Crear un Scanner para el File
    Scanner input = new Scanner(file);
    // Leer datos del fichero
    while (input.hasNext()) {
      String firstName = input.next();
      String lastName = input.next();
      int score = input.nextInt();
      System.out.println(firstName + " " + lastName + " " + score);
    }
    // Cerrar el fichero
    input.close();
  }
}
