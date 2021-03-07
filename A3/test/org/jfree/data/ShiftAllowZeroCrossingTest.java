package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShiftAllowZeroCrossingTest {
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
void testNullValueAllowZeroTrue() {
	assertThrows(InvalidParameterException.class, () -> {Range.shift(null, 0.0, true);});
}

@Test
void testNullValueAllowZeroFalse() {
	assertThrows(InvalidParameterException.class, () -> {Range.shift(null, 0.0, false);});
}

@Test
void testZeroValuesForLBAndUBWithShiftZeroAndNoZeroCrossing() {
	exampleRange = new Range(0,0);
	Range actual = Range.shift(exampleRange, 0, false);
	Range expected = new Range(0, 0);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}

@Test
void testPositiveValuesForLBAndUBWithShiftPositiveAndZeroCrossingEnabled() {
	exampleRange = new Range(3,5);
	Range actual = Range.shift(exampleRange, 1, true);
	Range expected = new Range(4, 6);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test//
void testPositiveValuesForLBAndUBWithShiftNegativeAndZeroCrossingEnabled() {
	exampleRange = new Range(3,5);
	Range actual = Range.shift(exampleRange, -1, true);
	Range expected = new Range(2, 4);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testNegativeValuesForLBAndUBWithShiftPositiveOneAndZeroCrossingEnabled() {
	exampleRange = new Range(-5,-3);
	Range actual = Range.shift(exampleRange, 1, true);
	Range expected = new Range(-4, -2);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testNegativeValuesForLBAndUBWithShiftNegativeAndZeroCrossingEnabled() {
	exampleRange = new Range(-5,-3);
	Range actual = Range.shift(exampleRange, -1, true);
	Range expected = new Range(-6, -4);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testNegativeValueForLBAndPositiveForUBWithShiftPositiveAndZeroCrossingEnabled() {
	exampleRange = new Range(-5,5);
	Range actual = Range.shift(exampleRange, 4,true);
	Range expected = new Range(-1, 9);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testNegativeValuesForLBAndUBWithShiftPositiveAndZeroCrossingEnabled() {
	exampleRange = new Range(-5,-1);
	Range actual = Range.shift(exampleRange, 6,true);
	Range expected = new Range(1, 5);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testNegativeValueForLBAndPositiveForUBWithShiftNegativeAndZeroCrossingEnabled() {
	exampleRange = new Range(-5,5);
	Range actual = Range.shift(exampleRange, -6, true);
	Range expected = new Range(-11, -1);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
@Test
void testPoitiveValuesForLBAndUBWithShiftNegativeAndZeroCrossingEnabled() {
	exampleRange = new Range(5,8);
	Range actual = Range.shift(exampleRange, -9, true);
	Range expected = new Range(-4,-1);
	
	 assertAll(
			 () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
			 () -> assertEquals(expected.getUpperBound(), actual.getUpperBound())
			 );
}
}
