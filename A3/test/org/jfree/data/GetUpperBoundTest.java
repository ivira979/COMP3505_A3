/**
 * 
 */
package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author irfan
 *
 */
class GetUpperBoundTest {
	private Range exampleRange;
	private double LB = -1000, UB; //fulfills condition of LB <= UB

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testZeroValueForUB() {
		UB  = 0;
		exampleRange = new Range(LB,UB);
		assertEquals(UB, exampleRange.getUpperBound(), 0.1d, String.format("The upper bound of (%f,%f) is %f", LB, UB, UB));
	}
	@Test
	void testNegativeValueForUB() {
		UB  = -5;
		exampleRange = new Range(LB,UB);
		assertEquals(UB, exampleRange.getUpperBound(), 0.1d, String.format("The upper bound of (%f,%f) is %f", LB, UB, UB));
	}
	@Test
	void testPositiveValueForUB() {
		UB  = 5;
		exampleRange = new Range(LB,UB);
		assertEquals(UB, exampleRange.getUpperBound(), 0.1d, String.format("The upper bound of (%f,%f) is %f", LB, UB, UB));
	}

}
