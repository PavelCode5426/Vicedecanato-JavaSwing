package logica;

public class Revista extends Publicacion{
	private String nombre;
	private int volumen;
	private int año;
	private String editorial;
	private int pagina;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVolumen() {
		return volumen;
	}
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
	public int getAño() {
		return año;
	}
	public Revista(String nombre, int volumen, int año, String editorial,
			int pagina) {
		super();
		this.nombre = nombre;
		this.volumen = volumen;
		this.año = año;
		this.editorial = editorial;
		this.pagina = pagina;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
}
