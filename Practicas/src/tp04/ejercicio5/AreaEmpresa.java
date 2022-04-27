package tp04.ejercicio5;

public class AreaEmpresa {
	private int tardanza;
	private String identificacion;
	
	public int getTardanza() {
		return tardanza;
	}
	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public AreaEmpresa() {
		
	}
	
	public AreaEmpresa(int tardanza, String identificacion) {
		this.tardanza = tardanza;
		this.identificacion = identificacion;
	}
	
	

}
