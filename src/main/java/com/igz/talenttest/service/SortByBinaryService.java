package com.igz.talenttest.service;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.model.NumberAndBinary;
import com.igz.talenttest.output.NumberAndBinaryOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
            ArrayList<NumberAndBinary> unsortedNumberAndBinary = prepareInput(inputData);
            ArrayList<NumberAndBinary> sortedNumberAndBinary = sortAndCompare(unsortedNumberAndBinary);
            numberAndBinaryOutput.setSortedList(prepareOutput(sortedNumberAndBinary));
        } catch (NumberFormatException | NullPointerException error) {
            log.error("The format of the number is incorrect: " + error);
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The number's format is wrong or there was a null.", error);
        }
        return numberAndBinaryOutput;
    }

    private ArrayList<NumberAndBinary> prepareInput(ArrayList<Integer> inputData) {
        log.info("Preparing the input...");
        ArrayList<NumberAndBinary> numberAndBinary = inputData.stream()
                .filter(SortByBinaryService::filterPositiveNumbers)
                .map(NumberAndBinary::new)
                .collect(Collectors.toCollection(ArrayList::new));
        log.info("Input prepared!");
        return numberAndBinary;
    }

    private static boolean filterPositiveNumbers(Integer number) {
        return number >= 0;
    }

    private ArrayList<NumberAndBinary> sortAndCompare(ArrayList<NumberAndBinary> unsortedNumberAndBinary) {
        log.info("Sorting the numbers...");
        unsortedNumberAndBinary.sort(Comparator.comparingInt(NumberAndBinary::getBinaryOfNumber).reversed());
        log.info("Numbers sorted!");
        return unsortedNumberAndBinary;
    }

    private ArrayList<Integer> prepareOutput(ArrayList<NumberAndBinary> sortedNumberAndBinary) {
        log.info("Preparing the output...");
        ArrayList<Integer> output = sortedNumberAndBinary.stream()
                .map(NumberAndBinary::getNumber)
                .collect(Collectors.toCollection(ArrayList::new));
        log.info("Output prepared!");
        return output;
    }
}