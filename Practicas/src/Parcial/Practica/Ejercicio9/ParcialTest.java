package Parcial.Practica.Ejercicio9;

import tp04.ejercicio1.ArbolGeneral;

public class ParcialTest {

	public static void main(String[] args) {
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(50);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(10);
		
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(50);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(30);
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(50);
		
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(50);
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> l = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> m = new ArbolGeneral<Integer>(35);
		ArbolGeneral<Integer> n = new ArbolGeneral<Integer>(50);
		ArbolGeneral<Integer> o = new ArbolGeneral<Integer>(22);
		ArbolGeneral<Integer> p = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> q = new ArbolGeneral<Integer>(80);
		ArbolGeneral<Integer> r = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> s = new ArbolGeneral<Integer>(40);
		
		a.agregarHijo(b);
		a.agregarHijo(i);
		a.agregarHijo(p);
		a.agregarHijo(s);
		
		b.agregarHijo(c);
		
		c.agregarHijo(e);
		e.agregarHijo(f);
		f.agregarHijo(g);
		g.agregarHijo(h);
		
		i.agregarHijo(j);
		j.agregarHijo(k);
		
		k.agregarHijo(l);
		k.agregarHijo(m);
		
		m.agregarHijo(n);
		n.agregarHijo(o);
		
		p.agregarHijo(q);
		q.agregarHijo(r);
		
		Parcial test = new Parcial();
		System.out.println(test.contar(a, 174));
	}

}
