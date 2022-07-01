package Parcial.Practica2.Ejercicio12;

public class Ciudad {
	private String nombre;
	private int transito;
	
	public Ciudad(String nombre, int fase) {
		this.nombre = nombre;
		this.transito = fase;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTransito() {
		return transito;
	}

	public void setTransito(int fase) {
		this.transito = fase;
	}
	

}
