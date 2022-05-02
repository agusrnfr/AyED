package Parcial.Practica.Ejercicio2;

import tp03.ejercicio1.ArbolBinario;

public class ParcialTest {

	public static void main(String[] args) {
		Parcial test = new Parcial ();
		
		ArbolBinario<Integer> a = new ArbolBinario<Integer> (7);
		ArbolBinario<Integer> b = new ArbolBinario<Integer> (56);
		ArbolBinario<Integer> c = new ArbolBinario<Integer> (25);
		ArbolBinario<Integer> d = new ArbolBinario<Integer> (38);
		ArbolBinario<Integer> e = new ArbolBinario<Integer> (31);
		ArbolBinario<Integer> f = new ArbolBinario<Integer> (5);
		ArbolBinario<Integer> g = new ArbolBinario<Integer> (6);
		ArbolBinario<Integer> h = new ArbolBinario<Integer> (87);
		ArbolBinario<Integer> i = new ArbolBinario<Integer> (77);
		ArbolBinario<Integer> j = new ArbolBinario<Integer> (94);
		ArbolBinario<Integer> k = new ArbolBinario<Integer> (16);
		ArbolBinario<Integer> l = new ArbolBinario<Integer> (2);
		ArbolBinario<Integer> m = new ArbolBinario<Integer> (43);
		ArbolBinario<Integer> n = new ArbolBinario<Integer> (1);
		ArbolBinario<Integer> o = new ArbolBinario<Integer> (9);
		ArbolBinario<Integer> p = new ArbolBinario<Integer> (10);
		
		
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		
		d.agregarHijoIzquierdo(h);
		d.agregarHijoDerecho(i);
		
		i.agregarHijoIzquierdo(k);
		
		k.agregarHijoDerecho(m);
		
		m.agregarHijoIzquierdo(o);
		m.agregarHijoDerecho(p);
		
		f.agregarHijoDerecho(j);
		
		j.agregarHijoDerecho(l);
		
		l.agregarHijoIzquierdo(n);
		
		c.agregarHijoIzquierdo(f);
		c.agregarHijoDerecho(g);
		
		System.out.println("SUMA: "+ test.sumaImparesPosOrdenMayorA(a, 30));

	}

}
