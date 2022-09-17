package principal;
import interfaz.Autenticar;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import auxiliar.BasePublicaciones;
import auxiliar.ResultadoCurso;
import logica.Articulo;
import logica.CursoPosgrado;
import logica.Departamento;
import logica.Docente;
import logica.Estudiante;
import logica.Facultad;
import logica.Investigador;
import logica.Libro;
import logica.LineaInvestigacion;
import logica.Persona;
import logica.Profesional;
import logica.Publicacion;
import logica.TemaInvestigacion;

public class Iniciadora {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					for(javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels())
						if("Windows".equals(info.getName())){
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
						}
					AutoInstance();
					new Autenticar().setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void AutoInstance()
	{
		//Instancia de Docentes
		Facultad.getInstance().getPersonas().add(new Docente("99122107385","Pavel Perez Gonzalez","Masculino", true, 19, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Profesor Auxiliar", "Ninguna", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("99110207851","Alejandro Perez Gonzalez","Masculino", true, 19, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Profesor Titular", "Ninguna", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("99763214789","Danielle Portal Ramirez","Femenino", true, 19, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Doctor", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("97542625451","Reynold Macias Robert","Masculino", true, 54, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Asistente", "Ninguna", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("23654154789","Marisol Gonzalez Ramirez","Femenino", true, 52, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Master", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("65874521566","Lester Ernesto Pella Rodriguez","Masculino", true, 25, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Ninguna", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("65214789659","Antoine Felipe de la Cruz Machado","Masculino", true,35, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Master", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("98547852123","Sandro Julian Perez Fernandez","Masculino", true, 34, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Asistente", "Ninguna", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("54136589987","Leonardo Gonzalez Ramos","Masculino", true, 58, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Ninguna", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("65214789651","Carlitos Felipe de la Cruz Machado","Masculino", true,30, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Master", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("65214789653","Arian Felipe de la Cruz Machado","Masculino", true,31, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Master", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("65214789654","Saydel  Machado Martinez","Masculino", true,29, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Master", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("65214789655","Celina de la Caridad Vonaventura Jurado","Masculino", true,30, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Master", "Informatica", null,"Ingeniero Informatico"));
		Facultad.getInstance().getPersonas().add(new Docente("65214789656","Rodolfo Felipe Diaz","Masculino", true,30, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Master", "Informatica", null,"Ingeniero Informatico"));
		//Instancia de Estudiantes
		Facultad.getInstance().getPersonas().add(new Estudiante("00251407859","Alejandra Rodriguez Hermandez", "Fememino", false, 18, 0, 1));
		Facultad.getInstance().getPersonas().add(new Estudiante("00012547885","Elena Acosta Gil", "Fememino", false, 18, 0, 1));
		Facultad.getInstance().getPersonas().add(new Estudiante("00745547185","Dayron Acosta Pérez", "Masculino", false, 18, 0, 1));
		Facultad.getInstance().getPersonas().add(new Estudiante("00032178985","Yamile Aldama Lloyd", "Fememino", false, 18, 0, 1));
		Facultad.getInstance().getPersonas().add(new Estudiante("99051458968","Carlos David Alejandrez", "Masculino", false, 20, 0, 2));
		Facultad.getInstance().getPersonas().add(new Estudiante("99012147858","Alejandro Alfonso Hernández", "Masculino", false, 20, 0, 2));
		Facultad.getInstance().getPersonas().add(new Estudiante("98032347589","Ronny Álvarez Pérez", "Masculino", false, 22, 0, 2));
		Facultad.getInstance().getPersonas().add(new Estudiante("97021415658","Indira Baeza Albear ", "Fememino", false, 23, 0, 3));
		Facultad.getInstance().getPersonas().add(new Estudiante("97092587899","Yuniet Artiles García ", "Fememino", false, 22, 0, 2));
		Facultad.getInstance().getPersonas().add(new Estudiante("99051436987","Anabel Andrés Costa", "Fememino", false, 19, 0, 2));
		Facultad.getInstance().getPersonas().add(new Estudiante("00032569877","Janne Araujo Oliva", "Fememino", false, 18, 0, 2));
		Facultad.getInstance().getPersonas().add(new Estudiante("00091874589","Ernesto Andrade Martin", "Masculino", false, 17, 0, 2));
		//Instancia de Profesionales
		Facultad.getInstance().getPersonas().add(new Profesional("93091254782","Camilo Bàez Aneiros", "Masculino", true, 25, "Carlos Tercero","Informatico", new ArrayList<ResultadoCurso>(), null));
		Facultad.getInstance().getPersonas().add(new Profesional("92061874584","Ariel Brito Medina", "Masculino", true, 26, "Facultadad de Informatica","Informatico", new ArrayList<ResultadoCurso>(), null));
		Facultad.getInstance().getPersonas().add(new Profesional("96111102545","Bruno Bú Balmaseda", "Masculino", true, 22, "Etecsa","Informatico", new ArrayList<ResultadoCurso>(), null));
		Facultad.getInstance().getPersonas().add(new Profesional("88050745856","Leonardo Castellanos Martínez", "Masculino", true, 30, "Etecsa","Informatico", new ArrayList<ResultadoCurso>(), null));
		Facultad.getInstance().getPersonas().add(new Profesional("90032514558","Jessibel Castilla Zaldivar", "Masculino", true, 28, "Etecsa","Informatico", new ArrayList<ResultadoCurso>(), null));
		Facultad.getInstance().getPersonas().add(new Profesional("76071868987","Pedro Enrique Castro Rodriguez", "Masculino", true, 42, "Palco","Informatico", new ArrayList<ResultadoCurso>(), null));
		Facultad.getInstance().getPersonas().add(new Profesional("82122145875","Arnold Castroman García", "Masculino", true, 36, "Centro de Estudio de Biomedicina","Informatico", new ArrayList<ResultadoCurso>(), null));
		Facultad.getInstance().getPersonas().add(new Profesional("93082465878","Laidel Cobo Hoyos", "Masculino", true, 25, "Carlos Tercero","Informatico", new ArrayList<ResultadoCurso>(), null));
		/**
		 * INSTANCIA DE LOS DEPATAMENTOS
		 */
		ArrayList<LineaInvestigacion> lin1= new ArrayList<LineaInvestigacion>();

		lin1.add(new LineaInvestigacion("Linea 1",(Docente)Facultad.getInstance().getPersonas().get(0)));
		lin1.get(0).getTemasInvestigacion().add(new TemaInvestigacion("Tema 1"));
		lin1.get(0).getTemasInvestigacion().get(0).setResponsable((Docente)Facultad.getInstance().getPersonas().get(5));
		lin1.get(0).getTemasInvestigacion().get(0).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(25));
		lin1.get(0).getTemasInvestigacion().get(0).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(15));
		lin1.get(0).getTemasInvestigacion().get(0).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(20));
		lin1.get(0).getTemasInvestigacion().get(0).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(24));
		lin1.get(0).getTemasInvestigacion().add(new TemaInvestigacion("Tema 2"));
		lin1.get(0).getTemasInvestigacion().get(1).setResponsable((Docente)Facultad.getInstance().getPersonas().get(3));
		lin1.get(0).getTemasInvestigacion().get(1).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(23));
		lin1.get(0).getTemasInvestigacion().get(1).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(14));
		lin1.get(0).getTemasInvestigacion().get(1).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(19));
		lin1.get(0).getTemasInvestigacion().add(new TemaInvestigacion("Tema 3"));
		lin1.get(0).getTemasInvestigacion().get(2).setResponsable((Docente)Facultad.getInstance().getPersonas().get(2));
		lin1.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(25));
		lin1.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(15));
		lin1.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(14));
		lin1.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(20));
		lin1.add(new LineaInvestigacion("Linea 2",(Docente)Facultad.getInstance().getPersonas().get(5)));

		Facultad.getInstance().getDepartamentos().add(new Departamento("Departamento 1",(Docente)Facultad.getInstance().getPersonas().get(7),lin1));
		ArrayList<LineaInvestigacion> lin= new ArrayList<LineaInvestigacion>();
		lin.add(new LineaInvestigacion("Linea 1",(Docente)Facultad.getInstance().getPersonas().get(4)));
		lin.get(0).getTemasInvestigacion().add(new TemaInvestigacion("Tema 4"));
		lin.get(0).getTemasInvestigacion().get(0).setResponsable((Docente)Facultad.getInstance().getPersonas().get(9));
		lin.get(0).getTemasInvestigacion().get(0).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(25));
		lin.get(0).getTemasInvestigacion().get(0).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(15));
		lin.get(0).getTemasInvestigacion().get(0).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(20));
		lin.get(0).getTemasInvestigacion().get(0).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(24));
		lin.get(0).getTemasInvestigacion().add(new TemaInvestigacion("Tema 5"));
		lin.get(0).getTemasInvestigacion().get(1).setResponsable((Docente)Facultad.getInstance().getPersonas().get(2));
		lin.get(0).getTemasInvestigacion().get(1).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(23));
		lin.get(0).getTemasInvestigacion().get(1).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(14));
		lin.get(0).getTemasInvestigacion().get(1).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(19));
		lin.get(0).getTemasInvestigacion().get(1).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(14));
		lin.get(0).getTemasInvestigacion().get(1).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(11));
		lin.get(0).getTemasInvestigacion().add(new TemaInvestigacion("Tema 6"));
		lin.get(0).getTemasInvestigacion().get(2).setResponsable((Docente)Facultad.getInstance().getPersonas().get(3));
		lin.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(25));
		lin.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(6));
		lin.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(7));
		lin.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(15));
		lin.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(20));
		lin.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(10));
		lin.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(14));
		lin.get(0).getTemasInvestigacion().get(2).getInvestigadores().add((Investigador)Facultad.getInstance().getPersonas().get(23));
		Facultad.getInstance().getDepartamentos().add(new Departamento("Departamento 2",(Docente)Facultad.getInstance().getPersonas().get(2),lin));
		/**
		 *Publicaciones 
		 */
		ArrayList<String> autores= new ArrayList<String>();
		autores.add("Paco");
		autores.add("Paca");
		BasePublicaciones.getInstance().getBaseLibro().add(new Libro("Libro 1",autores, 3,"La editorial", "####"));
		BasePublicaciones.getInstance().getBaseLibro().add(new Libro("Libro 0",autores, 3,"La editorial", "####"));
		BasePublicaciones.getInstance().getBaseLibro().add(new Libro("Libro 2",autores, 3,"La editorial", "####"));
		BasePublicaciones.getInstance().getBaseLibro().add(new Libro("Libro 3",autores, 3,"La editorial", "####"));
		

		








		/**
		 * Creando los cursos
		 */

		ArrayList<Persona> x= new ArrayList<Persona>();
		x.add(Facultad.getInstance().getPersonas().get(1));
		x.add(Facultad.getInstance().getPersonas().get(0));
		Facultad.getInstance().getCursos().add(new CursoPosgrado("Redes e Internet", "Las redes sociales y su importancia", "Ayudar a los pobres pofesores",(Docente)Facultad.getInstance().getPersonas().get(2),3,x, 10));
		


	}
































}
