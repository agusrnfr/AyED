package Parcial.pr2.Ejercicio1;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Test {
	public static void main (String[]args) {
		Ejercicio1_6 test = new Ejercicio1_6();
		
		ListaDeEnterosEnlazada l = test.c(6);
		
		l.comenzar();
		while(!l.fin()) {
			System.out.println(l.proximo());
		}
	}

}
