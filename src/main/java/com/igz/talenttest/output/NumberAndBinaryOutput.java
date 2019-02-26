package com.igz.talenttest.output;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumberAndBinaryOutput {
    private ArrayList<Integer> sortedList;

    public NumberAndBinaryOutput() {
        super();
    }

    public NumberAndBinaryOutput(ArrayList<Integer> sortedList) {
        this.sortedList = sortedList;
    }

    public List<Integer> getSortedList() {
        return sortedList;
    }

    public void setSortedList(ArrayList<Integer> sortedList) {
        this.sortedList = sortedList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberAndBinaryOutput that = (NumberAndBinaryOutput) o;
        return Objects.equals(sortedList, that.sortedList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortedList);
    }

    @Override
    public String toString() {
        return "NumberAndBinaryOutput{" +
                "sortedList=" + sortedList +
                '}';
    }
}