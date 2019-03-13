package com.igz.talenttest.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class NumberAndBinary implements Comparable<NumberAndBinary> {
    @NonNull private Integer number;
    private Integer binaryOfNumber;

    public NumberAndBinary() {
        super();
    }

    public NumberAndBinary(Integer number) {
        this.number = number;
        this.binaryOfNumber = Integer.bitCount(number);
    }

    public void setBinaryOfNumber(Integer number) {
        this.binaryOfNumber = Integer.bitCount(number);
    }

    @Override
    public int compareTo(NumberAndBinary o) {
        return 0;
    }
}