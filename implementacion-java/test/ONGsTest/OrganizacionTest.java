package ONGsTest;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.*;

import Enums.EVinchuca;
import Enums.OpinionValue;
import Enums.TipoDeOrganizacion;
import ar.edu.unq.poo2.tpintegrador.organizaciones.*;
import mainPackage.*;
import position.*;
import sample.*;
import user.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class OrganizacionTest{
	
	App syst = new App();
	Position pos;
	Organizacion ong;
	Sample s1 ;
	Sample s2;
	Position posCenter;
	EventManager events;
	Region rA;
	User u1;
	User u2;
	User u3;
	
	@BeforeEach
	public void setUp() {
		u1 = new PermanentE("PepeE1", syst);
		u2 = new PermanentE("PepeE2", syst);
		u3 = new User("PepeBasic", syst);
		
		ong = new Organizacion("Pepe´s Comp.", TipoDeOrganizacion.Asistencia, 32);
		
		s1 =  new Sample(u1, EVinchuca.Guasayana, new Position(1,1), syst);
		s2 =  new Sample(u1, EVinchuca.Guasayana, new Position(1,1), syst);
		
		events = new EventManager();
		rA = new Region(new Position(2,1), 1000d, "El Pais de las Maravillas", events);
		
		syst.addRegion(rA);
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
		s1.addReview(OpinionValue.Chinche_Foliada, u3);
		s1.addReview(OpinionValue.Phtia_Chinche, u2);
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		s1.addReview(OpinionValue.Phtia_Chinche,u1);
		assertTrue(s1.getState() instanceof Closed);
		
		assertEquals(1, ong.countValidation);
		
	}
	
	@Test
	public void noSeValidaPorqueLaMuestraNoEstaEnNingunaRegionPorUpload() {
		events.suscribeUpload(ong);
		s2 =  new Sample(u1, EVinchuca.Guasayana, new Position(1432,1543), syst);
		syst.addSample(s2);
		
		assertEquals(0, ong.countUpload);
		
	}
	@Test
	public void noSeValidaPorqueLaMuestraNoEstaEnNingunaRegionPorValidation() {
		events.suscribeValidation(ong);
		s2 =  new Sample(u1, EVinchuca.Guasayana, new Position(1432,1543), syst);
		syst.addSample(s2);
		
		s1.addReview(OpinionValue.Chinche_Foliada, u3);
		s1.addReview(OpinionValue.Phtia_Chinche, u2);
		s1.addReview(OpinionValue.Phtia_Chinche,u1);
		
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
		s1.addReview(OpinionValue.Chinche_Foliada, u3);
		s1.addReview(OpinionValue.Phtia_Chinche, u2);
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		s1.addReview(OpinionValue.Phtia_Chinche,u1);
		assertTrue(s1.getState() instanceof Closed);
		
		
		assertEquals(0, ong.countValidation);
		
	}
	
	
	@Test
	public void setValidationAction() {
		FuncionalidadExterna validation = mock(FuncionalidadExterna.class);
		ong.setValidationAction(validation);
		
		FuncionalidadExterna upload = mock(FuncionalidadExterna.class);
		ong.setUploadAction(upload);

	}

}
