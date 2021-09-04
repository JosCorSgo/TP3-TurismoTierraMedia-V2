package TierraMediaCod;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {
	private double PorcentajeDeDescuento;
	
	public PromocionPorcentual (String nombre, double precio, double duracion, ArrayList<Atraccion> atracciones, double PorcentajeDeDescuento, TipoDeAtraccion tipo) {
		super(nombre, precio, duracion, tipo, atracciones);
		this.PorcentajeDeDescuento = PorcentajeDeDescuento;
	}
	
	public boolean ofrecer(){
		mostrarEncabezado();
		super.mostrarLaPromocion();
		return super.pedirConfirmacion();
	}

	public void mostrarEncabezado() {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-                 PROMOCION CON DESCUENTO PORCENTUAL DEL: %"+ this.PorcentajeDeDescuento );
		System.out.println("---------------------------------------------------------------------------------------------");

	}
}
