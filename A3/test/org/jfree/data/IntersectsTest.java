package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntersectsTest {
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
void testPositiveValuesForLBAndUBWithTargetRangeWider() {
	exampleRange = new Range(3,5);
	boolean actual = exampleRange.intersects(1,15);
	
	assertTrue(actual);
}
@Test
void testPositiveValuesForLBAndUBWithTargetRangeNarrower() {
	exampleRange = new Range(1,15);
	boolean actual = exampleRange.intersects(3,5);

	assertTrue(actual);
}
@Test
void testPositiveValuesForLBAndUBWithTargetRangeLessThanLB() {
	exampleRange = new Range(1,10);
	boolean actual = exampleRange.intersects(-5,-1);
	
	assertFalse(actual);
}
@Test
void testPositiveValuesForLBAndUBWithTargetRangeGreaterThanUB() {
	exampleRange = new Range(3,5);
	boolean actual = exampleRange.intersects(5,1);
	
	assertFalse(actual);
}
@Test//
void testPositiveValuesForLBAndUBWithTargetRangeEqual() {
	exampleRange = new Range(1,5);
	boolean actual = exampleRange.intersects(1,5);
	
	assertTrue(actual);
}
@Test
void testNegativeValuesForLBAndUBWithTargetRangeWider() {
	exampleRange = new Range(-5,-3);
	boolean actual = exampleRange.intersects(-15,-1);
	
	assertTrue(actual);
}
@Test
void testNegativeValuesForLBAndUBWithTargetRangeNarrower() {
	exampleRange = new Range(-15,-1);
	boolean actual = exampleRange.intersects(-5,-3);

	assertTrue(actual);
}
@Test//
void testNegativeValuesForLBAndUBWithTargetRangeGreaterThanUB() {
	exampleRange = new Range(-5,-1);
	boolean actual = exampleRange.intersects(0,5);

	assertFalse(actual);
}
@Test//
void testNegativeValuesForLBAndUBWithTargetRangeLessThanLB() {
	exampleRange = new Range(-5,-1);
	boolean actual = exampleRange.intersects(-10,-6);

	assertFalse(actual);
}
@Test//
void testNegativeValuesForLBAndUBWithTargetRangeEqual() {
	exampleRange = new Range(-5,-1);
	boolean actual = exampleRange.intersects(-5,-1);
	
	assertTrue(actual);
}
}


