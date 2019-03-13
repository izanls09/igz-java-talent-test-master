package com.igz.talenttest.input;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class NumberAndBinaryInput {
    private ArrayList<Integer> unsortedList;

    public NumberAndBinaryInput() {
        super();
    }
}
