package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShiftTest {
private Range exampleRange;

@BeforeAll
static void setUpBeforeClass() throws Exception {
}
@BeforeEach
void setUp() throws Exception {
}

@AfterEach
void tearDown() throws Exception {
}
@AfterAll
static void tearDownAfterClass() throws Exception {
}


@Test
void testPositiveValuesForLBAndUBWithShiftPositive() {
	exampleRange = new Range(3,5);
	Range actual = Range.shift(exampleRange, 1);
	Range expected = new Range(4, 6);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test//
void testPositiveValuesForLBAndUBWithShiftNegative() {
	exampleRange = new Range(3,5);
	Range actual = Range.shift(exampleRange, -1);
	Range expected = new Range(2, 4);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testNegativeValuesForLBAndUBWithShiftPositive() {
	exampleRange = new Range(-5,-3);
	Range actual = Range.shift(exampleRange, 1);
	Range expected = new Range(-4, -2);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testNegativeValuesForLBAndUBWithShiftNegative() {
	exampleRange = new Range(-5,-3);
	Range actual = Range.shift(exampleRange, -1);
	Range expected = new Range(-6, -4);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}

@Test
void testNegativeValueForLBAndPositiveForUBWithShiftPositiveAndZeroCrossingDisabled() {
	exampleRange = new Range(-5,5);
	Range actual = Range.shift(exampleRange, 6);
	Range expected = new Range(0, 11);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testNegativeValueForLBAndPositiveForUBWithShiftNegativeAndZeroCrossingDisabled() {
	exampleRange = new Range(-5,5);
	Range actual = Range.shift(exampleRange, -6);
	Range expected = new Range(-11, 0);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
}
