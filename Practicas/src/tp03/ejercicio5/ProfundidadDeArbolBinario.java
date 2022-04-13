package tp03.ejercicio5;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	ArbolBinario<Integer> arbol;
	
	public ProfundidadDeArbolBinario (ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	
	public int sumaElementosProfundidad(int p) {
		int suma=0;
		ArbolBinario<Integer> arbol2 = new ArbolBinario<Integer>();
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(arbol);
		cola.encolar(null);
		boolean ok = false;
		int nivel = 0;
		while ((!cola.esVacia()) && !ok) {
			arbol2 = cola.desencolar();
			if ((arbol2!= null)) {
				if (nivel == p)
					suma+= arbol2.getDato();
				if (arbol2.tieneHijoIzquierdo())
					cola.encolar(arbol2.getHijoIzquierdo());
				if (arbol2.tieneHijoDerecho())
					cola.encolar(arbol2.getHijoDerecho());
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				nivel++;	
			}
			
			if (nivel > p) 
				ok = true;
		}
		if (!ok) 
			return -1;
		else
			return suma;
	}
}
