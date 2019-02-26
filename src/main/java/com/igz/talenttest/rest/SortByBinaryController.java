package com.igz.talenttest.rest;

import com.igz.talenttest.input.NumberAndBinaryInput;
import com.igz.talenttest.output.NumberAndBinaryOutput;
import com.igz.talenttest.service.SortByBinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortByBinaryController {
    @Autowired
    SortByBinaryService sortByBinaryService;
    @RequestMapping(value = "/sortByBinaryAndThenDecimal/numbers/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public NumberAndBinaryOutput sortByBinaryController(@RequestBody NumberAndBinaryInput numberAndBinaryInput) {
        NumberAndBinaryOutput numberAndBinaryOutput = sortByBinaryService.sortByBinaryThenDecimal(numberAndBinaryInput);
        return numberAndBinaryOutput;
    }
}