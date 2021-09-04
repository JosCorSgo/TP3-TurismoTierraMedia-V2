package TierraMediaCod;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private TipoDeAtraccion preferencia;
	private double dinero;
	private double tiempo;
	private Posicion posicion;
	private ArrayList<Atraccion> itinerarioDiario;
	
	
	public Usuario(String nombre, TipoDeAtraccion preferencia, double monedasDisponibles,
					int horasDisponibles, Posicion posicion) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.dinero = monedasDisponibles;
		this.tiempo = horasDisponibles;
		this.posicion  = posicion;
		//inicializar el arraylist 
	}
	
	public Usuario () {
		
	}
	
	protected void mostrarElUsuario(){
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.print(String.format("%-25s", "Nombre: " + this.nombre));
		System.out.print(String.format("%-30s", "Preferencia: " + this.preferencia));
		System.out.print(String.format("%-15s", "Dinero: " + this.dinero));
		System.out.println(String.format("%-15s", "Tiempo: " + this.tiempo));
		System.out.println("---------------------------------------------------------------------------------------------");
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoDeAtraccion getPreferencia() {
		return this.preferencia;
	}

	public double getDinero() {
		return this.dinero;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public void agregarAtraccionAlItinerario(Atraccion atraccion) {
		itinerarioDiario.add(atraccion);
	}

	public void imprimirElItinerarioDiario() {
		System.out.println("-----------------FALTA HACER ES UN LISTADO NADA MAS----------------------");
		
	}



	
	
	
}
