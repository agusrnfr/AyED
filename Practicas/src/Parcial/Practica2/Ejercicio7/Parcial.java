package Parcial.Practica2.Ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public int resolver (Grafo<String> grafo, Vertice<String> inicial) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		
		return bfs (grafo,marca,inicial);
		
	}
	
	private int bfs (Grafo<String> grafo, boolean[] marca, Vertice<String> v) {
		int nivel = 0;
		ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
		cola.encolar(v);
		cola.encolar(null);
		marca[v.getPosicion()] = true;
		
		while(!cola.esVacia()) {
			Vertice<String> aux = cola.desencolar();
			
			if (aux!= null) {
				ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(aux);
				ady.comenzar();
				while(!ady.fin()) {
					Arista<String> arista = ady.proximo();
					int j = arista.verticeDestino().getPosicion();
					if (!marca[j]) {
						cola.encolar(arista.verticeDestino());
						marca[j] = true;
					}
				}
			} else 
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
				}
		}
			
		return nivel;
	}

}
