package com.kata.tdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CellsShould {

    private String entry; 
    private Cells cells;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        entry = new String(
                  "    _  _     _  _  _  _  _ "
                        + "  | _| _||_||_ |_   ||_||_|"
                        + "  ||_  _|  | _||_|  ||_| _|");
        cells = new Cells();
    }

    @Test
    public void return_first_cell_from_entry() throws IllegalArgumentException {
        assertThat(cells.from(entry).get(0),
                is("   " +
                         "  |" +
                         "  |"));
    }

    @Test
    public void return_second_cell_from_entry() {
        assertThat(cells.from(entry).get(1),
                is(" _ " +
                         " _|" +
                         "|_ "));
    }

    @Test
    public void return_third_cell_from_entry() {
        assertThat(cells.from(entry).get(2),
                is(" _ " +
                         " _|" +
                         " _|"));
    }

    @Test
    public void throw_an_exception_when_entry_is_invalid() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(containsString("Invalid Entry _| |"));

        Cell.get(cells.from("_| |").get(0));
    }

    @Test
    public void throw_an_exception_when_entry_has_invalid_cells() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(containsString("Unknown cell with ''     |   '' value"));
        String invalidEntry = new String(
                  "    _  _     _  _  _  _  _ "
                        + "  | _| _||_||_ |_   ||_||_|"
                        + "   |_  _|  | _||_|  ||_| _|");

        Cell.get(cells.from(invalidEntry).get(0));
    }
}