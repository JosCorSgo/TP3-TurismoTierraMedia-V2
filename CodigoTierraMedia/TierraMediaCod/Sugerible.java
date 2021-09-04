package TierraMediaCod;

public abstract class Sugerible {
	private String nombre;
	private double precio;
	private double duracion;
	private TipoDeAtraccion tipo;
	
	public Sugerible (String nombre, double precio, double duracion,TipoDeAtraccion tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.duracion = duracion;
		this.tipo = tipo;
	}
	
	public Sugerible(){

	}
	
	public boolean ofrecer() {
		return false;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public double getDuracion() {
		return this.duracion;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}


}
