package Parcial.Practica2.Ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public ListaGenerica<ListaGenerica<String>> resolver (Grafo<String> ciudades){
		boolean [] marca = new boolean [ciudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<ListaGenerica<String>> listaDeListas = new ListaEnlazadaGenerica<ListaGenerica<String>> ();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		int costo;
		for (int i = 1; i <= ciudades.listaDeVertices().tamanio(); i++) {
			costo = 0;
			resolver(i,camino,listaDeListas,marca,ciudades,costo);
			marca[i] = false;
			camino.eliminarEn(camino.tamanio());
		}
		
		return listaDeListas;
	}

	
	private void resolver (int i ,ListaGenerica<String> camino, ListaGenerica<ListaGenerica<String>> listaDeListas,boolean[] marca, Grafo<String> ciudades, int costo) {
		marca[i] = true;
		Vertice<String> v = ciudades.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (costo == 10) {
			listaDeListas.agregarFinal(camino.clonar());
		}
		else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && (costo + arista.peso()<=10)) {
					resolver(j,camino,listaDeListas,marca,ciudades,costo + arista.peso());
					marca[j] = false;
					camino.eliminarEn(camino.tamanio());
				}
			}
		}
	}
}
