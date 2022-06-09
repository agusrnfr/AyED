package tp06.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class RecorridosTest {

	public static void main(String[] args) {
		Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
		Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");

		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);

		ciudades.conectar(v1, v2);
		ciudades.conectar(v1, v3);
		ciudades.conectar(v1, v4);
		ciudades.conectar(v1, v5);
		ciudades.conectar(v2, v5);
		ciudades.conectar(v2, v7);
		ciudades.conectar(v3, v5);
		ciudades.conectar(v4, v5);
		ciudades.conectar(v6, v5);
		ciudades.conectar(v6, v7);


		Recorridos<String> r = new Recorridos<String>();
		System.out.println("--- Se imprime el GRAFO con DFS ---");
		ListaGenerica <Vertice<String>> lis = r.dfs(ciudades);
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo().dato());
		}
		System.out.println(" ");
		System.out.println("--- Se imprime el GRAFO con BFS ---");
		ListaGenerica <Vertice<String>> lis2 = r.bfs(ciudades);
		lis2.comenzar();
		while(!lis2.fin()) {
			System.out.println(lis2.proximo().dato());
		}
	}

}
