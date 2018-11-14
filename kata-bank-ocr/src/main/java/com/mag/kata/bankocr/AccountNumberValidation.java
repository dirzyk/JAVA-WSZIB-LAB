package com.mag.kata.bankocr;

import static com.mag.kata.bankocr.AccountNumber.Status;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.codepoetics.protonpack.StreamUtils;

public class AccountNumberValidation {

    private static final int MOD_VALUE = 11;
   
    private static final Function<Integer, List<Integer>> CREATE_DIs = i ->
              IntStream.rangeClosed(1, i)
                       .boxed()
                       .sorted( (l,r) -> Integer.compare(r, l) )
                       .collect(Collectors.toList());

    public static AccountNumber.Status getStatus(AccountNumber accountNumber) {
        if (isIllegible(accountNumber)) {
            return Status.ILLEGIBLE;
        } else if (!isValidCheckSum(accountNumber)) {
            return Status.INVALID;
        } else {
            return Status.OK;
        }
    }

    public static boolean isValidCheckSum(AccountNumber accountNumber) {

        List<Integer> ds = CREATE_DIs.apply((int)accountNumber.digits
                                     .stream()
                                     .count());
 
        List<Integer> digits = accountNumber.digits
                                            .stream()
                                            .map( a -> a.get() )
                                            .collect(Collectors.toList());

        int value = StreamUtils.zip(ds.stream(), digits.stream(), 
                                    (a,b) -> a * b )
                               .reduce(0, (a, b) -> a + b);
        
        return value % MOD_VALUE == 0;
    }

    public static boolean isIllegible(AccountNumber accountNumber) {
        return !accountNumber.digits
                             .stream()
                             .allMatch( Optional::isPresent );
    }
    

}
