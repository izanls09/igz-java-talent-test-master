package com.igz.talenttest;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.service.SortByBinaryService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SortByBinaryServiceTest {
    @InjectMocks
    SortByBinaryService sortByBinaryService;
    @Mock
    NumberAndBinaryInput numberAndBinaryInput;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    final Integer[] INIT_VALUES = new Integer[] {1, 3, 5, 7, 15};
    final Integer[] EXPECTED_VALUES = new Integer[] {15, 7, 3, 5, 1};
    final ArrayList<Integer> initialArrayList = new ArrayList<>(Arrays.asList(INIT_VALUES));
    final ArrayList<Integer> expectedResultList = new ArrayList<>(Arrays.asList(EXPECTED_VALUES));

    @Test
    public void testAssertInputIsNotNull() {
        when(numberAndBinaryInput.getUnsortedList()).thenReturn(initialArrayList);
        assertNotNull(sortByBinaryService.sortByBinaryThenDecimal(numberAndBinaryInput));
    }

    @Test
    public void testAssertIsSortedRight() {
        when(numberAndBinaryInput.getUnsortedList()).thenReturn(initialArrayList);
        assertEquals(expectedResultList, sortByBinaryService.sortByBinaryThenDecimal(numberAndBinaryInput).getSortedList());
    }
}
