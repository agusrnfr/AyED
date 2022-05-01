package tp02.ejercicio4;
import 	tp02.ejercicio3.*;

import java.util.Scanner;

import 	tp02.ejercicio2.*;

public class TestBalanceo {
	public static boolean esBalanceado (String str) {
		ListaEnlazadaGenerica<Character> inicio = new ListaEnlazadaGenerica <Character>();
		inicio.agregarFinal('(');
        inicio.agregarFinal('[');
        inicio.agregarFinal('{');

        ListaGenerica<Character> cierre = new ListaEnlazadaGenerica<Character>();
        cierre.agregarFinal(')');
        cierre.agregarFinal(']');
        cierre.agregarFinal('}');
        
        PilaGenerica <Character> pila = new PilaGenerica <Character>();
        
        Character act,ant;
        for (int i = 0; i <str.length(); i++) {
        	 act = str.charAt(i);
             if (inicio.incluye(act)) {
            	 pila.apilar(act);
             }
             else 
            	 if ((cierre.incluye(act))&& !(pila.esVacia())) {
            		 ant = pila.desapilar();
            		 if (!((act.equals(')') && ant.equals('(')) ||
            		 (act.equals(']') && ant.equals('[') )|| (act.equals('}') && ant.equals('{') )))
            			 return false;
            	 }
            	 else return false;
        }
        if (!pila.esVacia()) 
        	return false;
        
return true;
  
  
        
	}
	
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese los caracteres ()[]{} en el orden que desee : ");
		String str = s.next();
		s.close();
  
        if (esBalanceado(str))
            System.out.println("Esta balanceada");
        else 
        	System.out.println("No esta balanceada" );
    }
}