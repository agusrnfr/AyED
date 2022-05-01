package Parcial.pr2.Ejercicio1;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Ejercicio1_6 {
	public ListaDeEnterosEnlazada c ( int n) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		l.agregarFinal(n);
		c(n,l);
		return l;
	}
	
	private void c(int n, ListaDeEnterosEnlazada l) {
		if (n != 1) {
			if (n % 2 == 0) 
				n = n/2;
			else
				n = 3*n+1;
			l.agregarFinal(n);
			c(n,l);
		}
	}

}
