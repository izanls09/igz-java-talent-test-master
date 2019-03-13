package com.igz.talenttest.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class NumberAndBinaryOutput {
    @NonNull private ArrayList<Integer> sortedList;

    public NumberAndBinaryOutput() {
        super();
    }
}