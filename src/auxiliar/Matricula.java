package auxiliar;

import java.util.ArrayList;

public class Matricula {
	private ArrayList<String> nombreCursosMaestria;
	private boolean vistoBueno;
	private boolean graduadoMaestria;
	
	public Matricula(ArrayList<String> nombreCursosMaestria,
			boolean vistoBueno, boolean graduadoMaestria) {
		super();
		this.nombreCursosMaestria = nombreCursosMaestria;
		this.vistoBueno = vistoBueno;
		this.graduadoMaestria = graduadoMaestria;
	}
	public ArrayList<String> getNombreCursosMaestria() {
		return nombreCursosMaestria;
	}
	public void setNombreCursosMaestria(ArrayList<String> nombreCursosMaestria) {
		this.nombreCursosMaestria = nombreCursosMaestria;
	}
	public boolean isVistoBueno() {
		return vistoBueno;
	}
	public void setVistoBueno(boolean vistoBueno) {
		this.vistoBueno = vistoBueno;
	}
	public boolean isGraduadoMaestria() {
		return graduadoMaestria;
	}
	public void setGraduadoMaestria(boolean graduadoMaestria) {
		this.graduadoMaestria = graduadoMaestria;
	}
	
	public void removerMatricula(){
		nombreCursosMaestria=null;
	}
	
}
