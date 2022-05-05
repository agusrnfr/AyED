package Parcial.Practica.Ejercicio9;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	public int contar (ArbolGeneral<Integer> a, int valor) {
		int cuenta = valor - a.getDato();
		int cant = 0;
		if ((a.esHoja()) && (cuenta == 0))
			return 1;
		else
			if ((a.tieneHijos()) && (cuenta > 0)){
				ListaGenerica<ArbolGeneral<Integer>> l = a.getHijos();
				l.comenzar();
				while (!l.fin())
					cant+= contar(l.proximo(),cuenta);
			}
		return cant;
	}
}
