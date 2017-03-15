import java.util.Scanner;


class EliminaRepetidos{
    public static void main(String[] args){
        int n;
        int[] array, arrayFinal;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Numero de enteros a leer: ");    
        n = entrada.nextInt();
        array = leerArrayInt(n);
        
        arrayFinal = eliminaRepetidos(array);
        imprimirArrayInt(arrayFinal);
        
    }

    
    public static int[] eliminaRepetidos(int[] array){
        int[] arrayCopia = new int[array.length];
        int utiles = array.length, i = 1;
        System.arraycopy(array, 0, arrayCopia, 0, utiles);

        while(i < utiles){

            if(buscaElemento(arrayCopia[i], arrayCopia, 0, i - 1) >= 0){
                utiles--;
                moverIzquierda(arrayCopia, i+1, utiles - 1);
            }
            else 
                i++;
        }

        int[] arrayFinal = new int[utiles];
        System.arraycopy(arrayCopia, 0, arrayFinal, 0, utiles);
    
        return arrayFinal;
    }

    
    public static int buscaElemento(int ele, int[] array, int ini, int fin){      // Devuelve la posicion del
        int i = ini;                                                                // elemento repetido. Si no lo 
                                                                                    // encuentra devuelve -1
        while(i <= fin){
            if(array[i] == ele)
                return i;
            
            i++;
        }
        return -1;
    }

    
    public static void moverIzquierda(int[] array, int ini, int fin){
    
        for(int i = ini; i<= fin; i++){
            array[i-1] = array[i];
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
