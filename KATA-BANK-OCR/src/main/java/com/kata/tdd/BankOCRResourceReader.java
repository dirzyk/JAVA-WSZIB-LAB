package com.kata.tdd;
 
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BankOCRResourceReader implements BankOCRReader {

    public List<String> readLinesFrom(String source) throws IOException, URISyntaxException {
        List<String> lines = new ArrayList<>();

        Path path = Paths.get(Objects
                .requireNonNull(getClass()
                        .getClassLoader()
                        .getResource(source))
                .toURI());
        Stream<String> readLines = Files.lines(path);
        readLines.forEach(lines::add);

        return lines;
    }
}
