/**
 * 
 */
package tp06.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

/**
 * Implementacion del grafo con matriz
 * 
 * @author juan
 *
 */
public class GrafoImplMatrizAdy<T>
    implements Grafo<T> {
    private int maxVertices;
    ListaGenerica<Vertice<T>> vertices;
    int[][] matrizAdy;

    public GrafoImplMatrizAdy(int maxVert) {
        // Para ser compatible con la lista la matriz comienza en 1
        maxVertices = maxVert;
        vertices = new ListaEnlazadaGenerica<Vertice<T>>();
        matrizAdy = new int[maxVertices + 1][maxVertices + 1];
        for (int i = 1; i <= maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                matrizAdy[i][j] = 0;
            }
        }
    }

    @Override
    public void agregarVertice(Vertice<T> v) {
        if (!vertices.incluye(v)) {
            vertices.agregarFinal(v);
            ((VerticeImplMatrizAdy<T>) v).setPosicion(vertices.tamanio());
        }
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {

        int index = ((VerticeImplMatrizAdy<T>) v).getPosicion();
        // Elimino la fila
        for (int fila = index; fila <= vertices.tamanio(); fila++) {
            matrizAdy[fila] = matrizAdy[fila + 1];
        }
        // Elimino la columna
        for (int fila = 0; fila <= vertices.tamanio(); fila++) {
            for (int col = index; col < vertices.tamanio(); col++) {
                matrizAdy[fila][col] = matrizAdy[fila][col + 1];
            }
        }
        vertices.eliminar(v);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        conectar(origen, destino, 1);

    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        matrizAdy[((VerticeImplMatrizAdy<T>) origen).getPosicion()][((VerticeImplMatrizAdy<T>) destino)
            .getPosicion()] = peso;
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        matrizAdy[((VerticeImplMatrizAdy<T>) origen).getPosicion()][((VerticeImplMatrizAdy<T>) destino).getPosicion()] = 0;
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        return matrizAdy[((VerticeImplMatrizAdy<T>) origen).getPosicion()][((VerticeImplMatrizAdy<T>) destino)
            .getPosicion()] > 0;
    }

    @Override
    public boolean esVacio() {
        return vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return vertices;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return matrizAdy[((VerticeImplMatrizAdy<T>) origen).getPosicion()][((VerticeImplMatrizAdy<T>) destino)
            .getPosicion()];
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        ListaGenerica<Arista<T>> ady = new ListaEnlazadaGenerica<Arista<T>>();
        int veticePos = ((VerticeImplMatrizAdy<T>) v).getPosicion();
        Arista<T> arista;
        for (int i = 1; i <= vertices.tamanio(); i++) {
            if (matrizAdy[veticePos][i] > 0) {
                arista = new AristaImpl<T>(vertices.elemento(i), matrizAdy[veticePos][i]);
                ady.agregarFinal(arista);
            }
        }
        return ady;
    }

    @Override
    public Vertice<T> vetice(int posicion) {
        return vertices.elemento(posicion);
    }
}
