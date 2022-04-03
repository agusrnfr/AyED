package ClaseEstudiante;

public class Test {

	public static void main(String[] args) {
		Estudiante [] arregloE = {new Estudiante(),new Estudiante ()};
		Profesor [] arregloP = {new Profesor (),new Profesor(),new Profesor()};
		
		// ESTUDIANTES
		
		arregloE[0].setNombre("Marina");
		arregloE[0].setApellido("Diamandis");
		arregloE[0].setComision(2);
		arregloE[0].setEmail("marinadiamandis85@gmail.com");
		arregloE[0].setDireccion("unadireccion");
		arregloE[1].setNombre("Lana");
		arregloE[1].setApellido("Del Rey");
		arregloE[1].setComision(2);
		arregloE[1].setEmail("lanadelrey85@gmail.com");
		arregloE[1].setDireccion("unadireccion");
		
		//PROFESORES
		
		arregloP[0].setNombre("Madonna");
		arregloP[0].setApellido("Ciccone");
		arregloP[0].setCatedra ("Like a Prayer");
		arregloP[0].setEmail("madonna@gmail.com");
		arregloP[0].setFacultad("New York");
		arregloP[1].setNombre("Amy");
		arregloP[1].setApellido("Lee");
		arregloP[1].setCatedra("My immortal");
		arregloP[1].setEmail("amylee81@gmail.com");
		arregloP[1].setFacultad("Evanescence");
		arregloP[2].setNombre("Taylor");
		arregloP[2].setApellido("Swift");
		arregloP[2].setCatedra("All Too Well");
		arregloP[2].setEmail("ts1989@gmail.com");
		arregloP[2].setFacultad("Reputation");
	
	
		for (int i = 0; i < 2; i++) {
			System.out.println( arregloE[i].tusDatos());
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println(arregloP[i].tusDatos());
		}

	}
	
}
