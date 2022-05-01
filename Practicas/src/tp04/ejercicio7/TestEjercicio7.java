package tp04.ejercicio7;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class TestEjercicio7 {

	public static void main(String[] args) {
		ListaGenerica<ArbolGeneral<Integer>> lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		ArbolGeneral<Character> a = new ArbolGeneral<Character>('a');
		ArbolGeneral<Character> b = new ArbolGeneral<Character>('b');
		ArbolGeneral<Character> c = new ArbolGeneral<Character>('c');
		ArbolGeneral<Character> d = new ArbolGeneral<Character>('d');
		ArbolGeneral<Character> e = new ArbolGeneral<Character>('e');
		ArbolGeneral<Character> f = new ArbolGeneral<Character>('f');
		ArbolGeneral<Character> g = new ArbolGeneral<Character>('g');
		ArbolGeneral<Character> h = new ArbolGeneral<Character>('h');
		ArbolGeneral<Character> i = new ArbolGeneral<Character>('i');
		ArbolGeneral<Character> j = new ArbolGeneral<Character>('j');
		ArbolGeneral<Character> k = new ArbolGeneral<Character>('k');
		ArbolGeneral<Character> l = new ArbolGeneral<Character>('l');
		ArbolGeneral<Character> m = new ArbolGeneral<Character>('m');
		ArbolGeneral<Character> n = new ArbolGeneral<Character>('n');
		ArbolGeneral<Character> o = new ArbolGeneral<Character>('o');
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		a.agregarHijo(e);
		
		c.agregarHijo(f);
		c.agregarHijo(g);
		
		d.agregarHijo(h);
		d.agregarHijo(i);
		d.agregarHijo(j);
		d.agregarHijo(k);
		d.agregarHijo(o);
		
		j.agregarHijo(m);
		j.agregarHijo(n);
		
		
		RedDeAguaPotable<Character> test = new RedDeAguaPotable <Character>(a);
		
		System.out.println("MINIMO : "+ test.minimoCaudal(1000.00));
		
		System.out.println("MINIMO : "+ test.minimoCaudal2(1000.00));
		
	}

}
