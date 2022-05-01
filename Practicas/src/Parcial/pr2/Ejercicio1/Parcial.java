package Parcial.pr2.Ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	
	public ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> caminosPares (ArbolGeneral<Character> arbol){
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> lista = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>>();
		int cantidad = 0;
		ListaEnlazadaGenerica<Character> listaNormal = new ListaEnlazadaGenerica<Character>();
		listaNormal.agregarInicio(arbol.getDato());
		ListaEnlazadaGenerica<Character> camino = new ListaEnlazadaGenerica<Character>();
		caminosPares(cantidad,arbol,lista,listaNormal,camino);
		return lista;
		
		
	}
	
	private void clonarLista(ListaEnlazadaGenerica<Character> listaNormal,ListaEnlazadaGenerica<Character> camino) {
		listaNormal.comenzar();
		while (!listaNormal.fin()) {
			camino.agregarFinal(listaNormal.proximo());
		}
		
		
	}
	
	private void caminosPares(int cantidad,ArbolGeneral<Character> arbol,ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> lista,
			ListaEnlazadaGenerica<Character> listaNormal,ListaEnlazadaGenerica<Character> camino) {
		cantidad = cantidad + 1;
		if (arbol.esHoja()) {
			if (cantidad % 2 == 0) {
				clonarLista(listaNormal,camino);
				lista.agregarFinal(camino);
			}
		}
		if (arbol.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos(); 
			hijos.comenzar();
			while (!hijos.fin()) {
				ArbolGeneral<Character> aux = hijos.proximo();
				listaNormal.agregarFinal(aux.getDato());				
				camino = new ListaEnlazadaGenerica<Character>();
				caminosPares(cantidad,aux,lista,listaNormal,camino);				
				listaNormal.eliminarEn(listaNormal.tamanio());	
			}
		}
		
	}
}
