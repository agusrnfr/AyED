package tp03.ejercicio4;
import tp03.ejercicio1.*;

public class RedBinariaLlena {
	
	public static int retardoEnvio (ArbolBinario<Integer> arbol) {
		if (arbol.esVacio())
			return - 1;
		
		int cant = -1;
		
		if (arbol.esHoja())
			return 0;
		
		else {
			if (arbol.tieneHijoIzquierdo()) 
				cant = Math.max(cant,retardoEnvio(arbol.getHijoIzquierdo())); // la maxima altura seria el maximo retardo
			if (arbol.tieneHijoDerecho())
				cant = Math.max (cant,retardoEnvio(arbol.getHijoDerecho())); // la maxima altura seria el maximo retardo
		}
		return cant + arbol.getDato();
	}
	
}