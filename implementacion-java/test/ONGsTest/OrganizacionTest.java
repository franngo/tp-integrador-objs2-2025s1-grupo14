package ONGsTest;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

import Enums.EVinchuca;
import Enums.OpinionValue;
import Enums.TipoDeOrganizacion;
import ar.edu.unq.poo2.tpintegrador.organizaciones.*;
import mainPackage.*;
import position.*;
import sample.*;

public class OrganizacionTest{
	
	App syst = new App();
	Position pos;
	Organizacion ong;
	Sample s1 ;
	Sample s2;
	Position posCenter;
	EventManager events;
	Region rA;
	
	
	@BeforeEach
	public void setUp() {
		ong = new Organizacion("Pepe´s Comp.", TipoDeOrganizacion.Asistencia, 32);
		pos = new Position(1,1,syst);
		s1 = new Sample("Palito", EVinchuca.Sordida, pos);
		s2 = new Sample("Anis", EVinchuca.Guasayana, new Position(32,124, syst));
		posCenter = new Position(2,1,syst);
		events = new EventManager();
		rA = new Region(posCenter, 1000d, "El Pais de las Maravillas", events);
		syst.addRegios(rA);
	}
	
	@Test
	public void notifyUploadEnRegionTest() {
		events.suscribeUpload(ong);
		syst.addSample(s1);
		
		assertEquals(1, ong.countUpload);
		
	}
	
	@Test
	public void notifyValidationEnRegionTest() {
		events.suscribeValidation(ong);
		syst.addSample(s1);
		
		assertTrue(s1.getState() instanceof Open);
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe1");
		s1.addReview(OpinionValue.Phtia_Chinche, "Expert", "Pepe2");
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe3");
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe45");
		assertTrue(s1.getState() instanceof Closed);
		
		assertEquals(1, ong.countValidation);
		
	}
	
	@Test
	public void noSeValidaPorqueLaMuestraNoEstaEnNingunaRegionPorUpload() {
		events.suscribeUpload(ong);
		
		syst.addSample(s2);
		
		assertEquals(0, ong.countUpload);
		
	}
	@Test
	public void noSeValidaPorqueLaMuestraNoEstaEnNingunaRegionPorValidation() {
		events.suscribeUpload(ong);
		syst.addSample(s1);
		
		assertEquals(0, ong.countValidation);
		
	}
	
	@Test
	public void unSuscribeOngUpload() {
		events.suscribeUpload(ong);
		events.unsuscribeUpload(ong);
		
		syst.addSample(s1);
		
		assertEquals(0, ong.countUpload);
		
	}
	
	
	@Test
	public void unSuscribeOngValidation() {
		events.suscribeValidation(ong);
		syst.addSample(s1);
		
		events.unsuscribeValidation(ong);
		
		assertTrue(s1.getState() instanceof Open);
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe1");
		s1.addReview(OpinionValue.Phtia_Chinche, "Expert", "Pepe2");
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe3");
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe45");
		assertTrue(s1.getState() instanceof Closed);
		
		assertEquals(0, ong.countValidation);
		
	}
	
}
