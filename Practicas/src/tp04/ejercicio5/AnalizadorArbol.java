package tp04.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa>arbol) {
	
	ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
	ArbolGeneral<AreaEmpresa> aux;
	
	cola.encolar(arbol);
	cola.encolar(null);
	
	int total=0,max = -1,nivel = 0,cantidad = 0;
	
	while (!cola.esVacia()) {
		aux = cola.desencolar();
		if (aux != null) {
			total = total + aux.getDato().getTardanza();
			cantidad++;
			if (aux.tieneHijos()) {
				ListaGenerica<ArbolGeneral<AreaEmpresa>> lhijos = aux.getHijos();
				lhijos.comenzar();
				while (!lhijos.fin())
					cola.encolar(lhijos.proximo());
			}
		}
		else {	
			total = total / cantidad;
			if(total > max)
				max = total;				
			cantidad=0;
			total = 0;
			if (!cola.esVacia()) {			
				cola.encolar(null);
				nivel++;
			}
		}
	}
	return max;
}	
}
