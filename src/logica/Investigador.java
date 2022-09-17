package logica;


public abstract class Investigador extends Persona{
	protected int cantTotalArt;

	public Investigador(String id, String nombre, String sexo,
			boolean graduado, int edad, int cantTotalArt) {
		super(id, nombre, sexo, graduado, edad);
		this.cantTotalArt = cantTotalArt;
	}

	public int getCantTotalArt() {
		return cantTotalArt;
	}

	public void setCantTotalArt(int cantTotalArt) {
		this.cantTotalArt = cantTotalArt;
	}



}
