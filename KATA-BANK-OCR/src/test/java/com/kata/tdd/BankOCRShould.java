package com.kata.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankOCRShould {

    @Mock 
    BankOCRParser parser;

    @Mock
    Entry entry = new Entry(
                          "    _  _     _  _  _  _  _ "
                        + "  | _| _||_||_ |_   ||_||_|"
                        + "  ||_  _|  | _||_|  ||_| _|");

    @Test
    public void get_an_account_number_from_an_entry() {
        BankOCR bankOCR = new BankOCR(parser);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(entry);

        given(parser.execute()).willReturn(entries);
        given(entry.convert()).willReturn(123456789);

        List<Integer> accountNumbers = bankOCR.getAccountNumbers();

        assertThat(accountNumbers.get(0), is(123456789));
    }
}