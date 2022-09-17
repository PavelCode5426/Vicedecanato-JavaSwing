package auxiliar;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.ArrayList;

import logica.Evento;
import logica.Libro;
import logica.Revista;

public class BasePublicaciones {
	private ArrayList<Libro>  baseLibro;
	private ArrayList<Evento> baseEvento;
	private ArrayList<Revista> baseRevista;
	private static BasePublicaciones Instance;
	/**
	 * 
	 * A CONTINUACION SE CREAN LOS CONTRUCTORES Y LOS GETTERS Y SETTERS
	 * 
	 */
	public static BasePublicaciones getInstance()
	{
		if(Instance==null)
			Instance=new BasePublicaciones();
		return Instance;
	}

	private BasePublicaciones() {
		super();
		this.baseLibro = new ArrayList<Libro>();
		this.baseEvento = new ArrayList<Evento>();
		this.baseRevista = new ArrayList<Revista>();
	}
	public ArrayList<Libro> getBaseLibro() {
		return baseLibro;
	}
	public void setBaseLibro(ArrayList<Libro> baseLibro) {
		this.baseLibro = baseLibro;
	}
	public ArrayList<Evento> getBaseEvento() {
		return baseEvento;
	}
	public void setBaseEvento(ArrayList<Evento> baseEvento) {
		this.baseEvento = baseEvento;
	}
	public ArrayList<Revista> getBaseRevista() {
		return baseRevista;
	}
	public void setBaseRevista(ArrayList<Revista> baseRevista) {
		this.baseRevista = baseRevista;
	}

	/**
	 * 
	 * A CONTINUACION LOS METODOS CREADOS POR MI Y SAYDEL
	 * 
	 */

	public void añadirLIBRO(Libro x){
		baseLibro.add(x);
	}

	private boolean containPublicacion(int numero,String nombre)
	{
		boolean y=true;
		switch (numero) {
		case 0:
for(int x=0;x<baseLibro.size()&&y;x++)
	if(baseLibro.get(x).getTitulo().equals(nombre))
		y=false;
			break;
		case 1:

			break;

		default:
			break;
		}
		return y;
	}

}
