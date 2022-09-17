package logica;

import java.util.ArrayList;

public class Libro extends Publicacion{
private String titulo;
private ArrayList<String> autores;
private int edicion;
private String editorial;
private String isbn;


/**
 * 
 * A CONTINUACION LOS CONTRUCCTORES Y LOS GETTER Y SETTERS
 * 
 */

public String getTitulo() {
	return titulo;
}
public Libro(String titulo, ArrayList<String> autores, int edicion,
		String editorial, String isbn) {
	super();
	this.titulo = titulo;
	this.autores = autores;
	this.edicion = edicion;
	this.editorial = editorial;
	this.isbn = isbn;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public int getEdicion() {
	return edicion;
}
public void setEdicion(int edicion) {
	this.edicion = edicion;
}
public String getEditorial() {
	return editorial;
}
public void setEditorial(String editorial) {
	this.editorial = editorial;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}


















}
