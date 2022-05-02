package Parcial.Practica.Ejercicio2;

import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	public Integer sumaImparesPosOrdenMayorA(ArbolBinario<Integer> ab, int limite) {
		Integer suma = 0;
		if (!ab.esVacio()) {
			if (ab.tieneHijoIzquierdo()) 
				suma+= sumaImparesPosOrdenMayorA(ab.getHijoIzquierdo(),limite);
			if (ab.tieneHijoDerecho())
				suma+= sumaImparesPosOrdenMayorA(ab.getHijoDerecho(),limite);
			if(((ab.getDato()%2)==1)&&(ab.getDato()> limite)) {
				suma+= ab.getDato();
				System.out.println(ab.getDato());
			}
			return suma;
		}
		return -1;
	}
}
