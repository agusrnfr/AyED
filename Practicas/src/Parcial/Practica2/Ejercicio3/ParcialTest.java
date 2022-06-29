package Parcial.Practica2.Ejercicio3;

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
			
			ciudades.conectar(LaPlata, Quilmes,1);
			ciudades.conectar(Quilmes,LaPlata,1);
			ciudades.conectar(Pinamar,LaPlata,1);
			ciudades.conectar(LaPlata,Pinamar,1);
			ciudades.conectar(LaPlata,Abasto,1);
			ciudades.conectar(Abasto,LaPlata,1);
			ciudades.conectar(Moreno,Quilmes,0);
			ciudades.conectar(Quilmes,Moreno,0);
			ciudades.conectar(Moreno,Abasto,0);
			ciudades.conectar(Abasto,Moreno,0);
			ciudades.conectar(Abasto,Cañuelas,1);
			ciudades.conectar(Cañuelas,Abasto,1);
			ciudades.conectar(Abasto, CarlosKeen,1);
			ciudades.conectar(CarlosKeen, Abasto,1);
			ciudades.conectar(Moreno,CarlosKeen,1);
			ciudades.conectar(CarlosKeen,Moreno,1);
			ciudades.conectar(CarlosKeen,Suipacha,1);
			ciudades.conectar(Suipacha,CarlosKeen,1);
			ciudades.conectar(Cañuelas,Navarro,1);
			ciudades.conectar(Navarro,Cañuelas,1);
			ciudades.conectar(Navarro,Suipacha,1);
			ciudades.conectar(Suipacha,Navarro,1);
			ciudades.conectar(Navarro,Saladillo,1);
			ciudades.conectar(Saladillo,Navarro,1);
			ciudades.conectar(Navarro,Lobos,0);
			ciudades.conectar(Lobos,Navarro,0);
			
			
			Parcial parcial = new Parcial();
			
			ListaGenerica<ListaGenerica<String>> lis = parcial.resolver(ciudades,"La Plata","Suipacha","Abasto");
			lis.comenzar();
			while(!lis.fin()) {
				System.out.println(lis.proximo());
			}

	}

}
