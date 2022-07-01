package Parcial.Practica2.Ejercicio11;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class CaminoSinControles {
	private Grafo<String> mapa;
	
	public CaminoSinControles(Grafo<String> mapa) {
		this.mapa = mapa;
	}
	
	public ListaGenerica<ListaGenerica<String>> devolverCaminos(String origen, String destino){
		boolean[] marca = new boolean[mapa.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String> ();
		ListaGenerica<ListaGenerica<String>> lista = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		ListaGenerica<Vertice<String>> aux = mapa.listaDeVertices();
		boolean ok = false;
		Vertice<String> v = null;
		aux.comenzar();
		while(!aux.fin()&&!ok) {
			v = aux.proximo();
			if (v.dato().equals(origen))
				ok = true;
		}
		if (ok) {
			resolver(v.getPosicion(),marca,camino,lista,destino);
		}
		return lista;
		
	}
	
	private void resolver (int i, boolean[] marca,ListaGenerica<String> camino,ListaGenerica<ListaGenerica<String>> lista, String destino) {
		marca[i] = true;
		Vertice<String> v = mapa.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(destino)) {
			lista.agregarFinal(camino.clonar());
		}
		else {
			ListaGenerica<Arista<String>> ady = mapa.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && arista.peso() == 0) {
					resolver(j,marca,camino,lista,destino);
					marca[j] = false;
					camino.eliminarEn(camino.tamanio());
				}
				
			}
		}
	}

}
