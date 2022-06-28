package Parcial.Practica2.Ejercicio2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {

	public static void main(String[] args) {
	/*1*/	Vertice<String> LaPlata = new VerticeImplListAdy<String>("La Plata");
	/*2*/	Vertice<String> Abasto = new VerticeImplListAdy<String>("Abasto");
	/*3*/	Vertice<String> Cañuelas = new VerticeImplListAdy<String>("Cañuelas");
	/*4*/	Vertice<String> Navarro = new VerticeImplListAdy<String>("Navarro");
	/*5*/	Vertice<String> Quilmes = new VerticeImplListAdy<String>("Quilmes");
	/*6*/	Vertice<String> Moreno = new VerticeImplListAdy<String>("Moreno");
	/*7*/	Vertice<String> CarlosKeen = new VerticeImplListAdy<String>("Carlos Keen");
	/*8*/	Vertice<String> Suipacha = new VerticeImplListAdy<String>("Suipacha");
	/*9*/	Vertice<String> Pinamar = new VerticeImplListAdy<String>("Pinamar");
	/*10*/	Vertice<String> Lobos = new VerticeImplListAdy<String>("Lobos");
	/*11*/	Vertice<String> Saladillo = new VerticeImplListAdy<String>("Saladillo");
		
		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(LaPlata);
		ciudades.agregarVertice(Abasto);
		ciudades.agregarVertice(Cañuelas);
		ciudades.agregarVertice(Navarro);
		ciudades.agregarVertice(Quilmes);
		ciudades.agregarVertice(Moreno);
		ciudades.agregarVertice(CarlosKeen);
		ciudades.agregarVertice(Suipacha);
		ciudades.agregarVertice(Pinamar);
		ciudades.agregarVertice(Lobos);
		ciudades.agregarVertice(Saladillo);
		
		ciudades.conectar(LaPlata, Quilmes);
		ciudades.conectar(Quilmes,LaPlata);
		ciudades.conectar(Pinamar,LaPlata);
		ciudades.conectar(LaPlata,Pinamar);
		ciudades.conectar(LaPlata,Abasto);
		ciudades.conectar(Abasto,LaPlata);
		ciudades.conectar(Moreno,Quilmes);
		ciudades.conectar(Quilmes,Moreno);
		ciudades.conectar(Moreno,Abasto);
		ciudades.conectar(Abasto,Moreno);
		ciudades.conectar(Abasto,Cañuelas);
		ciudades.conectar(Cañuelas,Abasto);
		ciudades.conectar(Moreno,CarlosKeen);
		ciudades.conectar(CarlosKeen,Moreno);
		ciudades.conectar(CarlosKeen,Suipacha);
		ciudades.conectar(Suipacha,CarlosKeen);
		ciudades.conectar(Cañuelas,Navarro);
		ciudades.conectar(Navarro,Cañuelas);
		ciudades.conectar(Navarro,Suipacha);
		ciudades.conectar(Suipacha,Navarro);
		ciudades.conectar(Navarro,Saladillo);
		ciudades.conectar(Saladillo,Navarro);
		ciudades.conectar(Navarro,Lobos);
		ciudades.conectar(Lobos,Navarro);
		
		
		Parcial parcial = new Parcial();
		
		ListaGenerica <String> pasandoPor = new ListaEnlazadaGenerica<String>();
		pasandoPor.agregarFinal("Quilmes"); pasandoPor.agregarFinal("Carlos Keen");
		
		ListaGenerica<String> lis = parcial.resolver(ciudades,"La Plata","Suipacha",pasandoPor);
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo());
		}

	}

}
