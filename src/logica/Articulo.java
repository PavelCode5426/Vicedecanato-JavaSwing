package logica;

import java.util.ArrayList;

public class Articulo {
private String titulo;
private ArrayList<Investigador> autores;
private Publicacion publicacion;

public Publicacion getPublicacion() {
	return publicacion;
}

public void setPublicacion(Publicacion publicacion) {
	this.publicacion = publicacion;
}



public Articulo(String titulo, Publicacion publicacion,
		ArrayList<Investigador> autores) {
	super();
	this.titulo = titulo;
	this.autores = autores;
	this.publicacion = publicacion;
}

public ArrayList<Investigador> getAutores() {
	return autores;
}

public void setAutores(ArrayList<Investigador> autores) {
	this.autores = autores;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

}
