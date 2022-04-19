package tests;

import tp03.ejercicio1.ArbolBinario;

public class PruebaTeoriaPractica {
	
	public static void traverse(ArbolBinario<Character> a) {
		if (!a.esVacio()) {
			System.out.print(a.getDato());
			if (a.tieneHijoIzquierdo())
				traverse(a.getHijoIzquierdo());
			if (a.tieneHijoDerecho())
				traverse(a.getHijoDerecho());
			System.out.print(a.getDato());
	}
}

	public static void main(String[] args) {
		ArbolBinario<Character> c = new ArbolBinario<Character>('c'); 
		ArbolBinario<Character> a = new ArbolBinario<Character>('a'); 
		ArbolBinario<Character> e = new ArbolBinario<Character>('e'); 
		ArbolBinario<Character> b = new ArbolBinario<Character>('b'); 
		ArbolBinario<Character> d = new ArbolBinario<Character>('d'); 
		ArbolBinario<Character> f = new ArbolBinario<Character>('f'); 
		
		c.agregarHijoIzquierdo(a);
		c.agregarHijoDerecho(e);
		a.agregarHijoDerecho(b);
		e.agregarHijoIzquierdo(d);
		e.agregarHijoDerecho(f);
		
		traverse(c);

	}

}
