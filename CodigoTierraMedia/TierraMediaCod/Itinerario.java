package TierraMediaCod;

import java.util.ArrayList;

public class Itinerario {
	private String nombreDelUsuario;
	private int costo;
	private double tiempoNecesario;
	private ArrayList<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();

	
	public Itinerario (String nombreDelUsuario, int costo, double tiempoNecesario, ArrayList<Atraccion> atraccionesIncluidas) {
		this.nombreDelUsuario = nombreDelUsuario;
		this.costo = costo;
		this.tiempoNecesario = tiempoNecesario;
		this.atraccionesIncluidas = atraccionesIncluidas;
	}


	public Itinerario(String nombreDelUsuario) {
		this.nombreDelUsuario = nombreDelUsuario;
		this.costo = 0;
		this.tiempoNecesario = 0;
	}
	
	public void agregarAtraccionAlItinerario (Atraccion atraccion) {
		atraccionesIncluidas.add(atraccion);
	}

	public void imprimirElItinerario() {
		for (int i=1; i<50; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("            EL ITINERARIO DE "+ this.nombreDelUsuario + " TIENE:  " + atraccionesIncluidas.size() + " ATRACCIONES"); 
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-                         LISTADO DE ATRACCIONES DEL ITINERARIO                             -");
		
		System.out.print(String.format("%-30s", "Nombre de la atraccion"));
		System.out.print(String.format("%-10s", "Tipo"));
		System.out.print(String.format("%-15s", "Duracion"));
		System.out.println(String.format("%-10s", "Posicion"));
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Atraccion atraccion :this.atraccionesIncluidas) {
			System.out.println("");
			System.out.print(String.format("%-30s", atraccion.getNombre()));
			System.out.print(String.format("%-15s", atraccion.getTipoDeAtraccionIncluidas()));
			System.out.print(String.format("%-10s", atraccion.getDuracion()));
			System.out.print(String.format("%-14s", atraccion.getPosicion()));
		}
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.print(String.format("%-40s"," Tiene un costo de $" + this.costo )); 
		System.out.print(String.format("%-40s"," y una duracion de " + this.tiempoNecesario + " horas"));
		System.out.println("");
		System.out.println(" Gracias por si visita");
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	

	// ------------------------------- GETTERS Y SETTERS -------------------------------------
	public String getNombreDelUsuario() {
		return this.nombreDelUsuario;
	}


	public void setNombreDelUsuario(String nombreDelUsuario) {
		this.nombreDelUsuario = nombreDelUsuario;
	}


	public int getCosto() {
		return this.costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public double getTiempoNecesario() {
		return this.tiempoNecesario;
	}


	public void setTiempoNecesario(double tiempoNecesario) {
		this.tiempoNecesario = tiempoNecesario;
	}


	public ArrayList<Atraccion> getAtraccionesIncluidas() {
		return this.atraccionesIncluidas;
	}


	public void setAtraccionesIncluidas(ArrayList<Atraccion> atraccionesIncluidas) {
		this.atraccionesIncluidas = atraccionesIncluidas;
	}


	
	
}
