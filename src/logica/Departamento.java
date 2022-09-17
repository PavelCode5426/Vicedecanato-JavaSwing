package logica;
import java.util.ArrayList;


public class Departamento {
	private String nombre;
	private Docente responsable;
	private ArrayList<LineaInvestigacion> lineasInvestigacion;

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Docente getResponsable() {
		return responsable;
	}


	public void setResponsable(Docente responsable) {
		this.responsable = responsable;
	}


	public ArrayList<LineaInvestigacion> getLineasInvestigacion() {
		return lineasInvestigacion;
	}


	public void setLineasInvestigacion(
			ArrayList<LineaInvestigacion> lineasInvestigacion) {
		this.lineasInvestigacion = lineasInvestigacion;
	}


	public Departamento(String nombre, Docente responsable,
			ArrayList<LineaInvestigacion> arrayList) {
		super();
		this.nombre = nombre;
		this.responsable = responsable;
		this.lineasInvestigacion = arrayList;
	}

	public Departamento(Departamento x){
		nombre=x.getNombre();
		responsable=x.getResponsable();
		lineasInvestigacion=x.getLineasInvestigacion();
	}

	public boolean containTema(String nombre)
	{
		boolean y=false;
		int x=0;
		while (x<lineasInvestigacion.size()&&!y) {
			if(!lineasInvestigacion.get(x++).containTema(nombre))
				y=true;
		}
		return y;
	}

	public boolean containLinea(String nombre)
	{
		boolean y=false;
		int x=0;
		while(lineasInvestigacion.size()>x && !y)
			if(lineasInvestigacion.get(x++).getNombre().equals(nombre))
				y=true;
		return y;
	}

	public ArrayList<Persona> devolvetInvest(){
		ArrayList<Persona> lista= new ArrayList<Persona>();
		
		for(int i=0; i<lineasInvestigacion.size(); i++){
			lista.addAll(lineasInvestigacion.get(i).devolverInvestiga());
		}
		return lista;
	}

	public int TotalArticulos()
	{
		int x=0;
		for(int t=0;lineasInvestigacion.size()>t;t++)
			x+=lineasInvestigacion.get(t).TotalArticulos();
		return x;
	}






}
