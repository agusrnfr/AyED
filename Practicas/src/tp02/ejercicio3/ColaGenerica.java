package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class ColaGenerica <T> {
	private ListaGenerica<T> dato = new ListaEnlazadaGenerica<T>();
	
		public void encolar(T dato) {
			this.dato.agregarFinal(dato);
		}
		
		public T desencolar () {
			T x = this.dato.elemento(1);
			this.dato.eliminarEn(1);
			return x;
		}
		
		public T tope () {
			return this.dato.elemento(1);
		}
		
		public boolean esVacia() {
			return this.dato.tamanio()==0;
		}
}
