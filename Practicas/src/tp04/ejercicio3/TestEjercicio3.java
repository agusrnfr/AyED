package tp04.ejercicio3;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class TestEjercicio3 {

	public static void main(String[] args) {
		
		ListaGenerica<ArbolGeneral<Integer>> lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(10);
		
		f.agregarHijo(h);
		f.agregarHijo(i);
		
		g.agregarHijo(j);
		
		lista.agregarFinal(c);
		lista.agregarFinal(d);
		lista.agregarFinal(e);
		
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(13,lista);

		
		lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		lista.agregarFinal(b);
		lista.agregarFinal(f);
		lista.agregarFinal(g);
		
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(11,lista);
		
		ArbolGeneralInt test = new ArbolGeneralInt(a);
		
		ListaGenerica <Integer> listaDatos = test.numerosImparesMayoresQuePreOrden(6);
		
		System.out.println("PREORDEN: " + listaDatos);
		
		listaDatos = test.numerosImparesMayoresQueInOrden(6);
		 
		System.out.println("INORDEN: "+ listaDatos);
		
		listaDatos = test.numerosImparesMayoresQuePostOrden(6);
		
		System.out.println("POSTORDEN: "+ listaDatos);
		
		listaDatos = test.numerosImparesMayoresQuePorNiveles(6);
		
		System.out.println("POR NIVELES: "+ listaDatos);
		
		
		ListaGenerica <Integer> listaDatos2 = a.numerosImparesMayoresQuePreOrden(6);
		
		System.out.println("PREORDEN: " + listaDatos2);
		
		listaDatos2 = a.numerosImparesMayoresQueInOrden(6);
		 
		System.out.println("INORDEN: "+ listaDatos2);
		
		listaDatos2 = a.numerosImparesMayoresQuePostOrden(6);
		
		System.out.println("POSTORDEN: "+ listaDatos2);
		
		listaDatos2 = a.numerosImparesMayoresQuePorNiveles(6);
		
		System.out.println("POR NIVELES: "+ listaDatos2);
		
		
	
	
	}
	
	
	

}
