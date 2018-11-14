package com.kata.tdd;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
 
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BankOCRResourceReaderShould {

    @Test
    public void return_lines_from_resource_file() throws IOException, URISyntaxException {
        BankOCRReader reader = new BankOCRResourceReader();
        List<String> lines = reader.readLinesFrom("scanneddocument.txt");

        assertThat(lines.size(), is(44));
    }

}