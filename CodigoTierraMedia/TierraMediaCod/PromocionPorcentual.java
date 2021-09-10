package TierraMediaCod;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		//String nombre, int precio, double duracion, ArrayList<Atraccion> atracciones, double PorcentajeDeDescuento, TipoDeAtraccion tipo
		String cadena = super.getNombre() + "," +
						super.getPrecio()  + "," +
						super.getDuracion()  + "," ;
						for(Atraccion atraccion: super.getAtracionesPromocionadas())
							cadena += atraccion.toString()+ ",";
				cadena += this.PorcentajeDeDescuento + "," + super.getTipoDeAtraccionIncluidas();
		return cadena;
	}


	
	
	
	
}
