package logica;

public class Evento extends Publicacion{
	private int año;
	private String isbn;
	private String nombre;
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Evento(int año, String isbn, String nombre) {
		super();
		this.año = año;
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
