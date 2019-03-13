package com.igz.talenttest.service;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.model.NumberAndBinary;
import com.igz.talenttest.output.NumberAndBinaryOutput;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class SortByBinaryService implements ISortByBinaryService {
    public NumberAndBinaryOutput sortByBinaryThenDecimal(NumberAndBinaryInput numberAndBinaryInput) {

        NumberAndBinaryOutput numberAndBinaryOutput = new NumberAndBinaryOutput();
        ArrayList<Integer> inputData = numberAndBinaryInput.getUnsortedList();

        try {
            ArrayList<NumberAndBinary> unsortedNumberAndBinary = prepareInput(inputData);
            ArrayList<NumberAndBinary> sortedNumberAndBinary = sortAndCompare(unsortedNumberAndBinary);
            numberAndBinaryOutput.setSortedList(prepareOutput(sortedNumberAndBinary));
        } catch(IllegalArgumentException e) {
            System.out.println("The following error was given: " + e);
        } finally {
            System.out.println("Everything went ok or, at least, the exception was controlled.");
        }
        return numberAndBinaryOutput;
    }

    private ArrayList<NumberAndBinary> prepareInput(ArrayList<Integer> inputData){
        ArrayList<NumberAndBinary> numberAndBinary = inputData.stream()
                .filter(number -> number >= 0)
                .map(NumberAndBinary::new)
                .collect(Collectors.toCollection(ArrayList::new));
        return numberAndBinary;
    }

    private ArrayList<NumberAndBinary> sortAndCompare(ArrayList<NumberAndBinary> unsortedNumberAndBinary) {
        unsortedNumberAndBinary.sort(Comparator.comparingInt(NumberAndBinary::getBinaryOfNumber).reversed());
        ArrayList<NumberAndBinary> sortedNumberAndBinary = unsortedNumberAndBinary;
        return sortedNumberAndBinary;
    }

    private ArrayList<Integer> prepareOutput(ArrayList<NumberAndBinary> sortedNumberAndBinary){
        ArrayList<Integer> output = sortedNumberAndBinary.stream()
                .map(numberAndBinary -> numberAndBinary.getNumber())
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return output;
    }
}