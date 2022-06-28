package Parcial.Practica2.Ejercicio2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public ListaGenerica<String> resolver (Grafo<String> ciudades, String origen, String destino, ListaGenerica<String> pasandoPor){
		
		boolean [] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		boolean ok = false;
		ListaGenerica<Vertice<String>> aux = ciudades.listaDeVertices();
		Vertice<String> v = null;
		aux.comenzar();
		while(!aux.fin() && !ok) {
			v = aux.proximo();
			if (v.dato().equals(origen)) {
				ok = true;
			}
		}
		if (ok) {
			resolver(v.getPosicion(),ciudades,destino,camino,pasandoPor,marca);
		}
		
		return camino;
		
	}
	
	private boolean resolver (int i,Grafo<String> ciudades, String destino, ListaGenerica<String> camino, ListaGenerica<String> pasandoPor, boolean[] marca) {
		boolean encontre = false;
		marca[i] = true;
		Vertice<String> v = ciudades.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(destino)) {
			encontre = true;
			pasandoPor.comenzar();
			while(!pasandoPor.fin() && encontre) {
				encontre = camino.incluye(pasandoPor.proximo());
			}
		}
		else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && !encontre) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					encontre= resolver(j,ciudades,destino,camino,pasandoPor,marca);
					if (!encontre) {
						marca[j] = false;
						camino.eliminarEn(camino.tamanio());
					}
				}
			}					
		}
		
		return encontre;
	}

}
