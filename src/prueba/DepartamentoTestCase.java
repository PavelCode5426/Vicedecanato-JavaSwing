package prueba;

import static org.junit.Assert.*;

import java.util.ArrayList;

import logica.Articulo;
import logica.Departamento;
import logica.Docente;
import logica.Facultad;
import logica.Investigador;
import logica.LineaInvestigacion;
import logica.TemaInvestigacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auxiliar.ResultadoCurso;

public class DepartamentoTestCase {

	private Departamento departamentoTest;

	@Before
	public void setUp() throws Exception {
		ArrayList<LineaInvestigacion> lin=new ArrayList<LineaInvestigacion>();
		lin.add(new LineaInvestigacion("CEMAT", new Docente("99763214789","Danielle Portal Ramirez","Femenino", true, 19, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Doctor", "Informatica", null,"Ingeniero Informatico")));
		lin.get(0).getTemasInvestigacion().add(new TemaInvestigacion("TEMA!"));
		departamentoTest= new Departamento("Cemat",new Docente("99122107385","Pavel Perez Gonzalez","Masculino", true, 19, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Profesor Auxiliar", "Ninguna", "Informatica", null,"Ingeniero Informatico"), lin);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContainLinea() {
		assertEquals(true, departamentoTest.containLinea("CEMAT"));	

	}
	@Test
	public void containTema(){
		assertEquals(false, departamentoTest.containTema("HOLA"));
	}

}
