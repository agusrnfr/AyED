package Parcial.Practica2.Ejercicio5;

public class Sitio {
	private String nom;
	private String estado;
	
	public Sitio(String nom, String estado) {
		this.setNombre(nom);
		this.setEstado(estado);
	}

	public String getNombre() {
		return nom;
	}

	public void setNombre(String nom) {
		this.nom = nom;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
