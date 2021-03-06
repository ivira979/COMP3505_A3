package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstrainTest {

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
	void testRange1NotNullWithLBNegativeAndUBPositiveAndConstrainZero() {
		Range r1 = new Range(-5, 5);
		int constraint = 0;
		int expected = 0;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndConstraintZero() {
		Range r1 = new Range(0, 5);
		int constraint = 0;
		int expected = 0;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndConstraintZero() {
		Range r1 = new Range(-5, -3);
		int constraint = 0;
		int expected = -3;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndConstraintZero() {
		Range r1 = new Range(3, 5);
		int constraint = 0;
		int expected = 3;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndConstraintZero() {
		Range r1 = new Range(-5, 0);
		int constraint = 0;
		int expected = 0;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndConstraintZero() {
		Range r1 = new Range(0, 0);
		int constraint = 0;
		int expected = 0;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBPositiveAndConstraintNegative() {
		Range r1 = new Range(-5, 5);
		int constraint = -1;
		int expected = -1;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndConstraintNegative() {
		Range r1 = new Range(0, 5);
		int constraint = -1;
		int expected = 0;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndConstraintNegative() {
		Range r1 = new Range(-5, -3);
		int constraint = -1;
		int expected = -3;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndConstraintNegative() {
		Range r1 = new Range(3, 5);
		int constraint = -1;
		int expected = 3;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndConstraintNegative() {
		Range r1 = new Range(-5, 0);
		int constraint = -1;
		int expected = -1;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndConstraintNegative() {
		Range r1 = new Range(0, 0);
		int constraint = -1;
		int expected = 0;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBPositiveAndConstraintPositive() {
		Range r1 = new Range(-5, 5);
		int constraint = 1;
		int expected = 1;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndConstraintPositive() {
		Range r1 = new Range(0, 5);
		int constraint = 1;
		int expected = 1;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndConstraintPositive() {
		Range r1 = new Range(-5, -3);
		int constraint = 1;
		int expected = -3;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndConstraintPositive() {
		Range r1 = new Range(3, 5);
		int constraint = 1;
		int expected = 3;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndConstraintPositive() {
		Range r1 = new Range(-5, 0);
		int constraint = 1;
		int expected = 0;
		
		assertEquals(expected, r1.constrain(constraint));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndConstraintPositive() {
		Range r1 = new Range(0, 0);
		int constraint = 1;
		int expected = 0;
		
		assertEquals(expected, r1.constrain(constraint));
	}

}
