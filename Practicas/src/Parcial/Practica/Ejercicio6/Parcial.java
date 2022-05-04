package Parcial.Practica.Ejercicio6;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	
	public void colorearArbol(ArbolBinario<String> arbol, Integer maxColor) {
		ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
		ArbolBinario<String> aux;
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		String color = "negro";
		
		int cantidad = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				cantidad++;
				if (cantidad > maxColor)
					aux.setDato("verde");
				else
					aux.setDato(color);
				if (aux.tieneHijoIzquierdo())
					cola.encolar(aux.getHijoIzquierdo());
				if (aux.tieneHijoDerecho())
					cola.encolar(aux.getHijoDerecho());
			}
			else
				if (!cola.esVacia()) {
					cola.encolar(null);
					cantidad = 0;
					if (color.equals("negro"))
						color = "rojo";
					else
						if (color.equals("rojo"))
							color = "negro";
				}
		}
	}

}
