package TierraMediaCod;

import java.util.Scanner;

public class Atraccion extends Sugerible{
	private int cupo;
	private Posicion posicion;
	
	public Atraccion (String nombre, int cupo, double precio, double duracion,TipoDeAtraccion tipo, Posicion posicion ) {
		super(nombre, precio, duracion, tipo);
		this.cupo = cupo;
		this.posicion= posicion;
	}
	

	public boolean ofrecer(){
		mostrarLaAtraccion();
		return pedirConfirmacion();
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

	protected void mostrarLaAtraccion() {
		for (int i=1; i<2; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.print(String.format("%-50s", "Nombre de la atraccion: " + super.getNombre()));
		System.out.println(String.format("%-10s", "Tipo: " + super.getTipo()));
		System.out.print(String.format("%-15s", "Costo: $"  + super.getPrecio()));
		System.out.print(String.format("%-20s", "Duracion: " + super.getDuracion() + " hs."));
		System.out.print(String.format("%-15s", "Cupo: " + this.cupo ));
		System.out.print(String.format("%-25s", "Posicion: " + this.posicion));
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------------------------");
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
	
	public boolean hayCupo() {
		return cupo > 0;
	}
	
	
}
