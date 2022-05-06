package Parcial.Practica.Ejercicio12;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	private ArbolBinario<Integer> arbol;
	
	public Parcial (ArbolBinario<Integer> arbol) {
	this.arbol = arbol;
	}
	
	public ArbolBinario<Integer> minEnNivelDeAB (int n){
		if (arbol.esVacio())
			return null;
		else {
			ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
			ArbolBinario<Integer> aux;
			
			cola.encolar(arbol);
			cola.encolar(null);
			
			int nivel = 0;
			int min = 9999;
			
			ArbolBinario<Integer> minArbol = null;
			
			while ((!cola.esVacia()) && (nivel <= n)) {
				aux = cola.desencolar();
				if (aux != null) {
					if ((nivel ==n)&&(aux.esHoja())&& (aux.getDato() < min)) {
						min = aux.getDato();
						minArbol = aux;
					}
					if (aux.tieneHijoIzquierdo())
						cola.encolar(aux.getHijoIzquierdo());
					if (aux.tieneHijoDerecho())
						cola.encolar(aux.getHijoDerecho());
				}
				else 
					if (!cola.esVacia()) {
						cola.encolar(null);
						nivel++;
					}
			}
			return minArbol;

		}
	}

}
