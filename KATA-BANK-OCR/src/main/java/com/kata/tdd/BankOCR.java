package com.kata.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 
public class BankOCR {

    private final BankOCRParser parser;

    public BankOCR(BankOCRParser parser) {
        this.parser = parser;
    }

    public List<Integer> getAccountNumbers() {
        List<Entry> entries = parse();
        return transform(entries);
    }

    private List<Entry> parse() {
        return parser.execute();
    }

    private List<Integer> transform(List<Entry> entries) {
        return  entries.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private int convert(Entry entry) {
        return entry.convert();
    }
}
