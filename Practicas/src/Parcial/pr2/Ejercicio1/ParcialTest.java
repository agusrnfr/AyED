package Parcial.pr2.Ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ParcialTest {

	public static void main(String[] args) {
		ArbolGeneral<Character> a = new ArbolGeneral<Character>('a');
		ArbolGeneral<Character> b = new ArbolGeneral<Character>('b');
		ArbolGeneral<Character> c = new ArbolGeneral<Character>('c');
		ArbolGeneral<Character> d = new ArbolGeneral<Character>('d');
		ArbolGeneral<Character> e = new ArbolGeneral<Character>('e');
		ArbolGeneral<Character> f = new ArbolGeneral<Character>('f');
		ArbolGeneral<Character> g = new ArbolGeneral<Character>('g');
		ArbolGeneral<Character> h = new ArbolGeneral<Character>('h');
		ArbolGeneral<Character> i = new ArbolGeneral<Character>('i');
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		
		b.agregarHijo(e);
		
		c.agregarHijo(f);
		c.agregarHijo(g);
		
		f.agregarHijo(h);
		f.agregarHijo(i);
		
		
		Parcial test = new Parcial();
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> listaDeListas = test.caminosPares(a);
		
		listaDeListas.comenzar();
		
		while (!listaDeListas.fin()) {
			ListaEnlazadaGenerica<Character> l = listaDeListas.proximo();
				l.comenzar();
				while (!l.fin()) {
					System.out.println(l.proximo());
				}
				System.out.println(" ");
		}
}


	
}
