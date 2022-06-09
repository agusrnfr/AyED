package tp06.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class VerticeImplListAdy<T>
    implements Vertice<T> {
    private T dato;
    private int posicion;
    private ListaGenerica<Arista<T>> adyacentes;

    public VerticeImplListAdy(T d) {
        dato = d;
        adyacentes = new ListaEnlazadaGenerica<Arista<T>>();
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

    public ListaGenerica<Arista<T>> obtenerAdyacentes() {
        return adyacentes;
    }

    public void conectar(Vertice<T> v) {
        conectar(v, 1);
    }

    public void conectar(Vertice<T> v, int peso) {
        Arista<T> arista = obtenerArista(v);

        if (arista == null) {
            Arista<T> a = new AristaImpl<T>(v, peso);
            adyacentes.agregarFinal(a);
        }
    }

    public void desconectar(Vertice<T> v) {
        Arista<T> arista = obtenerArista(v);

        if (arista != null) {
            adyacentes.eliminar(arista);
        }
    }

    public boolean esAdyacente(Vertice<T> v) {
        Arista<T> arista = obtenerArista(v);

        return arista != null;
    }

    public int peso(Vertice<T> v) {
        Arista<T> arista = obtenerArista(v);

        int ret = 0;
        if (arista != null) {
            ret = arista.peso();
        }

        return ret;
    }

    private Arista<T> obtenerArista(Vertice<T> v) {
        Arista<T> arista = null;
        Arista<T> aristaAux;
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            aristaAux = adyacentes.proximo();
            if (aristaAux.verticeDestino() == v) {
                arista = aristaAux;
            }
        }
        return arista;
    }

    public void setPosicion(int pos) {
        posicion = pos;
    }

}
