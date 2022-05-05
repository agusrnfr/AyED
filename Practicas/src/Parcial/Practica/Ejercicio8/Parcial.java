package Parcial.Practica.Ejercicio8;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	public ListaGenerica<Integer> camino (ArbolGeneral<Integer> arbol){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		resolver (arbol,l);
		return l;
	}
	
	private void resolver (ArbolGeneral<Integer> a, ListaGenerica<Integer> l) {
		int cant = 0;
		l.agregarFinal(a.getDato());
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				cant++;
				ArbolGeneral<Integer> aux = hijos.proximo();
				if (cant == a.getDato())
					resolver(aux,l);
			}
		}
	}

}
