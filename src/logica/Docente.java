package logica;

import java.util.ArrayList;

import auxiliar.Matricula;
import auxiliar.Matricula;
import auxiliar.ResultadoCurso;

public class Docente extends Investigador{
	private ArrayList<ResultadoCurso> resultadoCursos;
	private ArrayList<String> cursosDa;
	private String categoriaD;
	private String CategoriaC;
	private String facultad;
	private Matricula Matricula;
	private String profesion;


	public ArrayList<String> getCursosDa() {
		return cursosDa;
	}
	public void setCursosDa(ArrayList<String> cursosDa) {
		this.cursosDa = cursosDa;
	}
	public Docente(String id, String nombre, String sexo, boolean graduado,
			int edad, int cantTotalArt,
			ArrayList<ResultadoCurso> resultadoCursos,
			ArrayList<String> cursosDa, String categoriaD, String categoriaC,
			String facultad, Matricula Matricula, String profesion) {
		super(id, nombre, sexo, graduado, edad, cantTotalArt);
		this.resultadoCursos = resultadoCursos;
		this.cursosDa = cursosDa;
		this.categoriaD = categoriaD;
		CategoriaC = categoriaC;
		this.facultad = facultad;
		this.Matricula = Matricula;
		this.profesion = profesion;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public ArrayList<ResultadoCurso> getResultadoCursos() {
		return resultadoCursos;
	}
	public void setResultadoCursos(ArrayList<ResultadoCurso> resultadoCursos) {
		this.resultadoCursos = resultadoCursos;
	}
	public ArrayList<String> getcursosDa() {
		return cursosDa;
	}
	public void setcursosDa(ArrayList<String> cursosDa) {
		this.cursosDa = cursosDa;
	}
	public String getCategoriaD() {
		return categoriaD;
	}
	public void setCategoriaD(String categoriaD) {
		this.categoriaD = categoriaD;
	}
	public String getCategoriaC() {
		return CategoriaC;
	}
	public void setCategoriaC(String categoriaC) {
		CategoriaC = categoriaC;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public Matricula getMatricula() {
		return Matricula;
	}
	public void setMatricula(Matricula Matricula) {
		this.Matricula = Matricula;
	}


	/**
	 * saydel agregar metodo revisar resultado de curso 
	 */
	/////////////////////////////
	////Aqui empece a agregar las nuevas funcionalidades
	public boolean estaEnResultado(String nombreCurso){
		boolean esta=false;

		for(int i=0; i<resultadoCursos.size() && !esta; i++){
			if(resultadoCursos.get(i).getnombreCurso().equals(nombreCurso))
				esta=true;
		}
		return esta;
	}
	public void removeEnCurso(String nombreCurso){
		for(int i=0; i<cursosDa.size(); i++){
			if(cursosDa.get(i).equals(nombreCurso))
				cursosDa.remove(i);
		}
	}
	public void actualizarEnCurso(String nombreCurso){
		cursosDa.add(nombreCurso);

	}




	public void Copy(Docente x)
	{
		this.cantTotalArt = x.cantTotalArt;
		this.id = x.id;
		this.nombre = x.nombre;
		this.sexo = x.sexo;
		this.graduado = x.graduado;
		this.edad = x.edad;
		this.resultadoCursos = x.resultadoCursos;
		this.cursosDa = x.cursosDa;
		this.categoriaD = x.categoriaD;
		CategoriaC = x.CategoriaC;
		this.facultad = x.facultad;
		this.Matricula = x.Matricula;
		this.profesion = x.profesion;
	}

	public int cantidadCred(){
		int total=0;

		for(int i=0; i<resultadoCursos.size(); i++){
			total+= resultadoCursos.get(i).getCredito();
		}
		return total;
	}

	public String estaMatriculado(){
		String verificar=null;

		if(getMatricula()!= null)
			verificar="si";
		else
			verificar="no";

		return verificar;
	}

	public String estaDefendiendo(){
		String verificar="no";
		if(getMatricula()!= null)
			if(getMatricula().isVistoBueno())
				verificar="si";


		return verificar;
	}

	public String estaGraduado(){
		String verificar="no";
		if(getMatricula()!= null)
			if(getMatricula().isGraduadoMaestria())
			verificar="si";
		
		return verificar;
	}



}
