import java.util.Scanner;
public class ImprimirCalendario {
/**
metodo Main
*/
public static void main(String[] args) {
int mes = 0;
int anio = 0;
Scanner entrada = new Scanner(System.in);
// Pedir al usuario que introduzca el anio
while(anio <1800 ){
System.out.print("Introduce el anio (e.g., 2016): ");
anio = entrada.nextInt();
}
// Pedir al usuario que introduzca el mes
while(mes < 1 || mes > 12){
System.out.print("Introduce el mes en rango 1 a 12: ");
mes = entrada.nextInt();
}

// Imprimir el calendario
imprimirMes(anio, mes);
}






/**
Imprimir el calendario para el mes y anio
*/
public static void imprimirMes(int anio, int mes) {
   
imprimirTituloMes(anio, mes);
System.out.println(" Lun  Mar  Mie  Jue  Vie  Sab  Dom");
imprimirCuerpoMes(anio, mes);
}




/**
Imprir el titulo del mes, e.g., Febrero, 2016
*/
public static void imprimirTituloMes(int anio, int mes) {
    String mesString;
    mesString = obtenerNombreMes(mes);
    System.out.println();
    System.out.println(mesString + ", " + anio);
    System.out.println("------------------------------");    
}





/**
Obtener el nombre del mes
*/
public static String obtenerNombreMes(int mes) {
    String[] mesesVector = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    return mesesVector[mes - 1];
    
}





/**
Imprimir el cuerpo del mes
*/
public static void imprimirCuerpoMes(int anio, int mes) {
    
    int diaComienzo = obtenerDiaComienzo(anio, mes);
    int diaMes = obtenerNumeroDiasenMes(anio, mes);
    int j;
    if(diaComienzo == 0)
        diaComienzo = 7;
    
  
    for(j = 1; j < diaComienzo; j++){
        System.out.print("     ");
    }
   
    
    for(int i = 1; i <= diaMes; i++){
        if(i / 10 == 0)
            System.out.print("    "+i);
        else
            System.out.print("   "+i);
        if(j % 7 == 0)
            System.out.println("");
        j++;
   
   }
    System.out.println("");

    
}





/**
Obtener el dia de comienzo del mes en un anio
*/
public static int obtenerDiaComienzo(int anio, int mes) {
    
    int totalDias;
    int diaComienzo;
    totalDias = obtenerNumeroTotalDias(anio, mes);
    
    
    diaComienzo = (totalDias +3)% 7;      //1 Corresponde a Lunes, 2 a Martes
                                      // 0 a domingo
return diaComienzo; 
}






/**
Obtener numero total de dias desde 1 de enero de 1800
*/
public static int obtenerNumeroTotalDias(int anio, int mes) {
    int totalDias = 0;
    
    for(int i = 1800; i < anio; i++){
        totalDias = totalDias + 365;
        if(esAnioBisiesto(i) == true)
            totalDias++;        //Se suma un dia mas por año  bisiesto
    }
    for(int j = 1; j < mes; j++){
    totalDias = totalDias + obtenerNumeroDiasenMes(anio, j);
    }   
    
return totalDias; // Un valor ficticio
}







/**
 Obtener el numero de dias en un mes
*/
public static int obtenerNumeroDiasenMes(int anio, int mes) {
   
    int[] numeroDiasMes = {31,28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
    if(mes == 2 && esAnioBisiesto(anio) == true){
        return numeroDiasMes[mes - 1] + 1;
    }
   
return numeroDiasMes[mes - 1]; // Un valor ficticio
}





/**
Ver si un anio es bisiesto
*/
public static boolean esAnioBisiesto(int anio) {
    
    if(anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0))
        return true;
    
    
return false; // Un valor ficticio
}
}
