package com.igz.talenttest.output;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class NumberAndBinaryOutput {
    private ArrayList<Integer> sortedList;

    public NumberAndBinaryOutput() {
        super();
    }
}