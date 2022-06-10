package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mapa {
	private Grafo<String> mapaCiudades;
	
	public Mapa (Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2){
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			boolean ok = false;
			int i = -1;
			while ((!aux.fin()) && (!ok)) {
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if (i != -1) {
				dfs (i,lis,camino,marca,ciudad2);
			}
			
		return camino;
		
	}
	
	private void dfs (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			clonar (lis,camino);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Vertice<String> destino = ady.proximo().verticeDestino();
				int j = destino.getPosicion();
				if (!marca[j]) {
					lis.agregarFinal(destino.dato());
					dfs(j,lis,camino,marca,ciudad2);
					lis.eliminarEn(lis.tamanio());
				}
			}
		
		}
		
		
	}
	
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,ListaGenerica<String> ciudades){
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (!ciudades.incluye(ciudad1) && !ciudades.incluye(ciudad2)){
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			boolean ok = false;
			int i = -1;
			while ((!aux.fin()) && (!ok)) {
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if (i != -1) {
				dfsExceptuando (i,lis,camino,marca,ciudad2,ciudades);
			}
		}
		return camino;
		
	}
	
	private void dfsExceptuando (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2,ListaGenerica<String> ciudades) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			clonar (lis,camino);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Vertice<String> destino = ady.proximo().verticeDestino();
				int j = destino.getPosicion();
				if ((!marca[j]) && (!(ciudades.incluye(destino.dato())))) {
					lis.agregarFinal(destino.dato());
					dfsExceptuando(j,lis,camino,marca,ciudad2,ciudades);
					lis.eliminarEn(lis.tamanio());
				}
			}
		
		}
		
		
	}
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		Min minimo = new Min(9999);
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
		aux.comenzar();
		Vertice<String> vertice;
		boolean ok = false;
		int i = -1;
		while ((!aux.fin()) && (!ok)) {
			vertice = aux.proximo();
			if (vertice.dato() == ciudad1) {
				ok = true;
				i = vertice.getPosicion();
				lis.agregarFinal(vertice.dato());
			}
		}
		if (i != -1) {
			int distancia = 0;
			dfsCorto (i,lis,camino,marca,ciudad2,minimo,distancia);
		}
		return camino;
		
	}
	
	private void dfsCorto (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2,Min minimo,int distancia) {
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			if (distancia < minimo.getMinimo()) {
				clonar2 (lis,camino);
				minimo.setMinimo(distancia);
			}
		}
		else {
			marca[i] = true; //NO MARCO EL DESTINO PORQUE VOY A VOLVER A IR AHI
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()){
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					distancia+= arista.peso();
					lis.agregarFinal(arista.verticeDestino().dato());
					dfsCorto(j,lis,camino,marca,ciudad2,minimo,distancia);
					lis.eliminarEn(lis.tamanio());
					distancia-=arista.peso();
				}
			}
		}
			
	}
	
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (tanqueAuto != 0) {
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			boolean ok = false;
			int i = -1;
			while ((!aux.fin()) && (!ok)) {
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if (i != -1) {
				dfsSinCargar (i,lis,camino,marca,ciudad2,tanqueAuto);
			}
		}
		return camino;
		
	}
	
	private void dfsSinCargar (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2,int tanqueAuto) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
				clonar (lis,camino);
			}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()){
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					tanqueAuto-= arista.peso();
					if (tanqueAuto >= 0) {
						lis.agregarFinal(arista.verticeDestino().dato());
						dfsSinCargar(j,lis,camino,marca,ciudad2,tanqueAuto);
						lis.eliminarEn(lis.tamanio());
					}
					tanqueAuto+=arista.peso();
				}
			}
		}
			
	}
	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		Min minimo = new Min (9999);
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (tanqueAuto != 0) {
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			boolean ok = false;
			int i = -1;
			while ((!aux.fin()) && (!ok)) {
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if (i != -1) {
				int carga = tanqueAuto;
				int cant = 0;
				dfsMenorCarga (i,lis,camino,marca,ciudad2,tanqueAuto,carga,cant,minimo);
			}
		}
		return camino;
		
	}
	
	private void dfsMenorCarga (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2,int tanqueAuto, int carga, int cant,Min minimo) {
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			if (cant < minimo.getMinimo()) { //SI ES EL MINIMO DE CARGAS CLONO EL CAMINO Y AHORA PASA A SER EL MINIMO
				clonar2 (lis,camino);
				minimo.setMinimo(cant);
			}
		}
		else {
			if (tanqueAuto == 0) { //SI LLEGO A CIUDAD Y ME QUEDE SIN COMBUSTIBLE CARGO
				tanqueAuto+= carga - tanqueAuto;
				cant++; //INCREMENTO CONTADOR DE CARGAS
			}
			marca[i] = true;
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()){
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					tanqueAuto-= arista.peso(); //RESTO LO QUE VOY A GASTAR DE COMBUSTIBLE
					if (tanqueAuto >= 0) { //VERIFICO QUE NO ME VOY A QUEDAR SIN COMBUSTIBLE EN EL MEDIO DE LA RUTA
						lis.agregarFinal(arista.verticeDestino().dato());
						dfsMenorCarga(j,lis,camino,marca,ciudad2,tanqueAuto,carga,cant,minimo);
						lis.eliminarEn(lis.tamanio());
					}
					tanqueAuto+=arista.peso(); //SUMO LO QUE LE RESTE PARA PODER CAMBIAR DE CAMINO Y SEGUIR CON LA SUMA
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
	
	private void clonar2 (ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino) {
		camino.comenzar();
		while(!camino.fin()) {
			camino.eliminar(camino.proximo());
		}
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}

}

