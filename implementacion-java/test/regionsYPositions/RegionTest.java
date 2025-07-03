package regionsYPositions;
import Enums.EVinchuca;
import ar.edu.unq.poo2.tpintegrador.organizaciones.*;
import mainPackage.*;
import position.*;
import sample.*;
import user.User;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RegionTest {
	Position arielAzul = new Position(-36.5327, -59.9211);
	
	Position bsAs = new Position(-34.6037, -58.3816); //a 256km de arielAzul
	Position bahiaBlanca = new Position(-38.7155, -62.2615); //a 318km de arielAzul
	Position montevideo = new Position(-34.7276, -56.2159); //a 390km de arielAzul
	Position stgoDeChile = new Position(-33.4489, -70.6693); //a 1037km de arielAzul
	Position stgoDelEstero = new Position(-27.79, -64.2628); //a 1054km de arielAzul
	
	Region pba = new Region(arielAzul, 350, "Provincia de Buenos Aires", new EventManager());
	App system;
	
	
	@BeforeEach
	public void setUp() {
		system = new App();
		system.addRegion(pba);
	}
	
	@Test
	public void getSamplesInRegionTest() {
		Sample sBsAs = new Sample(new User("Pepe", system), EVinchuca.Infestans, bsAs, system);
		Sample sStgoDeChile = new Sample(new User("Pepe2", system), EVinchuca.Infestans, stgoDeChile, system);
		Sample sMontevideo = new Sample(new User("Pepe3", system), EVinchuca.Sordida, montevideo, system);
		Sample sBahiaBlanca = new Sample(new User("Pepe4", system), EVinchuca.Guasayana, bahiaBlanca, system);
		Sample sStgoDelEstero = new Sample(new User("Pepe5", system), EVinchuca.Infestans, stgoDelEstero, system);
		
		
		system.addSample(sBsAs);
		system.addSample(sBahiaBlanca);
		system.addSample(sMontevideo);
		system.addSample(sStgoDeChile);
		system.addSample(sStgoDelEstero);
		
		System.out.println(pba.isPosInside(bsAs));
		System.out.println(pba.isPosInside(bahiaBlanca));
		System.out.println(pba.isPosInside(montevideo));
		System.out.println(pba.isPosInside(stgoDeChile));
		System.out.println(pba.isPosInside(stgoDelEstero));
		
		List<Sample> ssInRange = pba.getSamples();
		
		assertEquals(2, ssInRange.size());
		assertTrue(ssInRange.contains(sBsAs));
		assertTrue(ssInRange.contains(sBahiaBlanca));
		assertFalse(ssInRange.contains(sMontevideo));
		assertFalse(ssInRange.contains(sStgoDeChile));
		assertFalse(ssInRange.contains(sStgoDelEstero));
	}
	
	@Test
	public void checkOverlapsTest() {
		//Region que nace dentro de pba, por lo que se da solapamiento.
		Region partidoBahiaBlanca = new Region(bahiaBlanca, 10, "Partido de Bahía Blanca", new EventManager());
		system.addRegion(partidoBahiaBlanca);
		
		//Region que no nace dentro de pba, pero, por su radio, se solapa con esta.
		Position rioDeLaPlata = new Position(-34.7849, -57.2300); //entre medio de CABA y Montevideo
		Region rRioDeLaPlata = new Region(rioDeLaPlata, 123, "Río de La Plata", null);
		system.addRegion(rRioDeLaPlata);
		
		//Region que no nace dentro de pba y con un radio tal que no se solapa con esta.
		Region regionMetropolitanaChile = new Region(stgoDeChile, 121, "Región Metropolitana (Chile)", new EventManager());
		system.addRegion(regionMetropolitanaChile);
		

		
		
		List<Region> overlaps = pba.checkOverlaps(system.getRegions());
		
		
		assertEquals(2, overlaps.size());
		assertTrue(overlaps.contains(partidoBahiaBlanca));
		assertTrue(overlaps.contains(rRioDeLaPlata));
		assertFalse(overlaps.contains(regionMetropolitanaChile));
	}
	
	@Test
	public void regionName() {
		assertEquals("Provincia de Buenos Aires", pba.getName());
	}
	
}
