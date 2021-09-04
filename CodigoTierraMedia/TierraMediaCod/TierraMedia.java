package TierraMediaCod;

import java.util.ArrayList;

public class TierraMedia {
	public static ArrayList<Promocion> promociones = new ArrayList<>();
	public static ArrayList<Atraccion> atracciones = new ArrayList<>();
	public static ArrayList<Usuario> usuarios = new ArrayList<>();
	public static ArrayList<Sugerible> sugeribles = new ArrayList<>();

	public static void main(String[] args) {
		atracciones = obtenerAtraccionesAlmacenados();
		usuarios =  obtenerUsuariosAlmacenados();
		promociones = obtenerPromocionesAlmacenadas();
		imprimirAtraccionesPorConsola();
		imprimirUsuariosPorConsola();
		imprimirPromocionesPorConsola();
		/*int i=1;
		for (Usuario usuario: usuarios)
			for (Atraccion atraccion: atracciones) {
				if (atraccion.ofrecer()){
					usuario.agregarAtraccionAlItinerario(atraccion);
				}
			usuario.imprimirElItinerarioDiario();
			}
		*/


	}
	
	private static void imprimirPromocionesPorConsola() {
		for (int i=1; i<3; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("                                  LISTADO DE PROMOCIONES                                    -");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(Promocion promocion: promociones) {
			promocion.mostrarEncabezado();
			promocion.mostrarLaPromocion();		
		}
	}

	private static void imprimirUsuariosPorConsola() {
		for (int i=1; i<3; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("                                  LISTADO DE USUARIOS                                       -");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(Usuario usuario: usuarios) 
			usuario.mostrarElUsuario();
	}

	private static void imprimirAtraccionesPorConsola() {
		for (int i=1; i<3; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-                               LISTADO DE ATRACCIONES                                      -");
		System.out.println("---------------------------------------------------------------------------------------------");		
		for(Atraccion atraccion: atracciones) 
			atraccion.mostrarLaAtraccion();

	}
	
	private static ArrayList<Atraccion> obtenerAtraccionesAlmacenados() {
		//------------------------------------------   nombre,  cupo,  precio,   duracion,  tipo,   posicion 
		TierraMedia.atracciones.add ( new Atraccion ("Moria", 6 , 10 , 2, TipoDeAtraccion.AVENTURA, new Posicion(1,2) ));
		TierraMedia.atracciones.add ( new Atraccion ("Minas Tirith", 25 , 5 , 2.5, TipoDeAtraccion.PAISAJES, new Posicion(1,2)));
		TierraMedia.atracciones.add ( new Atraccion ("La Comarca", 150 , 3 , 6.5, TipoDeAtraccion.DEGUSTACION, new Posicion(1,2)));
		TierraMedia.atracciones.add ( new Atraccion ("Mordor", 4 , 25 , 3, TipoDeAtraccion.AVENTURA, new Posicion(1,2)));
		TierraMedia.atracciones.add ( new Atraccion ("Abismo de Helm", 15 , 5 , 2, TipoDeAtraccion.PAISAJES, new Posicion(1,2)));
		TierraMedia.atracciones.add ( new Atraccion ("Lothlorien", 30 , 35 , 1, TipoDeAtraccion.DEGUSTACION, new Posicion(1,2)));
		TierraMedia.atracciones.add ( new Atraccion ("Eredor", 32 , 12 , 3, TipoDeAtraccion.PAISAJES, new Posicion(1,2)));
		TierraMedia.atracciones.add ( new Atraccion ("Bosque Negro", 12 , 3 , 4, TipoDeAtraccion.AVENTURA, new Posicion(1,2)));
		return TierraMedia.atracciones;
	}

	private static ArrayList<Usuario> obtenerUsuariosAlmacenados(){
		// -----------------------------------  nombre   ,  tipo  ,        dinero , tiempo , posicion
		TierraMedia.usuarios.add ( new Usuario ("Eowyn", TipoDeAtraccion.AVENTURA, 10, 8, new Posicion(1,2)));
		TierraMedia.usuarios.add ( new Usuario ("Gandalf", TipoDeAtraccion.PAISAJES , 100, 5, new Posicion(1,2)));
		TierraMedia.usuarios.add ( new Usuario ("Sam", TipoDeAtraccion.DEGUSTACION, 36, 8, new Posicion(1,2)));
		TierraMedia.usuarios.add ( new Usuario ("Galadriel", TipoDeAtraccion.PAISAJES, 10, 8, new Posicion(1,2)));
		TierraMedia.usuarios.add ( new Usuario ("Jose", TipoDeAtraccion.AVENTURA, 40, 10, new Posicion(1,2)));
		TierraMedia.usuarios.add ( new Usuario ("Maria", TipoDeAtraccion.PAISAJES, 25, 10, new Posicion(1,2)));
		TierraMedia.usuarios.add ( new Usuario ("Marta", TipoDeAtraccion.AVENTURA, 80, 22, new Posicion(1,2)));
		return usuarios;
	}
	
	private static ArrayList<Promocion> obtenerPromocionesAlmacenadas() {
		ArrayList <Atraccion> auxAtracciones1 = new ArrayList<Atraccion>();
		ArrayList <Atraccion> auxAtracciones2 = new ArrayList<Atraccion>();
		ArrayList <Atraccion> auxAtracciones3 = new ArrayList<Atraccion>();
		//-------------------------------------------------------- nombre,  precio,  duracion,  atracciones,  Porcentaje,  tipo
		auxAtracciones1.add(TierraMedia.atracciones.get(7)); auxAtracciones1.add(TierraMedia.atracciones.get(3)) ;
		TierraMedia.promociones.add ( new PromocionPorcentual("Pack aventura", 22.4, 7, auxAtracciones1, 20, TipoDeAtraccion.AVENTURA));
		//-------------------------------------------------------- nombre,  precio,  duracion,  tipo,  atracciones
		auxAtracciones2.add(TierraMedia.atracciones.get(2)); auxAtracciones2.add(TierraMedia.atracciones.get(5)) ;
		TierraMedia.promociones.add (new Promocion("Pack degustacion", 36, 7.5 , TipoDeAtraccion.DEGUSTACION, auxAtracciones2));
		//---------------------------------------------------------nombre,  precio, duracion, atracciones, atraccionBonificada, tipo
		auxAtracciones3.add(TierraMedia.atracciones.get(1)); auxAtracciones3.add(TierraMedia.atracciones.get(4));
		Atraccion bonificada = TierraMedia.atracciones.get(6);
		TierraMedia.promociones.add ( new PromocionAxB ("Promo 3", 10, 4.5, auxAtracciones3 ,bonificada,TipoDeAtraccion.PAISAJES ));
			
		return promociones;
	}
	

}
