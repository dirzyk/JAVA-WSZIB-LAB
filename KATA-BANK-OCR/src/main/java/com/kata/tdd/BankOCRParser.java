package com.kata.tdd;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankOCRParser {

    private BankOCRReader reader;
    private String source;

    BankOCRParser(BankOCRReader reader, String source) {
        this.reader = reader;
        this.source = source;
    }

    List<Entry> execute() {
        List<Entry> entries = new ArrayList<>();
        try {
            List<String> lines = reader.readLinesFrom(source);
            entries = buildEntriesFrom(lines);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return entries;
    } 

    private List<Entry> buildEntriesFrom(List<String> lines) {
        List<Entry> entries = new ArrayList<>();
        StringBuilder resultStringBuilder = new StringBuilder();
        int inc = 0;
        for (String line : lines) {
            if (inc < 4) {
                resultStringBuilder.append(line);
                inc++;
            }
            if (inc == 4) {
                Entry entry = new Entry(resultStringBuilder.toString());
                entries.add(entry);
                resultStringBuilder.setLength(0);
                inc = 0;
            }
        }
        return entries;
    }

}