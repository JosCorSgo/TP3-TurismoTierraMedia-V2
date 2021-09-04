package TierraMediaCod;

import java.util.ArrayList;
import java.util.Scanner;

public class PromocionAxB extends Promocion{
	private Atraccion atraccionBonificada;
	
	public PromocionAxB(String nombre, double precio, double duracion, ArrayList<Atraccion> atracciones,Atraccion atraccionBonificada, TipoDeAtraccion tipo) {
		super(nombre, precio, duracion, tipo, atracciones);
		this.atraccionBonificada = atraccionBonificada;
	}

	public boolean ofrecer(){
		mostrarEncabezado();
		super.mostrarLaPromocion();
		this.atraccionBonificada.mostrarLaAtraccion();
		return super.pedirConfirmacion();
	}

	public void mostrarEncabezado() {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-          ESTA PROMOCION BONIFICA LA ATRACCION: "+ this.atraccionBonificada.getNombre() );
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	
	
	
	
}
