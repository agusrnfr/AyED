package Parcial.Practica.Ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

/*
                  2
             /         \  
            /           \ 
           1             5
          /  \         /   \ 
         /    \       /     \ 
        16    6      25      8
                      \      /
                       \    /
                       64  22
 */

public class ParcialTest {
	

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(2);
		
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(5);
		
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(16);
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(6);
		
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(8);
		
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(22);
		
		ArbolBinario<Integer> h = new ArbolBinario<Integer> (25);
		
		ArbolBinario<Integer> i = new ArbolBinario<Integer> (64);
		
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		
		c.agregarHijoDerecho(f);
		c.agregarHijoIzquierdo(h);
		
		f.agregarHijoIzquierdo(g);
		
		h.agregarHijoDerecho(i);
		
		
		Parcial test = new Parcial();
		
		ListaGenerica<Integer> l = test.resolver(a);
		
		System.out.println(l.toString());
	}

}
