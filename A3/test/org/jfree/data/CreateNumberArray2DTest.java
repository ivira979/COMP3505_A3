package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateNumberArray2DTest {
	

@BeforeEach
void setUp() throws Exception {
	
}

@Test 
void testPositiveValueWithOneArgPerDimension() {
	double[][] doubleArray = {{1},{2}};
	
	Number[][] actual = DataUtilities.createNumberArray2D(doubleArray);

	Number num1_1 = Double.valueOf(1);
	Number num2_1 = Double.valueOf(2);

	
	Number[][] expected = {{num1_1}, {num2_1}};

	assertTrue(Arrays.deepEquals(expected, actual)); //here we use the static method
												 // Arrays.deepEquals to check for 
												 // equality by array and then by element
}

@Test 
void testPositiveValuesWithMultipleArgsPerDimension() {
	double[][] doubleArray = {{1,2,3,4,5},{1,2,3,4,5}};
	
	Number[][] actual = DataUtilities.createNumberArray2D(doubleArray);

	Number num1 = Double.valueOf(1);
	Number num2 = Double.valueOf(2);
	Number num3 = Double.valueOf(3);
	Number num4 = Double.valueOf(4);
	Number num5 = Double.valueOf(5);
	
	Number[][] expected = {{num1, num2, num3, num4, num5},
			{num1, num2, num3, num4, num5}};
	
	assertTrue(Arrays.deepEquals(expected, actual));
}

@Test 
void testPositiveFloatValuesWithMultipleArgsPerDimension() {
	double[][] doubleArray = {{1.1,2.2,3.3,4.4,5.5},
			{1.1,2.2,3.3,4.4,5.5}};
	
	Number[][] actual = DataUtilities.createNumberArray2D(doubleArray);

	Number num1 = Double.valueOf(1.1);
	Number num2 = Double.valueOf(2.2);
	Number num3 = Double.valueOf(3.3);
	Number num4 = Double.valueOf(4.4);
	Number num5 = Double.valueOf(5.5);
	
	Number[][] expected = {{num1, num2, num3, num4, num5},
			{num1, num2, num3, num4, num5}};
	
	assertTrue(Arrays.deepEquals(expected, actual));
}

@Test 
void testNegativeValueWithOneArgPerDimension() {
	double[][] doubleArray = {{-1},{-2}};
	
	Number[][] actual = DataUtilities.createNumberArray2D(doubleArray);

	Number num1_1 = Double.valueOf(-1);
	Number num2_1 = Double.valueOf(-2);

	
	Number[][] expected = {{num1_1}, {num2_1}};

	assertTrue(Arrays.deepEquals(expected, actual)); 
}

@Test 
void testNegativeValuesWithMultipleArgs() {
	double[][] doubleArray = {{-1,-2,-3,-4,-5},{-1,-2,-3,-4,-5}};
	
	Number[][] actual = DataUtilities.createNumberArray2D(doubleArray);

	Number num1 = Double.valueOf(-1);
	Number num2 = Double.valueOf(-2);
	Number num3 = Double.valueOf(-3);
	Number num4 = Double.valueOf(-4);
	Number num5 = Double.valueOf(-5);
	
	Number[][] expected = {{num1, num2, num3, num4, num5},
				{num1, num2, num3, num4, num5}};
	
	
	assertTrue(Arrays.deepEquals(expected, actual));
}

@Test 
void testNegativeFloatValuesWithMultipleArgs() {
	double[][] doubleArray = {{-1.1,-2.2,-3.3,-4.4,-5.5},
			{-1.1,-2.2,-3.3,-4.4,-5.5}};
	
	Number[][] actual = DataUtilities.createNumberArray2D(doubleArray);

	Number num1 = Double.valueOf(-1.1);
	Number num2 = Double.valueOf(-2.2);
	Number num3 = Double.valueOf(-3.3);
	Number num4 = Double.valueOf(-4.4);
	Number num5 = Double.valueOf(-5.5);
	
	Number[][] expected = {{num1, num2, num3, num4, num5},
				{num1, num2, num3, num4, num5}};
	
	
	assertTrue(Arrays.deepEquals(expected, actual));
}

@Test 
void testZeroValueWithOneArgPerDimension() {
	double[][] doubleArray = {{0},{0}};
	Number[][] actual = DataUtilities.createNumberArray2D(doubleArray);
	
	Number[][] expected = {{Double.valueOf(0)},{Double.valueOf(0)}};
	
	assertTrue(Arrays.deepEquals(expected, actual));
}

@Test 
void testEmptyArray() {
	double[][] doubleArray = {{},{}};
	
	Number[][] actual = DataUtilities.createNumberArray2D(doubleArray);

	Number[][] expected = {{},{}};
	
	assertTrue(Arrays.deepEquals(expected, actual));
}

@Test 
void testNullArray() {
	double[][] doubleArray = null;
	
	assertThrows(IllegalArgumentException.class, () -> {DataUtilities.createNumberArray2D(doubleArray);});


}

}
