package Parcial.Practica2.Ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {

	public static void main(String[] args) {
				Sitio municipalidad = new Sitio("Municipalidad","Sin control Mafia");
		/*1*/	Vertice<Sitio> Municipalidad = new VerticeImplListAdy<Sitio>(municipalidad);
				Sitio sitio1 = new Sitio ("Sitio1","Sin control Mafia");
		/*2*/	Vertice<Sitio> Sitio1 = new VerticeImplListAdy<Sitio>(sitio1);
				Sitio sitio2 = new Sitio ("Sitio2","Sin control Mafia");
		/*3*/	Vertice<Sitio> Sitio2 = new VerticeImplListAdy<Sitio>(sitio2);
				Sitio sitio3 = new Sitio ("Sitio3","Sin control Mafia");
		/*4*/	Vertice<Sitio> Sitio3 = new VerticeImplListAdy<Sitio>(sitio3);
				Sitio sitio4 = new Sitio ("Sitio4","Control Mafia");
		/*5*/	Vertice<Sitio> Sitio4 = new VerticeImplListAdy<Sitio>(sitio4);
				Sitio casa = new Sitio ("Casa del Intendente","Sin control Mafia");
		/*6*/	Vertice<Sitio> CasaIntendente = new VerticeImplListAdy<Sitio>(casa);
		
		Grafo<Sitio> grafo = new GrafoImplListAdy<Sitio>();
		
		grafo.agregarVertice(Municipalidad);
		grafo.agregarVertice(Sitio1);
		grafo.agregarVertice(Sitio2);
		grafo.agregarVertice(Sitio3);
		grafo.agregarVertice(Sitio4);
		grafo.agregarVertice(CasaIntendente);
		
		grafo.conectar(Municipalidad, Sitio4,1);
		grafo.conectar(Sitio4, Municipalidad,1);
		grafo.conectar(Municipalidad, Sitio3,1);
		grafo.conectar(Sitio3, Municipalidad,1);
		grafo.conectar(Municipalidad, Sitio1,0);
		grafo.conectar(Sitio1, Municipalidad,0);
		grafo.conectar(Sitio3, Sitio4,0);
		grafo.conectar(Sitio4, Sitio3,0);
		grafo.conectar(Sitio1, Sitio2,0);
		grafo.conectar(Sitio2, Sitio1,0);
		grafo.conectar(Sitio3, CasaIntendente,1);
		grafo.conectar(CasaIntendente, Sitio3,1);
		grafo.conectar(Sitio4, CasaIntendente,0);
		grafo.conectar(CasaIntendente, Sitio4,0);
		grafo.conectar(Sitio2, CasaIntendente,0);
		grafo.conectar(CasaIntendente, Sitio2,0);
		
		Parcial parcial = new Parcial();
		
		ListaGenerica<String> lis = parcial.resolver(grafo);
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo());
		}

		
		

	}

}
