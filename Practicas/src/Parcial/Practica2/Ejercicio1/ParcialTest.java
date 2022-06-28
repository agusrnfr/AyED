package Parcial.Practica2.Ejercicio1;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {
	
	public static void main(String[] args) {
		Ciudad ciudad = new Ciudad("La Plata",2);
		Vertice<Ciudad> LaPlata = new VerticeImplListAdy<Ciudad>(ciudad);
		Ciudad ciudad2 = new Ciudad("Abasto",2);
		Vertice<Ciudad> Abasto = new VerticeImplListAdy<Ciudad>(ciudad2);
		Ciudad ciudad3 = new Ciudad("Cañuelas",3);
		Vertice<Ciudad> Cañuelas = new VerticeImplListAdy<Ciudad>(ciudad3);
		Ciudad ciudad4 = new Ciudad("Navarro",4);
		Vertice<Ciudad> Navarro = new VerticeImplListAdy<Ciudad>(ciudad4);
		Ciudad ciudad5 = new Ciudad("Quilmes",1);
		Vertice<Ciudad> Quilmes = new VerticeImplListAdy<Ciudad>(ciudad5);
		Ciudad ciudad6 = new Ciudad("Moreno",1);
		Vertice<Ciudad> Moreno = new VerticeImplListAdy<Ciudad>(ciudad6);
		Ciudad ciudad7 = new Ciudad("Carlos Keen",3);
		Vertice<Ciudad> CarlosKeen = new VerticeImplListAdy<Ciudad>(ciudad7);
		Ciudad ciudad8 = new Ciudad("Suipacha",3);
		Vertice<Ciudad> Suipacha = new VerticeImplListAdy<Ciudad>(ciudad8);
		Ciudad ciudad9 = new Ciudad("Pinamar",3);
		Vertice<Ciudad> Pinamar = new VerticeImplListAdy<Ciudad>(ciudad9);
		Ciudad ciudad10 = new Ciudad("Lobos",3);
		Vertice<Ciudad> Lobos = new VerticeImplListAdy<Ciudad>(ciudad10);
		Ciudad ciudad11 = new Ciudad("Saladillo",4);
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
		
		ListaGenerica<Ciudad> lis = parcial.resolver(ciudades, "La Plata", "Carlos Keen");
		lis.comenzar();
		while(!lis.fin()) {
			System.out.println(lis.proximo().getNombre());
		}
	}
}
