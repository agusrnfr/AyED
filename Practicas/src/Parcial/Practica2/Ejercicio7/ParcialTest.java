package Parcial.Practica2.Ejercicio7;

import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {

	public static void main(String[] args) {
		/*1*/	Vertice<String> PC1 = new VerticeImplListAdy<String>("PC 1");
		/*2*/	Vertice<String> PC2 = new VerticeImplListAdy<String>("PC 2");
		/*3*/	Vertice<String> PC3 = new VerticeImplListAdy<String>("PC 3");
		/*4*/	Vertice<String> PC4 = new VerticeImplListAdy<String>("PC 4");
		/*5*/	Vertice<String> PC5 = new VerticeImplListAdy<String>("PC 5");
		/*6*/	Vertice<String> PC6 = new VerticeImplListAdy<String>("PC 6");
		
		Grafo<String> grafo = new GrafoImplListAdy<String>();
		
		grafo.agregarVertice(PC1);
		grafo.agregarVertice(PC2);
		grafo.agregarVertice(PC3);
		grafo.agregarVertice(PC4);
		grafo.agregarVertice(PC5);
		grafo.agregarVertice(PC6);
		
		grafo.conectar(PC1, PC2);
		grafo.conectar(PC2, PC1);
		grafo.conectar(PC1, PC4);
		grafo.conectar(PC4, PC1);
		grafo.conectar(PC2, PC5);
		grafo.conectar(PC5, PC2);
		grafo.conectar(PC2, PC3);
		grafo.conectar(PC3, PC2);
		grafo.conectar(PC4, PC3);
		grafo.conectar(PC3, PC4);
		
		
		Parcial parcial = new Parcial();
		
		System.out.println("TIEMPO EN INFECTAR: " + parcial.resolver(grafo, PC1));
		

	}

}
