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
class ContainsTest {
	private Range exampleRange;
	private double LB, UB, value;
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
	void testPositiveValuesForLBAndUBWithTargetPositiveInRange() {
		LB = 5;
		UB = 12;
		value = 6;
		exampleRange = new Range(LB, UB);
		assertTrue(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testPositiveValuesForLBAndUBWithTargetPositiveGreaterThanUB() {
		LB = 5;
		UB = 12;
		value = 13;
		exampleRange = new Range(LB, UB);
		assertFalse(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testPositiveValuesForLBAndUBWithTargetPositiveLessThanLB() {
		LB = 5;
		UB = 12;
		value = 4;
		exampleRange = new Range(LB, UB);
		assertFalse(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testPositiveValuesForLBAndUBWithTargetNegativeLessThanLB() {
		LB = 5;
		UB = 12;
		value = -4;
		exampleRange = new Range(LB, UB);
		assertFalse(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testPositiveValuesForLBAndUBWithTargetAsLB() {
		LB = 5;
		UB = 12;
		value = LB;
		exampleRange = new Range(LB, UB);
		assertTrue(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testPositiveValuesForLBAndUBWithTargetAsUB() {
		LB = 5;
		UB = 12;
		value = UB;
		exampleRange = new Range(LB, UB);
		assertTrue(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testZeroValuesForLBAndUBWithTargetZero() {
		LB = 0;
		UB = 0;
		value = 0;
		exampleRange = new Range(LB, UB);
		assertTrue(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testZeroValuesForLBAndUBWithTargetPositive() {
		LB = 0;
		UB = 0;
		value = 1;
		exampleRange = new Range(LB, UB);
		assertFalse(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testZeroValuesForLBAndUBWithTargetNegative() {
		LB = 0;
		UB = 0;
		value = -1;
		exampleRange = new Range(LB, UB);
		assertFalse(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testNegativeValuesForLBAndUBWithTargetNegativeGreaterThanUB() {
		LB = -12;
		UB = -5;
		value = -3;
		exampleRange = new Range(LB, UB);
		assertFalse(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testNegativeValuesForLBAndUBWithTargetPositiveGreaterThanUB() {
		LB = -12;
		UB = -5;
		value = 3;
		exampleRange = new Range(LB, UB);
		assertFalse(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testNegativeValuesForLBAndUBWithTargetNegativeLessThanLB() {
		LB = -12;
		UB = -5;
		value = -13;
		exampleRange = new Range(LB, UB);
		assertFalse(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testNegativeValuesForLBAndUBWithTargetAsLB() {
		LB = -12;
		UB = -5;
		value = LB;
		exampleRange = new Range(LB, UB);
		assertTrue(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
	@Test
	void testNegativeValuesForLBAndUBWithTargetAsUB() {
		LB = -12;
		UB = -5;
		value = UB;
		exampleRange = new Range(LB, UB);
		assertTrue(exampleRange.contains(value), String.format("The value %f is in (%f,%f)", value, LB, UB));
	}
}
