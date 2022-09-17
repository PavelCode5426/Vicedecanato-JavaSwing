package logica;

import java.util.ArrayList;


public class LineaInvestigacion {
	private String nombre;
	private Docente responsable;
	private ArrayList<TemaInvestigacion> temasInvestigacion;	

	public LineaInvestigacion(String nombre,Docente responsable){
		this.nombre=nombre;
		this.responsable=responsable;
		this.temasInvestigacion= new ArrayList<TemaInvestigacion>();
	}

	public LineaInvestigacion(String nombre,Docente responsable,ArrayList<TemaInvestigacion> temasInvestigacion){
		this.nombre=nombre;
		this.responsable=responsable;
		this.temasInvestigacion= temasInvestigacion;
	}


	public String getNombre() {
		return nombre;
	}

	public Docente getResponsable() {
		return responsable;
	}

	public void setResponsable(Docente responsable) {
		this.responsable = responsable;
	}

	public ArrayList<TemaInvestigacion> getTemasInvestigacion() {
		return temasInvestigacion;
	}

	public void setTemasInvestigacion(
			ArrayList<TemaInvestigacion> temasInvestigacion) {
		this.temasInvestigacion = temasInvestigacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public void addTema(TemaInvestigacion tema){
		//este metodo tengo pensado ponelo en boolean para 
		//comprobar o no si se a;adio correctamente el tema
		temasInvestigacion.add(tema);
	}
	public void removeTema(TemaInvestigacion tema){
		temasInvestigacion.remove(tema);
	}

	public void changeResponsable(Docente responsable){
		this.responsable=responsable;
	}

	public boolean containTema(String nombre)
	{
		boolean y=true;
		int x=0;
		while (x<temasInvestigacion.size()&&y) {
			if(temasInvestigacion.get(x++).equals(nombre))
				y=false;
		}
		return y;
	}
	
	public ArrayList<Persona> devolverInvestiga(){
		ArrayList<Persona> lista=new ArrayList<Persona>();

		for(int i=0; i<temasInvestigacion.size(); i++){
			lista.addAll(temasInvestigacion.get(i).devolverDocentes());
		}
		
		return lista;
	}
	public boolean estaEnLinea(String nombre){
		boolean encontrado=false;
		
		for(int i=0; i<temasInvestigacion.size() && !encontrado; i++){
			if(temasInvestigacion.get(i).estaEnTema(nombre))
				encontrado=true;			
		}
		return encontrado;
	}
	
	public int TotalArticulos()
	{
		int x=0;
		for(int t=0;temasInvestigacion.size()>t;t++)
			x+=temasInvestigacion.get(t).getArticulos().size();
		return x;
	}

}
