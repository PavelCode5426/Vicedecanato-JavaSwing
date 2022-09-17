package logica;

public class Evento extends Publicacion{
	private int a�o;
	private String isbn;
	private String nombre;
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Evento(int a�o, String isbn, String nombre) {
		super();
		this.a�o = a�o;
		this.isbn = isbn;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
