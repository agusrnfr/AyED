package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class PilaGenerica <T> {
	private ListaGenerica<T> dato = new ListaEnlazadaGenerica <T>(); //UPCASTING NO PUEDO HACER POR EJ
																	//EL METODO AGREGAR.
		public void apilar(T dato) {
			this.dato.agregarInicio(dato);
		}
		
		public T desapilar () {
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

//TOPE Y ES VACIA ES IGUAL EN AMBOS PODRIA HACER UNA CLASE ESTRUCTURA Y QUE HEREDEN DE ESTA.