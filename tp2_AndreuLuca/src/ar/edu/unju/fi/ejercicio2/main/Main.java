package ar.edu.unju.fi.ejercicio2.main;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		List<Efemeride> efemerides=new ArrayList<Efemeride>();
		Scanner sc=new Scanner(System.in);
		int option=0;
		boolean valido=false;
		while(option!=5){
			do {
				valido=false;
				System.out.print("\n*** MENU ***\n");
				System.out.print("1) Crear Efemeride\n");
				System.out.print("2) Mostrar Efemerides\n");
				System.out.print("3) Eliminar Efemeride\n");
				System.out.print("4) Modificar Efemeride\n");
				System.out.print("5) Salir\n");
				try {
					System.out.print("Opcion: ");
					option=Integer.parseInt(sc.next());
					if(option<1||option>5) {
						System.out.print("\nOpcion no valida\n");
					}else {
						valido=true;
					}
				}catch (NumberFormatException e) {
					System.out.print("\nERROR: Ingrese un numero valido\n");
				}
			}while(valido==false);
			switch(option) {
			case 1:
				crearEfemeride(efemerides,sc,valido);
				break;
			case 2:
				mostrarEfemerides(efemerides);
				break;
			case 3:
				eliminarEfemeride(efemerides,sc,valido);
				break;
			case 4:
				modificarEfemeride(efemerides,sc,valido);
				break;
			}
		}
		sc.close();
	}
	private static void crearEfemeride(List<Efemeride> efemerides, Scanner sc, boolean valido) {
		Efemeride efemeride=new Efemeride();
		String codigo="", detalle;
		int dia=0, opcion=0;
		valido=false;
		while(valido==false){
			valido=true;
			System.out.print("Ingrese el codigo del Efemeride: ");
			codigo=sc.next();
			Iterator<Efemeride> efemerideExistente=efemerides.iterator();
			while(efemerideExistente.hasNext()) {
				if (efemerideExistente.next().getCodigo().equals(codigo)) {
		           	valido=false;
		        }
		    }
			if(valido==false) {
				System.out.println("Codigo ya existente. Ingrese uno nuevo\n");
			}
		}
		valido=false;
		do {
			System.out.print("Ingrese el mes del Efemeride (Numero): ");
			try {
				opcion=Integer.parseInt(sc.next());
				if(opcion<1||opcion>12) {
					System.out.print("\nMes no valido\n");
				}else {
					valido=true;
				}
			}catch (NumberFormatException e) {
				System.out.print("\nERROR: Ingrese un numero valido\n");
			}
		}while(valido==false);
		switch(opcion) {
		case 1:
			efemeride.setMes(Mes.ENERO);
			break;
		case 2:
			efemeride.setMes(Mes.FEBRERO);
			break;
		case 3:
			efemeride.setMes(Mes.MARZO);
			break;
		case 4:
			efemeride.setMes(Mes.ABRIL);
			break;
		case 5:
			efemeride.setMes(Mes.MAYO);
			break;
		case 6:
			efemeride.setMes(Mes.JUNIO);
			break;
		case 7:
			efemeride.setMes(Mes.JULIO);
			break;
		case 8:
			efemeride.setMes(Mes.AGOSTO);
			break;
		case 9:
			efemeride.setMes(Mes.SEPTIEMBRE);
			break;
		case 10:
			efemeride.setMes(Mes.OCTUBRE);
			break;
		case 11:
			efemeride.setMes(Mes.NOVIEMBRE);
			break;
		case 12:
			efemeride.setMes(Mes.DICIEMBRE);
			break;
		}
		valido=false;
		do {
			System.out.print("Ingrese el dia del Efemeride: ");
			try {
				dia=Integer.parseInt(sc.next());
				if(dia<1||dia>31) {//Perdone si es que no controlo si el mes tiene esa cantidad de dias
					System.out.print("\nDia no valido\n");
				}else {
					valido=true;
				}
			}catch (NumberFormatException e) {
				System.out.print("\nERROR: Ingrese un numero valido\n");
			}
		}while(valido==false);
		System.out.print("Ingrese la descripcion del Efemeride: ");
		sc.nextLine();
		detalle=sc.nextLine();
		efemeride.setCodigo(codigo);
		efemeride.setDetalle(detalle);
		efemeride.setDia(dia);
		efemerides.add(efemeride);
		System.out.print("\nEfemeride añadido\n");
	}
	
	private static void mostrarEfemerides(List<Efemeride> efemerides) {
		System.out.println("\n**Efemerides**\n");
		for(Efemeride efemeride : efemerides) {
			System.out.print("Codigo: "+efemeride.getCodigo()+"\n");
			System.out.print("Mes: "+efemeride.getMes()+"\n");
			System.out.print("Dia: "+efemeride.getDia()+"\n");
			System.out.println("Detalle: "+efemeride.getDetalle()+"\n");
		}
	}
	
	private static void eliminarEfemeride(List<Efemeride> efemerides, Scanner sc, boolean valido) {
		String codigo;
		valido=false;
		System.out.print("Ingresar el codigo del efemeride a borrar: ");
		codigo=sc.next();
		Iterator<Efemeride> efemeride=efemerides.iterator();
		while(efemeride.hasNext()) {
			if (efemeride.next().getCodigo().equals(codigo)) {
	           	efemeride.remove();
	           	valido=true;
	        }
	    }
		if(valido==true) {
			System.out.println("\nEfemeride Eliminado");
		}else {
			System.out.println("\nEfemeride no encontrado");
		}
	}
	
	private static void modificarEfemeride(List<Efemeride> efemerides, Scanner sc, boolean valido) {
		String codigo, detalle;
		int opcion=0,dia=0;
		System.out.print("\nIngrese el codigo del Efemeride a modificar: ");
		codigo=sc.next();
		valido=false;
		for(Efemeride efemeride : efemerides) {
			if(efemeride.getCodigo().equals(codigo)) {
				System.out.print("\nEfemeride Encontrado\n");
				valido=false;
				do {
					System.out.print("Ingrese el mes del Efemeride (Numero): ");
					try {
						opcion=Integer.parseInt(sc.next());
						if(opcion<1||opcion>12) {
							System.out.print("\nMes no valido\n");
						}else {
							valido=true;
						}
					}catch (NumberFormatException e) {
						System.out.print("\nERROR: Ingrese un numero valido\n");
					}
				}while(valido==false);
				switch(opcion) {
				case 1:
					efemeride.setMes(Mes.ENERO);
					break;
				case 2:
					efemeride.setMes(Mes.FEBRERO);
					break;
				case 3:
					efemeride.setMes(Mes.MARZO);
					break;
				case 4:
					efemeride.setMes(Mes.ABRIL);
					break;
				case 5:
					efemeride.setMes(Mes.MAYO);
					break;
				case 6:
					efemeride.setMes(Mes.JUNIO);
					break;
				case 7:
					efemeride.setMes(Mes.JULIO);
					break;
				case 8:
					efemeride.setMes(Mes.AGOSTO);
					break;
				case 9:
					efemeride.setMes(Mes.SEPTIEMBRE);
					break;
				case 10:
					efemeride.setMes(Mes.OCTUBRE);
					break;
				case 11:
					efemeride.setMes(Mes.NOVIEMBRE);
					break;
				case 12:
					efemeride.setMes(Mes.DICIEMBRE);
					break;
				}
				valido=false;
				do {
					System.out.print("Ingrese el dia del Efemeride: ");
					try {
						dia=Integer.parseInt(sc.next());
						if(dia<1||dia>31) {//Perdone si es que no controlo si el mes tiene esa cantidad de dias
							System.out.print("\nDia no valido\n");
						}else {
							valido=true;
						}
					}catch (NumberFormatException e) {
						System.out.print("\nERROR: Ingrese un numero valido\n");
					}
				}while(valido==false);
				System.out.print("Ingrese la descripcion del Efemeride: ");
				sc.nextLine();
				detalle=sc.nextLine();
				efemeride.setDia(dia);
				efemeride.setDetalle(detalle);
				System.out.print("\nEfemeride Modificado\n");
			}
		}
		if(valido==false) {
			System.out.print("\nEfemeride no encontrado\n");
		}
	}
}