package logica;

import java.util.ArrayList;

import auxiliar.Matricula;
import auxiliar.ResultadoCurso;

public class Profesional extends Persona{
	private String centroTrabajo;
	private String profesion;
	private ArrayList<ResultadoCurso> resultadoCursos;
	private Matricula Matricula;


	public Profesional(String id, String nombre, String sexo, boolean graduado,
			int edad, String centroTrabajo, String profesion,
			ArrayList<ResultadoCurso> resultadoCursos,
			Matricula matricula) {
		super(id, nombre, sexo, graduado, edad);
		this.centroTrabajo = centroTrabajo;
		this.profesion = profesion;
		this.resultadoCursos = resultadoCursos;
		Matricula = matricula;
	}



	public Matricula getMatricula() {
		return Matricula;
	}


	public void setMatricula(Matricula Matricula) {
		this.Matricula = Matricula;
	}


	public String getProfesion() {
		return profesion;
	}


	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}






	public String getCentroTrabajo() {
		return centroTrabajo;
	}


	public void setCentroTrabajo(String centroTrabajo) {
		this.centroTrabajo = centroTrabajo;
	}


	public ArrayList<ResultadoCurso> getResultadoCursos() {
		return resultadoCursos;
	}


	public void setResultadoCursos(ArrayList<ResultadoCurso> resultadoCursos) {
		this.resultadoCursos = resultadoCursos;
	}
	////////////////////////
	///////Aqui comence a agregar metodos

	public boolean estaEnResultado(String nombreCurso){
		boolean esta=false;

		for(int i=0; i<resultadoCursos.size() && !esta; i++){
			if(resultadoCursos.get(i).getnombreCurso().equals(nombreCurso))
				esta=true;
		}
		return esta;
	}



	public void Copy(Profesional x)
	{
		this.id = x.id;
		this.nombre = x.nombre;
		this.sexo = x.sexo;
		this.graduado = x.graduado;
		this.edad = x.edad;
		this.centroTrabajo = x.centroTrabajo;
		this.profesion = x.profesion;
		this.resultadoCursos = x.resultadoCursos;
		Matricula = x.Matricula;
	}


}
