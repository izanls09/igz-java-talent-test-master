package com.igz.talenttest.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class NumberAndBinaryInput {
    @NonNull private ArrayList<Integer> unsortedList;

    public NumberAndBinaryInput() {
        super();
    }
}
