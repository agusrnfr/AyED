package PRACTICA2.Ejercicio2;
import tp02.ejercicio2.*;


public class PruebaEjer2_4 {

	public static void main(String[] args) {
		Integer [] array = {1};
		ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		System.out.println(l.agregar(array));
		l.comenzar();
		while (!l.fin()) {
			System.out.println(l.proximo());
		}

	}

}
