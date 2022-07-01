package Parcial.Practica2.Ejercicio4;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public int maximoGradoDeSeparacion(Grafo<String> grafo) {
		int max = -1;
		
		for (int i = 1; i <= grafo.listaDeVertices().tamanio();i++) {
			boolean[] marca = new boolean [grafo.listaDeVertices().tamanio() +1];
			if (!marca[i]) {
				max = Math.max(max, bfs(grafo,i,marca));
				if (max == 0) 
					return 0;
			}
		}
		return max;
	}
	
	private int bfs (Grafo<String> grafo, int i, boolean[] marca) {
		ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
		
		cola.encolar(grafo.listaDeVertices().elemento(i));
		cola.encolar(null);
		int visitas = 1;
		int nivel = 0;
		marca[i] = true;
		while(!cola.esVacia()) {
			Vertice<String> v = cola.desencolar();
			if (v!= null) {
				ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
				ady.comenzar();
				while(!ady.fin()) {
					Arista<String> arista = ady.proximo();
					int j = arista.verticeDestino().getPosicion();
					if (!marca[j]) {
						cola.encolar(arista.verticeDestino());
						marca[j] = true;
						visitas++;
					}
				}
				
			}
			else {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
				}
			}
		}
		if (visitas < grafo.listaDeVertices().tamanio()) 
			return 0;
			else return nivel;
	}

}
