package Parcial.Practica.Ejercicio7;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialTest {

	public static void recorrerArbol(ArbolBinario<String> a) {
		ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
		ArbolBinario<String> aux;
		
		cola.encolar(a);
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			System.out.println(aux.getDato());
			if (aux.tieneHijoIzquierdo())
				cola.encolar(aux.getHijoIzquierdo());
			if (aux.tieneHijoDerecho())
				cola.encolar(aux.getHijoDerecho());
		}
	}

	public static void main(String[] args) {
		ArbolBinario<String> a = new ArbolBinario<String>("incolor");
		ArbolBinario<String> b = new ArbolBinario<String>("incolor");
		ArbolBinario<String> c = new ArbolBinario<String>("incolor");
		ArbolBinario<String> d = new ArbolBinario<String>("incolor");
		ArbolBinario<String> e = new ArbolBinario<String>("incolor");
		ArbolBinario<String> f = new ArbolBinario<String>("incolor");
		ArbolBinario<String> g = new ArbolBinario<String>("incolor");
		ArbolBinario<String> h = new ArbolBinario<String>("incolor");
		ArbolBinario<String> i = new ArbolBinario<String>("incolor");
		ArbolBinario<String> j = new ArbolBinario<String>("incolor");
		ArbolBinario<String> k = new ArbolBinario<String>("incolor");
		
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		
		e.agregarHijoIzquierdo(h);
		
		f.agregarHijoDerecho(i);
		
		g.agregarHijoIzquierdo(j);
		g.agregarHijoDerecho(k);
		
		Parcial test = new Parcial();
		
		test.colorearArbol(a, 1,2);
		
		System.out.println("ARBOL");
		
		recorrerArbol(a);
	}

}
