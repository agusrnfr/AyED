package tp02.ejercicio2;
import ClaseEstudiante.Estudiante;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		Estudiante es1 = new Estudiante ("Lana","Del Rey",3,"lanadelrey85@gmail.com","direccion");
		Estudiante es2 = new Estudiante ("Marina","Diamandis",3,"marinad85@gmail.com","direccion");
		Estudiante es3 = new Estudiante ("Taylor","Swift",3,"ts1989@gmail.com","direccion");
		Estudiante es4 = new Estudiante ("Amy","Lee",3,"amyleev@gmail.com","direccion");
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante> ();
		lista.agregarFinal(es1);
		lista.agregarFinal(es2);
		lista.agregarFinal(es3);
		lista.agregarFinal(es4);
		
		while (!lista.fin()) {
			System.out.println(lista.proximo().tusDatos());
		}

	}

}
