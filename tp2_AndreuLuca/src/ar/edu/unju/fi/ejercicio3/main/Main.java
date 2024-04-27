package ar.edu.unju.fi.ejercicio3.main;
import ar.edu.unju.fi.ejercicio3.constantes.Provincia;
public class Main {
	public static void main(String[] args) {
		Provincia[] provincias=Provincia.values();
		System.out.println("** Provincias **\n");
		for(Provincia i : provincias) {
			System.out.println("Provincia: "+i.name());
			System.out.println("Habitantes: "+i.getCantidadPoblacion());
			System.out.println("Superficie: "+i.getSuperficie()+"km^2");
			System.out.println("Densidad: "+i.calcularDensidad()+"(h/km^2)\n");
		}
	}
}
