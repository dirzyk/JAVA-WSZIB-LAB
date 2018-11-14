package com.kata.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException; 
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class BankOCRParserShould {

    @Mock
    BankOCRResourceReader reader;

    @InjectMocks
    @Spy
    private BankOCRParser parser = new BankOCRParser(reader, "");

    @Test
    public void return_all_entries_from_read_lines() throws IOException, URISyntaxException {

        List<String> lines = new ArrayList<String>(Arrays.asList(
                new String(" _  _  _  _  _  _  _  _  _ "),
                new String("| || || || || || || || || |"),
                new String("|_||_||_||_||_||_||_||_||_|"),
                new String(""),
                new String("                           "),
                new String("  |  |  |  |  |  |  |  |  |"),
                new String("  |  |  |  |  |  |  |  |  |"),
                new String("")
        ));

        given(reader.readLinesFrom(anyString())).willReturn(lines);

        List<Entry> entries = new ArrayList<Entry>(Arrays.asList(
                new Entry(" _  _  _  _  _  _  _  _  _ | || || || || || || || || ||_||_||_||_||_||_||_||_||_|"),
                new Entry("                             |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |")
        ));

        List<Entry> result = parser.execute();

        assertThat(result.size(), is(2));
        assertThat(result, is(entries));
    }

}