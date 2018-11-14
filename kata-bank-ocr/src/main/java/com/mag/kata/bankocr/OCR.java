package com.mag.kata.bankocr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.codepoetics.protonpack.StreamUtils;

public class OCR {

    private static final int DIGITS_PER_LINE = 9;
    private static final int DIGIT_PATTERNS_PER_NUMBER_PER_LINE = 3;
    
    private static BiFunction<String, Integer, List<String>> 
        PARTITION_STRING = (s, i) -> { 
                   int len = s.length() / i;
                   List<String> result = new ArrayList<>();
                   for (int j = 0; j < i; j++) {
                       if (j + 1 < i)
                           result.add(s.substring(j * len, (j + 1) * len));
                       else
                           result.add(s.substring(j * len));
                   }
                   return result;
        };
    
    private static BiFunction<List<String>, Integer, List<List<String>>> 
        PARTITION_STRING_LIST = (l, i) ->
                             l.stream()
                              .map(s -> PARTITION_STRING.apply(s, i))
                              .collect(Collectors.toList());                             
    
    private static BiFunction<Stream<String>, Stream<String>, Stream<String>>
        ZIP_TWO_STRING_LISTS = (l, r) ->  StreamUtils.zip(l, r, (a,b) -> a + b);
    
    public static List<Optional<Integer>> parse(String accountNumberInputLine) {        
        
        List<String> lines = PARTITION_STRING
                                     .apply(accountNumberInputLine, 
                                            DIGIT_PATTERNS_PER_NUMBER_PER_LINE);        
        
        List<List<String>> digitPartitions = 
                        PARTITION_STRING_LIST.apply(lines, DIGITS_PER_LINE);
        
        List<String> digits =
                ZIP_TWO_STRING_LISTS.apply(digitPartitions.get(0).stream(),
                    ZIP_TWO_STRING_LISTS.apply(digitPartitions.get(1).stream(), 
                                               digitPartitions.get(2).stream()))
                                        .collect(Collectors.toList());        
       
        return digits.stream()
                     .map(Digit::get)
                     .collect(Collectors.toList());
     }

}
