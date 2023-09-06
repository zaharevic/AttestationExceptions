package ru.gb.atestation.parse_exception;

public class ParseDateException extends Exception{
    public void Exception(String exception){
        System.err.println("Exception: DateNotCorrectFormat");
        System.err.printf("It`s not correct format: %s\n", exception);
    }
}
