package TierraMediaCod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nombre;
	private TipoDeAtraccion preferencia;
	private double dinero;
	private double tiempo;
	private Posicion posicion;
	private ArrayList<Itinerario> itinerariosComprados = new ArrayList<Itinerario>() ;
	
	
	public Usuario(String nombre, TipoDeAtraccion preferencia, double monedasDisponibles,
					double horasDisponibles, Posicion posicion) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.dinero = monedasDisponibles;
		this.tiempo = horasDisponibles;
		this.posicion  = posicion;
	}
	
	public Usuario () {
		
	}
	
	// ----------------------------------------  metodos -----------------------------------------------------------
	/*
	public void agregarSugeribleAlItinerario(Atraccion atraccion) {
		itinerarioDiario.add(atraccion);
	}
	*/
	
	public boolean comproSugerible(Sugerible sugerible) {
		return false; // this.itinerarioDiario.contains(sugerible);
	}
		
	protected void mostrarElUsuario(){
		//System.out.print(String.format("%-10s", " "+ orden + "- "));
		System.out.print(String.format("%-25s", "Nombre: " + this.nombre));
		System.out.print(String.format("%-30s", "Preferencia: " + this.preferencia));
		System.out.print(String.format("%-15s", "Dinero: " + this.dinero));
		System.out.println(String.format("%-15s", "Tiempo: " + this.tiempo));
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	public void actualizarPorCompraDeAtraccion(Sugerible sugerible) {
		this.dinero -= sugerible.getPrecio();
		this.tiempo -= sugerible.getDuracion();
	}
	

	public void grabarEnArchivo(String nombreArchivo){
		try {
			FileWriter archivo = new FileWriter(nombreArchivo, true);
			PrintWriter salida = new PrintWriter(archivo);
			salida.println(this.toString());
			salida.close(); 
			archivo.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}


	
	@Override
	public String toString() {
		String cadena = "";
		cadena = this.nombre + "," +
				 this.preferencia + "," +
				 this.dinero + "," +
				 this.tiempo + "," +
				 this.posicion.toString();		
		return cadena;
		
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
