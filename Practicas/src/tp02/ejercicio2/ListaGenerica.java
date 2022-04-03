package tp02.ejercicio2;


public abstract class ListaGenerica<T> {

	/** permite posicionarse al principio de la lista */
	public abstract void comenzar();

	/** permite avanzar al proximo elemento de lista */
	public abstract T proximo();

	/**
	 * devuelve true si nos encontramos en el último elemento de la lista,
	 * false en caso contrario
	 */
	public abstract boolean fin();

	/**
	 * devuelve el elemento que se encuentra en la posicion pos. Hay que
	 * recordar que la lista empieza en la posicion 1.
	 * 
	 * @param pos
	 *            posicion del elemento que se va a recuperar
	 */
	public abstract T elemento(int pos);

	/**
	 * agrega un elemento en la posicion pos indicada. Si hubiera un elemento en
	 * dicha posicion, el mismo se reubicará a continuación del elemento que
	 * vamos a agregar. Si pudo eliminarlo devuelve true, false en caso
	 * contrario.
	 * 
	 * @param elem
	 *            elemento a agregar
	 * @param pos
	 *            posicion donde deberá agregarse el elemento
	 * */
	public abstract boolean agregarEn(T elem, int pos);

	/**
	 * agrega un elemento al principio de la lista. Si pudo agregarlo devuelve
	 * true, false en caso contrario.
	 * 
	 * @param elem
	 *            elemento a agregar
	 * */
	public abstract boolean agregarInicio(T elem);

	/**
	 * agrega un elemento al final de la lista. Si pudo agregarlo devuelve true,
	 * false en caso contrario.
	 * 
	 * @param elem
	 *            elemento a agregar
	 * */
	public abstract boolean agregarFinal(T elem);

	/**
	 * elimina la primer ocurrencia del elemento elem indicado. Si pudo
	 * eliminarlo devuelve true, false en caso contrario.
	 * 
	 * @param elem
	 *            elemento a eliminar
	 * */
	public abstract boolean eliminar(T elem);

	/**
	 * elimina el elemento ubicado en la posicion pos. Si pudo eliminarlo
	 * devuelve true, false en caso contrario.
	 * 
	 * @param pos
	 *            posicion del elemento a eliminar
	 * */
	public abstract boolean eliminarEn(int pos);

	/**
	 * devuleve true si la lista contiene al elemento elem, false en caso
	 * contrario
	 * 
	 * @param elem
	 *            elemento a buscar en la lista
	 * */
	public abstract boolean incluye(T elem);

	/**
	 * devuelve true si la lista no contiene elemntos, false en caso contrario
	 * */
	public abstract boolean esVacia();

	/**
	 * devuelve un numero que representa la cantidad de elementos que contiene
	 * la lista
	 * */
	public abstract int tamanio();

	/**
	 * reemplaza el elemento en la posicion pos por el parametro elem. Devuelve
	 * true si pudo realizar el reemplazo, false en caso contrario.
	 * **/
	public abstract boolean reemplazarEn(T elem, int pos);

	/**
	 * Agrega todos los elementos del parametro lista en la lista generica actual
	 * **/
	//public abstract boolean agregarTodos(ListaGenerica<T> lista);

	/**
	 * Devuelve una lista con una copia de los elementos de la lista generica receptora del mensaje
	 * **/
	public abstract ListaGenerica<T> clonar();

	/**
	 * Devuelve una lista sin elementos.
	 * **/


}
