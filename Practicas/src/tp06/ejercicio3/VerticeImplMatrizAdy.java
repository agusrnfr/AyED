/**
 * 
 */
package tp06.ejercicio3;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {
	private T dato;
	private int posicion;
	
	public VerticeImplMatrizAdy(T d) {
		dato = d;
	}
	
	@Override
	public T dato() {
		return this.dato;
	}
	
	@Override
	public void setDato(T dato) {
		this.dato = dato;
	}

	@Override
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

}
