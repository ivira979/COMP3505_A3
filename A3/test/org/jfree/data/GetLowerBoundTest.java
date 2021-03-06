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
class GetLowerBoundTest {
	private Range exampleRange;
	private double UB = 1000, LB; //fulfills condition of UB >= LB

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
	void testZeroValueForLB() {
		LB  = 0;
		exampleRange = new Range(LB,UB);
		assertEquals(LB, exampleRange.getLowerBound(), 0.1d, String.format("The lower bound of (%f,%f) is %f", LB, UB, LB));
	}
	@Test
	void testNegativeValueForLB() {
		LB  = -5;
		exampleRange = new Range(LB,UB);
		assertEquals(LB, exampleRange.getLowerBound(), 0.1d, String.format("The lower bound of (%f,%f) is %f", LB, UB, LB));
	}
	@Test
	void testPositiveValueForLB() {
		LB = 5;
		exampleRange = new Range(LB,UB);
		assertEquals(LB, exampleRange.getLowerBound(), 0.1d, String.format("The lower bound of (%f,%f) is %f", LB, UB, LB));
	}
}
