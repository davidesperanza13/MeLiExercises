/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import java.util.LinkedList;
/**
 *
 * @author David
 */
public class HackerRankExercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Call Exercise 1
        System.out.println(esPrimo(40));
        
        //Call Exercise 2
        LinkedList<String> piedras = new LinkedList();
        piedras.add("bc");
        piedras.add("bec");
        piedras.add("bbca");
        
        System.out.println(rockElements(piedras));
    }
    //Exercise 1
    public static int esPrimo(long n){
        int resp;
        int cont = 0;
        boolean firstTime = true;
        int minimo = 0;
        for(long i=1;i<=n;i++){//Loop de busqueda de divisores
            if(n%i==0){//Modulo indica que es divisible
                cont++;
                if(i!=1){//Guarda el primer numero divisible != 1
                    if(firstTime){
                      minimo = (int)i;
                      firstTime = false;
                    }            
                }
            }
        }
        if(cont==2)//Es primo
            resp = 1; 
        else//No es primo
            resp = minimo;

        return resp;
    }
    //Exercise 2
    public static String rockElements(LinkedList<String> rocks){
        String elements="";
        boolean cont = true;
        boolean pertenece = false;
        String aux;
        for (String rock : rocks) {
            if(cont){//Se guarda la primera piedra
                elements = rock;
                cont= !cont;
            }
            else{//Comparacion con elementos de las demas pìedras
                for(int i=0;i<elements.length();i++){
                    for(int j=0;j<rock.length();j++){
                        if(elements.charAt(i)== rock.charAt(j)){//Si hay elemento en comun
                            pertenece = true;
                        }
                        if(pertenece){//Salida del loop de ese elemento
                            break;
                        }
                    }
                    if(pertenece){//reestablecimiento de variable para proximo loop
                        pertenece = false;
                    }
                    else{//Si no es elemento en comun se reemplaza con '*'
                        aux = elements.replace(elements.charAt(i), '*');
                        elements = aux;
                    }
                }
            }
        }
        aux = "";//Reutilizacion de variable aux
        for(int k=0;k<elements.length();k++){//Se dejan los elementos recurrentes en la lista de rocas
            if(elements.charAt(k)!= '*'){
                aux = aux.concat(String.valueOf(elements.charAt(k)));
            }
        }
        elements = aux;
        return elements;
    }
    
    
}
