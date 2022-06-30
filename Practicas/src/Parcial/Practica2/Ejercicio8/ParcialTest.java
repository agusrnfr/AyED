package Parcial.Practica2.Ejercicio8;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {
	public static void main(String[] args) {
		Persona persona1 = new Persona ("Juan","Empleado");
		Vertice <Persona> p1 = new VerticeImplListAdy<Persona>(persona1);
		Persona persona2 = new Persona ("Marta","Jubilado");
		Vertice <Persona> p2 = new VerticeImplListAdy<Persona>(persona2);
		Persona persona3 = new Persona ("Clotilde","Jubilado");
		Vertice <Persona> p3 = new VerticeImplListAdy<Persona>(persona3);
		Persona persona4 = new Persona ("Diana","Empleado");
		Vertice <Persona> p4 = new VerticeImplListAdy<Persona>(persona4);
		Persona persona5 = new Persona ("Eduardo","Jubilado");
		Vertice <Persona> p5 = new VerticeImplListAdy<Persona>(persona5);
		Persona persona6 = new Persona ("Jose","Jubilado");
		Vertice <Persona> p6 = new VerticeImplListAdy<Persona>(persona6);
		
		
		Grafo<Persona> grafo = new GrafoImplListAdy<Persona>();
		
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.agregarVertice(p4);
		grafo.agregarVertice(p5);
		grafo.agregarVertice(p6);
		
		grafo.conectar(p1, p4);
		grafo.conectar(p4, p1);
		grafo.conectar(p1, p6);
		grafo.conectar(p6, p1);
		grafo.conectar(p4, p5);
		grafo.conectar(p5, p4);
		grafo.conectar(p4, p3);
		grafo.conectar(p3, p4);
		grafo.conectar(p3, p2);
		grafo.conectar(p2, p3);
		
		
		Parcial parcial = new Parcial();
		
		ListaGenerica<Persona> lis = parcial.resolver(grafo, p1, 2, 40);
		
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo().getNombre());
		}
		
		
		
		
		
	}

}
