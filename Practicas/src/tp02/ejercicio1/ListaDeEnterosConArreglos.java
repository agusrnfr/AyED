package tp02.ejercicio1;

public class ListaDeEnterosConArreglos extends ListaDeEnteros {
	
	private int tamanio;
	private Integer[] datos = new Integer[100];
	private int actual = 0;

	@Override
	public void comenzar() {
		actual = 0;
	}

	@Override
	public Integer proximo() {
		return datos[actual++];
	}

	@Override
	public boolean fin() {
		return actual == tamanio;
	}

	@Override
	public Integer elemento(int pos) {
		if (pos > 0)
			return datos[pos - 1];
		return null;
	}

	@Override
	// Se considera pos 1 al indice 0
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 1 || pos > tamanio + 1 || pos > datos.length
				|| tamanio == datos.length)
			return false;
		tamanio++;
		for (int i = tamanio - 1; i >= pos; i--)
			datos[i] = datos[i - 1];
		datos[pos - 1] = elem;
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		
		return this.agregarEn(elem, 1); 
	}



	@Override
	public boolean eliminar(Integer elem) {
		
		boolean encontre = false;
		int i = 0;
		while (i < tamanio && !encontre) {

			if (datos[i].equals(elem)) {
				return eliminarEn(i + 1);
				
			}
			i++;
		}  
		return encontre;
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 1 || pos > tamanio)
			return false;
		
		for (int i = pos - 1; i < tamanio; i++)
			datos[i] = datos[i + 1];
		tamanio--;
		if (actual == 1)// fix para poder vaciar la lista con proximo y eliminar
			actual = 0;
		return true;
	}

	
	@Override
	public boolean esVacia() {
		
		return (tamanio==0);
	}


	@Override
	public boolean agregarFinal(Integer elem) {
		tamanio++;
		datos[tamanio-1]=elem;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
	
		int i=0;
		while (i<tamanio){
			if (datos[i]==elem){
				return true;
			}
			i++;
		}
		return false;
	}

	@Override
	public int tamanio() {
		return tamanio;
	}

}
