package logica;

import java.util.ArrayList;

public class CursoPosgrado {
	private String nombre;
	private String tema;
	private String objetivos;
	private Docente profesor;
	private int creditos;
	private ArrayList<Persona> personasCurso;
	private int capacidadMax;
	
	

	public CursoPosgrado(String nombre, String tema, String objetivos,
			Docente profesor, int creditos, ArrayList<Persona> personasCurso,int capacidadMax) {
		
		this.nombre = nombre;
		this.tema = tema;
		this.objetivos = objetivos;
		this.profesor = profesor;
		this.creditos = creditos;
		this.personasCurso = personasCurso;
		this.capacidadMax=capacidadMax;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public Docente getProfesor() {
		return profesor;
	}

	public void setProfesor(Docente profesor) {
		this.profesor = profesor;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public ArrayList<Persona> getPersonasCurso() {
		return personasCurso;
	}

	public void setPersonasCurso(ArrayList<Persona> personasCurso) {
		this.personasCurso = personasCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean verificarEspacio(){
		boolean hayCapacidad=false;
		if(personasCurso.size()>=capacidadMax)
			hayCapacidad=true;
		
		return hayCapacidad;
	}
	public boolean personaEnCurso(String nombrePersona){
		boolean esta=false;
		for(int i=0;i<personasCurso.size() && !esta;i++){
			if(personasCurso.get(i).getNombre().equals(nombrePersona)){
				esta=true;
			}
		}
	return esta;	
	}
	public void removerDelCurso(String nombrePersona){
		for(int i=0; i<personasCurso.size(); i++){
			if(personasCurso.get(i).getNombre().equals(nombrePersona))
				personasCurso.remove(i);
		}
	}
	
	public void vaciarMatricula(){
			personasCurso.clear();
	}
	public void addPersonasCurso(Persona e){
		personasCurso.add(e);
	}
	
	

	
}
