/**
 * 
 */
package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author irfan
 *
 */
class CalculateColumnTotalTest {

	private Values2D value = mock(Values2D.class);
	private int colNum = 0;
	private double arg1,arg2,arg3,arg4,sum;
	
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

	static double getSum(double arg1, double arg2, double arg3, double arg4) {
		
		return arg1+arg2+arg3+arg4;
	}
	
	//Invalid Column Value
	
	@Test
	void testZeroValuesForAllArgsAndColNumLessThan0() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = -1;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testZeroValuesForAllArgsAndColNumGreaterThanMaxColNum() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 4;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsAndColNumLessThan0() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = -1;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsAndColNumGreaterThanMaxColNum() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 4;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsAndColNumLessThan0() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = -1;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsAndColNumGreaterThanMaxColNum() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 4;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	
	//Valid Column Value
	
	@Test
	void testZeroValuesForArgsExceptArg4WithArg4NullForColO() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		colNum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(null);
		
		assertEquals(0.0, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	
	@Test
	void testZeroValuesForAllArgsForColO() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testZeroValuesForAllArgsForCol1() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testZeroValuesForAllArgsForCol2() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testZeroValuesForAllArgsForCol3() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsForColO() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsForCol1() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsForCol2() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsForCol3() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsForColO() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		colNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsForCol1() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		colNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsForCol2() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		colNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsForCol3() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		colNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testZeroValuesForArg1AndPositiveValuesForAllOtherArgsForColO() {
		arg1 = 0;
		arg2 = 5;
		arg3 = 7;
		arg4 = 12;
		colNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testZeroValuesForArg1ForCol1() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testZeroValuesForArg1ForCol2() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testZeroValuesForArg1ForCol3() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		colNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForArg1ForColO() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForArg1ForCol1() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForArg1ForCol2() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testPositiveValuesForArg1ForCol3() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForArg1ForColO() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		colNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForArg1ForCol1() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		colNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForArg1ForCol2() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		colNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForArg1ForCol3() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		colNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForArg1AndPositiveValuesForAllArgsForColO() {
		arg1 = -5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}
	@Test
	void testNegativeValuesForArg1AndZeroValuesForAllArgsForColO() {
		arg1 = -5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		colNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, colNum)).thenReturn(arg1);
		when(value.getValue(1, colNum)).thenReturn(arg2);
		when(value.getValue(2, colNum)).thenReturn(arg3);
		when(value.getValue(3, colNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateColumnTotal(value, colNum), 0.1d, String.format("The total for column %d is %f", colNum, sum));
	}

}
