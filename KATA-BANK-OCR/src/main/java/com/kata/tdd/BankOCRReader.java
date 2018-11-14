package com.kata.tdd;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List; 

public interface BankOCRReader {
    List<String> readLinesFrom(String source) throws IOException, URISyntaxException;
}
