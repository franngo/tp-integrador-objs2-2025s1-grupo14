package ongTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.TipoDeOrganizacion;
import ar.edu.unq.poo2.tpintegrador.organizaciones.Organizacion;
import position.Position;

public class ongValidationTest {
	
	Organizacion ong;
	Position pos;
	
	
	
	@BeforeEach
	public void setUp() {
		pos = new Position(1,1);
		ong = new Organizacion (pos, TipoDeOrganizacion.Salud, 10);
	}
	
	@Test
	public void test() {
		assertEquals(1,1);
	}

}