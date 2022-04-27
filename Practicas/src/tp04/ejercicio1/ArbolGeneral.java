package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
public ListaGenerica<T> numerosImparesMayoresQuePreOrden (Integer n){
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();
		if (this.getDato().getClass().getSimpleName().equals("Integer")) {
			numerosImparesMayoresQuePreOrden(n,l);
		}
		return l;
	}
	
	private void numerosImparesMayoresQuePreOrden (Integer n,ListaGenerica<T> l){
		int num = (int) this.getDato();
		if (((num % 2) == 1) && (num > n )) 
			l.agregarFinal(this.getDato());
		if(this.tieneHijos()) {
			ListaGenerica <ArbolGeneral<T>> lhijos = this.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin()) 
				lhijos.proximo().numerosImparesMayoresQuePreOrden(n,l);
		}
	}
	
	public ListaGenerica<T> numerosImparesMayoresQueInOrden (Integer n){
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();
		if (this.getDato().getClass().getSimpleName().equals("Integer")) {
			numerosImparesMayoresQueInOrden(n,l);
		}
	return l;
	}
	
	private void numerosImparesMayoresQueInOrden (Integer n,ListaGenerica<T> l){
		if (this.tieneHijos()) {
			ListaGenerica <ArbolGeneral<T>> lhijos = this.getHijos();
			lhijos.comenzar();
			lhijos.proximo().numerosImparesMayoresQueInOrden(n,l);
		}
		int num = (int) this.getDato();
		if (((num % 2) == 1) && (num > n )) 
			l.agregarFinal(this.getDato());
		if(this.tieneHijos()) {
			ListaGenerica <ArbolGeneral<T>> lhijos = this.getHijos();
			while (!lhijos.fin()) 
				lhijos.proximo().numerosImparesMayoresQuePreOrden(n,l);
		}
	}
	
	public ListaGenerica<T> numerosImparesMayoresQuePostOrden (Integer n){
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();
		if (this.getDato().getClass().getSimpleName().equals("Integer")) {
			numerosImparesMayoresQuePostOrden(n,l);
		}
	return l;
	}
	
	private void numerosImparesMayoresQuePostOrden (Integer n,ListaGenerica<T> l){
		if(this.tieneHijos()) {
			ListaGenerica <ArbolGeneral<T>> lhijos = this.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin()) 
				lhijos.proximo().numerosImparesMayoresQuePostOrden(n,l);
		}
		int num = (int) this.getDato();
		if (((num % 2) == 1) && (num > n )) 
			l.agregarFinal(this.getDato());
		
	}

	
	public ListaGenerica<T> numerosImparesMayoresQuePorNiveles(Integer n){
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();
		if (this.getDato().getClass().getSimpleName().equals("Integer")) {
			int num = (int) this.getDato();
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			ArbolGeneral<T> aux;
			
			cola.encolar(this);
			cola.encolar(null);
			
			while(!cola.esVacia()) {
				aux = cola.desencolar();
				if (aux!= null) {
					num = (int) aux.getDato();
					if (((num % 2) == 1) && (num > n )) 
						l.agregarFinal(aux.getDato());
					if (aux.tieneHijos()) {
						ListaGenerica<ArbolGeneral<T>> lhijos = aux.getHijos();
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
		}
		return l;
	}

	
	public Integer altura() {
		int altura=-1;
		if (this.esHoja())
			return 0;
		else {
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
				lhijos.comenzar();
				while (!lhijos.fin()){
					altura = Math.max(altura,lhijos.proximo().altura());
				}
			}	
		}
		
		return altura + 1;
	}

	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		
		cola.encolar(this);
		cola.encolar(null);
		
		int nivel = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (aux.getDato() == dato)
					return nivel;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lhijos = aux.getHijos();
					lhijos.comenzar();
					while (!lhijos.fin()){
						cola.encolar(lhijos.proximo());
					}
				}
			}
			else
				if (!cola.esVacia()) {			
					cola.encolar(null);
					nivel++;
				}
		}
		return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		
		cola.encolar(this);
		cola.encolar(null);
		
		int cantidad=0,max = -1,nivel = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				cantidad = cantidad + 1;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lhijos = aux.getHijos();
					lhijos.comenzar();
					while (!lhijos.fin()){
						cola.encolar(lhijos.proximo());
					}
				}
			}
			else
				if (!cola.esVacia()) {			
					cola.encolar(null);
					nivel++;
					if(cantidad > max)
						max = cantidad;
					cantidad=0;
				}
		}
		return max;
	}

}