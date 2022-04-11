package tp02.ejercicio1;

public class Ejercicio1_6 {
	
	private ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada(); //creo lista como variable de instancia para agregale los elementos
	
		public ListaDeEnterosEnlazada sucesion (int n) {
			if (n != 1 ) {
				if (n % 2 == 0 ) {
					n = n/2;
				}
				else
					n = 3*n+1;
				lista.agregarFinal(n);
				sucesion(n);
			}
			return lista;
		}

	public static void main(String[] args) {
		int n = 6;
		Ejercicio1_6 f = new Ejercicio1_6(); //creo objeto de clase Ejercicio1_6 para poder instanciar el metodo
		ListaDeEnterosEnlazada l = f.sucesion(n); //creo lista de enteros para ponerle el resultado del metodo
		System.out.println("SUCESION DE " + n );
		l.comenzar();
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
	}

}