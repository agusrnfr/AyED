package Parcial.Practica.Ejercicio10;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	public ListaGenerica<String> resolver(ArbolGeneral<String> a){
		ListaGenerica<String> l = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		resolver(a,l,camino);
		
		return camino;
		
	}
	
	private void resolver (ArbolGeneral<String> a, ListaGenerica<String> l, ListaGenerica<String> camino) {
		
		if (!a.esVacio()) {
			String dato = a.getDato();
			l.agregarFinal(dato);
			if (dato.equals("princesa"))
				clonar(l,camino);
			if (camino.esVacia()) {
				ListaGenerica<ArbolGeneral<String>> hijos = a.getHijos();
				hijos.comenzar();
				while ((!hijos.fin()) && (camino.esVacia())) //me quedo con el primero que encuentro
					{
					ArbolGeneral<String> aux = hijos.proximo();
					if (!aux.getDato().equals("dragon")) {
						resolver(aux,l,camino);
						l.eliminarEn(l.tamanio());
					}
				}
			}
		}
		
	}
	
	private void clonar(ListaGenerica<String> l, ListaGenerica<String> camino) {
		l.comenzar();
		while(!l.fin())
			camino.agregarFinal(l.proximo());
	}

}
