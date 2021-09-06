package TierraMediaCod;

import java.util.ArrayList;
import java.util.Scanner;

public class Promocion extends Sugerible{
	private ArrayList <Atraccion> atracionesPromocionadas = new ArrayList <Atraccion>();

	
	public Promocion (String nombre, int precio, double duracion, TipoDeAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones) {
		super(TipoDeSugerible.PROMOCION, nombre, precio, duracion, tipoAtraccion );
		this.atracionesPromocionadas = atracciones;

	}
	
	public Promocion() {
	}

	
	// ---------------------- METODOS ---------------------------------------------
	
	public boolean ofrecer(){
		mostrarEncabezado();
		mostrar();
		return pedirConfirmacion();
	}
	
	public ArrayList<Atraccion> atraccionesQueContiene(){
		return this.atracionesPromocionadas;
		
	}
	
	public void agregarmeAlItinerario(Itinerario itinerario){
		for(Atraccion atraccion: this.atracionesPromocionadas) {
			itinerario.setCosto(itinerario.getCosto() + super.getPrecio());
			itinerario.setTiempoNecesario(itinerario.getTiempoNecesario() + super.getDuracion());
			itinerario.agregarAtraccionAlItinerario(atraccion);	
		}
		System.out.println("Se agrego una PROMOCION a su itinerario");
		
	}
	
	public void mostrarEncabezado() {
		for (int i=1; i<3; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-                                 PROMOCION ABSOLUTA                                        -");
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	public boolean tieneCupo() {
		boolean aux = true;
		for(Atraccion atraccion: this.atracionesPromocionadas)
			if (atraccion.getCupo() <= 0)
				aux = false;
		return aux;
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

	protected void mostrar() {
		System.out.println("");
		System.out.print(String.format("%-40s", "Nombre: " + super.getNombre()));
		System.out.println(String.format("%-40s", "Tipo de promocion: " + super.getTipoDeAtraccionIncluidas()));		
		System.out.print(String.format("%-30s", "Costo: "  + super.getPrecio()));
		System.out.print(String.format("%-15s", "Duracion: " + super.getDuracion()));
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("                    LA PROMOCION INCLUYE LAS "+ this.atracionesPromocionadas.size() +" SIGUIENTES ATRACCIONES");
		System.out.println("---------------------------------------------------------------------------------------------");
		
		for(Sugerible sugerible: this.atracionesPromocionadas)
			sugerible.mostrar();

		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	public ArrayList<Atraccion> getAtracionesPromocionadas() {
		return this.atracionesPromocionadas;
	}



}
