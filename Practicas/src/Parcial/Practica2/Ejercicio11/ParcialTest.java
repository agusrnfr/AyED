package Parcial.Practica2.Ejercicio11;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {
	public static void main(String[] args) {

	Vertice<String> Stavenger = new VerticeImplListAdy<String>("Stavenger");
	Vertice<String> Lofoten= new VerticeImplListAdy<String>("Lofoten");
	Vertice<String> Tromso= new VerticeImplListAdy<String>("Tromso");
	Vertice<String> Trondheim= new VerticeImplListAdy<String>("Trondheim");
	Vertice<String> Berger= new VerticeImplListAdy<String>("Berger");
	Vertice<String> Drammen= new VerticeImplListAdy<String>("Drammen");
	Vertice<String> Oslo= new VerticeImplListAdy<String>("Oslo");
	Vertice<String> Mosjeem= new VerticeImplListAdy<String>("Mosjeem");
	Vertice<String> Nordland= new VerticeImplListAdy<String>("Nordland");
	
	Grafo <String> mapa = new GrafoImplListAdy<String>();
	mapa.agregarVertice(Stavenger);
	mapa.agregarVertice(Lofoten);
	mapa.agregarVertice(Tromso);
	mapa.agregarVertice(Trondheim);
	mapa.agregarVertice(Berger);
	mapa.agregarVertice(Drammen);
	mapa.agregarVertice(Lofoten);
	mapa.agregarVertice(Oslo);
	mapa.agregarVertice(Mosjeem);
	mapa.agregarVertice(Nordland);
	
	
	mapa.conectar(Berger, Stavenger,0);
	mapa.conectar(Stavenger, Berger,0);
	mapa.conectar(Stavenger, Trondheim,2);
	mapa.conectar(Trondheim, Stavenger,2);
	mapa.conectar(Stavenger, Tromso,0);
	mapa.conectar(Tromso, Stavenger,0);
	mapa.conectar(Trondheim, Tromso,1);
	mapa.conectar(Tromso, Trondheim,1);
	mapa.conectar(Stavenger, Lofoten,3);
	mapa.conectar(Lofoten, Stavenger,3);
	mapa.conectar(Lofoten, Mosjeem,3);
	mapa.conectar(Mosjeem, Lofoten,3);
	mapa.conectar(Berger, Oslo,0);
	mapa.conectar(Oslo, Berger,0);
	mapa.conectar(Oslo, Drammen,0);
	mapa.conectar(Drammen, Oslo,0);
	mapa.conectar(Drammen, Mosjeem,1);
	mapa.conectar(Mosjeem, Drammen,1);
	mapa.conectar(Tromso, Mosjeem,0);
	mapa.conectar(Mosjeem, Tromso,0);
	mapa.conectar(Lofoten, Nordland,1);
	mapa.conectar(Nordland, Lofoten,1);
	mapa.conectar(Mosjeem, Nordland,1);
	mapa.conectar(Nordland, Mosjeem,1);
	mapa.conectar(Mosjeem, Oslo,0);
	mapa.conectar(Oslo, Mosjeem,0);
	
	CaminoSinControles parcial = new CaminoSinControles (mapa);
	
	ListaGenerica<ListaGenerica<String>> lis = parcial.devolverCaminos("Stavenger","Oslo");
	lis.comenzar();
	while(!lis.fin()) {
		System.out.println(lis.proximo());
	}
	
	}

}
