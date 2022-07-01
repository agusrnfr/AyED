package Parcial.Practica2.Ejercicio13;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class BuscadorDeCamino {
	
	public ListaGenerica<String> caminoDistanciaMaxima(Grafo<String> ciudades,String origen, String destino, int distanciaMaxima){
		boolean [] marca = new boolean[ciudades.listaDeVertices().tamanio()+1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		Vertice<String> v = buscar(origen,ciudades);
		if (v!= null && buscar(destino,ciudades) != null) {
			resolver(v.getPosicion(),marca,camino,destino,distanciaMaxima,ciudades);
		}
		return camino;
	}
	
	private Vertice<String> buscar(String local,Grafo <String> ciudades){
		ListaGenerica<Vertice<String>> aux = ciudades.listaDeVertices();
		Vertice<String> v = null;
		aux.comenzar();
		while(!aux.fin()) {
			v = aux.proximo();
			if (v.dato().equals(local))
				return v;
		}
		return null;
	}
	
	private boolean resolver (int i, boolean[] marca, ListaGenerica<String> camino, String destino, int distanciaMaxima,Grafo<String> ciudades) {
		boolean encontre = false;
		marca[i] = true;
		Vertice<String> v = ciudades.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(destino)) {
			encontre = true;
		}else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && !encontre) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && arista.peso()<= distanciaMaxima) {
					encontre = resolver(j,marca,camino,destino,distanciaMaxima,ciudades);
				}
			}
			if (!encontre) {
				marca[i] = false;
				camino.eliminarEn(camino.tamanio());
			}
		}
		return encontre;
	}

}
