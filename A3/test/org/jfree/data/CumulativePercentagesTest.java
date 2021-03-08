package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CumulativePercentagesTest {

	private KeyedValues keyedValues, keyedValues2, keyedValues3, keyedValues4, keyedValues5, keyedValues6;

	@BeforeEach
	void setUp() throws Exception {

		keyedValues = mock(KeyedValues.class);

		when(keyedValues.getItemCount()).thenReturn(3);
		when(keyedValues.getValue(0)).thenReturn(5);
		when(keyedValues.getValue(1)).thenReturn(9);
		when(keyedValues.getValue(2)).thenReturn(2);

		when(keyedValues.getKey(0)).thenReturn(0);
		when(keyedValues.getKey(1)).thenReturn(1);
		when(keyedValues.getKey(2)).thenReturn(2);

		when(keyedValues.getIndex(0)).thenReturn(0);
		when(keyedValues.getIndex(1)).thenReturn(1);
		when(keyedValues.getIndex(2)).thenReturn(2);

		ArrayList keyList = new ArrayList<>();
		keyList.add(0);
		keyList.add(1);
		keyList.add(2);
		when(keyedValues.getKeys()).thenReturn(keyList);

		keyedValues2 = mock(KeyedValues.class);
		when(keyedValues2.getItemCount()).thenReturn(4);
		when(keyedValues2.getValue(0)).thenReturn(5);
		when(keyedValues2.getValue(1)).thenReturn(0);
		when(keyedValues2.getValue(2)).thenReturn(8);
		when(keyedValues2.getValue(3)).thenReturn(2);

		when(keyedValues2.getKey(0)).thenReturn(0);
		when(keyedValues2.getKey(1)).thenReturn(1);
		when(keyedValues2.getKey(2)).thenReturn(2);
		when(keyedValues2.getKey(3)).thenReturn(3);

		when(keyedValues2.getIndex(0)).thenReturn(0);
		when(keyedValues2.getIndex(1)).thenReturn(1);
		when(keyedValues2.getIndex(2)).thenReturn(2);
		when(keyedValues2.getIndex(3)).thenReturn(3);

		ArrayList keyList2 = new ArrayList<>();
		keyList2.add(0);
		keyList2.add(1);
		keyList2.add(2);
		keyList2.add(3);
		when(keyedValues2.getKeys()).thenReturn(keyList2);

		keyedValues3 = mock(KeyedValues.class);
		when(keyedValues3.getItemCount()).thenReturn(4);
		when(keyedValues3.getValue(0)).thenReturn(0);
		when(keyedValues3.getValue(1)).thenReturn(5);
		when(keyedValues3.getValue(2)).thenReturn(9);
		when(keyedValues3.getValue(3)).thenReturn(2);

		when(keyedValues3.getKey(0)).thenReturn(0);
		when(keyedValues3.getKey(1)).thenReturn(1);
		when(keyedValues3.getKey(2)).thenReturn(2);
		when(keyedValues3.getKey(3)).thenReturn(3);

		keyedValues4 = mock(KeyedValues.class);
		when(keyedValues4.getItemCount()).thenReturn(1);
		when(keyedValues4.getValue(0)).thenReturn(0);

		when(keyedValues4.getKey(0)).thenReturn(0);

		keyedValues5 = mock(KeyedValues.class);
		when(keyedValues5.getItemCount()).thenReturn(2);
		when(keyedValues5.getValue(0)).thenReturn(0);
		when(keyedValues5.getValue(0)).thenReturn(5);

		when(keyedValues5.getKey(0)).thenReturn(0);
		when(keyedValues5.getKey(1)).thenReturn(1);

		keyedValues6 = mock(KeyedValues.class);
		when(keyedValues6.getItemCount()).thenReturn(2);
		when(keyedValues6.getValue(0)).thenReturn(-5);
		when(keyedValues6.getValue(0)).thenReturn(5);

		when(keyedValues6.getKey(0)).thenReturn(0);
		when(keyedValues6.getKey(1)).thenReturn(1);
	}

	/*
	 * @Test void testEmptyArg() { KeyedValues actual; ArrayList expected = new
	 * ArrayList();
	 * 
	 * when(testKeyedValues.getItemCount()).thenReturn(0); actual =
	 * DataUtilities.getCumulativePercentages(testKeyedValues);
	 * 
	 * assertEquals(expected, actual.getKeys());
	 * 
	 * }
	 * 
	 * @Test void testKVWhereSizeIsOneAndVIsPositive() { KeyedValues actual;
	 * ArrayList expected = new ArrayList();
	 * 
	 * when(testKeyedValues.getItemCount()).thenReturn(0); actual =
	 * DataUtilities.getCumulativePercentages(testKeyedValues);
	 * 
	 * assertEquals(expected, actual.getKeys());
	 * 
	 * }
	 * 
	 * @Test void testKVWhereSizeIsOneAndVIsNegative() { KeyedValues actual;
	 * ArrayList<Integer> expected = new ArrayList<Integer>();
	 * 
	 * int k1, v1; k1 = 0; v1 = 5;
	 * 
	 * expected.add(k1);
	 * 
	 * when(testKeyedValues.getItemCount()).thenReturn(1);
	 * when(testKeyedValues.getValue(k1)).thenReturn(v1);
	 * when(testKeyedValues.getKey(v1)).thenReturn(k1); actual =
	 * DataUtilities.getCumulativePercentages(testKeyedValues);
	 * 
	 * assertEquals(expected, actual.getKeys());
	 * 
	 * }
	 */

	/*
	 * getCumulativePercentages tests 1. values at 0(5/16), 1((5+9)/16),
	 * 2((5+9+2)/16) -> 0.3125, .875, 1.0 2. keys at 0, 1, 2 -> 0, 1, 2 3. indexes
	 * at 0, 1, 2 -> 0, 1, 2 4. values at 0 (5/15), 1(5+0/15), 2 (5+0+8)/15, 3
	 * (5+0+8+2)/15 -> .33, .33, .866.., 1.0 5. values at 0 (0/16), 1(0+5/16),
	 * 2(0+5+9/16), 3(0+5+9+2/16) -> 0.0, 0.3125, 0.875, 1.0 6. values at 0 (0/0) ->
	 * NaN 7. 0 (5/5), 1 (5+0/5) -> 1.0, 1.0 8. -5/0, -5+5/0 -> NaN
	 */

	@Test
	void testThreeValuesNotZeroAndIncludingOne() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues);

		assertAll(() -> assertEquals(0.3125, actual.getValue(0).doubleValue(), 0.1d),
				() -> assertEquals(0.875, actual.getValue(1).doubleValue(), 0.1d),
				() -> assertEquals(1, actual.getValue(2).doubleValue(), 0.1d));

	}

	@Test
	void testKeys() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues);

		assertAll(() -> assertEquals(0, actual.getKey(0)), () -> assertEquals(1, actual.getKey(1)),
				() -> assertEquals(2, actual.getKey(2)));
	}

	@Test
	void testIndexes() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues);

		assertAll(() -> assertEquals(0, actual.getIndex(0)), () -> assertEquals(1, actual.getIndex(1)),
				() -> assertEquals(2, actual.getIndex(2)));
	}

	@Test
	void testFourValuesNotZeroAndIncludingOne() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues2);

		assertAll(() -> assertEquals(0.33, actual.getValue(0).doubleValue(), 0.1d),
				() -> assertEquals(0.33, actual.getValue(1).doubleValue(), 0.1d),
				() -> assertEquals(0.866, actual.getValue(2).doubleValue(), 0.1d),
				() -> assertEquals(1, actual.getValue(3).doubleValue(), 0.1d));
	}

	@Test
	void testFourValuesIncludingZeroAndIncludingOne() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues3);

		assertAll(() -> assertEquals(0, actual.getValue(0).doubleValue(), 0.1d),
				() -> assertEquals(0.3125, actual.getValue(1).doubleValue(), 0.1d),
				() -> assertEquals(0.875, actual.getValue(2).doubleValue(), 0.1d),
				() -> assertEquals(1, actual.getValue(3).doubleValue(), 0.1d));
	}

	@Test
	void testZeroValues() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues4);
		assertEquals(0.0 / 0.0, actual.getValue(0).doubleValue());
	}


	@Test
	void testNullValues() {
		assertThrows(InvalidParameterException.class, () -> {
			DataUtilities.getCumulativePercentages(null);
		});
	}

}
