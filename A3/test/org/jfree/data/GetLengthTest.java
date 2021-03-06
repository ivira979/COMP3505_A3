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
class GetLengthTest {
	private Range exampleRange;
	private double LB, UB, len;
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
	
	static double getLen(double a, double b) {
		return b-a;
	}

	@Test
	void testPositiveValuesForLBAndUB() {
		LB = 5;
		UB = 12;
		len = getLen(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(len, exampleRange.getLength(), 0.1d, String.format("The length of (%f,%f) is %f", LB, UB, len));
	}
	@Test
	void testZeroValuesForLBAndUB() {
		LB = 0;
		UB = 0;
		len = getLen(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(len, exampleRange.getLength(), 0.1d, String.format("The length of (%f,%f) is %f", LB, UB, len));
	}
	@Test
	void testZeroValueForLBAndPositiveForUB() {
		LB = 0;
		UB = 12;
		len = getLen(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(len, exampleRange.getLength(), 0.1d, String.format("The length of (%f,%f) is %f", LB, UB, len));
	}
	@Test
	void testNegativeValueForLBAndZeroForUB() {
		LB = -5;
		UB = 0;
		len = getLen(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(len, exampleRange.getLength(), 0.1d, String.format("The length of (%f,%f) is %f", LB, UB, len));
	}
	@Test
	void testNegativeValuesForLBAndUB() {
		LB = -12;
		UB = -5;
		len = getLen(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(len, exampleRange.getLength(), 0.1d, String.format("The length of (%f,%f) is %f", LB, UB, len));
	}
	@Test
	void testNegativeValueForLBAndPositiveForUB() {
		LB = -5;
		UB = 12;
		len = getLen(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(len, exampleRange.getLength(), 0.1d, String.format("The length of (%f,%f) is %f", LB, UB, len));
	}
}
