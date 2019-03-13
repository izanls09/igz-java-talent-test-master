package com.igz.talenttest.model;

import java.util.Objects;

public class NumberAndBinary implements Comparable<NumberAndBinary> {
    private Integer number;
    private Integer binaryOfNumber;

    public NumberAndBinary() {
        super();
    }

    public NumberAndBinary(Integer number) {
        this.number = number;
        this.binaryOfNumber = Integer.bitCount(number);
    }

    public int compareTo(NumberAndBinary unsortedNumberAndBinary) {
        return 1;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBinaryOfNumber() {
        return binaryOfNumber;
    }

    public void setBinaryOfNumber(Integer number) {
        this.binaryOfNumber = Integer.bitCount(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberAndBinary that = (NumberAndBinary) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(binaryOfNumber, that.binaryOfNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, binaryOfNumber);
    }

    @Override
    public String toString() {
        return "NumberAndBinary{" +
                "number=" + number +
                ", binaryOfNumber='" + binaryOfNumber + '\'' +
                '}';
    }
}