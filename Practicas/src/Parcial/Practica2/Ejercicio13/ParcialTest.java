package Parcial.Practica2.Ejercicio13;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class ParcialTest {

	public static void main(String[] args) {
		Vertice<String> RioCuarto = new VerticeImplListAdy<String>("Rio Cuarto");
		Vertice<String> VillaMaria= new VerticeImplListAdy<String>("Villa Maria");
		Vertice<String> CruzDelEje= new VerticeImplListAdy<String>("Cruz del Eje");
		Vertice<String> VillaGralBelgrano= new VerticeImplListAdy<String>("Villa Gral Belgrano");
		Vertice<String> JesusMaria= new VerticeImplListAdy<String>("Jesus Maria");
		Vertice<String> Tulumba= new VerticeImplListAdy<String>("Tulumba");
		Vertice<String> VillaDolores= new VerticeImplListAdy<String>("Villa Dolores");
		Vertice<String> Cordoba= new VerticeImplListAdy<String>("Cordoba");
		
		Grafo <String> ciudades = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(RioCuarto);
		ciudades.agregarVertice(VillaMaria);
		ciudades.agregarVertice(CruzDelEje);
		ciudades.agregarVertice(VillaGralBelgrano);
		ciudades.agregarVertice(JesusMaria);
		ciudades.agregarVertice(Tulumba);
		ciudades.agregarVertice(VillaDolores);
		ciudades.agregarVertice(Cordoba);
		
		ciudades.conectar(RioCuarto, VillaMaria,70);
		ciudades.conectar(VillaMaria, RioCuarto,70);
		
		ciudades.conectar(RioCuarto, VillaGralBelgrano,50);
		ciudades.conectar(VillaGralBelgrano, RioCuarto,50);
		
		ciudades.conectar(VillaMaria, JesusMaria,60);
		ciudades.conectar(JesusMaria, VillaMaria,60);
		
		ciudades.conectar(VillaMaria, CruzDelEje,80);
		ciudades.conectar(CruzDelEje, VillaMaria,80);
		
		ciudades.conectar(VillaGralBelgrano, CruzDelEje,85);
		ciudades.conectar(CruzDelEje, VillaGralBelgrano,85);
		
		ciudades.conectar(RioCuarto, VillaDolores,90);
		ciudades.conectar(VillaDolores, RioCuarto,90);
		
		ciudades.conectar(VillaDolores, Tulumba,70);
		ciudades.conectar(Tulumba, VillaDolores,70);
		
		ciudades.conectar(VillaDolores, JesusMaria,70);
		ciudades.conectar(JesusMaria, VillaDolores,70);
		
		ciudades.conectar(Tulumba, VillaGralBelgrano,90);
		ciudades.conectar(VillaGralBelgrano, Tulumba,90);
		
		ciudades.conectar(CruzDelEje, Cordoba,60);
		ciudades.conectar(Cordoba, CruzDelEje,60);
		
		ciudades.conectar(JesusMaria, Cordoba,90);
		ciudades.conectar(Cordoba, JesusMaria,90);

		ciudades.conectar(Tulumba, Cordoba,75);
		ciudades.conectar(Cordoba, Tulumba,75);
		
		BuscadorDeCamino parcial = new BuscadorDeCamino();
		
		ListaGenerica<String> lis = parcial.caminoDistanciaMaxima(ciudades, "Rio Cuarto", "Cordoba", 80);
		System.out.println(lis);;
		

	}

}
