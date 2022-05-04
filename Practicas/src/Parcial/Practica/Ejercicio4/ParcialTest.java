package Parcial.Practica.Ejercicio4;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ParcialTest {

	public static void main(String[] args) {
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(8);
		
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(5);
		
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(6);	
		
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(10);
		
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(2);
		
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(16);
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		
		b.agregarHijo(d);
		b.agregarHijo(e);
		b.agregarHijo(f);
		
		c.agregarHijo(g);
		c.agregarHijo(h);
		c.agregarHijo(i);
		
		e.agregarHijo(j);
		
		g.agregarHijo(k);
		
		Parcial test = new Parcial(a);
		
		ListaGenerica<Integer> lista = test.devolverCamino();

		System.out.println(lista.toString());
	}

}
