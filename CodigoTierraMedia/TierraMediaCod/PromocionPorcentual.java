package TierraMediaCod;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {
	private double PorcentajeDeDescuento;
	
	public PromocionPorcentual (String nombre, int precio, double duracion, ArrayList<Atraccion> atracciones, double PorcentajeDeDescuento, TipoDeAtraccion tipo) {
		super(nombre, precio, duracion, tipo, atracciones);
		this.PorcentajeDeDescuento = PorcentajeDeDescuento;
	}
	
	// ---------------------- METODOS ---------------------------------------------
	
	public boolean ofrecer(){
		mostrarEncabezado();
		super.mostrar();
		return super.pedirConfirmacion();
	}
	
	public void agregarmeAlItinerario(Itinerario itinerario){
		super.agregarmeAlItinerario(itinerario);
		System.out.println("Se agrego una Promo porcentual a su itinerario");
	}

	public void mostrarEncabezado() {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-                 PROMOCION CON DESCUENTO PORCENTUAL DEL: %"+ this.PorcentajeDeDescuento );
		System.out.println("---------------------------------------------------------------------------------------------");

	}
	
	public boolean tieneCupo() {
		return super.tieneCupo();

	}
}
