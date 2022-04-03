package tp02.ejercicio1;

public abstract class ListaDeEnteros {
	
	public abstract void comenzar();
	public abstract Integer proximo();
	public abstract boolean fin();
	
	public abstract Integer elemento(int pos);
	
	public abstract boolean agregarEn(Integer elem, int pos);
	public abstract boolean agregarInicio(Integer elem);
	public abstract boolean agregarFinal(Integer elem);
	
	public abstract boolean eliminar(Integer elem);
	public abstract boolean eliminarEn(int pos);
	
	public abstract boolean incluye(Integer elem);
	public abstract boolean esVacia();
	public abstract int tamanio();

}
