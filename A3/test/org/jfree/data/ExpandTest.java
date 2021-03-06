package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpandTest {

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
	void testRangeNull() {
		assertThrows(IllegalArgumentException.class, () -> {Range.expand(null,  0.25, 0.25);});
	}
	
	@Test
	void testRangeNotNullWithLBZeroAndUBPositiveWithLM25AndUM50() {
		Range range = new Range(0,4);
		double lower = 0.25;
		double upper = 0.5;
		Range expected = new Range(-1,6);
		assertEquals(expected, Range.expand(range, lower, upper),
				"New range should be (-1,6)");
	}
	
	@Test
	void testRangeNotNullWithLBZeroAndUBPositiveWithLM0AndUM50() {
		Range range = new Range(0,4);
		double lower = 0;
		double upper = 0.5;
		Range expected = new Range(0,6);
		assertEquals(expected, Range.expand(range, lower, upper),
				"New range should be (0,6)");
	}
	
	@Test
	void testRangeNotNullWithLBZeroAndUBPositiveWithLM25AndUM0() {
		Range range = new Range(0,4);
		double lower = 0.25;
		double upper = 0;
		Range expected = new Range(-1,4);
		assertEquals(expected, Range.expand(range, lower, upper),
				"New range should be (-1,4)");
	}
	
	@Test
	void testRangeNotNullWithLBPositiveAndUBPositiveWithLM50AndUM50() {
		Range range = new Range(1,5);
		double lower = 0.5;
		double upper = 0.5;
		Range expected = new Range(-1,7);
		assertEquals(expected, Range.expand(range, lower, upper),
				"New range should be (-1,7)");
	}

	@Test
	void testRangeNotNullWithLBNegativeAndUBNegativeWithLM50AndUM50() {
		Range range = new Range(-6,-1);
		double lower = 0.5;
		double upper = 0.5;
		Range expected = new Range(-8.5,1.5);
		assertEquals(expected, Range.expand(range, lower, upper),
				"New range should be (-8.5,1.5))");
	}
	
	@Test
	void testRangeNotNullWithLBNegativeAndUBNegativeWithLM50AndUM50WithRangeLengthZero() {
		Range range = new Range(-6,-6);
		double lower = 0.5;
		double upper = 0.5;
		Range expected = new Range(-6,-6);
		assertEquals(expected, Range.expand(range, lower, upper),
				"New range should be (-6,-6))");
	}
	
	@Test
	void testRangeNotNullWithLBNegativeAndUBPositiveWithLM50AndUM50() {
		Range range = new Range(-6,0);
		double lower = 0.5;
		double upper = 0.5;
		Range expected = new Range(-9,3);
		assertEquals(expected, Range.expand(range, lower, upper),
				"New range should be (-9,3))");
	}
	
	@Test
	void testRangeNotNullWithLBNegativeAndUBPositiveWithLM100AndUM100() {
		Range range = new Range(-6,6);
		double lower = 1;
		double upper = 1;
		Range expected = new Range(-18,18);
		assertEquals(expected, Range.expand(range, lower, upper),
				"New range should be (-18,18))");
	}
	

}
