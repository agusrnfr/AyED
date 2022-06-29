package Parcial.Practica2.Ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public ListaGenerica<ListaGenerica<String>> resolver (Grafo<String> ciudades,String origen, String destino, String pasandoPor){
		
		boolean[] marca = new boolean [ciudades.listaDeVertices().tamanio() +1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<ListaGenerica<String>> listaDeListas = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		
		ListaGenerica<Vertice<String>> aux = ciudades.listaDeVertices();
		boolean ok = false;
		Vertice<String> v = null;
		while (!aux.fin() && !ok) {
			v = aux.proximo();
			if (v.dato().equals(origen)){
				ok = true;
			}
		}
		if (ok) {
			resolver (ciudades,destino,pasandoPor,marca,camino,listaDeListas,v.getPosicion());
		}
		
		return listaDeListas;
	}
	
	private void resolver (Grafo<String> ciudades, String destino, String pasandoPor, boolean[]marca, ListaGenerica<String> camino, ListaGenerica<ListaGenerica<String>> listaDeListas,int i) {
		marca[i] = true;
		Vertice<String> v = ciudades.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(destino) && camino.incluye(pasandoPor)) {
			listaDeListas.agregarFinal(camino.clonar());
		}
		else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && arista.peso() == 1) {
					resolver (ciudades,destino,pasandoPor,marca,camino,listaDeListas,j);
					marca[j] = false;
					camino.eliminarEn(camino.tamanio());
				}
			}
			
		}
	}

}
