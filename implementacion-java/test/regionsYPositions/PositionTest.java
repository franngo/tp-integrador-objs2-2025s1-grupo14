package regionsYPositions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import position.*;

public class PositionTest {
	Position bsAs = new Position(-34.6037, -58.3816);
	Position stgoDeChile = new Position(-33.4489, -70.6693); //a 1139km de bsAs
	Position montevideo = new Position(-34.7276, -56.2159); //a 199km de bsAs
	Position bahiaBlanca = new Position(-38.7155, -62.2615); //a 573km de bsAs
	Position stgoDelEstero = new Position(-27.79, -64.2628); //a 941km de bsAs
	
	@Test
	public void distanceTest() {
		assertEquals(1139, bsAs.getDistanceTo(stgoDeChile, new Kilometers()));
		assertEquals(1139000, bsAs.getDistanceTo(stgoDeChile, new Meters()));
		assertEquals(199, bsAs.getDistanceTo(montevideo, new Kilometers()));
		assertEquals(199000, bsAs.getDistanceTo(montevideo, new Meters()));
		assertEquals(573, bsAs.getDistanceTo(bahiaBlanca, new Kilometers()));
		assertEquals(573000, bsAs.getDistanceTo(bahiaBlanca, new Meters()));
		assertEquals(941, bsAs.getDistanceTo(stgoDelEstero, new Kilometers()));
		assertEquals(941000, bsAs.getDistanceTo(stgoDelEstero, new Meters()));
	}
	
	@Test
	public void positionsInRangeToMeTest() {
		List <Position> ps = new ArrayList<Position>();
		ps.add(stgoDeChile);
		ps.add(montevideo);
		ps.add(bahiaBlanca);
		ps.add(stgoDelEstero);
		List <Position> psInRange = bsAs.positionsInRangeToMe(ps, 573, new Kilometers());
		assertEquals(2, psInRange.size());
		assertTrue(psInRange.contains(montevideo));
		assertTrue(psInRange.contains(bahiaBlanca));
		assertFalse(psInRange.contains(stgoDelEstero));
		assertFalse(psInRange.contains(stgoDeChile));
		psInRange = bsAs.positionsInRangeToMe(ps, 1000, new Kilometers());
		assertEquals(3, psInRange.size());
		assertTrue(psInRange.contains(montevideo));
		assertTrue(psInRange.contains(bahiaBlanca));
		assertTrue(psInRange.contains(stgoDelEstero));
		assertFalse(psInRange.contains(stgoDeChile));
	}
	
}