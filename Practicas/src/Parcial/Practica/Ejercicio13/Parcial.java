package Parcial.Practica.Ejercicio13;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	private ArbolGeneral<Integer> arbol;
	
	public Parcial (ArbolGeneral<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public Integer buscarMayorEnPostOrden() {
		return buscar (arbol);
	}
	
	private Integer buscar(ArbolGeneral<Integer> a) {
		int max = -1;
		
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				max = Math.max(max, buscar(hijos.proximo()));
			}
		}
		if (a.getDato() > max)
			max = a.getDato();
	
		return max;
		
	}
}
