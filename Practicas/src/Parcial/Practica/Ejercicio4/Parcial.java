package Parcial.Practica.Ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	private ArbolGeneral<Integer> arbol;

	public Parcial (ArbolGeneral<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaGenerica<Integer> devolverCamino(){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<Integer>();
		resolver(arbol,l,camino);
		return camino;
	} 
	
	private void resolver(ArbolGeneral<Integer> a,ListaGenerica<Integer> l, ListaGenerica<Integer> camino) {
		if (!a.esVacio()) {
			l.agregarFinal(a.getDato());
			if(a.esHoja()) {
				if(l.tamanio() > camino.tamanio())
					clonar(l,camino);
			}
			else{
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					resolver(hijos.proximo(),l,camino);
					l.eliminarEn(l.tamanio());
				}
			}
		}
	}
	
	
	private void clonar (ListaGenerica<Integer> l, ListaGenerica<Integer> camino) {
		camino.comenzar();
		while(!camino.fin())
			camino.eliminar(camino.proximo());
		l.comenzar();
		while(!l.fin())
			camino.agregarFinal(l.proximo());
			
	}
	
}
