package com.kata.tdd;

import java.util.ArrayList;
import java.util.List;

//This class is responsible for extracting cells from an entry

public class Cells {

    public static final int MIN_CHAR_FOR_AN_ENTRY = 81;
    public static final int MAX_CELLS_FOR_AN_ENTRY = 9;
    public static final int LENGTH = 27;
    public static final int INC = 3;

    List<String> from(String entry) {
        if(entry.length() < MIN_CHAR_FOR_AN_ENTRY)
            throw new IllegalArgumentException("Invalid Entry " + entry);

        List<String> cells = new ArrayList<String>();
        StringBuilder cell = new StringBuilder();
        int beginIndex = 0;
        int endIndex = 3;
        for (int cellIndex = 0; cellIndex < MAX_CELLS_FOR_AN_ENTRY; cellIndex++) {
            cell.append(entry.substring(beginIndex, endIndex));
            cell.append(entry.substring(beginIndex + LENGTH, endIndex + LENGTH));
            cell.append(entry.substring(beginIndex + (LENGTH * 2), endIndex + (LENGTH * 2)));
            cells.add(cell.toString());
            cell.setLength(0);
            beginIndex += INC;
            endIndex += INC;
        }
        return cells;
    }
 

}
