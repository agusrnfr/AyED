package Parcial.Practica2.Ejercicio9;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;

public class MapaDeBicisenda {
	private GrafoImplListAdy<String> grafo;
	
	public MapaDeBicisenda (GrafoImplListAdy<String> grafo) {
		this.grafo = grafo;
	}
	
	public ListaEnlazadaGenerica<String> buscarCaminoEntreOrigenYDestino(String origen, String destino){
		
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		Vertice<String> v = buscar(origen);
		if (v != null && buscar(destino) != null) {
			resolver(v.getPosicion(),lis,marca,destino);
		}
		return lis;
		
	}
	
	private boolean resolver (int i, ListaEnlazadaGenerica<String> lis, boolean[] marca, String destino) {
		boolean encontre = false;
		marca[i] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		lis.agregarFinal(v.dato());
		if (v.dato().equals(destino)) {
			encontre = true;	
		}else {
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && !encontre) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					encontre = resolver(j,lis,marca,destino);
				}
			}
			if (!encontre) {
				marca[i] = false;
				lis.eliminarEn(lis.tamanio());
			}
		}
		return encontre;
	}
	
	public Vertice<String> buscar (String ciudad){
		ListaGenerica<Vertice<String>> aux = grafo.listaDeVertices();
		Vertice<String> v = null;
		aux.comenzar();
		while(!aux.fin ()) {
			v = aux.proximo();
			if (v.dato().equals(ciudad))
				return v;
		}
		return null;
		
	}
	

}
