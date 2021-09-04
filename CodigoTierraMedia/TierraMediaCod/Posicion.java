package TierraMediaCod;

public class Posicion {
	private int x;
	private int y;
	
	public Posicion (int x, int y) {
		this.x = x;
		this.y = y;		
	}
	
	public double distanciaAotraPosicion(Posicion pos2) {
		double distEjeX = pos2.x - this.x;
		double distEjeY = pos2.y - this.y;
		return Math.sqrt( Math.pow(distEjeX, 2) + Math.pow(distEjeY, 2));
	}
}
