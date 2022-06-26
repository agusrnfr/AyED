package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class MapaTest {

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

		ciudades.conectar(v1, v2,3);
		ciudades.conectar(v1, v3,2);
		ciudades.conectar(v1, v4,4);
		ciudades.conectar(v1, v5,10);
		ciudades.conectar(v2, v5,500);
		ciudades.conectar(v2, v7,4);
		ciudades.conectar(v3, v5,4);
		ciudades.conectar(v4, v5,6);
		ciudades.conectar(v6, v5,11);
		ciudades.conectar(v6, v7,10);
		
		Mapa m = new Mapa (ciudades);
		
		ListaGenerica<String> lis = m.devolverCamino("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime devolverCamino ---");
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo());
		}
		
		ListaGenerica<String> lis6 = m.devolverCamino2("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime devolverCamino 2 ---");
		lis6.comenzar();
		while(!lis6.fin()) {
			System.out.println(lis6.proximo());
		}
		
		ListaEnlazadaGenerica<String> exceptuando = new ListaEnlazadaGenerica<String>();
		exceptuando.agregarFinal("Santiago");
		exceptuando.agregarFinal("Lima");
		exceptuando.agregarFinal("Montevideo");
		ListaGenerica<String> lis2 = m.devolverCaminoExceptuando("Buenos Aires","Asuncion",exceptuando);
		System.out.println("--- Se imprime devolverCaminoExceptuando ---");
		lis2.comenzar();
		while(!lis2.fin()) {
			System.out.println(lis2.proximo());
		}
		
		ListaGenerica<String> lis7 = m.devolverCaminoExceptuando2("Buenos Aires","Asuncion",exceptuando);
		System.out.println("--- Se imprime devolverCaminoExceptuando 2 ---");
		lis7.comenzar();
		while(!lis7.fin()) {
			System.out.println(lis7.proximo());
		}
		
		ListaGenerica<String> lis3 = m.caminoMasCorto("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime caminoMasCorto ---");
		lis3.comenzar();
		while(!lis3.fin()) {
			System.out.println(lis3.proximo());
		}
		
		ListaGenerica<String> lis8 = m.caminoMasCorto2("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime caminoMasCorto 2 ---");
		lis8.comenzar();
		while(!lis8.fin()) {
			System.out.println(lis8.proximo());
		}

		ListaGenerica<String> lis4 = m.caminoSinCargarCombustible("Buenos Aires","Asuncion",1);
		System.out.println("--- Se imprime caminoSinCargarCombustible ---");
		lis4.comenzar();
		while(!lis4.fin()) {
			System.out.println(lis4.proximo());
		}
		
		ListaGenerica<String> lis9 = m.caminoSinCarga("Buenos Aires","Asuncion",1);
		System.out.println("--- Se imprime caminoSinCargarCombustible 2 ---");
		lis9.comenzar();
		while(!lis9.fin()) {
			System.out.println(lis9.proximo());
		}
		ListaGenerica<String> lis5 = m.caminoConMenorCargaDeCombustible("Buenos Aires","Asuncion",8);
		//PARA COMPROBAR QUE FUNCIONA CAMBIAR ciudades.conectar(v1, v2,8); Y ciudades.conectar(v2, v5,8);
		System.out.println("--- Se imprime caminoConMenorCargaDeCombustible ---");
		lis5.comenzar();
		while(!lis5.fin()) {
			System.out.println(lis5.proximo());
		}
	}

}
