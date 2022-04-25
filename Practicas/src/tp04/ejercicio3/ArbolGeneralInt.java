package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ArbolGeneralInt {
	private ArbolGeneral<Integer> arbol;
	
	public ArbolGeneralInt(ArbolGeneral<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePreOrden(n,l,this.arbol);
		return l;
	}
	
	private void numerosImparesMayoresQuePreOrden(Integer n,ListaGenerica<Integer> l,ArbolGeneral<Integer> arbol){
		if ((arbol.getDato() % 2 == 1) && (arbol.getDato() > n )) 
			l.agregarFinal(arbol.getDato());
		if(arbol.tieneHijos()) {
			ListaGenerica <ArbolGeneral<Integer>> lhijos = arbol.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin()) 
				numerosImparesMayoresQuePreOrden(n,l,lhijos.proximo());
		}
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden (Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQueInOrden(n,l,this.arbol);
		return l;
	}
	
	private void numerosImparesMayoresQueInOrden (Integer n,ListaGenerica<Integer> l,ArbolGeneral<Integer> arbol){
		if (arbol.tieneHijos()) {
			ListaGenerica <ArbolGeneral<Integer>> lhijos = arbol.getHijos();
			lhijos.comenzar();
			numerosImparesMayoresQueInOrden(n,l,lhijos.proximo());
		}
		if (((arbol.getDato() % 2) == 1) && (arbol.getDato() > n )) 
			l.agregarFinal(arbol.getDato());
		
		if(arbol.tieneHijos()) {
			ListaGenerica <ArbolGeneral<Integer>> lhijos = arbol.getHijos();
			while (!lhijos.fin()) 
				numerosImparesMayoresQueInOrden(n,l,lhijos.proximo());
		}
	}


	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden (Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePostOrden(n,l,this.arbol);
	return l;
	}

	private void numerosImparesMayoresQuePostOrden (Integer n,ListaGenerica<Integer> l,ArbolGeneral<Integer> arbol){
		if(arbol.tieneHijos()) {
			ListaGenerica <ArbolGeneral<Integer>> lhijos = arbol.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin()) 
				numerosImparesMayoresQuePostOrden(n,l,lhijos.proximo());
		}
		if (((arbol.getDato() % 2) == 1) && (arbol.getDato() > n )) 
			l.agregarFinal(arbol.getDato());
		
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux;
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux!= null) {
				if (((aux.getDato() % 2) == 1) && (aux.getDato() > n )) 
					l.agregarFinal(aux.getDato());
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> lhijos = aux.getHijos();
					lhijos.comenzar();
					while (!lhijos.fin()) {
						cola.encolar(lhijos.proximo());
					}
					
				}
			}
			else
				if (!cola.esVacia())
					cola.encolar(null);		
		}
		
		return l;
	}
}
