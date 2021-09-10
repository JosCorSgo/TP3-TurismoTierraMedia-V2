package TierraMediaCod;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PromocionAxB extends Promocion{
	private Atraccion atraccionBonificada;
	
	public PromocionAxB(String nombre, int precio, double duracion, ArrayList<Atraccion> atracciones,Atraccion atraccionBonificada, TipoDeAtraccion tipo) {
		super(nombre, precio, duracion, tipo, atracciones);
		this.atraccionBonificada = atraccionBonificada;
	}
	
	// ---------------------- METODOS ---------------------------------------------

	public boolean ofrecer(){
		mostrarEncabezado();
		super.mostrar();
		this.atraccionBonificada.mostrar();
		return super.pedirConfirmacion();
	}
	
	public void agregarmeAlItinerario(Itinerario itinerario){
		super.agregarmeAlItinerario(itinerario);
		itinerario.agregarAtraccionAlItinerario(atraccionBonificada);
		itinerario.setTiempoNecesario(itinerario.getTiempoNecesario() + super.getDuracion());
		System.out.println("Se agrego una Promo AXB a su itinerario");
	}

	
	public void mostrarEncabezado() {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-          ESTA PROMOCION BONIFICA LA ATRACCION: "+ this.atraccionBonificada.getNombre() );
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	public boolean tieneCupo() {
		boolean aux1 = super.tieneCupo();
		boolean aux2 = this.atraccionBonificada.getCupo() <= 0;
		return aux1 && aux2;
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
		//String nombre, int precio, double duracion, ArrayList<Atraccion> atracciones,Atraccion atraccionBonificada, TipoDeAtraccion tipo 
		String cadena = super.getNombre() + "," +
						super.getPrecio()  + "," +
						super.getDuracion()  + "," ;
						for(Atraccion atraccion: super.getAtracionesPromocionadas())
							cadena += atraccion.toString()+ ",";
				cadena += this.atraccionBonificada + "," + super.getTipoDeAtraccionIncluidas();
		return cadena;
	}


	
	
}
