package com.igz.talenttest.service;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.output.NumberAndBinaryOutput;

public interface ISortByBinaryService {
    NumberAndBinaryOutput sortByBinaryThenDecimal(NumberAndBinaryInput numberAndBinaryInput);
}
