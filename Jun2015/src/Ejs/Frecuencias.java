package Ejs;



class Pareja {

  private int dato;
  private int nVeces;

  public Pareja(int numero){
    dato=numero;
    nVeces=1;
  }

  public int getDato(){

    return dato;

  }

  public int getnVeces(){
    return nVeces;
  }

  public void incrementa(){
    nVeces++;
  }
}

class Frecuencias{

  private Pareja[] parejas;

  private int nPares;

  public Frecuencias(){
    parejas = new Pareja[0];
    nPares = 0;
  }

  public void add(int dato){
    for(int i = 0; i < nPares; i++){
      if(parejas[i].getDato() == dato){
        parejas[i].incrementa();
        return;
      }
    }
    Pareja[] nuevaParejas = new Pareja[parejas.length + 1];
    System.arraycopy(parejas, 0, nuevaParejas, 0, parejas.length);
    nuevaParejas[parejas.length] = new Pareja(dato);
    parejas = nuevaParejas;
  }

  public int getVecesDato(int dato){
    boolean encontrado = false;
    for(int i = 0; i < parejas.length; i++){
      if(parejas[i].getDato() == dato)
        return parejas[i].getnVeces();
    }
    return 0;
  }

}
