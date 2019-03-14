package com.igz.talenttest.service;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.output.NumberAndBinaryOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SortByBinaryService implements ISortByBinaryService {

    public NumberAndBinaryOutput sortByBinaryThenDecimal(NumberAndBinaryInput numberAndBinaryInput) {

        NumberAndBinaryOutput numberAndBinaryOutput = new NumberAndBinaryOutput();
        ArrayList<Integer> inputData = numberAndBinaryInput.getUnsortedList();

        try {
            ArrayList<com.igz.talenttest.model.NumberAndBinary> unsortedNumberAndBinary = prepareInput(inputData);
            ArrayList<com.igz.talenttest.model.NumberAndBinary> sortedNumberAndBinary = sortAndCompare(unsortedNumberAndBinary);
            numberAndBinaryOutput.setSortedList(prepareOutput(sortedNumberAndBinary));
        } catch (NumberFormatException error) {
            log.error("The format of the number is incorrect: " + error);
        } catch (IllegalArgumentException error) {
            log.error("There is an illegal argument in the numbers sent: " + error);
        } catch (NullPointerException error) {
            log.info("We don't want to neither receive nor send null, so we throw the exception");
            throw new NullPointerException();
        }
        return numberAndBinaryOutput;
    }

    private ArrayList<com.igz.talenttest.model.NumberAndBinary> prepareInput(ArrayList<Integer> inputData) throws NumberFormatException{
        ArrayList<com.igz.talenttest.model.NumberAndBinary> numberAndBinary = inputData.stream()
                .filter(number -> number >= 0)
                .map(com.igz.talenttest.model.NumberAndBinary::new)
                .collect(Collectors.toCollection(ArrayList::new));
        return numberAndBinary;
    }

    private ArrayList<com.igz.talenttest.model.NumberAndBinary> sortAndCompare(ArrayList<com.igz.talenttest.model.NumberAndBinary> unsortedNumberAndBinary) {
        unsortedNumberAndBinary.sort(Comparator.comparingInt(com.igz.talenttest.model.NumberAndBinary::getBinaryOfNumber).reversed());
        return unsortedNumberAndBinary;
    }

    private ArrayList<Integer> prepareOutput(ArrayList<com.igz.talenttest.model.NumberAndBinary> sortedNumberAndBinary){
        ArrayList<Integer> output = sortedNumberAndBinary.stream()
                .map(com.igz.talenttest.model.NumberAndBinary::getNumber)
                .collect(Collectors.toCollection(ArrayList::new));
        return output;
    }
}