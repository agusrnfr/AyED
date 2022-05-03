package Parcial.Practica.Ejercicio3;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ParcialTest {

	public static void main(String[] args) {
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(14);
		
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(4);
		
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(5);
		
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> l = new ArbolGeneral<Integer>(7);
		
		ArbolGeneral<Integer> m = new ArbolGeneral<Integer>(3);
		
		ArbolGeneral<Integer> n = new ArbolGeneral<Integer>(13);
		
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		
		b.agregarHijo(e);
		b.agregarHijo(f);
		
		f.agregarHijo(g);
		f.agregarHijo(h);
		f.agregarHijo(i);
		
		c.agregarHijo(j);
		c.agregarHijo(k);
		c.agregarHijo(l);
		
		j.agregarHijo(m);
		
		l.agregarHijo(n);
		
		Parcial test = new Parcial (a);
		
		ListaGenerica<Integer> lista = test.resolver();
		
		while (!lista.fin()) {
			System.out.println("SUMA: "+ lista.proximo());
		}
		
		
	}

}
