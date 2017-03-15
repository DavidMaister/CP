
import java.util.Scanner;

class numerosprimos {

    public static void main(String args[]) {
        double n;
        
        Scanner conin = new Scanner(System.in);
        System.out.println("Introduce un numero entero: ");
        n = conin.nextDouble();                                 //numero de numeros primos a mostrar
        System.out.println("El numero introducido es: " + n);
        imprimirPrimos(n);
        
    }

    public static boolean esPrimo(double numero) {
        int i;
        boolean checkPrimo = true;
        
        for (i = 2; i <= numero/2 && checkPrimo == true; i++) {
            if (numero % i == 0) {
                checkPrimo = false;
            }
        }
        return checkPrimo;

    }
    
    
    public static void imprimirPrimos(double n){
        int contador;
        
        contador = 2;
        for (int i = 1; i <= n; i++) {
            while (esPrimo(contador) == false) {
                contador++;
            }

            System.out.print("     " + contador);       //conseguimos que se 
            if (i % 10 == 0) {                          //muestren 10 numeros
                System.out.println("");                 //por linea
            }

            contador++;
        }

        System.out.println("");
    }

}
