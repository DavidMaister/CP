
import java.util.Scanner;

class TrazaMatriz{

    public static void main(String[] args){
        int[][] matriz;
        matriz = leerMatrizInt();
        System.out.println("Traza de la matriz: "+trazaMatriz(matriz));
    }


    public static int[][] leerMatrizInt(){
        
        int filas, col, i, j;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Numero de filas: ");
        filas = entrada.nextInt();
        
        System.out.print("Numero de columnas: ");
        col = entrada.nextInt();
        
        int[][] matriz = new int[filas][col];

        System.out.print("Introduce los elementos de la matriz: ");
        
        for(i = 0; i < filas; i++){
            for(j = 0; j < col; j++){
                matriz[i][j] = entrada.nextInt();
            }
        }
        return matriz;
    }
    
    public static int trazaMatriz(int[][] matriz){
    
        int traza = 0;
        
        for(int i = 0; i < matriz.length; i++){
            traza = traza + matriz[i][i];
        }
        return traza;
    }

}
