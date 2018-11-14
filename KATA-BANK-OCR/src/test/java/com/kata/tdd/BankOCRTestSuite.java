package com.kata.tdd;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
        BankOCRResourceReaderShould.class,
        BankOCRParserShould.class,
        BankOCRShould.class,
        EntryShould.class,
        CellsShould.class 
})
public class BankOCRTestSuite {

}

