
import java.util.Scanner;

class InvertirArray{

    public static void main(String[] args){
            int n;
            int[] array;
            Scanner entrada = new Scanner(System.in);
            System.out.print("Numero de enteros a leer: ");    
            n = entrada.nextInt();
            array = leerArrayInt(n);
            invertirArray(array);
            imprimirArrayInt(array);

        }


    
    public static void invertirArray(int[] array){
        
        int[] aux = new int[array.length];
        for(int i = 0; i < array.length; i++){
            aux[array.length -1 - i] = array[i];
        }
        for(int i = 0; i < array.length; i++){
            array[i] = aux[i];
        }
    
    
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


    public static void imprimirArrayInt(int[] array){

    for(int i = 0; i < array.length; i++)
        System.out.print(" "+array[i]);
        System.out.println();
    }

}
