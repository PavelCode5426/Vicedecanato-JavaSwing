package auxiliar;
public class ResultadoCurso {
	private int credito;
	private String nombreCurso;
	
	public ResultadoCurso( String nombreCurso,int credito) {
		super();
		this.credito = credito;
		this.nombreCurso = nombreCurso;
	}

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

	public String getnombreCurso() {
		return nombreCurso;
	}

	public void setnombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	
}
