package Parcial.Practica2.Ejercicio9;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class MapaTest {

	public static void main(String[] args) {
		Vertice<String> v1 = new VerticeImplListAdy<String> ("Estacion 1");
		Vertice<String> v2 = new VerticeImplListAdy<String> ("Estacion 2");
		Vertice<String> v3 = new VerticeImplListAdy<String> ("Estacion 3");
		Vertice<String> v4 = new VerticeImplListAdy<String> ("Estacion 4");
		Vertice<String> v5 = new VerticeImplListAdy<String> ("Estacion 5");
		Vertice<String> v6 = new VerticeImplListAdy<String> ("Estacion 6");
		Vertice<String> v7 = new VerticeImplListAdy<String> ("Estacion 7");
		Vertice<String> v8 = new VerticeImplListAdy<String> ("Estacion 8");
		
		GrafoImplListAdy<String> grafo = new GrafoImplListAdy<String>();
		
		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);
		grafo.agregarVertice(v8);
		
		grafo.conectar(v1, v2);
		grafo.conectar(v2, v1);
		grafo.conectar(v1, v4);
		grafo.conectar(v4, v1);
		grafo.conectar(v2, v6);
		grafo.conectar(v6, v2);
		grafo.conectar(v4, v6);
		grafo.conectar(v6, v4);
		grafo.conectar(v3, v8);
		grafo.conectar(v8, v3);
		grafo.conectar(v8, v5);
		grafo.conectar(v5, v8);
		grafo.conectar(v5, v7);
		grafo.conectar(v7, v5);
		
		MapaDeBicisenda parcial = new MapaDeBicisenda(grafo);
		
		ListaEnlazadaGenerica<String> lis = parcial.buscarCaminoEntreOrigenYDestino("Estacion 9","Estacion 3");
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo());
		}
	}

}
