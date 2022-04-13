package tp03.ejercicio5;

import tp03.ejercicio1.ArbolBinario;

public class TestProfundidad {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(1); 
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(2); 
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(3); 
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(4); 
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(5);
		
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		
		ProfundidadDeArbolBinario test = new ProfundidadDeArbolBinario(a);
		
		System.out.println(test.sumaElementosProfundidad(1));

	}

}
