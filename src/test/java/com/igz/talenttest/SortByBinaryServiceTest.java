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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SortByBinaryServiceTest {
    @Mock
    NumberAndBinaryInput numberAndBinaryInput;
    @InjectMocks
    SortByBinaryService sortByBinaryService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testAssertInputIsNotNull() {
        Integer[] valuesToInitialArrayList = new Integer[] {1, 3, 5, 7, 15};

        ArrayList<Integer> initialArrayList = new ArrayList<>();

        initialArrayList.addAll(Arrays.asList(valuesToInitialArrayList));

        when(numberAndBinaryInput.getUnsortedList()).thenReturn(initialArrayList);
        assertNotNull(sortByBinaryService.sortByBinaryThenDecimal(numberAndBinaryInput));
    }

    @Test
    public void testAssertIsSortedRight() {
        Integer[] valuesToInitialArrayList = new Integer[] {1, 3, 5, 7, 15};
        Integer[] valuesToExpectedResultList = new Integer[] {15, 7, 3, 5, 1};

        ArrayList<Integer> initialArrayList = new ArrayList<>();
        ArrayList<Integer> expectedResultList = new ArrayList<>();

        initialArrayList.addAll(Arrays.asList(valuesToInitialArrayList));
        expectedResultList.addAll(Arrays.asList(valuesToExpectedResultList));

        when(numberAndBinaryInput.getUnsortedList()).thenReturn(initialArrayList);
        assertEquals(expectedResultList, sortByBinaryService.sortByBinaryThenDecimal(numberAndBinaryInput).getSortedList());
    }
}
