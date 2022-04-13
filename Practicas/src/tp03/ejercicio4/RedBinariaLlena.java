package tp03.ejercicio4;
import tp03.ejercicio1.*;

public class RedBinariaLlena {
	
	public static int retardoReenvio (ArbolBinario<Integer> arbol) {
		if (arbol.esVacio())
			return - 1;
		
		int cant = -1;
		
		if (arbol.esHoja())
			return 0;
		
		else {
			if (arbol.tieneHijoIzquierdo()) 
				cant = Math.max(cant,retardoReenvio(arbol.getHijoIzquierdo()));
			if (arbol.tieneHijoDerecho())
				cant = Math.max (cant,retardoReenvio(arbol.getHijoDerecho()));
		}
		return cant + arbol.getDato();
	}
	
}