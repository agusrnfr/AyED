package tp03.ejercicio3;
import tp03.ejercicio1.*;
import tp02.ejercicio2.*;

public class ContadorArbol {
	private ArbolBinario<Integer> dato;
	
	public ContadorArbol (ArbolBinario<Integer> dato) {
		this.dato = dato;
	}

	public ListaGenerica<Integer> numerosPares(){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		//contarParesInOrden(lista,dato);
		contarParesPostOrden(lista,dato);
		return lista;
		}
	
	private void contarParesInOrden(ListaGenerica<Integer> lista,ArbolBinario<Integer> arbol) {
		if (arbol.tieneHijoIzquierdo())
			contarParesInOrden(lista,arbol.getHijoIzquierdo());
		if (arbol.getDato() % 2 == 0)
			lista.agregarFinal(arbol.getDato());
		if (arbol.tieneHijoDerecho())
			contarParesInOrden(lista,arbol.getHijoDerecho());
	}
	
	private void contarParesPostOrden(ListaGenerica<Integer> lista,ArbolBinario<Integer> arbol) {
		if (arbol.tieneHijoIzquierdo())
			contarParesPostOrden(lista,arbol.getHijoIzquierdo());
		if (arbol.tieneHijoDerecho())
			contarParesPostOrden(lista,arbol.getHijoDerecho());
		if (arbol.getDato() % 2 == 0)
			lista.agregarFinal(arbol.getDato());
	}
}


