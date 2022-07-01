package Parcial.Practica2.Ejercicio10;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class BuscadorDeCaminos {
	private Grafo<String> bosque;
	
	public BuscadorDeCaminos(Grafo<String> grafo) {
		this.bosque = grafo;
	}
	
	public ListaGenerica<ListaGenerica<String>> recorridosMasSeguro(){
		boolean[] marca = new boolean[bosque.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<ListaGenerica<String>> lista = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		ListaGenerica<Vertice<String>> aux = bosque.listaDeVertices();
		boolean ok = false;
		Vertice<String> v = null;
		aux.comenzar();
		while(!aux.fin() && !ok) {
			v = aux.proximo();
			if (v.dato().equals("Casa Caperucita"))
				ok = true;
		}
		if (ok) {
			resolver(v.getPosicion(),camino,lista,marca);
		}
		return lista;
		
	}
	
	private void resolver (int i,ListaGenerica<String> camino, ListaGenerica<ListaGenerica<String>> lista, boolean [] marca) {
		marca[i] = true;
		Vertice<String> v = bosque.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals("Casa Abuelita")) {
			lista.agregarFinal(camino.clonar());
		}else {
			ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && arista.peso() <5) {
					resolver(j,camino,lista,marca);
					marca[j] = false;
					camino.eliminarEn(camino.tamanio());
				}
			}
		}
	}

}
