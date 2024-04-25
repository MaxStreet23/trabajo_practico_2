package ar.edu.unju.fi.ejercicio4.main;
import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int option=0;
		Scanner sc=new Scanner(System.in);
		List<Jugador> jugadores=new ArrayList<Jugador>();
		boolean valido=false;
		while(option!=5){
			do {
				valido=false;
				System.out.println("\n*** MENU ***");
				System.out.println("1) Dar de alta un jugador");
				System.out.println("2) Mostrar todos los jugadores");
				System.out.println("3) Modificar la posicion de un jugador");
				System.out.println("4) Eliminar a un jugador");
				System.out.println("5) Salir");
				try {
					System.out.print("Opcion: ");
					option=Integer.parseInt(sc.next());
					if(option<1||option>5) {
						System.out.println("\nOpcion no valida");
					}else {
						valido=true;
					}
				}catch (NumberFormatException e) {
					System.out.println("\nERROR: Ingrese un numero valido");
				}
			}while(valido==false);
			switch(option) {
			case 1:
				agregarJugador(jugadores, sc, valido);
				break;
			case 2:
				mostrarJugadores(jugadores);
				break;
			case 3:
				modificarPosicionJugador(jugadores, sc, valido);
				break;
			case 4:
				eliminarJugador(jugadores, sc, valido);
				break;
			}
		}
		sc.close();
	}
	private static void agregarJugador(List<Jugador> jugadores, Scanner sc, boolean valido) {
		Jugador jugador=new Jugador();
		String nombre, apellido, nacionalidad;
		float estatura=0, peso=0;
		Calendar calendar=Calendar.getInstance();
		int dia=0,mes=0,anio=0,opcion=0;
		System.out.print("Ingrese nombre del jugador: ");
		nombre=sc.next();
		System.out.print("Ingrese apellido del jugador: ");
		apellido=sc.next();
		valido=false;
		while(valido==false){
			System.out.print("Ingrese la fecha de nacimiento(Dia): ");
			try {
				dia=Integer.parseInt(sc.next());
				if(dia<1) {
					System.out.println("Dia no valido");
				}else {
					valido=true;
				}
			}catch (NumberFormatException e) {
				System.out.println("Ingrese un numero valido");
			}
		}
		valido=false;
		while(valido==false){
			System.out.print("Ingrese la fecha de nacimiento(Mes): ");
			try {
				mes=Integer.parseInt(sc.next());
				if(mes<1) {
					System.out.println("Mes no valido");
				}else {
					valido=true;
				}
			}catch (NumberFormatException e) {
				System.out.println("Ingrese un numero valido");
			}
		}
		System.out.print("Ingrese la fecha de nacimiento(Anio): ");
		valido=false;
		while(valido==false) {
			try {
				anio=Integer.parseInt(sc.next());
				valido=true;
			}catch (NumberFormatException e) {
				System.out.println("Ingrese un numero valido");
			}
		}
		calendar.set(anio, mes-1, dia);
		System.out.print("Ingrese el pais del jugador: ");
		nacionalidad=sc.next();
		valido=false;
		while(valido==false){
			System.out.print("Ingrese la estatura del jugador(Metros): ");
			try {
				estatura=Float.parseFloat(sc.next());
				valido=true;
			}catch (NumberFormatException e) {
				System.out.println("Ingrese un numero valido");
			}
		}
		valido=false;
		while(valido==false){
			System.out.print("Ingrese el peso del jugador(Kilos): ");
			try {
				peso=Float.parseFloat(sc.next());
				valido=true;
			}catch (NumberFormatException e) {
				System.out.println("Ingrese un numero valido");
			}
		}
		valido=false;
		do {
			System.out.print("\n*** Posicion del Jugador ***\n");
			System.out.print("1) Delantero\n");
			System.out.print("2) Medio\n");
			System.out.print("3) Defensa\n");
			System.out.print("4) Arquero\n");
			try {
				System.out.print("Opcion: ");
				opcion=Integer.parseInt(sc.next());
				if(opcion<1||opcion>4) {
					System.out.print("\nOpcion no valida\n");
				}else {
					valido=true;
				}
			}catch (NumberFormatException e) {
				System.out.print("\nERROR: Ingrese un numero valido\n");
			}
		}while(valido==false);
		switch(opcion) {
		case 1:
			jugador.setPosicion(Posicion.DELANTERO);
			break;
		case 2:
			jugador.setPosicion(Posicion.MEDIO);
			break;
		case 3:
			jugador.setPosicion(Posicion.DEFENSA);
			break;
		case 4:
			jugador.setPosicion(Posicion.ARQUERO);
			break;
		}
		//(nombre, apellido, calendar, nacionalidad, estatura, peso, posicion);
		jugador.setNombre(nombre);
		jugador.setApellido(apellido);
		jugador.setFechaNacimiento(calendar);
		jugador.setNacionalidad(nacionalidad);
		jugador.setEstatura(estatura);
		jugador.setPeso(peso);
		jugadores.add(jugador);
		System.out.print("\nJugador creado\n");
	}
	
	private static void mostrarJugadores(List<Jugador> jugadores) {
		System.out.println("\n**Jugadores**\n");
		for(Jugador jugador : jugadores) {
			System.out.print("Nombre y Apellido: "+jugador.getNombre()+" "+jugador.getApellido()+"\n");
			jugador.mostrarFechaNacimiento();
			System.out.print("Nacionalidad: "+jugador.getNacionalidad()+"\n");
			System.out.print("Estatura: "+jugador.getEstatura()+"\n");
			System.out.print("Peso: "+jugador.getPeso()+"\n");
			System.out.println("Posicion: "+jugador.getPosicion()+"\n");
		}
	}
	
	private static void modificarPosicionJugador(List<Jugador> jugadores, Scanner sc, boolean valido) {
		String nombre, apellido;
		int opcion=0;
		System.out.print("Ingrese el nombre del jugador: ");
		nombre=sc.next();
		System.out.print("Ingrese el apellido del jugador: ");
		apellido=sc.next();
		valido=false;
		for(Jugador jugador : jugadores) {
			if(jugador.getNombre().equals(nombre)&&jugador.getApellido().equals(apellido)) {
				System.out.print("\nJugador Encontrado\n");
				do {
					System.out.print("\n*** Posicion del Jugador ***\n");
					System.out.print("1) Delantero\n");
					System.out.print("2) Medio\n");
					System.out.print("3) Defensa\n");
					System.out.print("4) Arquero\n");
					try {
						System.out.print("Opcion: ");
						opcion=Integer.parseInt(sc.next());
						if(opcion<1||opcion>4) {
							System.out.print("\nOpcion no valida\n");
						}else {
							valido=true;
						}
					}catch (NumberFormatException e) {
						System.out.print("\nERROR: Ingrese un numero valido\n");
					}
				}while(valido==false);
				switch(opcion) {
				case 1:
					jugador.setPosicion(Posicion.DELANTERO);
					break;
				case 2:
					jugador.setPosicion(Posicion.MEDIO);
					break;
				case 3:
					jugador.setPosicion(Posicion.DEFENSA);
					break;
				case 4:
					jugador.setPosicion(Posicion.ARQUERO);
					break;
				}
				System.out.print("\nJugador Modificado\n");
			}
		}
		if(valido==false) {
			System.out.print("\nJugador no Encontrado\n");
		}
	}
	
	private static void eliminarJugador(List<Jugador> jugadores, Scanner sc, boolean valido) {
		String nombre, apellido;
		Jugador jugadorBuscado=new Jugador();
		System.out.print("Ingresar el nombre del jugador: ");
		nombre=sc.next();
		System.out.print("Ingresar el apellido del jugador: ");
		apellido=sc.next();
		jugadorBuscado=buscarJugador(jugadores, nombre, apellido);
		if(jugadorBuscado.getNombre()!=null) {
			Iterator<Jugador> jugador=jugadores.iterator();
			while(jugador.hasNext()) {
				if (jugador.next().equals(jugadorBuscado)) {
	           		jugador.remove();
	           	}
	        }
			System.out.print("\nJugador Eliminado\n");
		}else {
			System.out.print("\nJugador no encontrado\n");
		}
	}
	public static Jugador buscarJugador(List<Jugador> jugadores, String nombre, String apellido) {
		Jugador jugadorBuscado=new Jugador();
		try{
			for (Jugador jugador : jugadores) {
            	if (jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
            		jugadorBuscado = jugador;
            	}                
            }
		}catch(Exception e){
			System.out.println("ERROR: "+e.getMessage());
		}
		return jugadorBuscado;
	}
}
