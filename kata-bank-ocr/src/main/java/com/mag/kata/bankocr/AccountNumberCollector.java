package com.mag.kata.bankocr;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.codepoetics.protonpack.Indexed;

public class AccountNumberCollector implements Consumer<Indexed<String>> {

    private static final int NUM_LINES_PER_ENTRY = 4;
    private StringBuilder currentLine = new StringBuilder();
    private List<AccountNumber> accountNumbers = new ArrayList<>();


    @Override
    public void accept(Indexed<String> line) {
       
        if ((line.getIndex() + 1) % NUM_LINES_PER_ENTRY == 0) {           
            accountNumbers.add(new AccountNumber(currentLine.toString()));
            currentLine.setLength(0);
        } else {           
            currentLine.append(line.getValue());
        }
    }
   
    public void combine(AccountNumberCollector other) {
        accountNumbers.addAll(other.accountNumbers);
        currentLine.setLength(0);
    }
    
    public List<AccountNumber> getAccountNumbers() {
        return accountNumbers;
    }

}
