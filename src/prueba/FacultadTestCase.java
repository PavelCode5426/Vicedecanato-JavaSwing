package prueba;

import static org.junit.Assert.*;
import logica.Facultad;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import principal.Iniciadora;

public class FacultadTestCase {

	@Before
	public void setUp() throws Exception {
		Iniciadora.AutoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFacultadContainPersona(){
		assertEquals(false,Facultad.getInstance().containPersona("9912210738"));
	}
	@Test
	public void testFacultadContainDepart(){
		assertEquals(false, Facultad.getInstance().containDepartamento("hola"));
	}
	@Test
	public void testFacultadisSpace(){
		assertEquals(true, Facultad.getInstance().check(0));
	}
	@Test
	public void testFacultadisSpace2(){
		assertEquals(true, Facultad.getInstance().check(1));
	}
	@Test
	public void testFacultadisSpace3(){
		assertEquals(true, Facultad.getInstance().check(2));
	}
	@Test
	public void testReturnPeople(){
		assertEquals(Facultad.getInstance().getPersonas().get(0), Facultad.getInstance().returnPeople("Pavel Perez Gonzalez"));
	}
}
