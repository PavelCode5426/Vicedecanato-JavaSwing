package prueba;

import static org.junit.Assert.*;

import java.util.ArrayList;

import logica.CursoPosgrado;
import logica.Docente;
import logica.Facultad;
import logica.Persona;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auxiliar.ResultadoCurso;
import principal.Iniciadora;

public class CursoPosgradoTestCase {
	CursoPosgrado x;
	@Before
	public void setUp() throws Exception {
		Iniciadora.AutoInstance();
		x= new CursoPosgrado("Curso 1", "Aprender mucho", "Desarrollar mejores avilidades en la informatica",new Docente("99763214789","Danielle Portal Ramirez","Femenino", true, 19, 0, new ArrayList<ResultadoCurso>(), new ArrayList<String>(), "Instructor", "Doctor", "Informatica", null,"Ingeniero Informatico") ,5, new ArrayList<Persona>(), 20);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVerificarEspasio() {
		assertEquals(20, x.getCapacidadMax());
	}

	@Test
	public void testVerificarPersonaEnCurso() {
		assertEquals(false,x.personaEnCurso(Facultad.getInstance().getPersonas().get(0).getNombre()));
	}
}
