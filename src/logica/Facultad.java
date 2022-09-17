package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Facultad {

	private String nombre;
	private ArrayList<Departamento> departamentos;
	private ArrayList<Persona> personas;
	private ArrayList<CursoPosgrado> cursos;
	private Maestria maestria;
	private static Facultad Instance;


	/**
	 * 
	 * A CONTINUACION ESTAN LOS CONSTRUCTORES Y LOS GETTERS & SETTERS 
	 *
	 */

	public static Facultad getInstance(){
		if(Instance==null)
			Instance=new Facultad("Facultad de Ingenieria Informatica");
		return Instance;
	}


	private Facultad(String nombre) {
		super();
		this.nombre = nombre;
		departamentos = new ArrayList<Departamento>();
		personas = new ArrayList<Persona>();
		cursos = new ArrayList<CursoPosgrado>();
		maestria = new Maestria(null, new ArrayList<String>(),new ArrayList<String>(),0,0);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(ArrayList<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	public ArrayList<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	public ArrayList<CursoPosgrado> getCursos() {
		return cursos;
	}
	public void setCursos(ArrayList<CursoPosgrado> cursos) {
		this.cursos = cursos;
	}

	
	public boolean addPersonas(Persona x){
		boolean valor=false;
		if(check(0))
		{
			if(personas.add(x))
				valor=true;
		}
		return valor;
	}




	public boolean check(int numero)
	{
		boolean valor=true;
		try{
			switch (numero) {
			case 0:
				if(personas.size()>1000)
					throw new Exception("No se pueden añadir mas personas a la facultad");
				break;
			case 1:
				if(cursos.size()>=200)
					throw new Exception("No se pueden añadir mas cursos a la facultad");
				break;
			case 2:
				if(departamentos.size()>20)
					throw new Exception("No se pueden añadir mas departamentos a la facultad");
				break;
			}

		}
		catch(Exception e)
		{
			valor=false;
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return valor;
	}


	public ArrayList<Persona> returnPeoples(String [] Cadpersonas)
	{
		ArrayList<Persona> nuevo=new ArrayList<Persona>(Cadpersonas.length);
		int x=0;
		while(Cadpersonas.length>x)
		{
			boolean encontrado=false;
			int y=0;
			while(y<personas.size()&&!encontrado)
			{
				if(Cadpersonas[x].equals(personas.get(y).getNombre()))
				{
					encontrado=true;
					nuevo.add(personas.get(y));
				}
				y++;
			}
			x++;
		}
		return nuevo;
	}

	public Persona returnPeople(String nombre)
	{
		Persona nuevo=null;
		int x=0;
		boolean encontrado=false;
		while(personas.size()>x && !encontrado){
			if(personas.get(x).getNombre().equalsIgnoreCase(nombre))
			{
				encontrado=true;
				nuevo=personas.get(x);
			}
			x++;
		}
		return nuevo;
	}

	public boolean addCurso(CursoPosgrado x)
	{
		boolean valor=false;
		if(check(1))
		{
			valor=true;
			cursos.add(x);
		}
		return valor;
	}


	public ArrayList<Investigador> returInvestig(String [] Cadpersonas)
	{
		ArrayList<Investigador> nuevo=new ArrayList<Investigador>(Cadpersonas.length);
		int x=0;
		while(Cadpersonas.length>x)
		{
			boolean encontrado=false;
			int y=0;
			while(y<personas.size()&&!encontrado)
			{
				if(Cadpersonas[x].equals(personas.get(y).getNombre())&& personas.get(y) instanceof Investigador)
				{
					encontrado=true;
					nuevo.add((Investigador)personas.get(y));
				}
				y++;
			}
			x++;
		}
		return nuevo;
	}


	private void restarResultadoInvestigacion()
	{
		for(int x=0;x<personas.size();x++)
		{
			if(personas.get(x) instanceof Investigador)
			{
				((Investigador)personas.get(x)).setCantTotalArt(0);
			}
		}
	}

	public void actualizarResultadoInvestigacion()
	{
		restarResultadoInvestigacion();
		for(int x=0;x<Facultad.getInstance().getDepartamentos().size();x++)
			for(int c=0;c<Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().size();c++)
				for(int v=0;v<Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().get(c).getTemasInvestigacion().size();v++)
					for(int b=0;b<Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().get(c).getTemasInvestigacion().get(v).getArticulos().size();b++)
						for(int n=0;n<Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().get(c).getTemasInvestigacion().get(v).getArticulos().get(b).getAutores().size();n++)
							Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().get(c).getTemasInvestigacion().get(v).getArticulos().get(b).getAutores().get(n).setCantTotalArt(Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().get(c).getTemasInvestigacion().get(v).getArticulos().get(b).getAutores().get(n).getCantTotalArt()+1);
	}

	public boolean containPersona(String CI)
	{
		boolean y=false;

		int x=0;
		while(x<personas.size()&&!y)
			if(personas.get(x++).getId().equals(CI)){
				y=true;
			}


		return y;

	}


	public boolean containTema(String nombre)
	{
		boolean y=false;
		int x=0;
		while (x<departamentos.size()&&!y) {
			if(departamentos.get(x++).containTema(nombre))
				y=true;
		}
		return y;
	}


	public boolean containLinea(String nombre)
	{
		boolean y=false;
		int x=0;
		while(departamentos.size()>x&&!y)
			if(departamentos.get(x++).containLinea(nombre))
				y=true;
		return y;
	}

	public boolean containDepartamento(String nombre)
	{
		boolean y=false;
		int x=0;
		while (departamentos.size()>x&&!y)
			if(departamentos.get(x++).getNombre().equals(nombre))
				y=true;
		return y;
	}
	private boolean checkremovePerson(Persona people)
	{
		boolean valor=true;

		try{
			for(int x=0;x<departamentos.size();x++){
				if(departamentos.get(x).getResponsable().equals(people))
					throw new Exception("La persona es responsable del departamento "+departamentos.get(x).getNombre());
				for(int y=0;y<departamentos.get(x).getLineasInvestigacion().size();y++)
				{
					if(departamentos.get(x).getLineasInvestigacion().get(y).getResponsable().equals(people))
						throw new Exception("La persona es responsable de la linea "+departamentos.get(x).getLineasInvestigacion().get(y).getNombre());
					for(int c=0;c<departamentos.get(x).getLineasInvestigacion().get(y).getTemasInvestigacion().size();c++)
						if(departamentos.get(x).getLineasInvestigacion().get(y).getTemasInvestigacion().get(c).getInvestigadores().contains(people))
							throw new Exception("La persona esta en el tema "+departamentos.get(x).getLineasInvestigacion().get(y).getTemasInvestigacion().get(c).getNombre());
						else if(departamentos.get(x).getLineasInvestigacion().get(y).getTemasInvestigacion().get(c).getResponsable().equals(people))
							throw new Exception("La persona es el responsable del tema "+departamentos.get(x).getLineasInvestigacion().get(y).getTemasInvestigacion().get(c).getNombre());
				}
			}
		}

		catch(Exception e)
		{
			valor=false;
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return valor;
	}



	public boolean removerPerson(Persona people)
	{
		boolean valor=checkremovePerson(people);
		if(valor)
			personas.remove(people);
		return valor;
	}

	public Persona buscarProfesor(String nombre){
		Persona nueva=null;
		boolean encontrado=false;
		int i=0;
		while(!encontrado){
			if(Facultad.getInstance().getPersonas().get(i).getNombre().equals(nombre)){
				encontrado= true;
				nueva=Facultad.getInstance().getPersonas().get(i);
			}
			else
				i++;
		}
		return nueva;
	}

	public CursoPosgrado buscarCurso(String nombreCurso){
		CursoPosgrado devolver=null;
		boolean encontrado=true;
		for(int i=0; i<Facultad.getInstance().getCursos().size() && encontrado; i++){
			if(Facultad.getInstance().getCursos().get(i).getNombre().equals(nombreCurso)){
				devolver= Facultad.getInstance().getCursos().get(i);
				encontrado=false;
			}
		}
		return devolver;
	}

	public CursoPosgrado xxx(int x)
	{
		return cursos.get(x);
	}
	public boolean chequearMatriculacion(String nombre){
		boolean chequeo=false;
		return chequeo;
	}
	public Persona buscarPersona(String nombre){
		Persona devolver=null;
		boolean encontrado=false;
		for(int i=0; i<Facultad.getInstance().getPersonas().size() && !encontrado; i++){
			if(Facultad.getInstance().getPersonas().get(i).getNombre().equals(nombre)){
				encontrado=true;
				devolver=Facultad.getInstance().getPersonas().get(i);
			}
		}
		return devolver;
	}
	public boolean comprobar(String nombreCurso){
		boolean encontrado=false;

		for(int i=0; i<Facultad.getInstance().getCursos().size();i++){

		}
		return encontrado;
	}
	public boolean validarNombreCurso(String nombreCurso){
		boolean repetido=false;
		for(int i=0; i<Facultad.getInstance().getCursos().size() && !repetido;i++){
			if(Facultad.getInstance().getCursos().get(i).equals(nombreCurso))
				repetido=true;
		}
		return repetido;
	}
	public boolean validarTema(String tema){
		boolean repetido=false;
		for(int i=0; i<Facultad.getInstance().getCursos().size() && !repetido;i++){
			if(Facultad.getInstance().getCursos().get(i).getTema().equals(tema))
				repetido=true;
		}
		return repetido;
	}


	public void setMaestria(Maestria unicaMaestria) {
		maestria=unicaMaestria;		
	}


	public Maestria getMaestria() {
		// TODO Auto-generated method stub
		return maestria;
	}


	public Docente devolverProfeCurso(String nombreCurso){
		Docente nuevo=null;
		for(int i=0; i<cursos.size(); i++)
			if(cursos.get(i).getNombre().equals(nombreCurso))
				nuevo=cursos.get(i).getProfesor();
		return nuevo;
	}
	//Dado el nombre de una persona revisar si hay espacio en todos los cursos(size tiene que ser<cantidad max
	public boolean verificarEspacio(){
		boolean espacio=false;

		for(int i=0; i<maestria.getCursosMaestria().size() && !espacio;i++){
			if(buscarCurso(maestria.getCursosMaestria().get(i)).verificarEspacio()){
				espacio=true;
			}
		}

		return espacio;
	}
	///////////////////////////////////////////////////
	//Funciones que hice nuevas
	public boolean comprobarNombre(String nombreCurso){
		boolean contenida=false;

		for(int i=0; i<cursos.size() && !contenida; i++){
			if(cursos.get(i).getNombre().equals(nombreCurso))
				contenida=true;
		}
		return contenida;
	}

	public boolean comprobarTema(String temaCurso){
		boolean repetido=false;

		for(int i=0; i<cursos.size() && !repetido; i++){
			if(cursos.get(i).getTema().equals(temaCurso))
				repetido=true;
		}
		return repetido;
	}


	//Verificar a todos los docentes y profesionales si tienen algun resultadoCurso de su lista que coincida con el nombre del curso seleccionado
	//En funcion de ello se habilita o no el boton Editar ya que si hay alguien graduado de ese curso, no deberia poderse editar el curso.
	public boolean verificarPersonas(String nombreCurso){
		boolean noHayResultado=true;

		for(int i=0; i<personas.size() && noHayResultado; i++){
			if(personas.get(i) instanceof Docente)
				if(((Docente)personas.get(i)).estaEnResultado(nombreCurso))
					noHayResultado=false;
		}

		return noHayResultado;
		//si esta funcion devuelve false si encuentra alguna con resultado 
	}
	//Esta cambia en algo con respecto a la de mas arriba ya que necesito ver si el nombre que se edito ya esta para lo que tngo que revisar
	//tosos los nombres de los cursos excepto el del indice que me pasan que es el mismo(en caso de que no lo haya cambiado se
	//cumpliria para esto ultimo
	public boolean comprobarNombreEditar(String nombreCurso,int indiceCurso){
		boolean contenida=false;

		for(int i=0; i<cursos.size() && !contenida; i++){
			if(i != indiceCurso)
				if(cursos.get(i).getNombre().equals(nombreCurso))
					contenida=true;
		}
		return contenida;
	}

	public boolean comprobarTemaEditar(String temaCurso,int indices){
		boolean repetido=false;

		for(int i=0; i<cursos.size() && !repetido; i++){
			if(i !=indices )
				if(cursos.get(i).getTema().equals(temaCurso))
					repetido=true;
		}
		return repetido;
	}

	public void insertarCurso(CursoPosgrado curso,int index) {
		Facultad.getInstance().getCursos().set(index, curso);

	}

	public Departamento devolverDep(String nombreDep){
		Departamento departamento=null;
		boolean encontrado=true;

		for(int i=0; i<departamentos.size() && encontrado; i++){
			if(departamentos.get(i).getNombre().equals(nombreDep)){
				departamento=departamentos.get(i);
				encontrado=false;
			}
		}

		return departamento;
	}
	public int cantCursosDa(String nombrePersona){
		int total=0;
		for(int i=0; i<cursos.size(); i++){
			if(cursos.get(i).getProfesor().getNombre().equals(nombrePersona))
				total++;
		}
		return total;
	}
	

	public int MaxArticulos()
	{
		int x=0;
		for(int p=0;p<departamentos.size();p++)
			if(departamentos.get(p).TotalArticulos()>x)
				x=departamentos.get(p).TotalArticulos();
		return x;
	}

	public int MaxLin()
	{
		int x=0;
		for(int p=0;p<departamentos.size();p++)
			x+=departamentos.get(p).getLineasInvestigacion().size();
		return x;
	}

	public Departamento returnDepart(String nombre)
	{
		Departamento e= null;
		for(int x=0;x<departamentos.size();x++)
			if(departamentos.get(x).getNombre().equals(nombre))
				e=departamentos.get(x);
		return e;
	}












}
