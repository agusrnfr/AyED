package tp03.ejercicio4;
import tp03.ejercicio1.*;

public class RedBinariaLlena {
	private ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena (ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio () {
		return retardoReenvio(arbol);
	}
	
	
	private int retardoReenvio (ArbolBinario<Integer> arbol) {
		if (arbol.esVacio())
			return - 1;
		
		int cant = -1;
		
		if (arbol.esHoja())
			return arbol.getDato();
		
		else {
			if (arbol.tieneHijoIzquierdo()) 
				cant = Math.max(cant,retardoReenvio(arbol.getHijoIzquierdo()));
			if (arbol.tieneHijoDerecho())
				cant = Math.max (cant,retardoReenvio(arbol.getHijoDerecho()));
		}
		return cant + arbol.getDato();
	}
	
}

/*private int retardoReenvio (ArbolBinario<Integer> arbol) {
	return a.getDato() + Math.max(retardoReenvio(a.getHijoIzquierdo()),retardoReenvio(a.getHijoDerecho()));
}
Se asume que el arbol esta lleno asi que podria solucionarse asi tambien.
*/