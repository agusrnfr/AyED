package tp06.ejercicio3;

import tp02.ejercicio2.ListaGenerica;


/**
 * Representa el grafo, donde se mantiene la estructura como un todo.
 * 
 * @author juan
 *
 */
public interface Grafo<T> {

	/**
	 * Agrega un vertice al Grafo.
	 * Verifica que el vertice no exista en el Grafo
	 * 
	 * @param v
	 */
	public void agregarVertice(Vertice<T> v);
	
	/**
	 * Elimina el vertice del Grafo.
	 * En caso que el vertice tenga conexiones con otros vertices, se eliminan todas sus conexiones.
	 * 
	 * @param v
	 */
	public void eliminarVertice(Vertice<T> v);
	
	/**
	 * Conecta el vertice origen con el vertice destino.
	 * Verifica que ambos vertices existan, caso contrario no realiza ninguna conexion.
	 * 
	 * @param origen
	 * @param destino
	 */
	public void conectar(Vertice<T> origen, Vertice<T> destino);
	
	/**
	 * Conecta el vertice origen con el destino con peso.
	 * Verifica que ambos vertices existan, caso contrario no realiza ninguna conexion
	 * 
	 * @param origen
	 * @param destino
	 * @param peso
	 */
	public void conectar(Vertice<T> origen, Vertice<T> destino, int peso);
	
	/**
	 * Desconecta el vertice origen con el destino.
	 * Verifica que ambos vertices existan, caso contrario no realiza ninguna desconexion
	 * En caso de existir la conexion destino-->origen, esta permanece sin cambios. 
	 * 
	 * @param origen
	 * @param destino
	 */
	public void desConectar(Vertice<T> origen, Vertice<T> destino);
	
	/**
	 * Retorna true si origen es adyacente a destino. False en caso contrario.
	 * 
	 * @param origen
	 * @param destino
	 * @return
	 */
	public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino);
	
	/**
	 * Retorna el peso entre dos vertices.
	 * En caso de no ser un grafo pesa es conveniete el uso el metodo esAdyacente.
	 * 
	 * @param origen
	 * @param destino
	 * @return
	 */
	public int peso(Vertice<T> origen, Vertice<T> destino);

	
	/**
	 * Retorna true en caso que el grafo no contenga ningun vertice. False en caso contrario.
	 * 
	 * @return
	 */
	public boolean esVacio();
	
	/**
	 * Retorna la lista de vertices.
	 * 
	 * @return
	 */
	public ListaGenerica<Vertice<T>> listaDeVertices();
		
	/**
	 * Retorna la lista de adyacentes de un vertice
	 * 
	 * @param v
	 * @return
	 */
	public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v);
	
	/**
	 * Obtiene un vertice dado su posicion
	 * 
	 * @param posicion
	 * @return
	 */
	public Vertice<T> vetice(int posicion);

}
