import java.util.ArrayList;
import java.util.*;

public class Lista {

    private String nombrePersona;
    public static ArrayList<Lista> listaNombres = new ArrayList<Lista>();
    public static ArrayList<Lista> auxiliar = new ArrayList<Lista>();
    
    Lista(){}
    Lista(String nombre){
        this.nombrePersona = nombre;
    }

    public String getNombre(){
        return this.nombrePersona;
    }

    public void setNombre(String nombre){
        this.nombrePersona = nombre;
    }

    public static void creacionLista(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de nombres de la lista: ");
        int cantidadDeLista = sc.nextInt();
        int i = 1;
        System.out.println("Ingrese nombres");
        while(cantidadDeLista > listaNombres.size()){
            System.out.print(i++ + ". ");
            String nombre = sc.next();
            listaNombres.add(new Lista(nombre));
        }
    }

    public static void imprimirLista(){
        for(int i=0;i<listaNombres.size();i++){
            System.out.println((i+1)+ ("- " )+listaNombres.get(i).getNombre());
        }
        System.out.println("Tamaño: " +listaNombres.size());
    }
    
    public static void insertarObjeto(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresar nuevo objeto nombre: ");
        String nombre = sc.nextLine();
        
        Lista ultimoNombre = new Lista(nombre);
        
        System.out.print("En que posicion (posicion maxima " + listaNombres.size()+"): ");
        int numeroPosicion = sc.nextInt();
        
        if(numeroPosicion == listaNombres.size()){
            listaNombres.add(ultimoNombre);
            auxiliar.removeAll(auxiliar);
        }else if(numeroPosicion<listaNombres.size()){
            for (int i = numeroPosicion - 1; i < listaNombres.size(); i++){
                auxiliar.add(listaNombres.get(i));
            }
            listaNombres.removeAll(auxiliar);
            listaNombres.add(ultimoNombre);
            listaNombres.addAll(auxiliar);
            auxiliar.removeAll(auxiliar);
        }else{
            System.out.println("No existe, vuelve a intentar.");
        }
    }

    public static void removerValor(){
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Que valor de la lista quiere remover? (posicion maxima " + listaNombres.size()+"): ");
        int removerPosicion = sc.nextInt();
        removerPosicion = removerPosicion -1;

        if(removerPosicion <= listaNombres.size()-1){
            listaNombres.remove(removerPosicion);
        }else{
            System.out.println("Numero erroneo");
        }
    }
    
    public static void actualizarValor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual valor quiere cambiar?");
        for(int i=0;i<listaNombres.size();i++){
            System.out.println((i+1)+". "+listaNombres.get(i).getNombre());
        }
        System.out.println("-------------------------------------");
        int numeroActualizar = sc.nextInt();
        if(listaNombres.size()>=numeroActualizar){
            System.out.print("Nuevo nombre: ");
            String cambioNombre = sc.next();
            listaNombres.get(numeroActualizar-1).setNombre(cambioNombre);            
        }else{
            System.out.println("Numero erroneo");
        }
        
    }
}