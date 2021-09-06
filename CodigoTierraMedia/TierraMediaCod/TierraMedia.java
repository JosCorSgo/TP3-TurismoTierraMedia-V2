package TierraMediaCod;

import java.util.ArrayList;
import java.util.Collections;

public class TierraMedia {
	public static ArrayList<Promocion> promociones = new ArrayList<Promocion>();
	public static ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static ArrayList<Sugerible> sugeribles = new ArrayList<Sugerible>();
	public static ArrayList<Sugerible> sugeriblesDelUsuario = new ArrayList<Sugerible>();
	
	
	public static void main(String[] args) {
		atracciones = obtenerAtraccionesAlmacenados();
		usuarios =  obtenerUsuariosAlmacenados();
		promociones = obtenerPromocionesAlmacenadas();
		sugeribles = obtenerSugeribles();
		Collections.sort(sugeribles);
		 
		//sugeribles.forEach(s -> System.out.println(s.getNombre() + "  " + s.getTipoSugerible()+ "  " + s.getPrecio()+ "  " + s.getDuracion()));
		//imprimirAtraccionesPorConsola();
		//imprimirUsuariosPorConsola();
		//imprimirPromocionesPorConsola();
		
		//for (Usuario usuario: usuarios) {
		
		int i = 1;
		sugeriblesDelUsuario =filtrarPreferidasYnoPreferidas(usuarios.get(i));
		ofertadorDeAtracciones(usuarios.get(i));


	}

	
	
	//  -----------------------------  metodos ----------------------------------------------------
	
	private static ArrayList<Sugerible> filtrarPreferidasYnoPreferidas(Usuario usuario) {
		ArrayList<Sugerible> preferidas = new ArrayList<Sugerible>();
		ArrayList<Sugerible> noPreferidas = new ArrayList<Sugerible>();
		ArrayList<Sugerible> arrayAuxiliar = new ArrayList<Sugerible>();
		for(Sugerible sugerible : sugeribles) {
			if (puedeComprar(sugerible, usuario)) {
				if (sugerible.getTipoDeAtraccionIncluidas() == usuario.getPreferencia()) {
					preferidas.add(sugerible);
				} else {
					noPreferidas.add(sugerible);
				}
			}
		}
		arrayAuxiliar.addAll(preferidas);
		arrayAuxiliar.addAll(noPreferidas);
		return arrayAuxiliar;
	}

 	private static void ofertadorDeAtracciones(Usuario usuario) {
 		Itinerario itinerario = new Itinerario(usuario.getNombre());
		encabezadoDelOfertador(usuario);
		imprimirSugeriblesDelUsuario();
		boolean itinerarioCreado = false;
		for (Sugerible sugerible: sugeriblesDelUsuario) {
			if (sugerible.ofrecer()) {
				itinerarioCreado = true;
				sugerible.agregarmeAlItinerario(itinerario);
			}
		}

		if (itinerarioCreado) {
			itinerario.imprimirElItinerario();
		} else {
			itinerario = null;
		}
	}



	private static void encabezadoDelOfertador(Usuario usuario) {
		for (int i=1; i<20; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("        OFERTADOR DE ATRACCIONES PARA EL USUARIO: "+ usuario.getNombre() + "   PREFERENCIA: "+ usuario.getPreferencia());
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println(" DINERO DISPONIBLE: "+ usuario.getDinero() + "       TIEMPO DISPONIBLE: " + usuario.getTiempo());
		System.out.println("---------------------------------------------------------------------------------------------");
	}

	private static boolean puedeComprar(Sugerible sugerible, Usuario usuario) {
		return usuario.getDinero() >= sugerible.getPrecio()
				&& usuario.getTiempo() >= sugerible.getDuracion()
				&& !usuario.comproSugerible(sugerible)
				&& sugerible.tieneCupo();
	}
	
	private static void imprimirSugeriblesDelUsuario() {
		System.out.print(String.format("%-30s", "Nombre de la atraccion"));
		System.out.print(String.format("%-18s", "Categoria"));
		System.out.print(String.format("%-10s", "Tipo"));
		System.out.print(String.format("%-10s", "Costo"));
		System.out.print(String.format("%-15s", "Duracion"));
		System.out.println(String.format("%-10s", "Cupo"));
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Sugerible sugerible:sugeriblesDelUsuario) {
			System.out.println("");
			System.out.print(String.format("%-30s", sugerible.getNombre()));
			System.out.print(String.format("%-15s", sugerible.getTipoSugerible()));
			System.out.print(String.format("%-15s", sugerible.getTipoDeAtraccionIncluidas()));
			System.out.print(String.format("%-10s", sugerible.getPrecio()));
			System.out.print(String.format("%-14s", sugerible.getDuracion()));
			if (sugerible.getTipoSugerible() == TipoDeSugerible.ATRACCION) {
				System.out.print(String.format("%-10s", sugerible.getCupo() ));
			}
			else {
				System.out.print(String.format("%-10s", "hay cupo"));
			}
		}
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("               POR FAVOR COMIENCE A CONFIRMAR O NO LAS ATRACCIONES SUGERIDAS                 ");
		System.out.println("---------------------------------------------------------------------------------------------");
	}

	private static void imprimirPromocionesPorConsola() {
		for (int i=1; i<20; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("                                  LISTADO DE PROMOCIONES                                    -");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(Promocion promocion: promociones) {
			promocion.mostrarEncabezado();
			promocion.mostrar();		
		}
	}

	private static void imprimirUsuariosPorConsola() {
		for (int i=1; i<20; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("                                  LISTADO DE USUARIOS                                       -");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(Usuario usuario: usuarios) 
			usuario.mostrarElUsuario();
	}

	private static void imprimirAtraccionesPorConsola() {
		for (int i=1; i<20; i++)
			System.out.println("-");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("-                               LISTADO DE ATRACCIONES                                      -");
		System.out.println("---------------------------------------------------------------------------------------------");		
		for(Atraccion atraccion: atracciones) 
			atraccion.mostrar();

	}

	private static ArrayList<Sugerible> obtenerSugeribles() {
		sugeribles.addAll(atracciones);
		sugeribles.addAll(promociones);
		return sugeribles;
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
		TierraMedia.usuarios.add ( new Usuario ("Gandalf", TipoDeAtraccion.PAISAJES , 100, 100, new Posicion(1,2)));
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
		TierraMedia.promociones.add ( new PromocionPorcentual("Pack aventura", 22, 7, auxAtracciones1, 20, TipoDeAtraccion.AVENTURA));
		//-------------------------------------------------------- nombre,  precio,  duracion,  tipo,  atracciones
		auxAtracciones2.add(TierraMedia.atracciones.get(2)); auxAtracciones2.add(TierraMedia.atracciones.get(5)) ;
		TierraMedia.promociones.add (new Promocion("Pack degustacion", 36, 7.5 , TipoDeAtraccion.DEGUSTACION, auxAtracciones2));
		//---------------------------------------------------------nombre,  precio, duracion, atracciones, atraccionBonificada, tipo
		auxAtracciones3.add(TierraMedia.atracciones.get(1)); auxAtracciones3.add(TierraMedia.atracciones.get(4));
		Atraccion bonificada = TierraMedia.atracciones.get(6);
		TierraMedia.promociones.add ( new PromocionAxB ("Pack paisajes ", 10, 4.5, auxAtracciones3 ,bonificada,TipoDeAtraccion.PAISAJES ));
		return promociones;
	}
	

}
