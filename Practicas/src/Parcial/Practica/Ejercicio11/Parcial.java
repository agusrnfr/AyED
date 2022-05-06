package Parcial.Practica.Ejercicio11;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	public Boolean esArbolCreciente(ArbolBinario<Integer> arbol) {
		if (arbol.esVacio())
			return false;
		else {
			ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
			ArbolBinario<Integer> aux;
			
			cola.encolar(arbol);
			cola.encolar(null);
			
			Boolean ok = true;
			int cant = 0;
			int nivel = 0;
			while ((!cola.esVacia())&& (ok)) {
				aux = cola.desencolar();
				if (aux != null) {
					cant++;
					if (aux.tieneHijoIzquierdo())
						cola.encolar(aux.getHijoIzquierdo());
					if (aux.tieneHijoDerecho())
						cola.encolar(aux.getHijoDerecho());
				}
				else {
					if (cant != nivel + 1)
						ok = false;
					if (!cola.esVacia()) {
						cola.encolar(null);
						nivel++;
						cant = 0;
					}
				}
			}
			return ok;
		}
		
	}

}
