import java.util.Scanner;

public class MayordeunArray{
    
    public static void main(String[] args){
        
    int n;
    int[] array;
    Scanner entrada = new Scanner(System.in);
    System.out.print("Numero de enteros a leer: ");    
    n = entrada.nextInt();
    array = leerArrayInt(n);
    System.out.println("El mayor numero del array es: "+numeroMayorArray(array));
    
    }
    
    public static int[] leerArrayInt(int n){
    
        int[] arrayInt = new int[n];
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce los elementos del array: ");
        for(int i = 0; i < n; i++){
            arrayInt[i] = entrada.nextInt();
        }
        return arrayInt;
    }
    
    public static int numeroMayorArray(int[] array){
        int mayor = array[0];
        
        for(int i = 1; i < array.length;i++){
            if(array[i] > mayor)
                mayor = array[i];
        }
        return mayor;
    }
     
}
