package Parcial.Practica.Ejercicio7;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	public void colorearArbol(ArbolBinario<String> arbol, Integer n, Integer m) {
		ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
		ArbolBinario<String> aux;
		
		int nivel = 0;
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if ((nivel >= n) && (nivel <=m))
					aux.setDato("rojo");
				else
					aux.setDato("negro");
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
	}

}
