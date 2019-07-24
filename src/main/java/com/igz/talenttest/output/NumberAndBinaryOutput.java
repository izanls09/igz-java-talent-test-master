package com.igz.talenttest.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NumberAndBinaryOutput {
    @NonNull
    private ArrayList<Integer> sortedList;
}