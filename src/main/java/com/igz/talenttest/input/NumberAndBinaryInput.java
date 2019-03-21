package com.igz.talenttest.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NumberAndBinaryInput {
    @NonNull private ArrayList<Integer> unsortedList;
}
