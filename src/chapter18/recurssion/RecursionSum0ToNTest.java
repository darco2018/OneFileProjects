package chapter18.recurssion;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecursionSum0ToNTest {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void sumTest() {
				
		assertEquals("Check sum of numbers from 0 to 0: ", (Integer)0, (Integer)RecursionSum0ToN.sum(0));
		assertEquals("Check sum of numbers from 0 to 1: ", (Integer)1, (Integer)RecursionSum0ToN.sum(1));
		assertEquals("Check sum of numbers from 0 to 3: ", (Integer)6, (Integer)RecursionSum0ToN.sum(3));		
		assertEquals("Check sum of numbers from 0 to 4: ", (Integer)10, (Integer)RecursionSum0ToN.sum(4));
	}

}
