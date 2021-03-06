package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateNumberArrayTest {
	
@BeforeEach
void setUp() throws Exception {
	
}

@Test 
void testPositiveValueWithOneArg() {
	double[] doubleArray = {1};
	
	Number[] actual = DataUtilities.createNumberArray(doubleArray);

	Number num1 = Double.valueOf(1);

	
	Number[] expected = {num1};

	assertTrue(Arrays.equals(expected, actual)); //here we use the static methods
												 // Arrays.equals to check for 
												 // equality by element
}

@Test 
void testPositiveValuesWithMultipleArgs() {
	double[] doubleArray = {1,2,3,4,5};
	
	Number[] actual = DataUtilities.createNumberArray(doubleArray);

	Number num1 = Double.valueOf(1);
	Number num2 = Double.valueOf(2);
	Number num3 = Double.valueOf(3);
	Number num4 = Double.valueOf(4);
	Number num5 = Double.valueOf(5);
	
	Number[] expected = {num1, num2, num3, num4, num5};
	
	assertTrue(Arrays.equals(expected, actual));
}

@Test 
void testPositiveFloatValuesWithMultipleArgs() {
	double[] doubleArray = {1.1,2.2,3.3,4.4,5.5};
	
	Number[] actual = DataUtilities.createNumberArray(doubleArray);

	Number num1 = Double.valueOf(1.1);
	Number num2 = Double.valueOf(2.2);
	Number num3 = Double.valueOf(3.3);
	Number num4 = Double.valueOf(4.4);
	Number num5 = Double.valueOf(5.5);
	
	Number[] expected = {num1, num2, num3, num4, num5};
	
	assertTrue(Arrays.equals(expected, actual));
}

@Test 
void testNegativeValueWithOneArg() {
	double[] doubleArray = {-1};
	
	Number[] actual = DataUtilities.createNumberArray(doubleArray);

	Number num1 = Double.valueOf(-1);
	
	Number[] expected = {num1};

	assertTrue(Arrays.equals(expected, actual)); //here we use the static methods
												 // Arrays.equals to check for 
												 // equality by element
}

@Test 
void testNegativeValuesWithMultipleArgs() {
	double[] doubleArray = {-1,-2,-3,-4,-5};
	
	Number[] actual = DataUtilities.createNumberArray(doubleArray);

	Number num1 = Double.valueOf(-1);
	Number num2 = Double.valueOf(-2);
	Number num3 = Double.valueOf(-3);
	Number num4 = Double.valueOf(-4);
	Number num5 = Double.valueOf(-5);
	
	Number[] expected = {num1, num2, num3, num4, num5};
	
	assertTrue(Arrays.equals(expected, actual));
}

@Test 
void testNegativeFloatValuesWithMultipleArgs() {
	double[] doubleArray = {-1.1,-2.2,-3.3,-4.4,-5.5};
	
	Number[] actual = DataUtilities.createNumberArray(doubleArray);

	Number num1 = Double.valueOf(-1.1);
	Number num2 = Double.valueOf(-2.2);
	Number num3 = Double.valueOf(-3.3);
	Number num4 = Double.valueOf(-4.4);
	Number num5 = Double.valueOf(-5.5);
	
	Number[] expected = {num1, num2, num3, num4, num5};
	
	assertTrue(Arrays.equals(expected, actual));
}

@Test 
void testZeroValueWithOneArg() {
	double[] doubleArray = {0};
	Number[] actual = DataUtilities.createNumberArray(doubleArray);
	
	Number[] expected = {Double.valueOf(0)};
	assertTrue(Arrays.equals(expected, actual));
}

@Test 
void testEmptyArray() {
	double[] doubleArray = {};
	
	Number[] actual = DataUtilities.createNumberArray(doubleArray);

	Number[] expected = {};
	
	assertTrue(Arrays.equals(expected, actual));
}

@Test 
void testNullArray() {
	double[] doubleArray = null;
	
	assertThrows(IllegalArgumentException.class, () -> {DataUtilities.createNumberArray(doubleArray);});


}

}
