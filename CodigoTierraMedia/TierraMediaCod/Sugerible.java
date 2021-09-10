package TierraMediaCod;

import java.util.ArrayList;

public abstract class Sugerible implements Comparable<Sugerible> {
	private String nombre;
	private int precio; //precio en monedas
	private double duracion;
	private TipoDeSugerible tipoSugerible;
	private TipoDeAtraccion tipoDeAtraccionIncluidas;
	

	public Sugerible (TipoDeSugerible tipoSugerible, String nombre, int precio, double duracion, TipoDeAtraccion tipoDeAtraccionIncluidas) {
		this.nombre = nombre;
		this.precio = precio;
		this.duracion = duracion;
		this.tipoSugerible = tipoSugerible;
		this.tipoDeAtraccionIncluidas = tipoDeAtraccionIncluidas;
	}
	
	public Sugerible(){	}
	
	// ---------------------  METODOS -------------------------------------
	
	public abstract boolean ofrecer(); 
	
	public abstract void agregarmeAlItinerario(Itinerario itinerario);
	
	public abstract ArrayList<Atraccion> atraccionesQueContiene();
	
	protected abstract void mostrar();

	protected abstract boolean tieneCupo();
	
	public int getCupo() {
		return 0;
	}
	
	// ----------------------- GETTERS Y SETTERS ------------------------------
		
	public String getNombre() {
		return this.nombre;
	}

	public int getPrecio() {
		return this.precio;
	}

	public double getDuracion() {
		return this.duracion;
	}

	public TipoDeSugerible getTipoSugerible() {
		return this.tipoSugerible;
	}
	
	public TipoDeAtraccion getTipoDeAtraccionIncluidas() {
		return this.tipoDeAtraccionIncluidas;
	}
	

	@Override
	public int compareTo(Sugerible o) {
		int auxiliar = (this.tipoSugerible.ordinal() - o.tipoSugerible.ordinal()) * -1;
		if (auxiliar == 0) {
			auxiliar = this.tipoSugerible.compareTo(o.getTipoSugerible());
			if (auxiliar == 0) {
				auxiliar = this.precio - o.getPrecio();
				if (auxiliar == 0)
					auxiliar = (int)this.duracion - (int)o.duracion;
			}	
		}	
		return auxiliar * -1;
			
	}






}
