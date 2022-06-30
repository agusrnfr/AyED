package Parcial.Practica2.Ejercicio8;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
	
	public ListaGenerica<Persona> resolver (Grafo<Persona> grafo, Vertice<Persona> empleado, int grado, int maxPersonas){
		boolean[] marca = new boolean [grafo.listaDeVertices().tamanio() + 1];
		ListaGenerica<Persona> jubilados = new ListaEnlazadaGenerica<Persona>();
		
		bfs (jubilados,marca,grafo,empleado,grado,maxPersonas);
		
		return jubilados;
	}
	
	private void bfs(ListaGenerica<Persona> jubilados, boolean[] marca, Grafo<Persona> grafo, Vertice <Persona> empleado, int grado, int maxPersonas) {
		ColaGenerica<Vertice<Persona>> cola = new ColaGenerica<Vertice<Persona>>();
		marca[empleado.getPosicion()] = true;
		
		cola.encolar(empleado);
		cola.encolar(null);
		
		while(!cola.esVacia() && jubilados.tamanio() < maxPersonas && grado > 0) {
			Vertice<Persona> v = cola.desencolar();
			if (v != null) {
				ListaGenerica<Arista<Persona>> ady = grafo.listaDeAdyacentes(v);
				ady.comenzar();
				while(!ady.fin() && jubilados.tamanio() < maxPersonas) {
					Arista<Persona> arista = ady.proximo();
					int j = arista.verticeDestino().getPosicion();
					if (!marca[j]) {
						cola.encolar(arista.verticeDestino());
						marca[j] = true;
						if (arista.verticeDestino().dato().getTipo().equals("Jubilado")) {
							jubilados.agregarFinal(arista.verticeDestino().dato());
						}
					}
				}
			}
			else
				if (!cola.esVacia()) {
					cola.encolar(null);
					grado--;
				}
		}
	}

}
