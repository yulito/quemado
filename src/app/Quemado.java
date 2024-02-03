/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;


/**
 *
 * @author yulia
 */
public class Quemado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //objeto de la clase para acceder a las funciones
        Quemado obj = new Quemado();
        //definimos las palabras en arreglos
        final String [] palabra1 = {"c","a","m","a","l","e","o","n"};
        final String [] palabra2 = {"z","a","p","a","t","e","r","o"};
        final String [] palabra3 = {"m","u","r","c","i","e","l","a","g","o"};
        final String [] palabra4 = {"b","a","t","e","r","i","a","s"};
        final String [] palabra5 = {"p","a","l","i","n","d","r","o","m","o"}; 
        final String [] palabra6 = {"s","o","l","s","t","i","c","i","o"}; 
        final String [] palabra7 = {"v","e","t","e","r","a","n","o"}; 
        final String [] palabra8 = {"i","n","v","i","e","r","n","o"}; 
        final String [] palabra9 = {"g","a","r","a","n","t","i","a"}; 
        final String [] palabra10 = {"c","l","i","m","a","t","o","l","o","g","i","a"}; 
        //usamos un objeto scanner para obtener datos por teclado
        Scanner ingresar = new Scanner(System.in);
        //creamos variable para almacenar los datos de scanner
        String respuesta = "";        
        //creamos arreglo bidimensional para almacenar los demas arreglos
        String [][] contenedor = {palabra1,palabra2,palabra3,palabra4,palabra5,
                                 palabra6,palabra7,palabra8,palabra9,palabra10};
                
        //numero random para generar palabra aleatoria
        int numeroRand = (int)(Math.random()*10+1); 
        int cantidadElementos = contenedor[numeroRand-1].length;
        //Arreglo para completar con letras
        String [] completar = new String[cantidadElementos];
        for(int j = 0; j < cantidadElementos; j++){
            completar[j] = "_ ";
        }
        
        System.out.println("***************************");
        System.out.println("EL JUEGO DEL QUEMADO");        
        //oportunidades
        int oportunidades = 4;
        int ciclo = 0;
        while(true)
        {   
            //pedimos ingresar una letra con la siguiente funcion
            obj.letra(completar);
            respuesta = ingresar.nextLine().toLowerCase().trim();
            //si este valor no se cambia a true se descontara de oportunidades
            boolean check = false;
            for(int i = 0; i < cantidadElementos; i++){
                if(respuesta.equals(contenedor[numeroRand-1][i])){
                    //agregamos la letra al indice correspondiente
                    completar[i]= contenedor[numeroRand-1][i];
                    //sumamos 1 por cada acierto
                    ciclo += 1;
                    //al cambiar a true mantenemos el nro de oportunidades
                    check = true;
                }
            }            
            boolean resultado1 = false;
            if(!check){ //si el check se mantiene en false le restamos una oportunidad
                oportunidades-=1;
                resultado1 = obj.verificarQuemadura(oportunidades);
            }
            //obtenemos los resultados de ambos para saber si se acaba el juego            
            boolean resultado2 = obj.verificarEstado(ciclo,cantidadElementos);
            //si cualquiera de los dos es true se acaba el juego
            //el mensaje dependera de cual de los dos resultados arroje true
            if(resultado1 || resultado2){ 
                obj.fin(completar);
                break;
            }
        }                                     
    }    
    //----
    public void letra(String [] com){
        System.out.println("___________________");
        System.out.print("Palabra: ");
        for(int i= 0; i < com.length; i++){
            System.out.print(com[i]);
        }
        System.out.println("");        
        System.out.println("Ingresa una Letra");
        System.out.print(">");
    }
    public boolean verificarQuemadura(int op){
        boolean valor = false;        
        switch(op){
            case 3:
                System.out.println("");
                System.out.println("SE LE QUEMARON LOS PIES...");
                break;
            case 2:
                System.out.println("");
                System.out.println("SE LE QUEMARON LOS BRAZOS...");
                break;
            case 1:
                System.out.println("");
                System.out.println("SE LE QUEMO EL TRONCO...");
                break;
            case 0:
                System.out.println("");
                System.out.println("SE LE QUEMO LA CABEZA...");
                System.out.println("+++++++++++++++++++++++++");
                System.out.println("HAS PERDIDO... :( PENITA");
                System.out.println("");
                valor = true;
                break;
        }
        return valor;
    }    
    public boolean verificarEstado(int ci, int cant){
        boolean valor = false;
        if(ci == cant){ 
            System.out.println("HAS GANADO!!!! ERES UN CRACK");
            System.out.println("");
            valor = true;
        }
        return valor;
    }
    public void fin(String []com){
        System.out.print("Resultado: ");
        for(int x= 0; x < com.length; x++){
            System.out.print(com[x]);
        }
        System.out.println("");
        System.out.println("*********************");
        System.out.println("EL JUEGO A ACABADO");
        System.out.println("*********************");
    }
}
