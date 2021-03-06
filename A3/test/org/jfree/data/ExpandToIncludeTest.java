package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpandToIncludeTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRangeNullWithValuePositive() {
		Range r = null;
		Range expected = new Range(5.0, 5.0);
		double value = 5.0;
		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRangeNullWithValueNegative() {
		Range r = null;
		Range expected = new Range(-5.0, -5.0);
		double value = -5.0;
		assertTrue(expected.equals(Range.expandToInclude(r, value)));
		
	}
	
	@Test
	void testRangeNullWithValueZero() {
		Range r = null;
		Range expected = new Range(0.0, 0.0);
		double value = 0.0;
		assertTrue(expected.equals(Range.expandToInclude(r, value)));

	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndValueGreaterThanUB() {
		double value = 0.0;
		double UB = 0.0;
		double LB = -5.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(LB, value);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndValueGreaterThanUB() {
		double value = 5.0;
		double UB = 0.0;
		double LB = 0.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(LB, value);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndValueGreaterThanUB() {
		double value = 5.0;
		double UB = 3.0;
		double LB = 0.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(LB, value);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndValueGreaterThanUB() {
		double value = -1.0;
		double UB = -3.0;
		double LB = -5.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(LB, value);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBPositiveAndValueGreaterThanUB() {
		double value = 5.0;
		double UB = 3.0;
		double LB = -5.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(LB, value);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndValueGreaterThanUB() {
		double value = 7.0;
		double UB = 5.0;
		double LB = 3.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(LB, value);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndValueLessThanLB() {
		double value = -7.0;
		double UB = 0.0;
		double LB = -5.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(value, UB);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndValueLessThanLB() {
		double value = -1.0;
		double UB = 0.0;
		double LB = 0.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(value, UB);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndValueLessThanLB() {
		double value = -1.0;
		double UB = 5.0;
		double LB = 0.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(value, UB);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndValueLessThanLB() {
		double value = -7.0;
		double UB = -3.0;
		double LB = -5.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(value, UB);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBPositiveAndValueLessThanLB() {
		double value = -7.0;
		double UB = 5.0;
		double LB = -5.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(value, UB);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndValueLessThanLB() {
		double value = 1.0;
		double UB = 5.0;
		double LB = 3.0;
		
		Range r = new Range(LB, UB);
		Range expected = new Range(value, UB);

		assertTrue(expected.equals(Range.expandToInclude(r, value)));
	}

}
