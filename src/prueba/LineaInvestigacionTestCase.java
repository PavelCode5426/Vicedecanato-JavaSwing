package prueba;

import static org.junit.Assert.*;

import java.util.ArrayList;

import logica.Articulo;
import logica.Docente;
import logica.Investigador;
import logica.LineaInvestigacion;
import logica.TemaInvestigacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auxiliar.ResultadoCurso;

public class LineaInvestigacionTestCase {
LineaInvestigacion x= null;
	@Before
	public void setUp() throws Exception {
		x= new LineaInvestigacion("linea 1", new Docente("99122107385","Pavel Perez Gonzalez","Masculino", true, 19, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Profesor Auxiliar", "Ninguna", "Informatica", null,"Ingeniero Informatico"));
		x.getTemasInvestigacion().add(new TemaInvestigacion("Tema 1", new ArrayList<Investigador>(), new ArrayList<Articulo>(), new Docente("99122107385","Pavel Perez Gonzalez","Masculino", true, 19, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Profesor Auxiliar", "Ninguna", "Informatica", null,"Ingeniero Informatico")));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContainTema(){
		assertEquals(true , x.containTema("Tema 1"));
	}
	
	

}
