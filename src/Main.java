import java.util.*;

public class Main {
    
    public static void menuLista(){
        Scanner sc = new Scanner(System.in);
        Lista.creacionLista();
        
        boolean condicion = true;
        while(condicion){
            System.out.println("La mama de rios");
            System.out.println("-------------------------------------");
            System.out.println("1. Imprimir");
            System.out.println("2. Insertar");
            System.out.println("3. Borrar");
            System.out.println("4. Actualizar");
            System.out.println("0. Salir");
            System.out.println("-------------------------------------");
            System.out.print("Ingrese un valor: ");
            int numeroCondicion = sc.nextInt();
            
            switch(numeroCondicion){
                case 0:{
                    System.out.println("Exit");
                    condicion = false;
                    break;
                }
                case 1: {
                    Lista.imprimirLista();
                    break;
                }
                case 2:{
                    Lista.insertarObjeto();
                    break;
                }
                case 3:{
                    Lista.removerValor();
                    break;
                }
                case 4:{
                    Lista.actualizarValor();
                    break;
                }
                default:{
                    System.out.println("Te equivocaste, vuelve a intentar.");
                    break;
                }
            }   
        }
        sc.close();
    }
    
    public static void main(String[] args){
        menuLista();
    }
}