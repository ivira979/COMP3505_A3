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
class EqualsTest {

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
	void testHashCode() {
		Range r1 = new Range(-5,0);
		r1.hashCode();
		assertTrue(true);
	}
	
	@Test
	void testRange1ValidRangeAndRange2AsInt() {
		Range r1 = new Range(-5,0);
		int r2 = 0;
		assertFalse(r1.equals(r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndNotEqualToRange2() {
		Range r1 = new Range(-5,0);
		Range r2 = new Range(-7,2);
		assertFalse(r1.equals(r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBZeroAndEqualsRange2() {
		Range r1 = new Range(-5,0);
		Range r2 = new Range(-5,0);
		assertTrue(r1.equals(r2));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBZeroAndEqualsRange2() {
		Range r1 = new Range(0,0);
		Range r2 = new Range(0,0);
		assertTrue(r1.equals(r2));
	}
	
	@Test
	void testRange1NotNullWithLBZeroAndUBPositiveAndEqualsRange2() {
		Range r1 = new Range(0,5);
		Range r2 = new Range(0,5);
		assertTrue(r1.equals(r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBNegativeAndEqualsRange2() {
		Range r1 = new Range(-5,-3);
		Range r2 = new Range(-5,0);
		assertTrue(r1.equals(r2));
	}
	
	@Test
	void testRange1NotNullWithLBNegativeAndUBPositiveAndEqualsRange2() {
		Range r1 = new Range(-5,0);
		Range r2 = new Range(-5,0);
		assertTrue(r1.equals(r2));
	}
	
	@Test
	void testRange1NotNullWithLBPositiveAndUBPositiveAndEqualsRange2() {
		Range r1 = new Range(-5,0);
		Range r2 = new Range(-5,0);
		assertTrue(r1.equals(r2));
	}

}
