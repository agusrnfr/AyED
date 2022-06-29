package Parcial.Practica2.Ejercicio4;

import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {

	public static void main(String[] args) {
		/*1*/	Vertice<String> Jorge = new VerticeImplListAdy<String>("Jorge");
		/*2*/	Vertice<String> Ariel = new VerticeImplListAdy<String>("Ariel");
		/*3*/	Vertice<String> Juan = new VerticeImplListAdy<String>("Juan");
		/*4*/	Vertice<String> Matias = new VerticeImplListAdy<String>("Matias");
		/*5*/	Vertice<String> Alex = new VerticeImplListAdy<String>("Alex");
		
		Grafo<String> personas = new GrafoImplListAdy<String>();
		
		personas.agregarVertice(Jorge);
		personas.agregarVertice(Matias);
		personas.agregarVertice(Juan);
		personas.agregarVertice(Ariel);
		personas.agregarVertice(Alex);
		
		personas.conectar(Jorge, Matias);
		personas.conectar(Matias, Jorge);
		personas.conectar(Matias, Ariel);
		personas.conectar(Ariel, Matias);
		personas.conectar(Juan, Matias);
		personas.conectar(Matias, Juan);
		personas.conectar(Ariel, Juan);
		personas.conectar(Juan, Ariel);
		personas.conectar(Ariel, Alex);
		personas.conectar(Alex, Ariel);
		
		Parcial parcial = new Parcial();
		
		System.out.println("MAXIMO GRADO DE SEPARACION: " + parcial.maximoGradoDeSeparacion(personas));
		
		
		

	}

}
