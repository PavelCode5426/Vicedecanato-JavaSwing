package logica;


public class Estudiante extends Investigador{
	private int año;


	public Estudiante(String id, String nombre, String sexo, boolean graduado,
			int edad, int cantTotalArt, int año) {
		super(id, nombre, sexo, graduado, edad, cantTotalArt);
		this.año = año;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}
	
	public void Copy(Estudiante x)
	{
		this.año = x.año;
		this.cantTotalArt = x.cantTotalArt;
		this.id = x.id;
		this.nombre = x.nombre;
		this.sexo = x.sexo;
		this.graduado = x.graduado;
		this.edad = x.edad;
	}

}
