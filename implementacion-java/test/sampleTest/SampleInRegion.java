package sampleTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.TipoDeOrganizacion;
import ar.edu.unq.poo2.tpintegrador.organizaciones.EventManager;
import ar.edu.unq.poo2.tpintegrador.organizaciones.Organizacion;
import mainPackage.App;
import mainPackage.Region;
import position.Position;
import sample.Sample;

public class SampleInRegion {
	
	App syst = new App();
	Position pos;
	Organizacion ong;
	Sample s1 ;
	Sample s2 ;
	Position posCenter;
	Region rA;
	EventManager events;
	
	
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
	public void addSampleToRegion() {
		syst.addSample(s1);
		assertEquals(1, rA.getSamplesInRegion(syst.getSamples()).size());
	}
	
	@Test
	public void addSampleToSystem() {
		syst.addSample(s2);
		assertEquals(0, rA.getSamplesInRegion(syst.getSamples()).size());
	}
}
