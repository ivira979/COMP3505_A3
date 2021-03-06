package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetCentralValueTest {

	private Range exampleRange;
	private double LB, UB, mean;
	
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
	
	//helper function
	static double getMean(double a, double b) {
		return (a+b)/2;
	}
	
	@Test
	void testPositiveValuesForLBAndUB() {
		LB = 5;
		UB = 12;
		mean = getMean(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(mean, exampleRange.getCentralValue(), 0.1d, String.format("The central value of (%f,%f) is %f", LB, UB, mean));
	}
	@Test
	void testZeroValuesForLBAndUB() {
		LB = 0;
		UB = 0;
		mean = getMean(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(mean, exampleRange.getCentralValue(), 0.1d, String.format("The central value of (%f,%f) is %f", LB, UB, mean));
	}
	@Test
	void testZeroValueForLBAndPositiveForUB() {
		LB = 0;
		UB = 12;
		mean = getMean(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(mean, exampleRange.getCentralValue(), 0.1d, String.format("The central value of (%f,%f) is %f", LB, UB, mean));
	}
	@Test
	void testNegativeValueForLBAndZeroForUB() {
		LB = -5;
		UB = 0;
		mean = getMean(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(mean, exampleRange.getCentralValue(), 0.1d, String.format("The central value of (%f,%f) is %f", LB, UB, mean));
	}
	@Test
	void testNegativeValuesForLBAndUB() {
		LB = -12;
		UB = -5;
		mean = getMean(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(mean, exampleRange.getCentralValue(), 0.1d, String.format("The central value of (%f,%f) is %f", LB, UB, mean));
	}
	@Test
	void testNegativeValueForLBAndPositiveForUB() {
		LB = -5;
		UB = 12;
		mean = getMean(LB,UB);
		exampleRange = new Range(LB, UB);
		assertEquals(mean, exampleRange.getCentralValue(), 0.1d, String.format("The central value of (%f,%f) is %f", LB, UB, mean));
	}


}
