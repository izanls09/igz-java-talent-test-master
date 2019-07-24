package com.igz.talenttest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NumberAndBinary {
    @NonNull
    private Integer number;
    private Integer binaryOfNumber;

    public NumberAndBinary(Integer number) {
        this.number = number;
        this.binaryOfNumber = Integer.bitCount(number);
    }

    public void setBinaryOfNumber(Integer number) {
        this.binaryOfNumber = Integer.bitCount(number);
    }
}