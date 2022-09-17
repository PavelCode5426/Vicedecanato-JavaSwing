package logica;

public abstract class Persona {
	protected String id;
	protected String nombre;
	protected String sexo;// hacer un enum del sexo
	protected boolean graduado;
	protected int edad;

	public Persona(String id, String nombre, String sexo, boolean graduado,
			int edad) {
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.graduado = graduado;
		this.edad = edad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void Copy(Persona x,int index)
	{
		if(x instanceof Estudiante)
			((Estudiante)Facultad.getInstance().getPersonas().get(index)).Copy((Estudiante)x);
		else if (x instanceof Docente)
			((Docente)Facultad.getInstance().getPersonas().get(index)).Copy((Docente)x);
		else
			((Profesional)Facultad.getInstance().getPersonas().get(index)).Copy((Profesional)x);
	}
	
	
}
