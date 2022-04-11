package tp02.ejercicio1;

import java.util.Scanner;

public class AlReves {

	public static void inverso (ListaDeEnteros lista, int puntero) {
		if (puntero <= lista.tamanio()) {
			AlReves.inverso(lista, puntero+1);
			System.out.println(lista.elemento(puntero));
		}
	}
	
	public static void main(String[] args) {
		ListaDeEnterosConArreglos obj = new ListaDeEnterosConArreglos ();
		ListaDeEnterosEnlazada obj2 = new ListaDeEnterosEnlazada ();
		Scanner s = new Scanner (System.in);
		System.out.println("INGRESE NUMEROS: ");
		int num = s.nextInt();	
		while (num  != -1) {
			obj.agregarFinal(num);
			obj2.agregarFinal(num);
			num = s.nextInt();	
		}
		s.close();
		System.out.println("ARREGLO");
		obj.comenzar();
		while (!obj.fin()) {
			System.out.println(obj.proximo());
		}
		System.out.println("AL REVES ARREGLO: ");
		AlReves.inverso(obj, 1);
	
		System.out.println("ENLAZADA");
		obj2.comenzar();
		while (!obj2.fin()) {
			System.out.println(obj2.proximo());
		}
		System.out.println("AL REVES ENLAZADA: ");
		AlReves.inverso(obj2, 1);
		
	}
}
