package TierraMediaCod;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nombre;
	private TipoDeAtraccion preferencia;
	private double dinero;
	private double tiempo;
	private Posicion posicion;
	private ArrayList<Sugerible> itinerarioDiario = new ArrayList<Sugerible>() ;
	
	
	public Usuario(String nombre, TipoDeAtraccion preferencia, double monedasDisponibles,
					int horasDisponibles, Posicion posicion) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.dinero = monedasDisponibles;
		this.tiempo = horasDisponibles;
		this.posicion  = posicion;
	}
	
	public Usuario () {
		
	}
	
	// ----------------------------------------  metodos -----------------------------------------------------------
	
	public boolean comproSugerible(Sugerible sugerible) {
		return this.itinerarioDiario.contains(sugerible);
	}

	public void agregarSugeribleAlItinerario(Atraccion atraccion) {
		itinerarioDiario.add(atraccion);
	}



	protected void mostrarElUsuario(){
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.print(String.format("%-25s", "Nombre: " + this.nombre));
		System.out.print(String.format("%-30s", "Preferencia: " + this.preferencia));
		System.out.print(String.format("%-15s", "Dinero: " + this.dinero));
		System.out.println(String.format("%-15s", "Tiempo: " + this.tiempo));
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	

	// ------------------------------- getters y setters -------------------------------------------------------

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

	
	
	
}
