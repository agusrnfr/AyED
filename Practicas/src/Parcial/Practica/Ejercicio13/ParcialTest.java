package Parcial.Practica.Ejercicio13;

import tp04.ejercicio1.ArbolGeneral;

public class ParcialTest {

	public static void main(String[] args) {
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(22);
		
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(6);
		
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> l = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> m = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> n = new ArbolGeneral<Integer>(22);
		ArbolGeneral<Integer> o = new ArbolGeneral<Integer>(8);
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		
		b.agregarHijo(e);
		b.agregarHijo(f);
		
		f.agregarHijo(j);
		f.agregarHijo(k);
		
		c.agregarHijo(g);
		g.agregarHijo(l);
		
		d.agregarHijo(h);
		d.agregarHijo(i);
		
		i.agregarHijo(m);
		i.agregarHijo(n);
		i.agregarHijo(o);
		
		Parcial test = new Parcial(a);
		
		System.out.println(test.buscarMayorEnPostOrden());
	}

}
