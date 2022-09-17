package logica;

import java.util.ArrayList;

public class TemaInvestigacion {
	private String nombre;
	private Docente responsable;
	private ArrayList<Investigador> investigadores;
	private ArrayList<Articulo> articulos;

	
	public TemaInvestigacion(String nombre,ArrayList<Investigador> investigadores,ArrayList<Articulo> articulos,Docente responsable){
		this.nombre=nombre;
		this.articulos=articulos;
		this.responsable=responsable;
		this.investigadores= investigadores;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TemaInvestigacion(String nombre)
	{
		this.nombre=nombre;
		this.articulos= new ArrayList<Articulo>();
		this.investigadores= new ArrayList<Investigador>();
	}
	
	public ArrayList<Investigador> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(ArrayList<Investigador> investigadores) {
		this.investigadores = investigadores;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}
	public Docente getResponsable() {
		return responsable;
	}

	public void setResponsable(Docente responsable) {
		this.responsable = responsable;
	}

	/**
	 * 
	 * METODOS DE LA CLASE
	 */
	public void addInvestigador(Investigador investigador){
		//RECORDAR COMPROBAR SI EL INVESTIGADOR EXTISTE EN LA LISTA
		this.investigadores.add(investigador);
	}
	public void addArticulo(Articulo articulo){
		//RECORDAR SI EL ARTICULO EXISTE EN LA LISTA
		this.articulos.add(articulo);
	}
	public void removeInvestigador(Investigador investigador){
		this.investigadores.add(investigador);
	}
	public void removeArticulo(Articulo articulo){
		this.articulos.add(articulo);
	}
	
	public ArrayList<Persona> devolverDocentes(){
		ArrayList<Persona> docentes= new ArrayList<Persona>();
		
		for(int i=0; i<investigadores.size(); i++){
			if(investigadores.get(i)instanceof Docente)
				docentes.add(investigadores.get(i));
		}
		return docentes;
	}
	public boolean estaEnTema(String nombre){
		boolean encontrado=false;
		
		if(investigadores.contains(nombre))
			encontrado=true;
		
		return encontrado;
	}
	
	
}
