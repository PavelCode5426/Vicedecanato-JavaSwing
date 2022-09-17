package logica;


public class Estudiante extends Investigador{
	private int a�o;


	public Estudiante(String id, String nombre, String sexo, boolean graduado,
			int edad, int cantTotalArt, int a�o) {
		super(id, nombre, sexo, graduado, edad, cantTotalArt);
		this.a�o = a�o;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	
	public void Copy(Estudiante x)
	{
		this.a�o = x.a�o;
		this.cantTotalArt = x.cantTotalArt;
		this.id = x.id;
		this.nombre = x.nombre;
		this.sexo = x.sexo;
		this.graduado = x.graduado;
		this.edad = x.edad;
	}

}
