package com.igz.talenttest.service;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.model.NumberAndBinary;
import com.igz.talenttest.output.NumberAndBinaryOutput;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class SortByBinaryService implements ISortByBinaryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.igz.talenttest.service.SortByBinaryService.class);

    public NumberAndBinaryOutput sortByBinaryThenDecimal(NumberAndBinaryInput numberAndBinaryInput) {

        NumberAndBinaryOutput numberAndBinaryOutput = new NumberAndBinaryOutput();
        ArrayList<Integer> inputData = numberAndBinaryInput.getUnsortedList();

        try {
            ArrayList<NumberAndBinary> unsortedNumberAndBinary = prepareInput(inputData);
            ArrayList<NumberAndBinary> sortedNumberAndBinary = sortAndCompare(unsortedNumberAndBinary);
            numberAndBinaryOutput.setSortedList(prepareOutput(sortedNumberAndBinary));
        } catch (NumberFormatException error) {
            LOGGER.error("The format of the number is incorrect: " + error);
        } catch (IllegalArgumentException error) {
            LOGGER.error("There is an illegal argument in the number sent: " + error);
        } catch (NullPointerException error) {
            throw new NullPointerException();
        }
        return numberAndBinaryOutput;
    }

    private ArrayList<NumberAndBinary> prepareInput(ArrayList<Integer> inputData) throws NumberFormatException{
        ArrayList<NumberAndBinary> numberAndBinary = inputData.stream()
                .filter(number -> number >= 0)
                .map(NumberAndBinary::new)
                .collect(Collectors.toCollection(ArrayList::new));
        return numberAndBinary;
    }

    private ArrayList<NumberAndBinary> sortAndCompare(ArrayList<NumberAndBinary> unsortedNumberAndBinary) {
        unsortedNumberAndBinary.sort(Comparator.comparingInt(NumberAndBinary::getBinaryOfNumber).reversed());
        return unsortedNumberAndBinary;
    }

    private ArrayList<Integer> prepareOutput(ArrayList<NumberAndBinary> sortedNumberAndBinary){
        ArrayList<Integer> output = sortedNumberAndBinary.stream()
                .map(numberAndBinary -> numberAndBinary.getNumber())
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return output;
    }
}