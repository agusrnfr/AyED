package Parcial.Practica.Ejercicio10;

import tp04.ejercicio1.ArbolGeneral;

//el personaje en la foto es un objeto pero lo hago con string

public class ParcialTest {
	
	public static void main (String[] args) {
		ArbolGeneral<String> a = new ArbolGeneral<String>("coyote");
		ArbolGeneral<String> b = new ArbolGeneral<String>("scooby");
		ArbolGeneral<String> c = new ArbolGeneral<String>("princesa");
		ArbolGeneral<String> d = new ArbolGeneral<String>("cid");
		
		ArbolGeneral<String> e = new ArbolGeneral<String>("princesa");
		ArbolGeneral<String> f = new ArbolGeneral<String>("dragon");
		ArbolGeneral<String> g = new ArbolGeneral<String>("animal");
		
		ArbolGeneral<String> h = new ArbolGeneral<String>("princesa");
		ArbolGeneral<String> i = new ArbolGeneral<String>("tweety");
		ArbolGeneral<String> j = new ArbolGeneral<String>("princesa");
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		
		b.agregarHijo(j);
		
		c.agregarHijo(e);
		c.agregarHijo(f);
		c.agregarHijo(g);
		
		d.agregarHijo(h);
		d.agregarHijo(i);
		
		Parcial test = new Parcial();
		
		System.out.println(test.resolver(a));
		
	}

}
