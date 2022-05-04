package Parcial.Practica.Ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> arbol){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		
		resolver (arbol,l);
		
		return l;
		
	}
	
	private Integer resolver (ArbolBinario<Integer> a, ListaGenerica<Integer>l) {
		int cant = 0;
		int cantizq = 0;
		int cantder = 0;
		
		if (a.esHoja()) 
			l.agregarFinal(a.getDato());
		else {
			if (a.tieneHijoIzquierdo()) {
				cantizq+= resolver(a.getHijoIzquierdo(),l);
				cant+= cantizq;
			}
			if (a.tieneHijoDerecho()) {
				cantder+= resolver(a.getHijoDerecho(),l);
				cant+=cantder;
			}
			if (cantder == cantizq)
				l.agregarFinal(a.getDato());
		}
		return cant + 1;
	}

}
