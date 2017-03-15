import java.util.Scanner;

class MultiplicarMatrices{

    public static void main(String[] args){
        int[][] matriz1, matriz2, result;
        matriz1 = leerMatrizInt();
        matriz2 = leerMatrizInt();
        System.out.println("Filas matriz1: "+matriz1.length+" . Filas matriz2: "+matriz2.length+ " .Columnas matriz1: "+matriz1[0].length+" .Columnas matriz2: "+matriz2[0].length);
        //habria que comprobar que las columnas de m1 coinciden con las filas de m2
        result = multiplicarMatrices(matriz1, matriz2);
        System.out.println("Matriz 1: ");
        imprimirMatrizInt(matriz1);
        System.out.println("Matriz 2: ");
        imprimirMatrizInt(matriz2);
        System.out.println("Resultado: ");
        imprimirMatrizInt(result);

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
    
    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2){
    
        //multiplicaion mxn · nxp = mxp
        int m = matriz1.length;
        int n = matriz2.length;
        int p = matriz2[0].length;
        int[][] result = new int[m][p];
        
        for (int x=0; x < m; x++) {
            for (int y = 0; y < p; y++) {
                for (int z = 0; z < n; z++) {
                    result[x][y] += matriz1[x][z]*matriz2[z][y]; 
                }
            }    
        }
        return  result;
    }
    
    
    public static void imprimirMatrizInt(int[][] matriz){
        
                
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                System.out.print(" "+matriz[i][j]);
            }
            System.out.println(" ");
        }
    }
}