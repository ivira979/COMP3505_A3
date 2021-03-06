package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateRowTotalTest {

	private Values2D value = mock(Values2D.class);
	private int rowNum = 0;
	private double arg1,arg2,arg3,arg4,sum;

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
	
	static double getSum(double arg1, double arg2, double arg3, double arg4) {
		
		return arg1+arg2+arg3+arg4;
	}
	//Invalid Row Values
	
	@Test
	void testZeroValuesForAllArgsAndRowNumLessThan0() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = -1;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testZeroValuesForAllArgsAndRowNumGreaterThanMaxRowNum() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 4;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsAndRowNumLessThan0() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = -1;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsAndRowNumGreaterThanMaxRowNum() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 4;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsAndRowNumLessThan0() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = -1;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsAndRowNumGreaterThanMaxRowNum() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 4;
		sum = 0;
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	
	//Valid Row Values
	
	@Test
	void testZeroValuesForAllArgsForRowO() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, rowNum)).thenReturn(arg1);
		when(value.getValue(1, rowNum)).thenReturn(arg2);
		when(value.getValue(2, rowNum)).thenReturn(arg3);
		when(value.getValue(3, rowNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testZeroValuesForAllArgsForRow1() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, rowNum)).thenReturn(arg1);
		when(value.getValue(1, rowNum)).thenReturn(arg2);
		when(value.getValue(2, rowNum)).thenReturn(arg3);
		when(value.getValue(3, rowNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testZeroValuesForAllArgsForRow2() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, rowNum)).thenReturn(arg1);
		when(value.getValue(1, rowNum)).thenReturn(arg2);
		when(value.getValue(2, rowNum)).thenReturn(arg3);
		when(value.getValue(3, rowNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testZeroValuesForAllArgsForRow3() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(0, rowNum)).thenReturn(arg1);
		when(value.getValue(1, rowNum)).thenReturn(arg2);
		when(value.getValue(2, rowNum)).thenReturn(arg3);
		when(value.getValue(3, rowNum)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsForRowO() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsForRow1() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsForRow2() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForAllArgsForRow3() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsForRowO() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		rowNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsForRow1() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		rowNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsForRow2() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		rowNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForAllArgsForRow3() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		rowNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testZeroValuesForArg1AndPositiveValuesForAllOtherArgsForRowO() {
		arg1 = 0;
		arg2 = 5;
		arg3 = 7;
		arg4 = 12;
		rowNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testZeroValuesForArg1ForRow1() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testZeroValuesForArg1ForRow2() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testZeroValuesForArg1ForRow3() {
		arg1 = 0;
		arg2 = 0;
		arg3 = 0;
		arg4 = 0;
		rowNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForArg1ForRowO() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForArg1ForRow1() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForArg1ForRow2() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testPositiveValuesForArg1ForRow3() {
		arg1 = 5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForArg1ForRowO() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		rowNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForArg1ForRow1() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		rowNum = 1;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForArg1ForRow2() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		rowNum = 2;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForArg1ForRow3() {
		arg1 = -5;
		arg2 = -7;
		arg3 = -12;
		arg4 = -1;
		rowNum = 3;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForArg1AndPositiveValuesForAllArgsForRowO() {
		arg1 = -5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}
	@Test
	void testNegativeValuesForArg1AndZeroValuesForAllArgsForRowO() {
		arg1 = -5;
		arg2 = 7;
		arg3 = 12;
		arg4 = 1;
		rowNum = 0;
		sum = getSum(arg1, arg2, arg3, arg4);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(4);
		when(value.getValue(rowNum, 0)).thenReturn(arg1);
		when(value.getValue(rowNum, 1)).thenReturn(arg2);
		when(value.getValue(rowNum, 2)).thenReturn(arg3);
		when(value.getValue(rowNum, 3)).thenReturn(arg4);
		
		assertEquals(sum, DataUtilities.calculateRowTotal(value, rowNum), 0.1d, String.format("The total for row %d is %f", rowNum, sum));
	}

}
