package tp04.ejercicio7;

import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable<T> {
	private ArbolGeneral<T> estructura;
	
	public RedDeAguaPotable(ArbolGeneral<T> estructura) {
		this.estructura = estructura;
	}
	
	public double minimoCaudal (double caudal) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ColaGenerica<Double> colaCaudal = new ColaGenerica<Double>();
		ArbolGeneral<T> aux;
		double auxCaudal;
		
		int nivel = 0;
		double min = 99999.9;
		
		cola.encolar(estructura);
		cola.encolar(null);
		
		colaCaudal.encolar(caudal);
		colaCaudal.encolar(0.0);
		
		System.out.println("NIVEL "+nivel+" : ");
		while (!cola.esVacia()) {
			int cantidad = 0;
			
			aux = cola.desencolar();
			auxCaudal = colaCaudal.desencolar();
			
			if (aux != null) {				
				System.out.println("NODO: "+ aux.getDato() + " CAUDAL: " + auxCaudal);
				if (auxCaudal < min)
					min = auxCaudal;
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lhijos = aux.getHijos();
					lhijos.comenzar();
					while (!lhijos.fin()) {
						cantidad++;
						cola.encolar(lhijos.proximo());
					}
					auxCaudal = auxCaudal / (double) cantidad;
				}
				else 
					auxCaudal = 0.0;
				for (int i= 0; i < cantidad; i++)
					colaCaudal.encolar(auxCaudal);	

			}
		else
			if (!cola.esVacia()) {
				cola.encolar(null);
				colaCaudal.encolar(0.0);
				nivel++;
				System.out.println("NIVEL "+nivel+" : ");
			}	
		}
		System.out.println(" ");
		return min;
	}
	
	public double minimoCaudal2(double caudal) {
		return minimoCaudal2(caudal,estructura);
	}
	
	private double minimoCaudal2 (double caudal,ArbolGeneral<T> a) {
		double min = 9999.99;
		if (a.esHoja()) {
			System.out.println("NODO: "+ a.getDato()+" CAUDAL: "+ caudal);
			return caudal;
		}
		if(a.tieneHijos()) {
			System.out.println("NODO: "+ a.getDato()+" CAUDAL: "+ caudal);
			ListaGenerica<ArbolGeneral<T>> l = a.getHijos();
			caudal = caudal /(double) l.tamanio();
			l.comenzar();
			while (!l.fin()) {
				min = Math.min(min,minimoCaudal2(caudal,l.proximo()));
			}
		}
		return min;
	}
}
