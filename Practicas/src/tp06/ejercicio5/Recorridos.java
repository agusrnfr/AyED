package tp06.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos <T> {
	public ListaGenerica<Vertice<T>> dfs (Grafo<T> grafo){
		boolean[]marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		for (int i=1; i<=grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i])
				dfs(i,grafo,lis,marca);
		}
		return lis;
	}
	
	private void dfs (int i,Grafo<T> grafo,ListaEnlazadaGenerica<Vertice<T>> lis, boolean[] marca) {
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		lis.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if (!marca[j])
				dfs(j,grafo,lis,marca);
		}
		
	}
	
	public ListaGenerica<Vertice<T>> bfs (Grafo<T> grafo){
		boolean[]marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		for (int i=1; i<=grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i])
				bfs(i,grafo,lis,marca);
		}
		return lis;
	}
	
	private void bfs (int i,Grafo<T> grafo,ListaEnlazadaGenerica<Vertice<T>> lis, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i]= true;
		while(!q.esVacia()) {
			Vertice <T> v = q.desencolar();
			lis.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
		
	}
}
