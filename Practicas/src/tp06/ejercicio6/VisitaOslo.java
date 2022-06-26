package tp06.ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class VisitaOslo {
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,ListaGenerica<String> lugaresRestringidos){
		boolean[]marca = new boolean[lugares.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!lugaresRestringidos.incluye(destino) && !lugaresRestringidos.incluye("Ayuntamiento")) {
			ListaGenerica<Vertice<String>> aux = lugares.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			boolean ok = false;
			int i = -1;
			while ((!aux.fin()) && (!ok)) {
				vertice = aux.proximo();
				if (vertice.dato() == "Ayuntamiento") {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if (i != -1) {
				int tiempo = 0;
				dfs (lugares,i,lis,camino,marca,destino,maxTiempo,lugaresRestringidos,tiempo);
			}
		}
		
		return camino;
		
		
	}
	
	private void dfs (Grafo<String> lugares,int i, ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino, boolean[]marca, String destino, int maxTiempo,ListaGenerica<String> lugaresRestringidos,int tiempo) {
		marca[i] = true;
		Vertice<String> v = lugares.listaDeVertices().elemento(i);
		if (v.dato() == destino) {
			clonar (lis,camino);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if ((!marca[j]) && (!(lugaresRestringidos.incluye(arista.verticeDestino().dato())))) {
					tiempo += arista.peso();
					if (tiempo <= maxTiempo) {
						lis.agregarFinal(arista.verticeDestino().dato());
						dfs (lugares,j,lis,camino,marca,destino,maxTiempo,lugaresRestringidos,tiempo);
						lis.eliminarEn(lis.tamanio());
						if (camino.esVacia()) {
							marca[j] = false;
						}
					}
					tiempo-= arista.peso();
				}
			}
		}
	}

	
	private void clonar (ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino) {
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
	
	public ListaGenerica<String> paseoEnBici2(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean[lugares.listaDeVertices().tamanio() + 1];
		ListaGenerica<Vertice<String>> aux = lugares.listaDeVertices();
		Vertice<String> v = null;
		boolean ok = false;
		aux.comenzar();
		while(!aux.fin() && !ok) {
			v = aux.proximo();
			if (v.dato().equals("Ayuntamiento")) {
				ok = true;
			}
		}
		if (ok) {
			paseoEnBici2(lugares,v.getPosicion(),camino,marca,maxTiempo,destino,lugaresRestringidos);
		}
		
		return camino;
	}
	
	private boolean paseoEnBici2(Grafo<String> lugares,int i,ListaGenerica<String> camino,boolean[]marca,int maxTiempo,String destino,ListaGenerica<String> restringido) {
		boolean encontre = false;
		marca[i] = true;
		Vertice<String> v = lugares.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(destino)) {
			encontre = true;
		}else {
			ListaGenerica<Arista<String>>ady = lugares.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin() && !encontre) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && !restringido.incluye(arista.verticeDestino().dato())) {
					maxTiempo-= arista.peso();
					if (maxTiempo >= 0) {
						encontre = paseoEnBici2(lugares,j,camino,marca,maxTiempo,destino,restringido);
					}
					maxTiempo+= arista.peso();
				}
				
			}
			if (!encontre) {
				marca[i] = false;
				camino.eliminarEn(camino.tamanio());
			}
		}
		
		return encontre;
	}

}
