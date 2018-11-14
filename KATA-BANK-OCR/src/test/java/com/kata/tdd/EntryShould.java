package com.kata.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EntryShould {

    @Mock
    Cells cells;

    @InjectMocks
    Entry entry = new Entry(
                      "    _  _     _  _  _  _  _ "
                    + "  | _| _||_||_ |_   ||_||_|"
                    + "  ||_  _|  | _||_|  ||_| _|");

    @Test
    public void convert_a_basic_entry() {

        when(cells.from(anyString()))
                .thenReturn(asList(
                                  "   "
                                + "  |"
                                + "  |",
                                  " _ "
                                + " _|"
                                + "|_ ",
                                  " _ "
                                + " _|"
                                + " _|",
                                  "   "
                                + "|_|"
                                + "  |",
                                  " _ "
                                + "|_ "
                                + " _|",
                                  " _ "
                                + "|_ "
                                + "|_|",
                                  " _ "
                                + "  |"
                                + "  |",
                                  " _ "
                                + "|_|"
                                + "|_|",
                                  " _ "
                                + "|_|"
                                + " _|"
                ));

        assertThat(entry.convert(), is(123456789)); 
    }
}