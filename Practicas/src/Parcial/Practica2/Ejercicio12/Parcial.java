package Parcial.Practica2.Ejercicio12;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public int resolver (Grafo<Ciudad> ciudades,String origen,String destino,int maxControles) {
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()+1];
		Vertice<Ciudad> v = buscar(origen,ciudades);
		Maximo max = new Maximo (0);
		if (v!= null && buscar(destino,ciudades) != null) {
			resolver(v.getPosicion(),marca,destino,ciudades,maxControles,max,v.dato().getTransito());
		}
		return max.getMax();
	}
	
	private Vertice<Ciudad> buscar (String local,Grafo<Ciudad> ciudades){
		ListaGenerica<Vertice<Ciudad>> aux = ciudades.listaDeVertices();
		Vertice<Ciudad> v = null;
		aux.comenzar();
		while(!aux.fin()) {
			v = aux.proximo();
			if (v.dato().getNombre().equals(local))
				return v;
		}
		return null;
	}
	
	private void resolver(int i,boolean[]marca,String destino,Grafo<Ciudad> ciudades,int maxControles, Maximo max, int transito) {
		marca[i] = true;
		Vertice<Ciudad> v = ciudades.listaDeVertices().elemento(i);
		if (v.dato().getNombre().equals(destino)) {
			if (transito > max.getMax()) 
				max.setMax(transito);
		}else {
			ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<Ciudad>arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && arista.peso() <= maxControles) {
					resolver(j,marca,destino,ciudades,maxControles,max,transito+arista.verticeDestino().dato().getTransito());
					marca[j] = false;
				}	
			}
		}	
	}
}
