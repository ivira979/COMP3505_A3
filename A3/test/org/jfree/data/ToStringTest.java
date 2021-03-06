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
class ToStringTest {
	private Range exampleRange;
	private String expected;
	private double LB, UB;
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
	void testPositiveValuesForLBAndUB() {
		LB = 5;
		UB = 12;
		expected = String.format("Range[%.1f,%.1f]", LB, UB);
		exampleRange = new Range(LB,UB);
		assertTrue(expected.equals(exampleRange.toString()));
	}
	@Test
	void testZeroValuesForLBAndUB() {
		LB = 0;
		UB = 0;
		expected = String.format("Range[%.1f,%.1f]", LB, UB);
		exampleRange = new Range(LB,UB);
		assertTrue(expected.equals(exampleRange.toString()));
	}
	@Test
	void testZeroValueForLBAndPositiveForUB() {
		LB = 0;
		UB = 12;
		expected = String.format("Range[%.1f,%.1f]", LB, UB);
		exampleRange = new Range(LB,UB);
		assertTrue(expected.equals(exampleRange.toString()));
	}
	@Test
	void testNegativeValueForLBAndZeroForUB() {
		LB = -5;
		UB = 0;
		expected = String.format("Range[%.1f,%.1f]", LB, UB);
		exampleRange = new Range(LB,UB);
		assertTrue(expected.equals(exampleRange.toString()));
	}
	@Test
	void testNegativeValuesForLBAndUB() {
		LB = -12;
		UB = -5;
		expected = String.format("Range[%.1f,%.1f]", LB, UB);
		exampleRange = new Range(LB,UB);
		assertTrue(expected.equals(exampleRange.toString()));
	}
	@Test
	void testNegativeValueForLBAndPositiveForUB() {
		LB = -5;
		UB = 12;
		expected = String.format("Range[%.1f,%.1f]", LB, UB);
		exampleRange = new Range(LB,UB);
		assertTrue(expected.equals(exampleRange.toString()));
		
	}
}
