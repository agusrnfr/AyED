package Parcial.Practica.Ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	
	private ArbolGeneral<Integer> arbol;
	
	public Parcial (ArbolGeneral<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaGenerica<Integer> resolver(){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		
		postOrden (arbol,l);
		
		return l;
	}
	
	private void postOrden (ArbolGeneral<Integer> a, ListaGenerica<Integer> l) {
		Integer suma = 0;
		Boolean ok = false;
		
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			while (!hijos.fin()) {
				ArbolGeneral<Integer> aux = hijos.proximo();
				if ((hijos.tamanio()%2) == 1) {
					ok = true;
					suma+= aux.getDato();
				}
				postOrden(aux,l);
				}
			}
		if (!a.esHoja()) {
			if (ok) {
				l.agregarFinal(suma);
			}
		}
		
	}

}
