package TierraMediaCod;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nombre;
	private TipoDeAtraccion preferencia;
	private double dinero;
	private double tiempo;
	private Posicion posicion;
	private ArrayList<Atraccion> itinerarioDiario = new ArrayList<Atraccion>() ;
	
	
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
		double cantDinero= 0;
		double cantTiempo = 0;
		for (int i=1; i<100; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("   Su itinerario tiene: " + itinerarioDiario.size() + " atracciones"); 
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-                         LISTADO DE ATRACCIONES DEL ITINERARIO                             -");
		
		for(Atraccion atraccion: this.itinerarioDiario) {
			atraccion.mostrarLaAtraccion();
			cantDinero += atraccion.getPrecio();
			cantTiempo += atraccion.getDuracion();
		}
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.print(String.format("%-40s"," Tiene un costo de $" + cantDinero + " atracciones")); 
		System.out.print(String.format("%-40s"," y una duracion de " + cantTiempo + " horas"));
		System.out.println("");
		System.out.println(" Gracias por si visita");
		System.out.println("---------------------------------------------------------------------------------------------");
	}



	
	
	
}
