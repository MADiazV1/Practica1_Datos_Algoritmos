package Universidad.EstDatosAlgorit.Practica1.ListaJava.Practica1_Datos_Algoritmos;

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
        System.out.println("Datos de la lista original: ");
            Lista persona1 = new Lista("Pablo");
            Lista persona2 = new Lista("Miguel");
            Lista persona3 = new Lista("Juan");
            Lista persona4 = new Lista("Santiago");
            Lista persona5 = new Lista("Andres");
            
            listaNombres.add(persona1);
            listaNombres.add(persona2);
            listaNombres.add(persona3);
            listaNombres.add(persona4);
            listaNombres.add(persona5);
    }

    public static void imprimirLista(){
        for(int i=0;i<listaNombres.size();i++){
            System.out.println(listaNombres.get(i).getNombre());
        }
        System.out.println("Tamaño: " +listaNombres.size());
    }
    
    public static void insertarObjeto(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresar nuevo objeto nombre: ");
        String nombre = sc.nextLine();
        
        Lista ultimoNombre = new Lista(nombre);
        
        System.out.print("En que posicion: ");
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
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("¿Que valor de la lista quiere remover? ");
            int removerPosicion = sc.nextInt() -1;

            if(removerPosicion <= listaNombres.size()-1){
                listaNombres.remove(removerPosicion);
            }else{
                System.out.println("Numero erroneo");
            }
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