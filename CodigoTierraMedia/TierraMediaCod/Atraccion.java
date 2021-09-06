package TierraMediaCod;

import java.util.ArrayList;
import java.util.Scanner;

public class Atraccion extends Sugerible{
	private int cupo;
	private Posicion posicion;
	private TipoDeAtraccion tipoAtraccion;
	
	public Atraccion (String nombre, int cupo, int precio, double duracion,TipoDeAtraccion tipo, Posicion posicion ) {
		super(TipoDeSugerible.ATRACCION, nombre, precio, duracion, tipo);
		this.cupo = cupo;
		this.posicion= posicion;
		this.tipoAtraccion = tipo;
	}
	

	public boolean ofrecer(){
		mostrar();
		return pedirConfirmacion();
	}

	public void agregarmeAlItinerario(Itinerario itinerario){
		itinerario.setCosto(itinerario.getCosto() + super.getPrecio());
		itinerario.setTiempoNecesario(itinerario.getTiempoNecesario() + super.getDuracion());
		itinerario.agregarAtraccionAlItinerario(this);	
		System.out.println("Se agrego una Atraccion a su itinerario");
	}
	
	public ArrayList<Atraccion> atraccionesQueContiene(){
		ArrayList <Atraccion> ALauxiliar = new ArrayList <Atraccion>();
		ALauxiliar.add(this);
		return ALauxiliar;
	}
	public int getCupo() {
		return this.cupo;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void restarUnCupo() {
		this.cupo -= 1;
	}
	
	public boolean tieneCupo() {
		return this.cupo > 0;
	}
	
	protected void mostrar() {
		for (int i=1; i<2; i++)
			System.out.println("-");
		//System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.print(String.format("%-50s", "Nombre de la atraccion: " + super.getNombre()));
		System.out.println(String.format("%-10s", "Tipo: " + this.tipoAtraccion));
		System.out.print(String.format("%-15s", "Costo: $"  + super.getPrecio()));
		System.out.print(String.format("%-20s", "Duracion: " + super.getDuracion() + " hs."));
		System.out.print(String.format("%-15s", "Cupo: " + this.cupo ));
		System.out.print(String.format("%-25s", "Posicion: " + this.posicion));
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	private boolean pedirConfirmacion() {
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
}
