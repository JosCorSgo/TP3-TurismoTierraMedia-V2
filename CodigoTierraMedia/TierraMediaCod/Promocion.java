package TierraMediaCod;

import java.util.ArrayList;
import java.util.Scanner;

public class Promocion extends Sugerible{
	private ArrayList <Atraccion> atracionesPromocionadas;
	
	public Promocion (String nombre, double precio, double duracion, TipoDeAtraccion tipo, ArrayList<Atraccion> atracciones) {
		super(nombre, precio, duracion, tipo);
		this.atracionesPromocionadas = atracciones;
	}
	
	public Promocion() {
		
	}
		
	public boolean ofrecer(){
		mostrarEncabezado();
		mostrarLaPromocion();
		return pedirConfirmacion();
	}
	
	public void mostrarEncabezado() {
		for (int i=1; i<3; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-                                 PROMOCION ABSOLUTA                                        -");
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	protected boolean pedirConfirmacion() {
		Scanner entrada = new Scanner(System.in);
		boolean seguir = true;
		boolean acepta = false;
		while (seguir) {
			System.out.print(String.format("%-15s", "¿Agregar esta atraccion al itinerario? s/n: "));
			char opcion = entrada.next().charAt(0);
			switch (opcion){
			case 's': acepta = true;  seguir = false; break;
			case 'S': acepta = true;  seguir = false; break;
			case 'n': acepta = false; seguir = false; break;
			case 'N': acepta = false; seguir = false; break;
  			}
		}
		if (acepta) 
			System.out.print("Excelente eleccion, la agregaremos a su itinerario.");	
		
		return acepta;
	}

	protected void mostrarLaPromocion() {
		System.out.println("");
		System.out.print(String.format("%-40s", "Nombre: " + super.getNombre()));
		System.out.println(String.format("%-40s", "Tipo de Atraccion: " + super.getTipo()));		
		System.out.print(String.format("%-30s", "Costo: "  + super.getPrecio()));
		System.out.print(String.format("%-15s", "Duracion: " + super.getDuracion()));
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("                    LA PROMOCION INCLUYE LAS SIGUIENTES ATRACCIONES                          ");
		System.out.println("---------------------------------------------------------------------------------------------");
		
		for(Atraccion atraccion: this.atracionesPromocionadas)
			atraccion.mostrarLaAtraccion();
		
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	public ArrayList<Atraccion> getAtracionesPromocionadas() {
		return this.atracionesPromocionadas;
	}
	

}
