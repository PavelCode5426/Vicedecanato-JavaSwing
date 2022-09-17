package logica;

import java.util.ArrayList;

public class Maestria {
	private String nombre;
	private ArrayList<String> cursosMaestria;
	private int cantidadMatriculados;
	private int cantidadGraduados;
	
	
	public Maestria(String nombre, ArrayList<String> cursosMaestria,
			ArrayList<String> matriculados,int cantidadMatriculados,int cantidadGraduados) {
		super();
		this.nombre = nombre;
		this.cursosMaestria = cursosMaestria;
		this.cantidadMatriculados=cantidadMatriculados;
		this.cantidadGraduados=cantidadGraduados;
		
	}

	public int getCantidadMatriculados() {
		return cantidadMatriculados;
	}

	public void setCantidadMatriculados(int cantidadMatriculados) {
		this.cantidadMatriculados = cantidadMatriculados;
	}

	public int getCantidadGraduados() {
		return cantidadGraduados;
	}
	public void aumentarCantMatri(){
		cantidadMatriculados++;
	}
	public void aumentarCantGrad(){
		cantidadGraduados++;
	}

	public void setCantidadGraduados(int cantidadGraduados) {
		this.cantidadGraduados = cantidadGraduados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getCursosMaestria() {
		return cursosMaestria;
	}

	public void setCursosMaestria(ArrayList<String> cursosMaestria) {
		this.cursosMaestria = cursosMaestria;
	}

	public int cantidadCursos(Persona persona){
		int total=0;
		if(persona instanceof Docente){
			for(int i=0; i<cursosMaestria.size(); i++){
				if(((Docente)persona).estaEnResultado(cursosMaestria.get(i)))
					total++;
		}	
		}
		else{
			if(persona instanceof Profesional)
				for(int i=0; i<cursosMaestria.size(); i++){
					if(((Profesional)persona).estaEnResultado(cursosMaestria.get(i)))
						total++;
			}	
		}
		return total;
	}
	
	
	
	
}
