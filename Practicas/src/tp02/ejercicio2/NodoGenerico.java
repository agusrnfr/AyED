package tp02.ejercicio2;
/**
 * Esta clase representa un nodo de la lista enlazada.
 * */
public class NodoGenerico<T> {
	private T dato;
	private NodoGenerico<T> siguiente;
	
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public NodoGenerico<T> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoGenerico<T> siguiente) {
		this.siguiente = siguiente;
	}

}