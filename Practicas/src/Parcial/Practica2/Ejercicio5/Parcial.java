package Parcial.Practica2.Ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public ListaGenerica<String> resolver (Grafo<Sitio> grafo){
		boolean [] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		boolean ok = false;
		ListaGenerica<Vertice<Sitio>> vertices = grafo.listaDeVertices();
		Vertice<Sitio> v = null;
		vertices.comenzar();
		while(!vertices.fin() && !ok) {
			v = vertices.proximo();
			if (v.dato().getNombre().equals("Municipalidad")) {
				ok = true;
			}
		}
		if (ok) {
			dfs (grafo,camino,marca,v.getPosicion());
		}
		
		return camino;
	}
	
	private boolean dfs (Grafo<Sitio> grafo, ListaGenerica<String> camino, boolean [] marca,int i) {
		boolean encontre = false;
		marca[i] = true;
		Vertice<Sitio> v = grafo.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato().getNombre());
		if (v.dato().getNombre().equals("Casa del Intendente")) {
			encontre = true;
		}else {
			ListaGenerica<Arista<Sitio>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && !encontre) {
				Arista<Sitio> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && arista.peso()!= 1 && arista.verticeDestino().dato().getEstado().equals("Sin control Mafia")) {
					encontre = dfs(grafo,camino,marca,j);
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
