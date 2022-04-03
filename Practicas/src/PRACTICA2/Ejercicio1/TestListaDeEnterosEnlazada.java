package PRACTICA2.Ejercicio1;
import tp02.ejercicio1.*;
import java.util.Scanner;


public class TestListaDeEnterosEnlazada {
	
	public static void inverso (ListaDeEnteros lista, int puntero) {
		if (puntero <= lista.tamanio()) {
			TestListaDeEnterosEnlazada.inverso(lista, puntero+1);
			System.out.println(lista.elemento(puntero));
		}
	}

	public static void main(String[] args) {
		ListaDeEnterosEnlazada obj = new ListaDeEnterosEnlazada ();
		Scanner s = new Scanner (System.in);
		System.out.println("INGRESE NUMEROS: ");
		int num = s.nextInt();	
		while (num  != -1) {
			obj.agregarFinal(num);
			num = s.nextInt();	
		}
		obj.comenzar();
		while (!obj.fin()) {
			System.out.println(obj.proximo());
		}
	}	
}
