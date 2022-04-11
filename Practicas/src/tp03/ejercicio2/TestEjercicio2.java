package tp03.ejercicio2;
import  tp03.ejercicio1.*;

public class TestEjercicio2 {
	
	public static void imprimirArbol (ArbolBinario<Integer> arbol) {
		System.out.println(arbol.getDato());
		if (arbol.tieneHijoIzquierdo()) {
			imprimirArbol(arbol.getHijoIzquierdo());
		}
		if (arbol.tieneHijoDerecho()) {
			imprimirArbol(arbol.getHijoDerecho());
		}
	}

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
		
		imprimirArbol(a);
		
		System.out.println(' ');
		
		System.out.println(a.contarHojas());
		
		System.out.println(' ');
		
		a.espejo();
		
		System.out.println(' ');
		
		imprimirArbol(a);
		
		System.out.println(' ');
		
		a.entreNiveles(0,1);

	}

}
