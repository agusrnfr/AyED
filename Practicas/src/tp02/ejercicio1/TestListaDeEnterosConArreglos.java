package tp02.ejercicio1;

public class TestListaDeEnterosConArreglos {
	
	public static void main(String[] args) {
		ListaDeEnterosConArreglos obj = new ListaDeEnterosConArreglos ();
        if (args.length  == 0){
       	 System.out.println("El programa se ejecutó sin parametros");
        }
        else if (args.length > 1) {
    		int num = 0;
    		Integer numero;
        	while (num < args.length) {
			numero = Integer.parseInt(args[num]);
			num++;
			obj.agregarFinal(numero);
        	}
		}
		obj.comenzar();
		while (!obj.fin()) {
			System.out.println(obj.proximo());
		}
	}	
}

/*1.4. ¿Qué diferencia encuentra entre las implementaciones de los puntos anteriores? 
La diferencia es que uno la lista de enteros enlazada con un objeto llamado NODO donde se almacena la informacion, mientras que en la de arreglos se almacena en un arreglo propio
de la clase.
El arreglo tiene un limite, la lista no.

*/