package sampleTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import ar.edu.unq.poo2.tpintegrador.organizaciones.EventManager;
import mainPackage.App;
import mainPackage.Region;
import position.Position;
import sample.Sample;
import user.User;

public class SampleInRegion {
	
	App syst = new App();
	Sample s1 ;
	Sample s2 ;
	Region rA;
	EventManager events;
	User u1;
	
	@BeforeEach
	public void setUp() {
		u1 = new User("Pepe", syst);
		s1 =  new Sample(u1, EVinchuca.Guasayana, new Position(1,1), syst);
		s2 =  new Sample(u1, EVinchuca.Guasayana, new Position(1432,14324), syst);
		events = new EventManager();
		rA = new Region(new Position(2,1), 1000d, "El Pais de las Maravillas", events);
		syst.addRegion(rA);
	}
	
	@Test
	public void addSampleToRegion() {
		syst.addSample(s1);
		
		assertEquals(Arrays.asList(s1), rA.getSamples());
	}
	
	@Test
	public void addSampleToSystem() {
		syst.addSample(s2);
		assertEquals(Arrays.asList(s2), syst.getSamplesNoRegion());
	}
}
