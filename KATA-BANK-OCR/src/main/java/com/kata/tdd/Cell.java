package com.kata.tdd;

enum Cell {
    ZERO (  " _ " + 
            "| |" +
            "|_|", "0"),
    ONE (   "   " +
            "  |" +
            "  |", "1"),
    TWO (   " _ " +
            " _|" +
            "|_ ", "2"),
    THREE ( " _ " +
            " _|" +
            " _|", "3"),
    FOUR (  "   " +
            "|_|" +
            "  |", "4"),
    FIVE (  " _ " +
            "|_ " +
            " _|", "5"),
    SIX (   " _ " +
            "|_ " +
            "|_|", "6"),
    SEVEN ( " _ " +
            "  |" +
            "  |", "7"),
    EIGHT ( " _ " +
            "|_|" +
            "|_|", "8"),
    NINE (  " _ " +
            "|_|" +
            " _|", "9"),;


    private final String value;
    private final String number;

    Cell(String value, String number) {
        this.value = value;
        this.number = number;
    }

    public String number() {
        return number;
    }

    public static Cell get(String aCell) throws IllegalArgumentException {
        for (Cell cell: values()) {
            if (aCell.equals(cell.value)) {
                return cell;
            }
        }
        throw new IllegalArgumentException("Unknown cell with \''" + aCell + "\'' value");
    }
}
