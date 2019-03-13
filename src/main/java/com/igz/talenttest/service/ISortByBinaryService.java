package com.igz.talenttest.service;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.output.NumberAndBinaryOutput;
import org.springframework.stereotype.Service;

@Service
public interface ISortByBinaryService {
    NumberAndBinaryOutput sortByBinaryThenDecimal(NumberAndBinaryInput numberAndBinaryInput);
}
