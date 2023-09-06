package ru.gb.atestation.parse_exception;

public class ParseGenderException extends Exception{
    public void Exception(String exception){
        System.err.println("Exception: GenderNotCorrectFormat");
        System.err.printf("It`s not correct format: %s\n", exception);
    }
}
