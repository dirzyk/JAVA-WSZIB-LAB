package com.kata.tdd;

import java.util.List;
import java.util.Objects;

/*
 This class is responsible for converting a list of cells into its corresponding number.
 It tells the cells extractor to provide the list of cells from a given entry then takes`
 each cells and tells the cell to provide the corresponding number. For the conversion,
 the Entry class concatenates each cell number and then transform the end result into
 an Integer (i.e. the account number)
*/
public class Entry {

    private String entry;
    private Cells cells;

    Entry(String entry) {
        this.entry = entry;
        this.cells = new Cells();
    }

    int convert() {
        List<String> cells = this.cells.from(entry);
        String number = this.numberMatching(cells);
        return Integer.valueOf(number);
    }

    private String numberMatching(List<String> cells) {
        StringBuilder number = new StringBuilder();
        cells.forEach(cell -> {
            try {
                number.append(Cell.get(cell).number());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        });
        return number.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry1 = (Entry) o;
        return Objects.equals(entry, entry1.entry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entry);
    } 
}
