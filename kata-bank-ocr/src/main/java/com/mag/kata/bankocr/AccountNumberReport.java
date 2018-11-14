package com.mag.kata.bankocr;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.mag.kata.bankocr.AccountNumber.Status;
import static java.lang.String.format;

public class AccountNumberReport {                    
   
    public static void report(List<AccountNumber> accountNumbers,
                              Consumer<String> output) {
        
        BiFunction<AccountNumber, List<AccountNumber>, String> formatOutput = (a, b) ->
                format("%s %s %s", a.accountNumber,
                        (b == null) ? a.getStatus().reportOutput : Status.AMBIGUOUS.reportOutput,
                        (b == null) ? "" : b.toString())
                .trim().concat("\n");
        
        for (AccountNumber accountNumber : accountNumbers) {
            if (accountNumber.getStatus() == Status.OK) {                
                output.accept(formatOutput.apply(accountNumber, null));
            } else {                
                List<AccountNumber> validAlternatives =
                        accountNumber.generateAlternatives()
                                     .stream()
                                     .filter(a -> a.getStatus() == Status.OK)
                                     .collect(Collectors.toList());
                
                if (validAlternatives.size() == 1) {                    
                    output.accept(formatOutput.apply(validAlternatives.get(0), null));
                } else if (validAlternatives.size() == 0) {                    
                    output.accept(formatOutput.apply(accountNumber, null));
                } else {                    
                    output.accept(formatOutput.apply(accountNumber, validAlternatives));
                }

            }
        }
    }
}
