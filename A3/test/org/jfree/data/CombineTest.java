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
class CombineTest {

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
	void testBothRangesNull() {
		Range r1 = null;
		Range r2 = null;
		Range r3 = null;
		assertEquals(r3, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NullAndRange2NotNullWithLBNegativeAndUBPositive() {
		Range r1 = null;
		Range r2 = new Range(-1,1);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NullAndRange2NotNullWithLBZeroAndUBPositive() {
		Range r1 = null;
		Range r2 = new Range(0,5);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NullAndRange2NotNullWithLBNegativeAndUBNegative() {
		Range r1 = null;
		Range r2 = new Range(-5,-3);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NullAndRange2NotNullWithLBPositiveAndUBPositive() {
		Range r1 = null;
		Range r2 = new Range(3, 5);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NullAndRange2NotNullWithLBNegativeAndUBZero() {
		Range r1 = null;
		Range r2 = new Range(-5,0);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NullAndRange2NotNullWithLBZeroAndUBZero() {
		Range r1 = null;
		Range r2 = new Range(0,0);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBPositiveAndRange2Null() {
		Range r1 = new Range(-1,1);
		Range r2 = null;
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndRange2Null() {
		Range r1 = new Range(-5,0);
		Range r2 = null;
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndRange2Null() {
		Range r1 = new Range(-1,-1);
		Range r2 = null;
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndRange2Null() {
		Range r1 = new Range(0,0);
		Range r2 = null;
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndRange2Null() {
		Range r1 = new Range(0,5);
		Range r2 = null;
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndRange2Null() {
		Range r1 = new Range(3,5);
		Range r2 = null;
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1EqualsRange2WithLBNegativeAndUBPositive() {
		Range r1 = new Range(-1,1);
		Range r2 = new Range(-1,1);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1EqualsRange2WithLBNegativeAndUBZero() {
		Range r1 = new Range(0,0);
		Range r2 = new Range(0,0);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1EqualsRange2WithLBNegativeAndUBNegative() {
		Range r1 = new Range(-1,1);
		Range r2 = new Range(-1,1);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1EqualsRange2WithLBAndUBZero() {
		Range r1 = new Range(0,0);
		Range r2 = new Range(0,0);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1EqualsRange2WithLBZeroAndUBPositive() {
		Range r1 = new Range(0,5);
		Range r2 = new Range(0,5);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	@Test
	void testRange1EqualsRange2WithLBPositiveAndUBPositive() {
		Range r1 = new Range(3,5);
		Range r2 = new Range(3,5);
		assertEquals(r2, Range.combine(r1, r2));
	}
	
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBPositiveAndRange2NotNullWithLBNegativeAndUBPositive() {
		Range r1 = new Range(-1,1);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2,2), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndRange2NotNullWithLBNegativeAndUBPositive() {
		Range r1 = new Range(-5,0);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-5, 2), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndRange2NotNullWithLBNegativeAndUBPositive() {
		Range r1 = new Range(-1,-1);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2, 2), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndRange2NotNullWithLBNegativeAndUBPositive() {
		Range r1 = new Range(0,0);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2, 2), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndRange2NotNullWithLBNegativeAndUBPositive() {
		Range r1 = new Range(0,5);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2, 5), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndRange2NotNullWithLBNegativeAndUBPositive() {
		Range r1 = new Range(3,5);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2, 5), Range.combine(r1, r2));
	}
	
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBPositiveAndRange2NotNullWithLBNegativeAndUBZero() {
		Range r1 = new Range(-1,1);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2,2), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndRange2NotNullWithLBNegativeAndUBZero() {
		Range r1 = new Range(-5,0);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-5, 2), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndRange2NotNullWithLBNegativeAndUBZero() {
		Range r1 = new Range(-1,-1);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2, 2), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndRange2NotNullWithLBNegativeAndUBZero() {
		Range r1 = new Range(0,0);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2, 2), Range.combine(r1, r2));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndRange2NotNullWithLBNegativeAndUBZero() {
		Range r1 = new Range(0,5);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2, 5), Range.combine(r2, r1));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndRange2NotNullWithLBNegativeAndUBZero() {
		Range r1 = new Range(3,5);
		Range r2 = new Range(-2,2);
		assertEquals(new Range(-2, 5), Range.combine(r2, r1));
	}

}
