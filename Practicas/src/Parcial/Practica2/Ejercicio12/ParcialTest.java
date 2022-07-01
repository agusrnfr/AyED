package Parcial.Practica2.Ejercicio12;

import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {
	public static void main(String[] args) {
	/*1*/Ciudad ciudad = new Ciudad("La Plata",1);
		Vertice<Ciudad> LaPlata = new VerticeImplListAdy<Ciudad>(ciudad);
	/*2*/Ciudad ciudad2 = new Ciudad("Abasto",3);
		Vertice<Ciudad> Abasto = new VerticeImplListAdy<Ciudad>(ciudad2);
	/*3*/Ciudad ciudad3 = new Ciudad("Cañuelas",2);
		Vertice<Ciudad> Cañuelas = new VerticeImplListAdy<Ciudad>(ciudad3);
	/*4*/Ciudad ciudad4 = new Ciudad("Navarro",1);
		Vertice<Ciudad> Navarro = new VerticeImplListAdy<Ciudad>(ciudad4);
	/*5*/Ciudad ciudad5 = new Ciudad("Quilmes",3);
		Vertice<Ciudad> Quilmes = new VerticeImplListAdy<Ciudad>(ciudad5);
	/*6*/Ciudad ciudad6 = new Ciudad("Moreno",2);
		Vertice<Ciudad> Moreno = new VerticeImplListAdy<Ciudad>(ciudad6);
	/*7*/Ciudad ciudad7 = new Ciudad("Carlos Keen",2);
		Vertice<Ciudad> CarlosKeen = new VerticeImplListAdy<Ciudad>(ciudad7);
	/*8*/Ciudad ciudad8 = new Ciudad("Suipacha",3);
		Vertice<Ciudad> Suipacha = new VerticeImplListAdy<Ciudad>(ciudad8);
	/*9*/Ciudad ciudad9 = new Ciudad("Pinamar",0);
		Vertice<Ciudad> Pinamar = new VerticeImplListAdy<Ciudad>(ciudad9);
	/*10*/Ciudad ciudad10 = new Ciudad("Lobos",1);
		Vertice<Ciudad> Lobos = new VerticeImplListAdy<Ciudad>(ciudad10);
	/*11*/Ciudad ciudad11 = new Ciudad("Saladillo",2);
		Vertice<Ciudad> Saladillo = new VerticeImplListAdy<Ciudad>(ciudad11);
		
		Grafo<Ciudad> ciudades = new GrafoImplListAdy<Ciudad>();
		
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
		
		ciudades.conectar(LaPlata, Quilmes,2);
		ciudades.conectar(Quilmes,LaPlata,2);
		ciudades.conectar(Pinamar,LaPlata,2);
		ciudades.conectar(LaPlata,Pinamar,2);
		ciudades.conectar(LaPlata,Abasto,2);
		ciudades.conectar(Abasto,LaPlata,2);
		ciudades.conectar(Moreno,Quilmes,2);
		ciudades.conectar(Quilmes,Moreno,2);
		ciudades.conectar(Moreno,Abasto,3);
		ciudades.conectar(Abasto,Moreno,3);
		ciudades.conectar(Abasto,Cañuelas,2);
		ciudades.conectar(Cañuelas,Abasto,2);
		ciudades.conectar(Moreno,CarlosKeen,2);
		ciudades.conectar(CarlosKeen,Moreno,2);
		ciudades.conectar(CarlosKeen,Suipacha,2);
		ciudades.conectar(Suipacha,CarlosKeen,2);
		ciudades.conectar(Cañuelas,Navarro,2);
		ciudades.conectar(Navarro,Cañuelas,2);
		ciudades.conectar(Navarro,Suipacha,2);
		ciudades.conectar(Suipacha,Navarro,2);
		ciudades.conectar(Navarro,Saladillo,2);
		ciudades.conectar(Saladillo,Navarro,2);
		ciudades.conectar(Navarro,Lobos,4);
		ciudades.conectar(Lobos,Navarro,4);
		
		
		Parcial parcial = new Parcial();
		
		System.out.println(parcial.resolver(ciudades,"La Plata", "Navarro",2));

	}
}
