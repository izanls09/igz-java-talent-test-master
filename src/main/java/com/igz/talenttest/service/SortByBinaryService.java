package com.igz.talenttest.service;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.model.NumberAndBinary;
import com.igz.talenttest.output.NumberAndBinaryOutput;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class SortByBinaryService {
    public NumberAndBinaryOutput sortByBinaryThenDecimal(NumberAndBinaryInput numberAndBinaryInput) {

        NumberAndBinaryOutput numberAndBinaryOutput = new NumberAndBinaryOutput();
        ArrayList<Integer> inputData = numberAndBinaryInput.getUnsortedList();

        try {
            ArrayList<NumberAndBinary> unsortedNumberAndBinary = prepareInput(inputData);
            ArrayList<NumberAndBinary> sortedNumberAndBinary = sortCompareNumber(unsortedNumberAndBinary);
            numberAndBinaryOutput.setSortedList(prepareOutput(sortedNumberAndBinary));
        } catch(IllegalArgumentException e) {
            System.out.println("The following error was given: " + e);
        } finally {
            System.out.println("Everything went ok or, at least, the exception was controlled.");
        }
        return numberAndBinaryOutput;
    }

    private ArrayList<NumberAndBinary> prepareInput(ArrayList<Integer> inputData){
        ArrayList<NumberAndBinary> numberAndBinary = new ArrayList<>();
        inputData.stream().filter(number -> number >= 0)
                .forEachOrdered(number -> numberAndBinary
                        .add(new NumberAndBinary(number)));
        return numberAndBinary;
    }

    private ArrayList<NumberAndBinary> sortCompareNumber(ArrayList<NumberAndBinary> unsortedNumberAndBinary) {
        Collections.sort(unsortedNumberAndBinary);
        for(int i = 0; i < unsortedNumberAndBinary.size() - 1; i++)
            for (int j = i + 1; j < unsortedNumberAndBinary.size(); j++)
                if (unsortedNumberAndBinary.get(i).getBinaryOfNumber() < unsortedNumberAndBinary.get(j).getBinaryOfNumber()) {
                    NumberAndBinary secondaryList = new NumberAndBinary(unsortedNumberAndBinary.get(i));
                    unsortedNumberAndBinary.set(i, unsortedNumberAndBinary.get(j));
                    unsortedNumberAndBinary.set(j, secondaryList);
                }
        return unsortedNumberAndBinary;
    }

    private ArrayList<Integer> prepareOutput(ArrayList<NumberAndBinary> sortedNumberAndBinary){
        ArrayList<Integer> output = sortedNumberAndBinary.stream()
                .map(numberAndBinary -> numberAndBinary.getNumber())
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return output;
    }
}